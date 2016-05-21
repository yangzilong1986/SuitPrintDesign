
package com.lc.design.unit;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeUtils {

	public static final String DEFAULT_START_DATE = "1900-1-1";

	public static final String YMD = "yyyy-MM-dd";

	public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

	public static final String YMDHMSS = "yyyy-MM-dd HH:mm:ss:SS";

	public static final String HMS = "HH:mm:ss";

	public static final String YMDHMS_STR = "yyyyMMddHHmmss";

	public static final String Y = "yyyy";

	public static final String M = "MM";

	public static final String D = "dd";

	/**
	 * 将java.util.Date 按指定格式转化为String
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2str(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 将string 按指定格式转化为java.util.Date
	 * 
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date str2Date(String str, String format) throws ParseException {
		if (str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}

	/**
	 * 返回当前java.sql.Timestamp类型时间
	 */
	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 将string 按指定格式转化为java.sql.Timestamp
	 * 
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp str2Timestamp(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return new Timestamp(sdf.parse(str).getTime());
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将Date 按照 format 进行格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 验证字符串是否为合法日期格式 
	 * 支持YYYY-MM-DD OR YYYY-MM-DD HH:mm:ss
	 * @param dateString
	 */
	public static boolean validateDateFormat(String dateString) {
		Boolean validate = Boolean.FALSE;
		String reg1 = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-9]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		String reg2 = "^((\\d{2}(([02468][048])|([13579][26]))" + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
				+ "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
				+ "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

		Pattern p1 = Pattern.compile(reg1);
		Pattern p2 = Pattern.compile(reg2);
		Matcher m1 = p1.matcher(dateString);
		Matcher m2 = p2.matcher(dateString);
		if (m1.matches() || m2.matches()) {
			validate = Boolean.TRUE;
		}
		return validate;
	}

	/**
	 *  将制定日期向 向后推若干分钟
	 * @param startTime 日期
	 * @param compartTime 要推迟的分钟数  正数 向后 负数向前
	 * @return
	 */
	public static Date compartDate(Date startTime, int compartTime) {
		if (null == startTime) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		c.add(Calendar.MINUTE, compartTime);
		return c.getTime();
	}

	/**
	 * 获得对某个时间单位进行偏移之后时间
	 * 如getDate(new Date(), 1, Calendar.DATE)，表示取到当前时间一天之后的时间
	 * @param date
	 * @param offset
	 * @param unit
	 * @return
	 */
	public static Date getDate(Date date, int offset, int unit) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(unit, offset);
		return c.getTime();
	}
}
