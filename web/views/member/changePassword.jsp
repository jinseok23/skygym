<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.skygym.member.model.vo.Member" %>
<%
    String userId = (String)request.getAttribute("userId");
%>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/img/favicon-16x16.png" />    

<style>
    div#updatePassword-container table {
        margin:0 auto;
        border-spacing: 20px;
    }
    div#updatePassword-container table tr:last-of-type td {
        text-align:center;
    }
 
</style>
<script>
	$(function(){
		$('#password_chk').blur(function(){
			var pw1=$('#password_new').val().trim();
			var pw2=$('#password_chk').val().trim();
			if(pw1!=pw2)
			{
				alert("비밀번호가 일치하지 않습니다.");
				$('#password_new').val("");
				$('#password_chk').val("");
				$('#password_new').focus();
			}
		});
	});
</script>
<br>
    <div id="updatePassword-container">
    <img src="<%=request.getContextPath()%>/img/logo2.png" style="width: 200px;">
		<form name="updatePwdFrm" action="<%=request.getContextPath()%>/changePasswordEnd" method="post" >
			<table>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" name="password" id="password" required></td>
				</tr>
				<tr>
					<th>변경할 비밀번호</th>
					<td>
						<input type="password" name="password_new" id="password_new" minlength='6' required>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>	
						<input type="password" id="password_chk" minlength='6' required><br>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<br>
						<input type="submit" class="btn btn-primary" value="변경" />&nbsp;
						<input type="button" class="btn btn-dark" onclick="self.close();" value="닫기" />						
					</td>
				</tr>
			</table>
			<input type="hidden" name="userId" value="<%=userId %>" />
		</form>
	</div>