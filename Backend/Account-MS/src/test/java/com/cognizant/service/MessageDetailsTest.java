package com.cognizant.service;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

import com.cognizant.accountservice.model.MessageDetails;

public class MessageDetailsTest {
	MessageDetails md=new MessageDetails();
	MessageDetails md1=new MessageDetails("show message");
	
	@Test
	public void setMessageTest()
	{ md.setMessage("my message");
	assertEquals("my message", md.getMessage());
		
	}
	
	@Test
	public void setMessageTest1()
	{ 
	assertEquals("show message", md1.getMessage());
		
	}
	

}
