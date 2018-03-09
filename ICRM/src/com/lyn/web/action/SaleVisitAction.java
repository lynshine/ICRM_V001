package com.lyn.web.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.lyn.domain.PageBean;
import com.lyn.domain.SaleVisit;
import com.lyn.domain.User;
import com.lyn.service.SaleVisitService;
import com.lyn.utils.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit;
	private SaleVisitService service;
	private int currentPage = 1;
	private int pageSize = 3 ;
	private Date start_visit_time;
	private Date end_visit_time;
	/**
	 * 转发到添加页面
	 * @return
	 */
	public String add(){
		return Constant.to_add;
	}
	/**
	 * 保存拜访记录表
	 * @return
	 */
	public String save(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		saleVisit.setVisit_user_id(user);
		service.save(saleVisit);		
		return Constant.save_success;
	}
	/**
	 * 分页查询,分附加筛选条件
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//客户名称
		if(saleVisit.getVisit_cust_id()!=null && !StringUtils.isEmpty(saleVisit.getVisit_cust_id().getCust_id())){
			detachedCriteria.add(Restrictions.eq("visit_cust_id.cust_id", saleVisit.getVisit_cust_id().getCust_id()));
		}
		//时间(起止时间都有,且合法)
		if (start_visit_time!=null && end_visit_time!=null && start_visit_time.before(end_visit_time)) {
			detachedCriteria.add(Restrictions.between("visit_time", start_visit_time, end_visit_time));
		}
		//起止时间都有但不合法
		if (start_visit_time!=null && end_visit_time!=null && start_visit_time.after(end_visit_time)) {
			addActionError("请输入正确时间段");
		}
		//只有开始时间
		if(start_visit_time!=null && end_visit_time==null){
			detachedCriteria.add(Restrictions.ge("visit_time", start_visit_time));
		}
		//只有截止时间
		if(start_visit_time==null && end_visit_time!=null){
			detachedCriteria.add(Restrictions.le("visit_time", end_visit_time));
		}
		
		PageBean<SaleVisit> pageBean = service.findByPage(detachedCriteria,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return Constant.find_success;
	}
	
	
	
	@Override
	public SaleVisit getModel() {
		if (saleVisit==null) {
			saleVisit = new SaleVisit();
			
		}
		return saleVisit;
	}
	
	public void setService(SaleVisitService service) {
		this.service = service;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStart_visit_time(Date start_visit_time) {
		this.start_visit_time = start_visit_time;
	}
	public void setEnd_visit_time(Date end_visit_time) {
		this.end_visit_time = end_visit_time;
	}
	public Date getStart_visit_time() {
		return start_visit_time;
	}
	public Date getEnd_visit_time() {
		return end_visit_time;
	}

}
