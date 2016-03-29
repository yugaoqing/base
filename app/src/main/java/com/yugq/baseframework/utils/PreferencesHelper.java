package com.yugq.baseframework.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 配置文件
 * 
 * @author caibin
 * 
 */
public class PreferencesHelper {

	SharedPreferences mPreferences;

	SharedPreferences.Editor mEditor;

	Context context;

	public PreferencesHelper(Context c) {
		context = c;
		mPreferences = context.getSharedPreferences("yugqsetting", 0);
		mEditor = mPreferences.edit();
	}

	/**
	 * 获取全部
	 * 
	 * @return map
	 */
	public Map<String, ?> getAll() {
		return mPreferences.getAll();
	}

	/**
	 * 设置参数
	 * 
	 * @param key
	 * @param value
	 */
	public void setValue(String key, String value) {
		mEditor = mPreferences.edit();
		mEditor.putString(key, value);
		mEditor.commit();

	}

	/**
	 * 获取参数
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return mPreferences.getString(key, "");
	}

	/**
	 * 带默认值的获取参数
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getValue(String key, String defaultValue) {
		if (!mPreferences.contains(key)) {
			return defaultValue;
		}
		return mPreferences.getString(key, defaultValue);
	}

	public void remove(String name) {
		mEditor.remove(name);

	}

	public void removeAll() {
		Map<String, ?> map = getAll();

		Set<String> key = map.keySet();
		for (Iterator<String> it = key.iterator(); it.hasNext();) {
			String sKey = it.next();
			remove(sKey);
			// setValue(sKey,null);
		}

	}

}
