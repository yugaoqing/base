package com.yugq.baseframework.utils;

import java.util.List;

/**
 * TODO: json工具类
 * 
 */
public abstract class JsonUtils {
	private static JsonUtils json;

	JsonUtils() {
	}

	public static JsonUtils get() {
		if (json == null) {
			json = new GsonImpl();
		}
		return json;
	}

	public abstract String toJson(Object src);

	public abstract <T> T toObject(String json, Class<T> claxx);

	public abstract <T> T toObject(byte[] bytes, Class<T> claxx);

	public abstract <T> List<T> toList(String json, Class<T> claxx);
}
