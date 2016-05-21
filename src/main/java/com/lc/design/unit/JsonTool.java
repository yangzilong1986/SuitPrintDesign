
package com.lc.design.unit;

import java.util.ArrayList;

public class JsonTool {

	//换行符
	public static String LINE_SPLIT = "\n";

	/**
	 * json格式化
	 * 
	 * @param jsonString 待格式化的字符串
	 * @return
	 */
	public static String formatJson(String jsonString) {
		return formatJson(jsonString, "  ");
	}

	/**
	 * JSON格式化
	 * 
	 * @param inJsonString 待格式化的字符串
	 * @param fillStringUnit 格式化后左侧补充显示的占位符
	 * @return 格式化后字符串
	 */
	private static String formatJson(String inJsonString, String fillStringUnit) {
		//判空
		String jsonString = inJsonString;
		if (jsonString == null || jsonString.trim().length() == 0) {
			return null;
		}
		jsonString = jsonString.trim();
		jsonString = jsonString.replace("\\/", "/");
		// 保存所有的Json行
		ArrayList<String> eachRowStringList = new ArrayList<String>();
		{
			String jsonTemp = jsonString;
			//循环拆分出所有的JsonHang
			while (jsonTemp.length() > 0) {
				// 取得JSON一行数据
				String eachRowString = getEachRowOfJsonString(jsonTemp);
				eachRowStringList.add(eachRowString.trim());
				// 剩余待分析的数据
				jsonTemp = jsonTemp.substring(eachRowString.length());
			}
		}

		int fixedLenth = 0;
		for (int i = 0; i < eachRowStringList.size(); i++) {
			String token = eachRowStringList.get(i);
			int length = token.getBytes().length;
			if (length > fixedLenth && i < eachRowStringList.size() - 1 && eachRowStringList.get(i + 1).equals(":")) {
				fixedLenth = length;
			}
		}

		StringBuilder buf = new StringBuilder();
		int count = 0;
		for (int i = 0; i < eachRowStringList.size(); i++) {

			String token = eachRowStringList.get(i);

			if (token.equals(",")) {
				buf.append(token);
				doFill(buf, count, fillStringUnit);
				continue;
			}
			if (token.equals(":")) {
				buf.append(token);
				continue;
			}
			if (token.equals("{")) {
				String nextToken = eachRowStringList.get(i + 1);
				if (nextToken.equals("}")) {
					i++;
					buf.append("{ }");
				}
				else {
					count++;
					buf.append(token);
					doFill(buf, count, fillStringUnit);
				}
				continue;
			}
			if (token.equals("}")) {
				count--;
				doFill(buf, count, fillStringUnit);
				buf.append(token);
				continue;
			}
			if (token.equals("[")) {
				String nextToken = eachRowStringList.get(i + 1);
				if (nextToken.equals("]")) {
					i++;
					buf.append("[ ]");
				}
				else {
					count++;
					buf.append(token);
					doFill(buf, count, fillStringUnit);
				}
				continue;
			}
			if (token.equals("]")) {
				count--;
				doFill(buf, count, fillStringUnit);
				buf.append(token);
				continue;
			}

			buf.append(token);
			// 对齐: 一般不需要
			//			if (i < eachRowStringList.size() - 1 && eachRowStringList.get(i + 1).equals(":")) {
			//				int fillLength = fixedLenth - token.getBytes().length;
			//				if (fillLength > 0) {
			//					for (int j = 0; j < fillLength; j++) {
			//						buf.append(" ");
			//					}
			//				}
			//			}
		}
		return buf.toString();
	}

	/**
	 * 取得一行数据
	 * 
	 * @param jsonString
	 * @return
	 */
	private static String getEachRowOfJsonString(String jsonString) {
		StringBuilder buf = new StringBuilder();
		boolean isInYinHao = false;
		while (jsonString.length() > 0) {
			// 取得第一个字符
			String firstString = jsonString.substring(0, 1);
			//是否是特殊字符: { } [ ] ,
			if (!isInYinHao
					&& (firstString.equals(":") || firstString.equals("{") || firstString.equals("}") || firstString.equals("[") || firstString.equals("]") || firstString
							.equals(","))) {
				// 特殊字符直接加入
				if (buf.toString().trim().length() == 0) {
					buf.append(firstString);
				}
				break;
			}
			// 剩余其它字符
			jsonString = jsonString.substring(1);
			// 第一个字符 = \
			if (firstString.equals("\\")) {
				buf.append(firstString);
				buf.append(jsonString.substring(0, 1));
				jsonString = jsonString.substring(1);
				continue;
			}
			// 第一个字符 = "
			if (firstString.equals("\"")) {
				buf.append(firstString);
				if (isInYinHao) {
					break;
				}
				else {
					isInYinHao = true;
					continue;
				}
			}
			buf.append(firstString);
		}
		return buf.toString();
	}

	private static void doFill(StringBuilder buf, int count, String fillStringUnit) {
		buf.append(LINE_SPLIT);
		for (int i = 0; i < count; i++) {
			buf.append(fillStringUnit);
		}
	}

	/**
	 * JSON格式化后，分行。
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String[] formatedJsonToArray(String json) {
		if (null == json || json.length() == 0) {
			return new String[0];
		}
		return json.split("\n");
	}

}
