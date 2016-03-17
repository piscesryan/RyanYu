package com.bby.ants.util;

public class CommonUtil {
	public static boolean checkIsEmpty(String str){
		if(str==null||str.trim().equals("")){
			return true;
		}
		return false;
	}
}
