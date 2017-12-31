package com.damo.product.groynemq;

import com.damo.product.groynemq.client.MQClient;
import com.damo.product.groynemq.server.MQServer;

/**
 * See you next room.
 *
 */
public class GroyneSample
{
    public static void main( String[] args ) throws Exception {
//        System.out.println( "What I have done!" );

        MQServer server=new MQServer(8081);
        server.run();
        MQClient consumer=new MQClient("127.0.0.1",8081);
        consumer.offer("info consume","info i get from mq");

        consumer.poll("info consume");

        Thread.currentThread().join(1000L);
    }
}
