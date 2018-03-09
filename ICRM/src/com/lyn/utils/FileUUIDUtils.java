package com.lyn.utils;

import java.util.UUID;

public class FileUUIDUtils {
	
	public static String getFileName(String fileName) {
		String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
		fileName = fileName.substring(fileName.lastIndexOf("."));
		
		return newFileName+fileName;
	}

}
