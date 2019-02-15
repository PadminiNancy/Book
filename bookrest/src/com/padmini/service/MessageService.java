package com.padmini.service;

import java.util.*;

import com.padmini.model.Message;
import com.padmini.database.DatabaseClass;

//import javax.xml.bind.annotation.XmlRootElement;


//@XmlRootElement

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessage();
	
 /*	public MessageService(){
		
	//	messages.put(1L, new Message(1,"Hey","Ram"));
	//	messages.put(2L, new Message(2,"Hello","Padmini"));
	} */
	
	public List<Message> getAllMessages()
	{		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long mid)
	{		
		return messages.get(mid);		
	}
		
	public Message addMessage(Message msg)
	{
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
	}
	
	public Message updateMessage(Message msg)
	{
		if(msg.getId()<=0)
			return null;
		
		messages.put(msg.getId(),msg);
		return msg;
	}
	
	public Message removeMessage(long mid)
	{				 
		return messages.remove(mid);		
	}
	
}
