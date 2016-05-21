
package com.lc.design.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelper {
	//
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String temp = (String) obj;
			if ("".equals(temp.trim())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNullStr(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String temp = (String) obj;
			if ("null".equals(temp.trim().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	//
	public static boolean isIntNumber(String str) {

		if ((str == null) || "".equals(str.trim())) {
			return false;
		}
		String rep = "^-?\\d+$";
		Pattern p = Pattern.compile(rep);
		Matcher m = p.matcher(str.trim());
		return m.matches();
	}

	//
	public static boolean isDoubleNumber(String str) {

		if ((str == null) || "".equals(str.trim())) {
			return false;
		}
		String rep = "^([1-9]\\d*\\.\\d*|0\\.\\d+|0)$";
		Pattern p = Pattern.compile(rep);
		Matcher m = p.matcher(str.trim());
		return m.matches();
	}

	public static boolean isValidNumber(String str) {

		if ((str == null) || "".equals(str.trim())) {
			return false;
		}
		String rep = "^[0-9]*\\.?[0-9]+$";
		Pattern p = Pattern.compile(rep);
		Matcher m = p.matcher(str.trim());
		return m.matches();
	}

}
