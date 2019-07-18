package com.huarui.service.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sloan on 2019/7/16.
 */


@Component
public class MqProducer {
    //消息发送者

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    public void orderDish(Long userId, Long dishId) {
        Map<String,Long> map = new HashMap<>();
        map.put("userId",userId);
        map.put("dishId",dishId);
        jmsMessagingTemplate.convertAndSend(queue,map);

        System.out.println("您点的菜已经交给后厨处理...请耐心等待");

    }
}
