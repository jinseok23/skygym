<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
	page import="com.skygym.findgym.model.vo.GYM, java.util.*,
				com.skygym.detailview.model.vo.GYMImage,
				com.skygym.detailview.model.vo.Trainer,
				com.skygym.detailview.model.vo.GYMReply,
				com.skygym.member.model.vo.Member"
 %> 
 <%
 	int GYMNumber = (int)request.getAttribute("GYMNumber");
 	GYM g = (GYM)request.getAttribute("GYM");
	GYMImage imglist = (GYMImage)request.getAttribute("imglist");
	Trainer t = (Trainer)request.getAttribute("t");
 	List<GYMReply> commentList = (List)request.getAttribute("list"); 
 	Member m = new Member();
 	GYMReply reply = (GYMReply)request.getAttribute("GYMReply"); 	
 %>

<%@ include file='/views/common/header.jsp' %>

<script src="vendor/jquery/jquery.min.js"></script>

<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="http://cdn.jsdelivr.net/xeicon/1.0.4/xeicon.min.css" />


<style>
	#recipeDetail .nutritional , #recipeDetail .nutritional  h3{color:#fff;}
    #slider,
    #carousel {margin:auto;}
    
    #slider,
    #slider img {
        width: 600px;
        height: 600px;
    }
    #carousel{
       width: 600px;
    }
    #carousel img {
        width: 125px;
        height: 125px;
    }
    .col-lg-9 {width: 100%;}
    .recipe-set {width: 100%;margin: auto;float:left;padding: 25px 40px;}
    .wrapper-detail-contents {display:flex;}
    .wrapper-recipe-heading {display:block;}
    .single-recipe-detail {width:100%;}
    .slider-recipe-detail {display:inline-block;width:100%;display: flex;}
    
    /* 
    	댓글 css
     */
    
    .recipe-steps {display: inline-block;margin-bottom: 44px;}
    .recipe-detail-body h2, .recipe-detail-body h3, .recipe-comments h2{text-align: left;color:#000;font-weight:bold;}
    .box_write {
        background-color: #f7f7f7;
        height: 130px;
        box-sizing: border-box;
        padding: 13px 18px;
        border: 1px solid #e6e6e6;
        margin-bottom: 10px;
     }
     .box_write textarea {
        width: 85%;
        height: 71px;
        box-sizing: border-box;
        border: 1px solid #e6e6e6;
        resize: none;
        float: left;
        color: #c7c7c7;
        font-size: 16px;
        text-align: center;
        padding-top: 20px;
        color: #313131;
        overflow: auto;
     }
     
    .box_write input[type='submit'] {
        display: block;
        width: 123px;
        height: 71px;
        background-color: #f26c4f;
        border: none;
        color: #fff;
        font-size: 17px;
        float: right;
     }
     .alterbtn button, input[type='button']{
     	display: block;
        width: 75px;
        height: 40px;
        margin-right:5px;
        background-color: #f26c4f;
        border: 1px groove black;
        color: #fff;
        font-size: 13px; 
        float: right;
     }
     

	 /*댓글테이블*/
	table#tbl-comment{width:100%; margin:0 auto; border-collapse:collapse; clear:both; } 
	table#tbl-comment tr td{border-top:1px groove black; border-bottom:1px groove black; border-left:none; 
		border-right:none; padding:5px; text-align:left; line-height:100%;
	}
	
	table#tbl-comment sub.userId {color:navy; font-size:20px}
	table#tbl-comment sub.reply-date {color:tomato; font-size:20px}
	
     
     
     .info-icons {margin-top:40px;margin-bottom:0;text-align: center;}
     .info-icons .semipart {width:20%;}
     
     #wrap {background-color:#fff;}
     
    .selectStar {display:block; height:30px;line-height:30px;}
    .selectStar label {float:left;font-weight:bold;margin-right:10px;}
    .commentArea {float:left;width:100%; margin-bottom: 10px; background-color : white;}
    .avgStar {height: 70px;width: 100%;line-height: 70px;display: -webkit-inline-box;}
    .avgStar label {font-size:25px;font-weight:bold;margin: 0 25px;}
    .avgStar img {width:100px;vertical-align: middle; margin-top:-10px;}
    .avgStar p {    
       font-size: 30px;
       line-height: 70px;
    }
     
    .ingredients h3 {
       font-size: 24px;
        padding: 30px 0 10px 0;
        color: #f26c4f;
        border-bottom: 1px solid;
     }
     
     .nutritional {color:#fff;}
     .nutritional h3 {
       font-size: 24px;
        padding: 30px 0 10px 0;
        color: #fff;
        border-bottom: 1px solid;
     }
     
     .step-detail p {color:black;}
     
     .scrapBtn {
         padding: 5px;
        width: 220px;
        border: 1px solid #f26c4f;
        font-size: 16px;
        line-height: 25px;
        color: #f26c4f;
        border-radius: 18px;
        background-color: #fff;
       	font-size: 20px;
        font-weight: bold;
    }
    
    .scrapArea {
    	text-align: center;
    }
  	#tbl-operatinghours  th, td {
		
		text-align: center;
		border: 1px solid black;
	}
	#price  th, td {
		
		text-align: center;
		border: 1px solid black;
	}
	#ptprice  th, td {
		
		text-align: center;
		border: 1px solid black;
	}
	
	#tbl-operatinghours th {
	   background-color: #8BBBD2;
	}
	#price th {
	   background-color: #8BBBD2;
	}
	#ptprice th {
	   background-color: #8BBBD2;
	}
	#comment-div{
		font-family: :'Nanum Gothic', sans-serif;
	}
	
	.container{
	 font-family: :'Nanum Gothic', sans-serif;
	}
    
