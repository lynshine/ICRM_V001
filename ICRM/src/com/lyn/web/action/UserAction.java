package com.lyn.web.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lyn.domain.User;
import com.lyn.service.UserService;
import com.lyn.utils.Constant;
import com.lyn.utils.MD5Utils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	private String code;
	private UserService service;
	
	public String regist(){
		System.out.println(user);
		service.save(user);
		
		return Constant.regist_success;
	}
	public String login(){
			String trueCode = (String) ActionContext.getContext().getSession().get("trueCode");
			if (code==null || !code.equalsIgnoreCase(trueCode)) {
				ActionContext.getContext().put("msg", "验证码错误");
				return Constant.login_failed;
			}
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
			detachedCriteria.add(Restrictions.and(Restrictions.eq("uname", user.getUname())).add(Restrictions.eq("password", MD5Utils.encrypt(user.getPassword()))));
			User user1 = service.findByUser(detachedCriteria);
			if (user1==null) {
				ActionContext.getContext().put("msg", "用户名或密码错误!");
				return Constant.login_failed;
			}
			if (user1.getState()==0) {
				ActionContext.getContext().put("msg", "账号已失效!");
				return Constant.login_failed;
			}
			
			ActionContext.getContext().getSession().put("user", user1);
			return Constant.login_success;
	}
	

	@Override
	public User getModel() {
		return user;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	

}
