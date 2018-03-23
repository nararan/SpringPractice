package com.lee.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} connected", session.getId());
	}
	
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("from {}, received Message : {}", session.getId(), message.getPayload());
		
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
		}
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		
		logger.info("{} Connection Closed", session.getId());
	}
}
