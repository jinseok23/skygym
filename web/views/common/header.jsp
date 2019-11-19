<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="com.skygym.member.model.vo.Member"%>
<%
   /* 서블릿에서 session객체에 담아놓은 login정보를 확인 */
   Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SkyGym</title>    
    <link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/skygym2.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/img/favicon-16x16.png" />    
    <link href="http://cdn.jsdelivr.net/xeicon/1.0.4/xeicon.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
  	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  </head>
  <body>
    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg bg-light" id="mainNav">
      <div class="container">
       <!-- 로고삽입부분 -->
        <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"> <img src="<%=request.getContextPath()%>/img/logo2.png" style="width: 140px"> </a>
        
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
         <span class="burger-menu sky"></span>
        </button>        
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
             <li class="nav-item ">
              <a class="nav-link px-0 px-lg-3" href="#">About</a>
            </li> 
            <li class="nav-item">
              <a class="nav-link px-0 px-lg-3" href="<%=request.getContextPath()%>/rank/rankList">Ranking</a>
            </li>
            <li class="nav-item">
            	<%if(memberLoggedIn!=null) 
                  		{ %>
                	<a class="nav-link px-0 px-lg-3" href="<%=request.getContextPath()%>/recommend/MemberRecommend?userId=<%=memberLoggedIn.getUserId()%>"> 추천GYM </a>
                    <% } 
                    else 
                    { %>
                    <a class="nav-link px-0 px-lg-3" href="<%=request.getContextPath()%>/recommend/Recommend"> 추천GYM </a>
                    <% } %>           
            </li>
            <li class="nav-item">
                <a class="nav-link px-0 px-lg-3" href="<%=request.getContextPath()%>/find/findGYM">제휴지점찾기</a>
            </li>              
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBoard" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                	고객센터
              </a>
              <div class="dropdown-menu dropdown-menu-right" id="navbarDropdownBoard" aria-labelledby="navbarDropdownBoard">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/board/boardList?bn=newsboard">skygym 소식</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/board/boardList?bn=freeboard">자유게시판</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/board/boardList?bn=partnerboard">제휴문의</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/board/boardList?bn=qnaboard">QnA</a>                
              </div>
            </li>
            <!-- 반응형처리 -->
            <li class="nav-item visible-xs hidden-sm">
            	<hr>
            	<!-- 비 로그인 로그인페이지로 넘기기 -->
            	<%if(memberLoggedIn==null) { %>
            	<div>            	
               <a href="<%=request.getContextPath() %>/views/member/login.jsp" title="Login to SkyGym" class="nav-link px-0 px-lg-3 login" >로그인</a>
				</div>				
				<%}else{ %>          
            <!-- 로그인 시 -->            
            <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle login" href="#" id="loginDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%= memberLoggedIn.getUserName() %>님 
              </a>             
              <!-- 관리자 -->
              <%if(memberLoggedIn.getUserId().equals("admin")){%>
              <div class="dropdown-menu dropdown-menu-right login" id="navbarDropdownLogin" aria-labelledby="navbarDropdownBoard">
                <a class="dropdown-item" href="<%=request.getContextPath() %>/memberView?userId=<%=memberLoggedIn.getUserId() %>">
                	<i class="fa fa-user fa-fw"></i>마이페이지</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/logout">
                	<i class="fa fa-sign-out fa-fw"></i>로그아웃</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/admin/memberList"">
                	<i class="fa fa-gear fa-fw"></i>회원관리</a>
                <a class="dropdown-item" href="#">
                	<i class="fa fa-gear fa-fw"></i>제휴업체관리</a>
                </div>
                </li>
                </ul>
              
                <!-- 일반회원 -->
               <%}else{ %> 
                <div class="dropdown-menu dropdown-menu-right login" id="navbarDropdownLogin" aria-labelledby="navbarDropdownBoard">
                <a class="dropdown-item" href="<%=request.getContextPath() %>/memberView?userId=<%=memberLoggedIn.getUserId()%>">마이페이지</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/logout">로그아웃</a>
                </div>
                </li>
                </ul>
                <%}
              
                }%>
        </div>        
      </div>
      
      	<!-- 반응형처리 -->
		<div class="hidden-xs">		
            <!-- 비 로그인 로그인페이지로 넘기기 -->
            <%if(memberLoggedIn==null) { %>
          	<ul class="navbar-nav ml-auto ">
            <li class="nav-item dropdown">
              <a class="nav-link  btn btn-empty login" href="<%=request.getContextPath() %>/views/member/login.jsp" title="Login to SkyGym" >
               Login
              </a>         
              </li>
             </ul>         	
          <%-- 	<div>
          	
               <a href="<%=request.getContextPath() %>/views/member/login.jsp" title="Login to SkyGym" class="btn btn-empty login">Login</a>
            </div>  --%>
            <%}else{ %>          
            <!-- 로그인 시 -->            
            <ul class="navbar-nav ml-auto ">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle btn btn-empty login" href="#" id="loginDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%= memberLoggedIn.getUserName() %>님 
              </a>             
              <!-- 관리자 -->
              <%if(memberLoggedIn.getUserId().equals("admin")){%>
              <div class="dropdown-menu dropdown-menu-right login" id="navbarDropdownLogin" aria-labelledby="navbarDropdownBoard">
                <a class="dropdown-item" href="<%=request.getContextPath() %>/memberView?userId=<%=memberLoggedIn.getUserId() %>">
                	<i class="fa fa-user fa-fw"></i>마이페이지</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/logout">
                	<i class="fa fa-sign-out fa-fw"></i>로그아웃</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/admin/memberList"">
                	<i class="fa fa-gear fa-fw"></i>회원관리</a>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/admin/gymList">
                	<i class="fa fa-gear fa-fw"></i>지점관리</a>
                </div>                              
                <!-- 일반회원 -->
               <%}else{ %> 
                <div class="dropdown-menu dropdown-menu-right login" id="navbarDropdownLogin" aria-labelledby="navbarDropdownBoard">
                <a class="dropdown-item" href="<%=request.getContextPath() %>/memberView?userId=<%=memberLoggedIn.getUserId()%>">
                <i class="fa fa-user fa-fw"></i>마이페이지</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/logout">
                <i class="fa fa-sign-out fa-fw"></i>로그아웃</a>
                </div>
       
                <%}%>
              	</li>
                </ul>
                <%}%> 
                
          </div>
    </nav>
<!-- 본문삽입부분  -->

