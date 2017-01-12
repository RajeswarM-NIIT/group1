package com.abcd.group1.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcd.group1.model.Message;
import com.abcd.group1.model.OutputMessage;
import com.abcd.group1.model.UserDetails;



@RestController
public class ChatController {
	
	@RequestMapping("/chat/info")
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
		//message.setMessage(message.getMessage()+((UserDetails)session.getAttribute("user")).getFullname());
	    return new OutputMessage(message, new Date());
	  }

}
