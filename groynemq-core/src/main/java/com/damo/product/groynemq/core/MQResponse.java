package com.damo.product.groynemq.core;

/**
 * Response POJO.
 * @author suny
 * @date Dec 31, 2017
 */
public class MQResponse {
	private MQTransferType mqTransferType;
	private Object content;

	public MQTransferType getMqTransferType() {
		return mqTransferType;
	}
	public MQResponse setMqTransferType(MQTransferType mqTransferType) {
		this.mqTransferType = mqTransferType;
		return this;
	}
	public Object getContent() {
		return content;
	}
	public MQResponse setContent(Object content) {
		this.content = content;
		return this;
	}
}
