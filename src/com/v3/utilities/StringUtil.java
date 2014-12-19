package com.v3.utilities;

public class StringUtil {
	
	/**
	 * Use WordUtil.capitalizeFully(String) instead
	 * @param str
	 */
	@Deprecated
	public static void proper(String str){
		StringBuilder sb = new StringBuilder(str);
		sb.replace(0, str.length(),str.toString().toLowerCase());
		
	}
}
