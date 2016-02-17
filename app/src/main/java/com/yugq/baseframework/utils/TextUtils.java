package com.yugq.baseframework.utils;

public class TextUtils {
	/**
	 * 添加对字符串长度的判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean StrIsNotNull(String str) {
		if (str == null || str.equals("") || str.equals("null") || str.length() == 0) {
			return true;
		}
		return false;
	}
}