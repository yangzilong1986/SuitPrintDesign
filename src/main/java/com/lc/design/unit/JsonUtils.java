
package com.lc.design.unit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	static {
		DateFormat dateFormat = new SimpleDateFormat(DateTimeUtils.YMDHMSS);
		SerializationConfig serConfig = mapper.getSerializationConfig().withDateFormat(dateFormat);
		DeserializationConfig deserConfig = mapper.getDeserializationConfig().withDateFormat(dateFormat);
		mapper.setSerializationConfig(serConfig);
		mapper.setDeserializationConfig(deserConfig);
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	public static String convertToString(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
			return mapper.writeValueAsString(obj);
		}
		catch (Exception e) {
			logger.error("{}转换为JOSN格式出错", obj.toString(), e);
		}
		return null;
	}

	public static <T> T convertToObject(String value, Class<T> clazz) {
		if (ValidateHelper.isNull(value)) {
			return null;
		}
		try {
			mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
			return mapper.readValue(value, clazz);
		}
		catch (Exception e) {
			logger.error("{}转换为JOSN格式出错", value.toString(), e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> convertToListObject(String value, Class<?>... clazz) throws Exception {

		if (ValidateHelper.isNull(value)) {
			return null;
		}
		try {
			JavaType javaType = getCollectionType(ArrayList.class, clazz);
			List<T> list = (List<T>) mapper.readValue(value, javaType);
			return list;
		}
		catch (Exception e) {
			logger.error("{}转换为JOSN格式出错", value.toString(), e);
		}
		return null;
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass 泛型的Collection
	 * @param elementClasses 元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * 调用这个接口只返回list对象，需要用mapConvertor去转
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List convertToList(String value) {
		if (ValidateHelper.isNull(value)) {
			return null;
		}
		try {
			return mapper.readValue(value, List.class);
		}
		catch (Exception e) {
			logger.error("{}转换为JOSN格式出错", value.toString(), e);
		}
		return null;
	}
}
