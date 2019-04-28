<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

	<!-- 메시지 표시 영역 -->
    <textarea id="messageTextArea" readonly="readonly" rows="10" cols="45"></textarea><br />
    <!-- 송신 메시지 텍스트박스 -->
    <input type="text" id="messageText" size="50" />
    <!-- 송신 버튼 -->
    <input type="button" value="Send" onclick="sendMessage()" />
    <script type="text/javascript">
        //웹소켓 초기화
        var webSocket = new WebSocket("ws://localhost:9090/MI_mr/broadsocket");
        var messageTextArea = document.getElementById("messageTextArea");
        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
        webSocket.onmessage = function processMessge(message){
        	console.log(message);
            //Json 풀기
            var jsonData = JSON.parse(message.data);
           	console.log(jsonData);
           	console.log(jsonData.message + " : " + jsonData.username);
            if(jsonData.message != null) {
                messageTextArea.value += jsonData.message + "\n"
            };
        }
        //메시지 보내기
        function sendMessage(){
            var messageText = document.getElementById("messageText");
            webSocket.send(messageText.value);
            messageText.value = "";
        }
    </script>

</body>
</html>