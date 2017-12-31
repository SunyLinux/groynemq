package com.damo.product.groynemq.core;

/**
 * Serialize info.
 * @author suny
 * @date Dec 31, 2017
 */
public class MQEntity {
	
	private Class<?> clazz;
	private Object content;

	public Class<?> getClazz() {
		return clazz;
	}
	public MQEntity setClazz(Class<?> clazz) {
		this.clazz = clazz;
		return this;
	}
	public Object getContent() {
		return content;
	}
	public MQEntity setContent(Object content) {
		this.content = content;
		return this;
	}

}