</style>
<br><br><br>


<!-- Page Content -->
<div class="container">

   <!-- Portfolio Item Row -->
	<div class="row">

		<div class="col-md-8">
		   <img class="img-fluid" src="<%=request.getContextPath()%><%=imglist.getMainImage() %>" alt="메인이미지" style="width:100%;height:100%;">
		</div>

		<div class="col-md-4">
      	
         <h2 class="my-3"><%=g.getGYMbranchName() %></h2>
         
         <p><%=g.getGYMInfo() %></p>
         <br>
         <br>
         <br>
         <br>
         <br>
         <br>
         <br>
         <h3>
            <small><strong>주소</strong></small>
         </h3>
         <hr>
         <p>
            <strong><%=g.getGYMAddress() %></strong> <br>
            <br> <span style='font-size: 25pt; color: #ed0677;'><%=g.getGYMtel() %></span>
         </p>
         <img src="<%=request.getContextPath() %>/img/logo2.png" style="width: 150px; height: 50px"/></img>
   			</div>
	      <br>
	   </div>
	   <!-- /.row -->
		
	   <!-- Related Projects Row -->
	   <br>
	   <hr>
	   <h3 class="my-4"><strong><i class='xi-images'></i>&nbsp;시설 사진</strong></h3>
	   <hr>
	   <div class="row">
	      <div class="col-md-3 col-sm-6 mb-4">
	         <a href="#"> <img class="img-fluid" src="<%=request.getContextPath()%><%=imglist.getSubImagea() %>" alt="subImagea" style="width:100%;height:100%;">
	         </a>
	      </div>
	
	      <div class="col-md-3 col-sm-6 mb-4">
	         <a href="#"> <img class="img-fluid" src="<%=request.getContextPath()%><%=imglist.getSubImageb() %>" alt="subImageb" style="width:100%;height:100%;">
	         </a>
	      </div>
	
	      <div class="col-md-3 col-sm-6 mb-4">
	         <a href="#"> <img class="img-fluid" src="<%=request.getContextPath()%><%=imglist.getSubImagec() %>" alt="subImagec" style="width:100%;height:100%;">
	         </a>
	      </div>
	   </div>
	   
	   <!-- /.row -->
	   
	   <br><hr> <i class="far fa-clock"></i> &nbsp;운영시간 <br>
	   <hr>
	   <table id='tbl-operatinghours' style="width:900px;">
	      <tr>
	         <th colspan="3">평일</th>
	         <th colspan='2'>일요일, 공휴일</th>
	         <th colspan='2'>정기휴관일</th>
	         <th colspan='2'>기타휴일</th>
	      </tr>
	      <tr>
	         <td>OPEN</td>
	         <td>주중</td>
	         <td>CLOSE</td>
	         <td>OPEN</td>
	         <td>CLOSE</td>
	         <td colspan='2' rowspan='2'>365일 오픈을 원칙으로 하고 있으나
	         <br> 지점 관리상 휴관이 필요할때는<br> 미리 공지해 드립니다.
	         </td>
	         <td colspan='2' rowspan='2'>구정, 추석 명절에도 오픈<br> (근무자 부재시 휴관)
	         </td>
	      </tr>
	      <tr>
	         <td>월요일<br> 새벽 0시
	         </td>
	         <td>24시</td>
	         <td>토요일<br> 밤 11시
	         </td>
	         <td>오전 10시</td>
	         <td>오후 6시</td>
	      </tr>
	   </table>
	   <br>
	   <br>
	   <hr>
	   <div>
	      <i class="fas fa-won-sign"></i> &nbsp;이용요금 <br>
	      <hr>
	      <table id='price' style="width:900px;">
	         <tr>
	            <th></th>
	            <th>1개월</th>
	            <th>3개월</th>
	            <th>6개월</th>
	            <th>1년</th>
	         </tr>
	         <tr>
	            <td>이용요금</td>
	            <td>6만원</td>
	            <td>15만원</td>
	            <td>20만원</td>
	            <td>25만원</td>
	         </tr>
	         <tr>
	            <td>운동복대여</td>
	            <td>5천원</td>
	            <td>1만원</td>
	            <td>3만원</td>
	            <td>무료</td>
	         </tr>
	         <tr>
	            <td>개인사물함</td>
	            <td>1만원</td>
	            <td>3만원</td>
	            <td>5만원</td>
	            <td>7만원</td>
	         </tr>
	      </table>
	      <br>
	      <p>
	         *헬스 1일 이용요금 : 10,000원(대여운동복포함) *부가세 별도<br> *운동복 1일 대여요금: 1천원
	         *SKYGYM 최초가입시에는 가입비 3만원이 추가됩니다.
	      </p>
	   </div>
	   <hr>
	   <i class="fas fa-money-check-alt"></i> &nbsp;P.T 요금 <br>
	   <hr>
	   <div>
	      <table id='ptprice' style="width:900px;">
	         <tr>
	            <th>트레이너 등급</th>
	            <th>session당 금액</th>
	         </tr>
	         <tr>
	            <td>1</td>
	            <td>3만원</td>
	         </tr>
	         <tr>
	            <td>2</td>
	            <td>5만원</td>
	         </tr>
	         <tr>
	            <td>3</td>
	            <td>7만원</td>
	         </tr>
	      </table>
	   </div>
	   <br>
	   <p>
	      *부가세 별도<br> *10세션 이상 등록시 할인이 적용되오니 전화로 문의해 주세요.
	   </p>
	   <div>
	   <hr>
	      <i class="far fa-address-card"></i> &nbsp;트레이너 정보 
	      <br><hr>
	      <div style='display:inline-block;'>
	      		<div style='float:left;width:45%;'>
		      		<img src="<%=request.getContextPath()%><%=t.getTrainerAImage() %>" width="300px" height="350px"></img>
		      		<div style='display:inline-block;'>
		      			<p><strong>NAME : <%=t.getTrainerAName() %></strong></p>
		      			<p><strong>PART : <%=t.getTrainerAPart() %></strong></p>
		      		</div>
		      	</div>
		      	
		      	<div style='float:right;width:45%;'>
		      		<img src="<%=request.getContextPath()%><%=t.getTrainerBImage() %>" width="300px" height="350px"></img>
		      		<div style='display:inline-block;'>
		      			<p><strong>NAME : <%=t.getTrainerBName() %></strong></p>
		      			<p><strong>PART : <%=t.getTrainerBPart() %></strong></p>
		      		</div>
		      	</div>
	      </div>
	   </div>
	   <br><hr>
	   
	   
	   <div>
	      <i class="far fa-id-badge"></i> &nbsp;신규회원 이용가이드
	      <br><hr>
	      	1. 운동하러 나오시는 첫날 처음오셨다고 말씀해 주시면 그날부터 시작하는것으로 해 드립니다.<br>
			2. 수건,비누는 기본적으로 제공됩니다. 기타 필요하신 물건이 있으면 직접 준비해 주세요.<br>
			3. 지점내에서만 신을 운동화를 별도로 준비해 주세요.<br>
			4. 회원등록시에 발급받은 회원카드는 입장시 꼭 체크해 주셔야 회원확인이 가능합니다.<br>
			5. 등록하신 지점 이외의 체인지점을 이용하실때에는 월10회까지 이용하실 수 있습니다. <br>
			6. 운동지도 등 그 밖에 필요한 사항은 운동하시러 나오는 첫날 안내해 드리오니 첫날 데스크에 꼭 말씀해주세요.<br>
	   </div>
	   <hr>
	   
	   
	   <div>
	      <i class="far fa-check-circle"></i> &nbsp;유의사향
	      <br><hr>
		    1. 일일 일회, 회원본인만 이용하실 수 있습니다.<br>
			2. 등록이후에는 환불 및 양도가 불가 합니다.<br>
			3. 연기는 1개월미만,1회까지만 가능합니다.(3개월 등록 기준)<br>
			4. 개인보관함 외에 보관된 물품은 분실시 책임지지 않습니다.<br>
			5. 개인보관함에 보관된 물품이라도 등록일이 경과된 물품은 일주일후 보관함에서 꺼내 별도로 보관하며 한달후에는 더이상 보관하지 않습니다.<br>
			6. 다른 회원에게 방해되는 행동을 하거나 지도자의 지도를 따르지 않는등 본 지점의 규칙에 협조해주지 않으시는분은 회원자격이 취소될 수 있습니다.<br>
	   </div>
	   <br><br><hr>
	   <!-- 지도 API -->
	   
	   <div>
	      <i class="xi-map-folding"></i> &nbsp;위치
	   </div>
	   <hr>
		<div id="map" style="width:100%;height:400px;"></div>
		
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=384757bdbe4d173c01c82bf69da6d8c4&libraries=services"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('<%=g.getGYMAddress() %>', function(result, status) {
			
		    // 정상적으로 검색이 완료됐으면 
		     if (status === daum.maps.services.Status.OK) {
				
		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });
				
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=g.getGYMbranchName() %></div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    }
		});
		</script>
		
		
		
	<%if(memberLoggedIn!=null) {			
	%>
	<br><br>
	<hr>
	<h3><small><i class='xi-pen'></i>&nbsp;평점 남기기</small></h3>
	<hr>
		
   	<!-- 댓글작성 영역 -->
   	<form class="box_write" id="new_comment" action="<%=request.getContextPath() %>/InsertComment.do" accept-charset="UTF-8" method="post">
   		<input type="hidden" name='GYMNumber' value=<%=GYMNumber %>>
   		<input type="hidden" name="userId" value="<%=memberLoggedIn.getUserId() %>">
   		<input type="hidden" name="replyLevel" value="1">   		
   		   		
       	<!-- 점수주기 -->	
       	<div class="selectStar">
            <label class="col-form-label">제 점수는요 </label>
            <input type="radio" name="chk_point" value="5" checked="checked"/>
            <img src ="<%=request.getContextPath() %>/img/star5.png" style="width:80px;"/>
            
            <input type="radio" name="chk_point" value="4"/>
            <img src ="<%=request.getContextPath() %>/img/star4.png" style="width:80px;"/>
            
            <input type="radio" name="chk_point" value="3"/>
            <img src ="<%=request.getContextPath() %>/img/star3.png" style="width:80px;"/>
            
            <input type="radio" name="chk_point" value="2"/>
            <img src ="<%=request.getContextPath() %>/img/star2.png" style="width:80px;"/>
            
            <input type="radio" name="chk_point" value="1"/>
            <img src ="<%=request.getContextPath() %>/img/star1.png" style="width:80px;"/>
  	 	</div>
  	 	
  	 	<!-- 댓글입력창 -->
		<div class="commentArea">
			<textarea placeholder="한 줄 댓글을 남겨주세요." name="reply_content" id="comment_comment"></textarea>	    	
	    	<input type="submit" value="댓글남기기" class="btn">	    	
		</div>
	</form>
	<%} %>
	
	<br/>
	
	<!-- 댓글 -->
	<div id='comment-div' accept-charset="UTF-8" method="post" style="background:#f7f7f7;">
		<table id="tbl-comment">
		<%if(commentList!=null) 
		{
			%>
			
		<%
			for(GYMReply gr:commentList)
			{
				if(gr.getReplyLevel()==1)
				{
			%>
			<tr class="level1">
				<td style="height:150px;">
					<sub class="userId"><%=gr.getUserId() %></sub>
					<sub class="reply_date"><%=gr.getReply_date() %></sub>
					<sub class="GYMScore">
					<%String temp1 = "";
					switch(gr.getGYMScore()){
					case 1 : temp1 = "/img/star1.png"; break;
					case 2 : temp1 = "/img/star2.png"; break;
					case 3 : temp1 = "/img/star3.png"; break;
					case 4 : temp1 = "/img/star4.png"; break;
					case 5 : temp1 = "/img/star5.png"; break;
				} %>
						<img src="<%=request.getContextPath()%><%=temp1 %>" style="width:80px;"/>
					</sub>
					
					<br/><br/><br>
					
						<p id='re-comment'><%=gr.getReply_content() %></p>
					<%
				if(memberLoggedIn!=null)
				{
					if(gr.getUserId().equals(memberLoggedIn.getUserId())||"admin".equals(memberLoggedIn.getUserId()))
					{ %>
					<div class='alterbtn'>						
						<form name='deleteComment' action='<%=request.getContextPath() %>/detail/deleteComment' accept-charset="UTF-8" method="post">
								<input type='hidden' id='replyNumber' name='replyNumber' value='<%=gr.getReplyNumber() %>'>
								<input type='hidden' name='GYMNumber' value=<%=gr.getGYMNumber() %>>
						   		<input type='hidden' name='userId' value='<%=gr.getUserId() %>'>
						   		<input type='hidden' name='replyLevel' value='<%=gr.getReplyLevel() %>'>
						   		<input type='hidden' id='re-content1' name='re-content1' value='<%=gr.getReply_content() %>'>
								<button id='btn-delete' class="btn" onclick='fn_delete()' name='deleteComment'>삭제</button>
						</form>								
								<button class='btn-updatecon btn' type='button'  style='display:none;' value='<%=gr.getReplyNumber() %>'>수정완료</button>
								<button class='btn-update btn' type='button'  name='updateComment'>수정</button>
					</div>
					<%}
					}%>
					
				</td>
			</tr>
				<%}
			} // for문 닫기 // if문 닫기
		}%>
		</table>
		</div>
	
	</div>
    <!-- /.container -->
<script>

	function fn_loginAlert()
	{
	   alert("로그인 후 이용하세요~!");
	   confirm("<%=request.getContextPath() %>/member/login.jsp");
	}	
		
	if(<%=memberLoggedIn!=null%>)
	{
		$('.btn-update').on('click',function()
				{
					($(this).parent().parent()).children('p').html("<input size='60' type='text' name='re-content' id='re-content'></input>");
					$(this).prev().css('display','inline-block');
					$('.btn-delete').css('display','none');
					$(this).css('display','none');
					
				});
				
				$('.btn-updatecon').on('click',function(){
					var dd={
							replyNumber : $(this).val(),
							GYMNumber : "<%=GYMNumber %>",
							replyContent : $('#re-content').val()
						}
					$.ajax({
						url : "<%=request.getContextPath()%>/detail/updateComment",
						data : dd,
						dataType : "html",
						success : function(data)
						{
							$('#tbl-comment').html(data);
						}
						}); 
					});
	}
	
	function fn_delete(){
		
		var bool = confirm("정말 삭제하시겠습니까?");
		if(bool)
		{
		 
		}
		else
		{
		   alert("취소되었습니다.");
		   event.preventDefault();
		}
	}
	
</script>
<%@ include file='/views/common/footer.jsp' %>