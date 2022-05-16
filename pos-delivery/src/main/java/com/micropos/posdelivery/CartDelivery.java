package com.micropos.posdelivery;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class CartDelivery implements Consumer<String>{

    public static final Logger log = LoggerFactory.getLogger(CartDelivery.class);
    private StreamBridge streamBridge;
    @Autowired
    public void setStreamBridge(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }
    @Override
    public void accept(String info) {
        String[] infos = info.split("\\|");
        int cnt = Integer.parseInt(infos[0]);
        double fee = 1.25*cnt;
        String msg = String.format("deliver %d product(s) to %s,fee is %f",cnt,infos[1],fee);
        log.info(msg+"\n"); 
        streamBridge.send("delivery",message(msg));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
    
}
