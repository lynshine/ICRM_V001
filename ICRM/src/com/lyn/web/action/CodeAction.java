package com.lyn.web.action;

import java.io.IOException;

import javax.servlet.ServletOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dsna.util.images.ValidateCode;

public class CodeAction extends ActionSupport {
	
	public String createCode() {
		try {
			ValidateCode validateCode = new ValidateCode(120, 50, 4, 6);
			ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
			validateCode.write(outputStream);
			String trueCode = validateCode.getCode();
			ActionContext.getContext().getSession().put("trueCode", trueCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return NONE;
		
	}

}
