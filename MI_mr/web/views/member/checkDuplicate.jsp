<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isAble = (boolean) request.getAttribute("isAble");
	String memberId = (String) request.getAttribute("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<style>
div#checkid-container {
	text-align: center;
	padding-top: 50px;
}

span#duplicated {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<div id='checkid-container'>
		<%
			if (isAble) {
		%>
		[<span><%=memberId%></span>]는 사용 가능합니다. <br> <br>
		<button type="button" onclick="fn_close();">닫기</button>
		<%
			} else {
		%>
		[<span id="duplicated"><%=memberId%></span>]는 사용 불가능합니다.
		<form action="<%=request.getContextPath()%>/chekIdDuplicate"
			method="post" onsubmit="return fn_validate();">
			<input type="text" id="memberId" name="memberId" placeholder="아이디입력" />
			<input type="submit" value="재검색" />
		</form>
		<%
			}
		%>
	</div>
	<script>
		function fn_close() {
			var frm=opener.document.memberEnrollFrm;
			frm.memberId.value='<%=memberId%>';
			frm.password.focus();

			self.close();
		}
		function fn_validate() {
			var memberId = document.getElementById("memberId").value;
			if (!memberId || memberId.trim().length < 4) {
				alert("아이디는 항상 4글자이상으로...ㅎㅎㅎ");
				return false;
			} else {
				return true;
			}
		}
	</script>

</body>
</html>