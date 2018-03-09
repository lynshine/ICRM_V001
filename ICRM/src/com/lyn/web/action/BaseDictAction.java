package com.lyn.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lyn.domain.BaseDict;
import com.lyn.service.BaseDictService;
import com.lyn.utils.Constant;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	
	private BaseDict baseDict;
	private BaseDictService service;
	private List<BaseDict> list;
	/**
	 * 根据字典表的类型,返回Json
	 * @return
	 */
	public String findByType() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDict.class);
		detachedCriteria.add(Restrictions.eq("dict_type_code", baseDict.getDict_type_code()));
		list =  service.findByType(detachedCriteria);
		
		return Constant.json_success;
	}
	@Override
	public BaseDict getModel() {
		if (baseDict==null) {
			baseDict=new BaseDict();
		}
		return baseDict;
	}
	public void setService(BaseDictService service) {
		this.service = service;
	}
	
	public List<BaseDict> getList() {
		return list;
	}

}
