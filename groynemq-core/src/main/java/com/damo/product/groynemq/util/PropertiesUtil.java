package com.damo.product.groynemq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Raed Properties Files.
 * @author suny
 * @date Dec 31,2017
 */
public class PropertiesUtil {

	private static Properties properties;
	
	public static void load(String fileName) {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().
					getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load(InputStream inputStream) {
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getValue(Object key) {
		return properties.get(key);
	}

}
