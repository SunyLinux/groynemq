package com.damo.product.groynemq.core;

/**
 * Request POJO.
 * @author suny
 * @date Dec 31, 2017
 */
public class MQRequest {
	private MQTransferType mqTransferType;
	private String queueId;
	private Object content;
	
	public MQTransferType getMqTransferType() {
		return mqTransferType;
	}
	public MQRequest setMqTransferType(MQTransferType mqTransferType) {
		this.mqTransferType = mqTransferType;
		return this;
	}
	public String getQueueId() {
		return queueId;
	}
	public MQRequest setQueueId(String queueId) {
		this.queueId = queueId;
		return this;
	}
	public Object getContent() {
		return content;
	}
	public MQRequest setContent(Object content) {
		this.content = content;
		return this;
	}
}
