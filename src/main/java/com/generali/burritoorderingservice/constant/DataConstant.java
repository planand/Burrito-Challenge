package com.generali.burritoorderingservice.constant;

import org.apache.commons.lang3.EnumUtils;

import java.util.UUID;

public class DataConstant {
	
	public final static String getUUID() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	
	public static boolean isNotNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isValidChoice(Class clazz, String name){
		return EnumUtils.isValidEnum(clazz, name);
	}
	

}
