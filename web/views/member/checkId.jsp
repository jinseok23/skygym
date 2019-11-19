<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//isAble=false 중복이다. isAble=true 아니다.
	boolean isAble=(boolean)request.getAttribute("isAble");
	String userId=(String)request.getAttribute("userId");
%>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 중복검사</title>
	<style>
		div#checkId-container
		{
			text-align: center;
			padding-top:50px;
		}
		span#duplicated
		{
			color:red;
			font-weight:bold;
		}
		.btn_black{background-color:#0A0A2A; color:white;padding:5px;border:0px;}
	</style>
	<script>
		function fn_checkDuplicate()
		{
			var userId=document.getElementById("userId").value.trim();
			if(!userId||userId.length<4)
			{
				alert("아이디는 4글자 이상 가능합니다.");
				return;
			}
			checkDuplicateFrm.userId.value=userId;
			checkDuplicateFrm.submit();
		}
		//부모창에 해당 id를 입력해주는 함수
		function setUserId(userId)
		{
			//opener : 부모창.내용.부모창에 있는 form이름
			var frm=opener.document.memberEnrollFrm;
			//중복을 비교한 값을 userId저장
			frm.userId_.value=userId;
			frm.idvalid.value=1;
			//password 포커싱
			frm.password_.focus();
			//현재 윈도우를 닫는 기능
			self.close();
		}
	</script>
</head>
<body>
	<div id="checkId-container">
	<img src="<%=request.getContextPath()%>/img/logo.png" style="width: 200px;"><br><br>
		<%if(isAble==true) {%>
		[<span><%=userId %></span>]는 사용가능합니다.
		<br><br>
		<button type="button" onclick="setUserId('<%=userId%>');" class='btn_black'>사용하기</button>
		<%}
		else {%>
		[<span><%=userId %></span>]는 이미 사용중입니다.
		<br><br>
		<form action="<%=request.getContextPath() %>/checkId" name="checkDuplicateFrm" method="post">
			<input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요"/>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="fn_checkDuplicate();" class='btn_black'>아이디중복검사</button>
		</form>
		<%} %>
	</div>
</body>
</html>