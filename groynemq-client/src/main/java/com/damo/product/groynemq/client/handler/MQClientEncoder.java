package com.damo.product.groynemq.client.handler;

import com.damo.product.groynemq.core.MQRequest;
import com.damo.product.groynemq.util.SerializeUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client Encoder
 * @author suny
 * @date Dec 31, 2017
 */
public class MQClientEncoder extends MessageToByteEncoder<MQRequest> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQClientEncoder.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, MQRequest msg, ByteBuf out) throws Exception {
		LOGGER.debug("enter mq client encode ...");
		byte[] data = SerializeUtil.serialize(msg);
		out.writeBytes(data);
	}

}
