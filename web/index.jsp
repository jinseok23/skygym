<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url('<%=request.getContextPath()%>/img/main1.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h2>Matching System</h2>
              <p>회원님에게 꼭 맞는 GYM을 추천해드립니다.</p>
            </div>
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/img/main2.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h2>Ranking System</h2>
              <p>SKYGYM 회원님들의  평가를 기반으로 순위표를 제공합니다.</p>
            </div>
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/img/main3.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h2>Detail Page</h2>
              <p>지점의 상세한 정보를 제공합니다.</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
</header>
<br><br><br><br>
<div class="container">
	<%if(memberLoggedIn==null){ %>
      <div class="row gothic" style="background:white; font-weight: 300;" >
        <div class="col-sm-8">
          <h2 class="mt-4">SKY GYM이 특별한 이유?</h2>
          <p><br>사용자의 지역정보와 흥미를 기반으로 <br>
          	체육관을 매칭해주는 어디에도 없던 특별한 기능</p>
          <p>
            <a class="btn xet_btn sky large" href="<%=request.getContextPath() %>/memberEnroll">지금 바로 시작하세요! &raquo;</a>
          </p>
        </div>
        <div class="col-sm-4">
          <h2 class="mt-4">Contact Us</h2>
          <address>
            <strong>SKYGYM</strong>
            	 (T: 1544-9970 / F: 070-8290-2889)
            <br>서울특별시 강남구 테헤란로 14길 6
            <br>남도빌딩, 4F, R-Class New Sky Team
            <br>
          </address>
          <address>
            <abbr title="Phone">Phone : </abbr>  
            010-9049-1104          
            <br>
            <abbr title="Email">Email : </abbr>
            <a href="mailto:#">powas@naver.com</a>
          </address>
        </div>
      </div>
     </div>
      <!-- /.row -->
      <%}else{ %>
            <div class="row gothic" style="background:white; font-weight: 300;" >
        <div class="col-sm-8">
          <h2 class="mt-4">SKY GYM이 특별한 이유?</h2>
          <p><br>사용자의 지역정보와 흥미를 기반으로 <br>
          	체육관을 매칭해주는 어디에도 없던 특별한 기능</p>
          <p>
            <a class="btn xet_btn sky large" href="<%=request.getContextPath() %>/recommend/MemberRecommend?userId=<%=memberLoggedIn.getUserId()%>">Matching System 바로가기 &raquo;</a>
          </p>
        </div>
        <div class="col-sm-4">
          <h2 class="mt-4">Contact Us</h2>
          <address>
            <strong>SKYGYM</strong>
            	 (T: 1544-9970 / F: 070-8290-2889)
            <br>서울특별시 강남구 테헤란로 14길 6
            <br>남도빌딩, 4F, R-Class New Sky Team
            <br>
          </address>
          <address>
            <abbr title="Phone">Phone : </abbr>  
            010-9049-1104          
            <br>
            <abbr title="Email">Email : </abbr>
            <a href="mailto:#">powas@naver.com</a>
          </address>
        </div>
      </div>
     </div>
      <!-- /.row -->
      <%} %>

    </div>
      
 
<br><br><br><br><br>
    
    
		
		
			
<%@ include file="/views/common/footer.jsp"%>
