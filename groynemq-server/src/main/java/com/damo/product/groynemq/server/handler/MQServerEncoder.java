package com.damo.product.groynemq.server.handler;

import com.damo.product.groynemq.core.MQResponse;
import com.damo.product.groynemq.util.SerializeUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server Eecoder.
 * @author suny
 * @date May 3, 2016
 */
public class MQServerEncoder extends MessageToByteEncoder<MQResponse> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQServerEncoder.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, MQResponse msg, ByteBuf out) throws Exception {
		LOGGER.debug("enter mq server encode ...");
		byte[] data = SerializeUtil.serialize(msg);
		out.writeBytes(data);
	}

}
