<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.skygym.rank.model.vo.GymRank"%>
<%
ArrayList<GymRank> allList=(ArrayList)request.getAttribute("allList");
ArrayList<GymRank> seoulList=(ArrayList)request.getAttribute("seoulList"); 
ArrayList<GymRank> gyeongiList=(ArrayList)request.getAttribute("gyeongiList");

%>

<%@ include file="/views/common/header.jsp"%>



<link href="<%=request.getContextPath()%>/css/rankList.css" rel="stylesheet">

<div class="carousel-item active" style="height:50%; background-image: url('<%=request.getContextPath()%>/img/main2.jpg')">
   <div class="carousel-caption d-none d-md-block">
     <h2>지점랭킹</h2>
     <p>Ranking Service</p>
     <p style='font-size: 17px;'>SKYGYM 회원님들의  평가를 기반으로 순위표를 제공합니다.</p>

   </div>
 </div>
<br><br>
<div class="container">

<div class="dropdown" id="rankinglist_category">
  <button class="btn xet_btn large sky dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
    &ensp;운동종목&ensp; 
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    <li role="presentation"><a role="menuitem" href="<%=request.getContextPath()%>/rank/rankList?category=health">헬스</a></li>
    <li role="presentation"><a role="menuitem" href="<%=request.getContextPath()%>/rank/rankList?category=militaryArts">무술</a></li>
    <li role="presentation"><a role="menuitem" href="<%=request.getContextPath()%>/rank/rankList?category=physical">채형교정</a></li>
    <li role="presentation"><a role="menuitem" href="<%=request.getContextPath()%>/rank/rankList?category=martialArts">종합격투기</a></li>
  </ul>
</div>


<div style="width: 940px; margin:0 auto;">
	<div class="ranking-box">
	
		<div>
			<div class="ranking-box-title border_red">전체지역</div>
			<div class="ranking_box_sub_title">전체 평점킹</div>
		</div>
		<%
		
		for(GymRank gr : allList) {%>
		<div class="ranking-list" style="border-top: 1px solid #ddd;">
			<div class="ranking-list-thumb"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>"><img src="<%=request.getContextPath() %><%=gr.getMainimage()==null?"parkGym.png":gr.getMainimage()%>" /></a></div>
			<div class="ranking-list-num" style="padding:5px"><%=gr.getRank()%>위</div>
   	        <div class="ranking-list-text">
            	<div class="ranking-list-brand">
					<div class="ranking-list-brand-name"><%=gr.getGymBranchName()%><br></div>
					<div class="ranking-list-score"><%=gr.getScore() %>/5.0점</div>
					<span class="ranking_list_link"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>">전체보기 > </a></span>                 
                </div>
                <div class="ranking-list-item"><%=gr.getGymAddress() %></div>
           </div>
		</div>
		<%
		}%>
	</div>
	<div class="ranking-box" style="padding-left:20px;">
		<div>
			<div class="ranking-box-title border_yellow">서울지역</div>
			<div class="ranking_box_sub_title">서울 평점킹</div>
		</div>
		<%
		for(GymRank gr : seoulList) {
			if(gr.getGymDistrict().equals("서울")){%>
		<div class="ranking-list" style="border-top: 1px solid #ddd;">
			<div class="ranking-list-thumb"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>"><img src="<%=request.getContextPath() %><%=gr.getMainimage()==null?"parkGym.png":gr.getMainimage()%>" /></a></div>
			<div class="ranking-list-num" style="padding:5px"><%=gr.getRank()%>위</div>
   	        <div class="ranking-list-text">
            	<div class="ranking-list-brand">
					<div class="ranking-list-brand-name"><%=gr.getGymBranchName()%><br></div>
					<div class="ranking-list-score"><%=gr.getScore() %>/5.0점</div>
					<span class="ranking_list_link"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>">전체보기 > </a></span>                 
                </div>
                <div class="ranking-list-item"><%=gr.getGymAddress() %></div>
           </div>
		</div>
		<%
			}
		}%>
	</div>
	<div class="ranking-box" style="padding-left:20px;">
		<div>
			<div class="ranking-box-title border_yellow">경기지역</div>
			<div class="ranking_box_sub_title">경기 평점킹</div>
		</div>
		<% for(GymRank gr : gyeongiList) {
			if(gr.getGymDistrict().equals("경기도")){
		%>
		<div class="ranking-list" style="border-top: 1px solid #ddd;">
			<div class="ranking-list-thumb"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>"><img src="<%=request.getContextPath() %><%=gr.getMainimage()==null?"parkGym.png":gr.getMainimage()%>"/></a></div>
			<div class="ranking-list-num" style="padding:5px"><%=gr.getRank()%>위</div>
   	        <div class="ranking-list-text">
            	<div class="ranking-list-brand">
					<div class="ranking-list-brand-name"><%=gr.getGymBranchName()%><br></div>
					<div class="ranking-list-score"><%=gr.getScore() %>/5.0점</div>
					<span class="ranking_list_link"><a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%=gr.getGymNumber()%>">전체보기 > </a></span>                 
                </div>
                <div class="ranking-list-item"><%=gr.getGymAddress() %></div>
           </div>
		</div>
		<%
			}
		}%>
	</div>
</div>	
</div>
<%@ include file="/views/common/footer.jsp"%> 