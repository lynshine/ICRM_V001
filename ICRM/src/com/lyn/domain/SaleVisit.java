package com.lyn.domain;

import java.util.Date;

public class SaleVisit {
	private String visit_id;
	
	private Date visit_time;
	private LinkMan visit_lkm_id;
	private String visit_addr;
	private String visit_detail;
	private Date visit_nexttime;
	
	
	private Customer visit_cust_id;
	private User visit_user_id;
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public Date getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}
	
	
	public LinkMan getVisit_lkm_id() {
		return visit_lkm_id;
	}
	public void setVisit_lkm_id(LinkMan visit_lkm_id) {
		this.visit_lkm_id = visit_lkm_id;
	}
	public String getVisit_addr() {
		return visit_addr;
	}
	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public Date getVisit_nexttime() {
		return visit_nexttime;
	}
	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	public Customer getVisit_cust_id() {
		return visit_cust_id;
	}
	public void setVisit_cust_id(Customer visit_cust_id) {
		this.visit_cust_id = visit_cust_id;
	}
	public User getVisit_user_id() {
		return visit_user_id;
	}
	public void setVisit_user_id(User visit_user_id) {
		this.visit_user_id = visit_user_id;
	}
	
	

}
