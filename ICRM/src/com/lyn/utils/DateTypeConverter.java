package com.lyn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * struts带的转换器,可以将字符串转换成对象类型,对象类型转换成字符串
 * @author Lyn
 *
 */
public class DateTypeConverter extends StrutsTypeConverter {
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
	/**
	 * 将浏览器传来的字符串转换成Date类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		try {
			return simpleDateFormat.parse(values[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 将Date类型的数据转成字符串,方便在页面获取是
	 */
	@Override
	public String convertToString(Map context, Object o) {

		return simpleDateFormat.format(o);
	}

}
