<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>



	<!-- 메시지 표시 영역 -->
    <textarea id="messageTextArea" readonly="readonly" rows="10" cols="45"></textarea><br />
    <!-- 송신 메시지 텍스트박스 -->
    <input type="text" id="messageText" size="50" />
    <!-- 송신 버튼 -->
    <input type="button" value="Send" onclick="sendMessage()" />
    
    <% if (loginMember != null) { %>
    <script type="text/javascript">
    
        //웹소켓 초기화
        var webSocket = new WebSocket("ws://localhost:9090/MI_mr/broadsocket?username=<%=loginMember.getMemberId()%>");
        var messageTextArea = document.getElementById("messageTextArea");
        //메시지가 오면 messageTextArea요소에 메시지를 추가한다.
        webSocket.onmessage = function processMessge(message){
        	console.log(message);
        	/*
        	MessageEvent
				bubbles: false
				cancelBubble: false
				cancelable: false
				composed: false
				currentTarget: WebSocket {url: "ws://localhost:9090/MI_mr/broadsocket?username=miri", readyState: 1, bufferedAmount: 0, onopen: null, onerror: null, …}
				data: "{"username":"miri","message":"sadf"}"
				defaultPrevented: false
				eventPhase: 0
				isTrusted: true
				lastEventId: ""
				origin: "ws://localhost:9090"
        	*/
            //Json 풀기
            var jsonData = JSON.parse(message.data);
           	console.log(jsonData);
           	/*
           	Object
				message: "test"
				username: "miri"
           	*/
           	console.log(jsonData.message + " : " + jsonData.username);
            
            if(jsonData.message != null) {
                messageTextArea.value += jsonData.username + " : " + jsonData.message + "\n";
            };
        }
        //메시지 보내기
        function sendMessage(){
            var messageText = document.getElementById("messageText");
            webSocket.send(messageText.value);
            messageText.value = "";
        }
        
        $("#messageText").keyup(function(){
        	if (event.keyCode == 13) {
        		webSocket.send($(this).val());
        		$(this).val("");
        	}
        })
    </script>
    <%} %>

<%@ include file="/views/common/footer.jsp" %>