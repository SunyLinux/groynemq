package com.damo.product.groynemq.client.handler;

import java.util.List;

import com.damo.product.groynemq.util.SerializeUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client Decoder.
 * @author suny
 * @date Dec 31, 2017
 */
public class MQClientDecoder extends ByteToMessageDecoder {

	private Class<?> clazz;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQClientDecoder.class);

	public MQClientDecoder(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		LOGGER.debug("enter mq client decode ...");
		int size = in.readableBytes();
		byte[] data = new byte[size];
		in.readBytes(data);
		Object object = null;
		
		try {
			object = SerializeUtil.deserialize(data, clazz);
		} catch(IllegalStateException e) {
			LOGGER.error("the request is not mqrequest!", e);
		}
		out.add(object);
	}

}
