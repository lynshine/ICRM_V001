package com.lyn.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.lyn.domain.Customer;
import com.lyn.domain.PageBean;
import com.lyn.domain.User;
import com.lyn.service.CustomerService;
import com.lyn.utils.Constant;
import com.lyn.utils.FileUUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer;
	private CustomerService service;
	private Integer currentPage;
	private Integer pageSize;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private List<User> list;
	private Customer editCustomer ;
	private List<Customer> custList;
	/**
	 * 异步获取客户信息
	 * @return
	 */
	public String findAll(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		custList =  service.findAll(detachedCriteria);
		return Constant.find_customer_success;
	}
	
	/**
	 * 修改客户信心
	 * @return
	 */
	public String update(){
		service.update(customer);
		return Constant.update_success;
	}
	
	/**
	 * 获取id对应的客户信息,并转发到修改页面
	 * @return
	 */
	public String edit(){
		editCustomer =  service.findByid(customer.getCust_id());
		return Constant.to_edit;
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	public String delete(){
		service.delete(customer);
		
		return Constant.delete_success;
	}
	
	/**
	 * 转发到添加页面
	 * @return
	 */
	public String add(){
		return Constant.to_add;
	}
	/**
	 * 查询所有负责人
	 * @return
	 */
	public String findUser(){
		//查找客户的全部负责人,select cust_user_id from customer;
		list = service.findUser();
		return Constant.find_user_success;
	}
	/**
	 * 保存customer
	 * @return
	 * @throws IOException 
	 */
	public String save() throws IOException {
		
		
		if (StringUtils.isEmpty(customer.getCust_name())) {
			ActionContext.getContext().getValueStack().set("msg", "客户名称不能为空!");
			return Constant.save_failed;
		}
		if (StringUtils.isEmpty(customer.getCust_industry().getDict_id())) {
			ActionContext.getContext().getValueStack().set("msg", "客户行业不能为空!");
			return Constant.save_failed;
		}
		if (StringUtils.isEmpty(customer.getCust_source().getDict_id())) {
			ActionContext.getContext().getValueStack().set("msg", "客户来源不能为空!");
			return Constant.save_failed;
		}
		if (StringUtils.isEmpty(customer.getCust_level().getDict_id())) {
			ActionContext.getContext().getValueStack().set("msg", "客户级别不能为空!");
			return Constant.save_failed;
		}
		if (StringUtils.isEmpty(customer.getCust_address())) {
			ActionContext.getContext().getValueStack().set("msg", "客户地址不能为空!");
			return Constant.save_failed;
		}
		
		if (StringUtils.isEmpty(customer.getCust_phone())) {
			ActionContext.getContext().getValueStack().set("msg", "客户电话不能为空!");
			return Constant.save_failed;
		}
		if (file==null) {
			ActionContext.getContext().getValueStack().set("msg", "客户资质不能为空");
			return Constant.save_failed;
		}
		
		String child = FileUUIDUtils.getFileName(fileFileName);
		File srcFile = file;
		File destFile = new File("d:/test", child);
		FileUtils.copyFile(srcFile, destFile);
		//添加负责人,创建人
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		customer.setCust_create_id(user);
		customer.setCust_user_id(user);
		
		//保存图片虚拟路径,访问图片<img src="${pageContext.request.contextPath}/xx/aa.jpg"
		//-->/CRM/xxx/aa.jpg-->保存xx/aa.jpg
		//虚拟路径--->/CRM/xxx
		String cust_image = "img/"+child;
		customer.setCust_image(cust_image);
		
		
		System.out.println(customer);
		service.save(customer);
		return Constant.save_success;
	}
	/**
	 * customer的分页查询(可包含条件)
	 * @return
	 */
	public String findByPage(){
		System.out.println(customer.getCust_name());
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//客户名称过滤
		if (!StringUtils.isEmpty(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//客户级别过滤
		if (customer.getCust_level()!=null && !StringUtils.isEmpty(customer.getCust_level().getDict_id())) {
			detachedCriteria.add(Restrictions.eq("cust_level.dict_id", customer.getCust_level().getDict_id()));
		}
		//客户来源过滤
		if (customer.getCust_source()!=null && !StringUtils.isEmpty(customer.getCust_source().getDict_id())) {
			detachedCriteria.add(Restrictions.eq("cust_source.dict_id", customer.getCust_source().getDict_id()));
		}
		
		//客户行业过滤
		if (customer.getCust_industry()!=null && !StringUtils.isEmpty(customer.getCust_industry().getDict_id())) {
			detachedCriteria.add(Restrictions.eq("cust_industry.dict_id", customer.getCust_industry().getDict_id()));
		}
		//电话过滤
		if (!StringUtils.isEmpty(customer.getCust_phone())) {
			detachedCriteria.add(Restrictions.like("cust_phone", "%"+customer.getCust_phone()+"%"));
		}
		//负责人过滤
		if (customer.getCust_user_id()!=null && !StringUtils.isEmpty(customer.getCust_user_id().getUid())) {
			detachedCriteria.add(Restrictions.eq("cust_user_id.uid", customer.getCust_user_id().getUid()));
		}
		
		pageBean =  service.find(detachedCriteria,pageBean);
		ActionContext.getContext().put("pageBean", pageBean);
		System.out.println(pageBean);
		
		return Constant.find_success;
	}
	
	
	@Override
	public Customer getModel() {
		if (customer==null) {
			customer = new Customer();
		}
		return customer;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<User> getList() {
		return list;
	}

	public Customer getEditCustomer() {
		return editCustomer;
	}
	public List<Customer> getCustList() {
		return custList;
	}
	

	
}
