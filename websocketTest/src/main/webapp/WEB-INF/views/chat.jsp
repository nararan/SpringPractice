<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
.textarea {background-color:transparent; border:0; overflow-x:hidden; overflow-y:auto; padding-top:1; padding-right:5; padding-bottom:5; padding-left:5;}
</style>
</head>
<body>
	<input type="text" onkeydown="enterkey()" id="message" autofocus/>
	<input type="button" id="sendBtn" value="SEND"/><br/><br/>
	<textarea id="data" rows="10" cols="50" readonly="true"></textarea>
	
	<script src="/resources/js/jQuery-2.1.4.min.js"></script>
	<script src="/resources/js/sockjs.min.js"></script>
	
	<script>
	var sock = new SockJS("<c:url value="/echo"/>");
	sock.onmessage = onMessage;

	sock.onclose = onClose;

	$(function() {
		$("#sendBtn").click(function() {
			console.log('send message...');
			sendMessage();
		});
	});
	
	function sendMessage() {
		sock.send($("#message").val());
		$("#message").val('');
		document.getElementById("message").autofocus;
		document.getElementById("data").scrollTop = document.getElementById("data").scrollHeight; 
	}
	
	function onMessage(evt) {
		var data = evt.data;
		
		console.log('chatting data: ' + data);
		$("#data").append(data+'\r\n');
	}
	
	function onClose(evt) {
		$("#data").append("Connection Closed!");
	}
	
	function enterkey() {
		if(window.event.keyCode == 13) {
			console.log('send message...');
			sendMessage();
		}
	}
</script>
</body>
</html>