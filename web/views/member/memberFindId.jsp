<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.skygym.member.model.vo.Member"%>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Lato%7CMontserrat:500%7COpen+Sans:600%7CNanum+Gothic" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/css/find_idPw.css" rel="stylesheet">
    <link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet"/>

	<link	
	href="<%=request.getContextPath()%>/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css"/>
	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet">

	<link href="<%=request.getContextPath()%>/css/skygym.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet">
    <% 
    	Member m = (Member)request.getAttribute("m"); 
    	String name = (String)request.getAttribute("name");
    %>
    <style>
    	
		.message
		{
			font-family : "Nanum Pen Script";
			font-size : 30px;
			padding-top : 10px;
		}
    	.findId
    	{
    		font-size:20px;
    		text-align:center;
    		padding-top:40px;
    		
    	}
    	#checkId_btn
    	{
    		
			border: 1px solid #000;
			background: #000;
			font-size: 15px;			
			margin-top: 12px;
			color: #fff;
			font-weight: 600;
    		
    	}
    
    </style>

	<script>
		function fn_close()
		{
			var frm=opener.document.findIdForm;
			opener.document.findPasswdForm.member_id.focus();
			frm.id_name.value="";
			frm.birth.value="";
			self.close();
		}
		
		
		
	</script>
<div class="findId">
	<div>
		<img src="<%=request.getContextPath()%>/img/logo.png" style="width: 200px">
		<br>
	</div>
	<p class="message"><%=m.getUserName() %> 회원님의 아이디는 [<mark style='color:red'><%=m.getUserId() %></mark>] 입니다.</p>
	<button id="checkId_btn" type="button" class="btn btn-default navbar-btn" onclick="fn_close()">닫기</button>

</div>