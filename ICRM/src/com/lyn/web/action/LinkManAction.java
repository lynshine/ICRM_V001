package com.lyn.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.lyn.domain.Customer;
import com.lyn.domain.LinkMan;
import com.lyn.domain.PageBean;
import com.lyn.service.LinkManService;
import com.lyn.utils.Constant;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import sun.awt.image.ImageWatched.Link;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkman;
	private LinkManService service;
	private int currentPage = 1;
	private int pageSize = 3;
	private Long custId;
	private List<LinkMan> linkManlist;
	private LinkMan editLinkMan;
	
	/**
	 * 修改联系人信息
	 * @return
	 */
	public String update(){
		service.update(linkman);
		return Constant.update_success;
	}
	
	/**
	 * 查询修改联系人信息,并跳转到修改页面
	 * @return
	 */
	public String edit(){
		
		editLinkMan = service.findById(linkman.getLkm_id());
		
		return Constant.to_edit;
	}
	
	/**
	 * 删除联系人
	 * @return
	 */
	public String delete() {
		service.delete(linkman);
		return Constant.delete_success;
	}
	
	/**
	 * 根据客户id获取联系人
	 * @return
	 */
	public String findByCustID(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		detachedCriteria.add(Restrictions.eq("lkm_cust_id.cust_id", custId));
		linkManlist = service.findByCustID(detachedCriteria);
		
		return Constant.find_linkMan_success;
	}
	/**
	 * 跳转到新增联系人页面
	 * @return
	 */
	public String add(){
		return Constant.to_add;
	}
	/**
	 * 保存联系人
	 * @return
	 */
	public String save(){
		service.save(linkman);
		return Constant.save_success;
	}
	/**
	 * 分页查询联系人,加筛选条件
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//联系人名称
		if(!StringUtils.isEmpty(linkman.getLkm_name())){
			detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkman.getLkm_name()+"%"));
		}
		//性别
		if (!StringUtils.isEmpty(linkman.getLkm_gender())) {
			detachedCriteria.add(Restrictions.eq("lkm_gender", linkman.getLkm_gender()));
		}
		//电话
		if (!StringUtils.isEmpty(linkman.getLkm_phone())) {
			detachedCriteria.add(Restrictions.like("lkm_phone", "%"+linkman.getLkm_phone()+"%"));
		}
		//手机
		if (!StringUtils.isEmpty(linkman.getLkm_mobile())) {
			detachedCriteria.add(Restrictions.like("lkm_mobile", "%"+linkman.getLkm_mobile()+"%"));
		}
		//邮箱
		if (!StringUtils.isEmpty(linkman.getLkm_email())) {
			detachedCriteria.add(Restrictions.like("lkm_email", "%"+linkman.getLkm_email()+"%"));
		}
		//所属客户
		if (linkman.getLkm_cust_id()!=null && !StringUtils.isEmpty(linkman.getLkm_cust_id().getCust_id())) {
			detachedCriteria.add(Restrictions.eq("lkm_cust_id.cust_id", linkman.getLkm_cust_id().getCust_id()));
		}
		PageBean<LinkMan> pageBean =  service.findByPage(detachedCriteria,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return Constant.find_success;
	}
	

	
	
	
	@Override
	public LinkMan getModel() {
		if (linkman==null) {
			linkman = new LinkMan();
		}
		return linkman;
	}

	public void setService(LinkManService service) {
		this.service = service;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public List<LinkMan> getLinkManlist() {
		return linkManlist;
	}
	public LinkMan getEditLinkMan() {
		return editLinkMan;
	}
	
	

}
