package com.zcy.springintejms.service;

import javax.jms.JMSException;

public interface ConsumerService {

	public void receiveMessage(String message) throws JMSException;
	
}
