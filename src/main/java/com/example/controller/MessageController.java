package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@RestController
public class MessageController {
	
	@Autowired
	MessageRepository repository;
	
	@MessageMapping("/sent")
	@SendTo("/messages/group-chat")
	public Message publishMessage(@RequestBody Message message) {
		
		 Message msg = new Message(message.getUsername(),message.getMessage());
		
		 msg = repository.save(msg);
		 
		 return msg;		
		
	}

}
