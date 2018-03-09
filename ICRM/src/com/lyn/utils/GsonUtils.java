package com.lyn.utils;

import com.google.gson.Gson;

public class GsonUtils {
	public static String getJson(Object obj) {
		Gson gson = new Gson();
		if (obj!=null) {
			String json = gson.toJson(obj);
			return json;
			
		}
		return null;
		
	}

}
