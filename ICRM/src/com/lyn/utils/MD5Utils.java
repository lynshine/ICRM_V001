package com.lyn.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
	
	public static String encrypt(String password){
		
		for (int i = 0; i < 10; i++) {
			password = DigestUtils.md5DigestAsHex(password.getBytes());
		}
		return password;
	}

}
