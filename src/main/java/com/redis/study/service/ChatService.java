package com.redis.study.service;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@AllArgsConstructor
public class ChatService implements MessageListener {
    private RedisMessageListenerContainer container;
    RedisTemplate<String, String> redisTemplate;
    public void enterChatRoom(String chatRoomName){
        this.container.addMessageListener(this, new ChannelTopic(chatRoomName));
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.equals("q")){
                System.out.println("Quit...");
                break;
            }

            this.redisTemplate.convertAndSend(chatRoomName, line);
        }

        this.container.removeMessageListener(this);
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message : " + message.toString());
    }
}
