package com.damo.product.groynemq.server.handler;

import com.damo.product.groynemq.core.MQRequest;
import com.damo.product.groynemq.core.MQResponse;
import com.damo.product.groynemq.storage.RedisTemplate;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server Handler.
 * @author suny
 * @date May 6, 2016
 */
public class MQServerHandler extends SimpleChannelInboundHandler<MQRequest> {
	
	private RedisTemplate redisTemplate = RedisTemplate.getInstance();

	private static final Logger LOGGER = LoggerFactory.getLogger(MQServerHandler.class);

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, MQRequest msg) throws Exception {
		LOGGER.debug("enter server handler ...");
		LOGGER.debug("mq request type: " + msg.getMqTransferType());
		if (null != msg.getMqTransferType()) {
			MQResponse mqResponse = handle(msg);
			ctx.writeAndFlush(mqResponse).addListener(ChannelFutureListener.CLOSE);
		} else {
			LOGGER.debug("mq request is null!");
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.error("server handler error!", cause);
		ctx.close();
	}
	
	private MQResponse handle(MQRequest mqRequest) {
		MQResponse mqResponse = new MQResponse()
				.setMqTransferType(mqRequest.getMqTransferType());
		
		String queueId;
		Object content;
		
		switch (mqRequest.getMqTransferType()) {
		case offer:
			queueId = mqRequest.getQueueId();
			content = mqRequest.getContent();
			boolean result = redisTemplate.offer(queueId, content);
			mqResponse.setContent(result);
			break;
			
		case poll:
			queueId = mqRequest.getQueueId();
			content = redisTemplate.poll(queueId);
			mqResponse.setContent(content);
			break;

		default:
			break;
		}
		return mqResponse;
	}

}
