<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<style>
	div#enroll-container{padding:0 200px;font-size:12px;}
	table#enrolltbl tr{
		border-top:1px solid gray;
	}
	table#enrolltbl td
	{
		padding:10px 30px;
	}
	.tbl-header{background-color:#F6F6F6;text-align:center;color:gray;}
	#enrollbtn{width:400px; height:50px;margin-top:20px;}
	span{font-size:23px;}
	.tel{width:60px;}
	.email{width:110px;}
	.address{width:450px;margin-top:8px;}
	#city-seoul
	{
		display:inline;
	}
	#city-gyeonggi
	{
		display:none;
	}
	#randomNumber
	{
		display:none;
	}
	.btn_black{background-color:#0A0A2A; color:white;padding:5px;border:0px;}
</style>
<script>
	$(function(){
		$('#password_').focus(function(){
			checkId1();
		});
		//비밀번호가 일치한지 확인
		$('#password_2').focusout(function(){
			var pw1=$('#password_').val().trim();
			var pw2=$('#password_2').val().trim();
			if(pw1!=pw2)
		    {
		        $('#pwdresult').html("비밀번호 불일치").css('color','red');
		        $('#password_').val("");
		        $('#password_2').val("");
		        $('#password_').focus();
		    }
		    else{
		        $('#pwdresult').html("비밀번호 일치").css('color','green');
		    }
		});
	
		//이메일 주소 선택하기
		$('#emailselect').change(function() {
			if ($('#emailselect').val() == "1") {
				$("#email2").val(""); //값 초기화
				$("#email2").prop("readonly", false); //활성화
			}
			else {
				$("#email2").val($('#emailselect').val()); //선택값 입력
				$("#email2").prop("readonly", true); //비활성화
			}
		});
	});
	function fn_checkDuplicate()
	{
		checkId1();
		var userId=$('#userId_').val().trim();
		
		if(!userId||userId.length<4)
		{
			alert("아이디는 4글자 이상입니다!");
			return;
		}
		
		var url="<%=request.getContextPath()%>/checkId";
		var title="IDcheck";
		var status="left=500px, top=100px, width=400px, height=300px, menubar=no, status=no, scrollbars=yes";
		var popup=window.open('',title,status);
		checkId.userId.value=$('#userId_').val();
		checkId.target=title;
		checkId.action=url;
		checkId.method="post";
		checkId.submit();
	}
	function checkId1(){
		var checkid=document.memberEnrollFrm.idvalid.value;
		if(checkid==0){
			$('#idresult').html("중복확인 해야합니다.").css('color','red');
	        $('#userId_').focus();
		}
		else
		{
			$('#idresult').html("사용가능한 아이디입니다").css('color','green');
		}
	};
	$(function(){
		var seoul=document.querySelector("#city-seoul");
		var gyeonggi=document.querySelector('#city-gyeonggi');
		$('#city-main').change(function(){
			seoul.style.display='none';
			gyeonggi.style.display='none';
			$('#city-'+this.value).css("display","inline-block");
		});
	});

	$(function(){
		$('#Authentication').on("click",function(){
			var email1=$('#email1').val();
			var email2=$('#email2').val();
			if(email1==""||email2=="")
			{
				alert("이메일을 입력하시오");
			}
			else
			{
				$('#randomNumber').css('display','inline-block');
				$.ajax({
					url : "<%=request.getContextPath()%>/memberMail",
					type : "post",
					data : {"email1":email1, "email2":email2},
					dataType : 'html',
					success : function(data){
						alert("메일 인증번호를 전송하였습니다.");
					}
				});
			}
		});
	});
	$(function(){
		$("#btn_check").on("click",function(){
			var userNum=$('#userNum').val().trim();
			$.ajax({
				url : "<%=request.getContextPath()%>/checkRandomNum",
				type : "post",
				data : {"userNum":userNum},
				dataType: 'html',
				success : function(data)
				{
					$("#emailresult").html(data);
					
					if($(".checksuccess").val()==1)
					{
						document.memberEnrollFrm.emailvalid.value=1;
						$('#watch').css("display","none");
					}
				}
			});
		});
	}); 
	function fn_signUp()
	{  
		if(document.memberEnrollFrm.emailvalid.value==0)
		{
			alert("이메일 인증을 해야합니다.");
			return false;
		}
		
		return true;
	}
	function stopwatch(){
    	var minute = 2;
    	var second = "00";
    	// 초기화
    	$("#watch").html(minute+":"+second);
    	var timer = setInterval(function () {
   			// 설정
   			$("#watch").html(minute+":"+second);
   			if(second == 0 && minute == 0 ){
   				$("#watch").html("재인증 하십시오");
   				clearInterval(timer); /* 타이머 종료 */
   			}
   			else{
   				second--;
   				// 분처리
   				if(second < 0){
   					minute--;
   					second = 59;
   				}
   			}
       	}, 1000);
    }

	var maxChecked = 2;   //선택가능한 체크박스 갯수
	var totalChecked = 0; // 설정 끝
	function countChecked(field) {
	    if (field.checked){totalChecked += 1;}
	    else{totalChecked -= 1;}
	    if (totalChecked > maxChecked) {
	        alert ("최대 2개 까지만 가능합니다.");
		    field.checked = false;
		    totalChecked -= 1;
	    }
	}
</script>
<div id='enroll-container'>
	<br><br>
	<h2 style="text-align: center;">회원가입</h2>
	
	<hr>
	<br><h5 style="text-align: center;">기본정보</h5><br>
	<form action="<%=request.getContextPath()%>/memberEnrollEnd" name="memberEnrollFrm" method="post" onsubmit="return fn_signUp()">
		<table id='enrolltbl' align="center">
			<tr>
				<td class='tbl-header'>아이디</td>
				<td>
					<input type='text' name="userId_" id="userId_" minlength='4' required/>
					&ensp;<input type="button" value="중복확인" class='btn xet_btn sky medium' onclick="fn_checkDuplicate();"/>
					<input type="hidden" name="idvalid" value='0'/>
					<label id="idresult"></label>
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>패스워드</td>
				<td>
					<input type="password" name="password_" id="password_" minlength='6' required> &ensp;6자 이상
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>패스워드확인</td>
				<td>
					<input type="password" id="password_2" minlength='6' required>
					<label id="pwdresult"></label>
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>이름</td>
				<td>
					<input type="text" name="userName" id="userName" required>
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>생년월일</td>
				<td>
					<input type="text" name="residentNum" id="residentNum" minlength='6' placeholder='ex)921023' required>
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>휴대폰</td>
				<td>
                    <select name='tel1' id='tel1'>
                        <option value='010'>010</option>
                        <option value='011'>011</option>
                        <option value='016'>016</option>
                    </select><span>-</span>
					<input type="text" name="tel2" class='tel' id="tel2"><span>-</span>
					<input type="text" name="tel3" class='tel' id="tel3">
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>이메일</td>
				<td>
					<input type='text' name="email1" id="email1" class='email' required><span>@</span>
					<input type='text' name="email2" id="email2" class='email' placeholder="직접입력" required>
                    <select name='emailselect' id='emailselect'>
						<option value="1" selected>직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="daum.net">daum.net</option>
						<option value="gmail.com">gmail.com</option>
						<option value="empas.com">empas.com</option>
						<option value="dreamwiz.com">dreamwiz.com</option>
						<option value="freechal.com">freechal.com</option>
					</select>
					&ensp;<input id="Authentication" type="button" value="메일인증" onclick='stopwatch()' class='btn xet_btn sky medium'/>
					<br>
					<div id="randomNumber">
						<input id='userNum' type='text' width='20px' height='10px' />
						<input type="hidden" name="emailvalid" value='0'/>
						<input type='button' id='btn_check' name='btn_check' class='btn xet_btn sky medium' value='확인'>
						<span id='watch' style='font-size:16px;'></span>
						<label id="emailresult"></label>
					</div>
					
                </td>
            </tr>
            <tr>
				<td class='tbl-header'>주소</td>
				<td>
					<select name='city-main' id='city-main'>
                        <option value='seoul'>서울특별시</option>
                        <option value='gyeonggi'>경기도</option>
                    </select>
					<select name='city-seoul' id='city-seoul'>
					    <option value='강남구'>강남구</option>
                        <option value='강동구'>강동구</option>
                        <option value='강북구'>강북구</option>
                        <option value='강서구'>강서구</option>
                        <option value='관악구'>관악구</option>
                        <option value='광진구'>광진구</option>
                        <option value='구로구'>구로구</option>
                        <option value='금천구'>금천구</option>
                        <option value='노원구'>노원구</option>
                        <option value='도봉구'>도봉구</option>
                        <option value='동대문구'>동대문구</option>
                        <option value='동작구'>동작구</option>
                        <option value='마포구'>마포구</option>
                        <option value='서대문구'>서대문구</option>
                        <option value='서초구'>서초구</option>
                        <option value='성동구'>성동구</option>
                        <option value='성북구'>성북구</option>
                        <option value='송파구'>송파구</option>
                        <option value='양천구'>양천구</option>
                        <option value='영등포구'>영등포구</option>
                        <option value='용산구'>용산구</option>
                        <option value='은평구'>은평구</option>
                        <option value='종로구'>종로구</option>
                        <option value='중구'>중구</option>
                        <option value='중랑구'>중랑구</option>
                    </select>
                    <select name='city-gyeonggi' id='city-gyeonggi'>
					    <option value='과천시'>과천시</option>
                        <option value='광명시'>광명시</option>
                        <option value='광주시'>광주시</option>
                        <option value='고양시'>고양시</option>
                        <option value='구리시'>구리시</option>
                        <option value='군포시'>군포시</option>
                        <option value='김포시'>김포시</option>
                        <option value='남양주시'>남양주시</option>
                        <option value='동두천시'>동두천시</option>
                        <option value='성남시'>성남시</option>
                        <option value='수원시'>수원시</option>
                        <option value='시흥시'>시흥시</option>
                        <option value='안산시'>안산시</option>
                        <option value='안성시'>안성시</option>
                        <option value='안양시'>안양시</option>
                        <option value='양주시'>양주시</option>
                        <option value='여주시'>여주시</option>
                        <option value='오산시'>오산시</option>
                        <option value='용인시'>용인시</option>
                        <option value='의왕시'>의왕시</option>
                        <option value='의정부시'>의정부시</option>
                        <option value='이천시'>이천시</option>
                        <option value='부천시'>부천시</option>
                        <option value='파주시'>파주시</option>
                        <option value='평택시'>평택시</option>
                        <option value='포천시'>포천시</option>
                        <option value='하남시'>하남시</option>
                        <option value='화성시'>화성시</option>
                        <option value='가평군'>가평군</option>
                        <option value='양평군'>양평군</option>
                        <option value='연천군'>연천군</option>
                    </select><br>
					<input type="text" name="subaddress" id="subaddress" class='address' placeholder='상세주소' required>
				</td>
			</tr>
			<tr>
				<td class='tbl-header'>관심분야</td>
				<td>
					<input type="checkbox" name="interest" id="interest1" value="헬스" onclick='countChecked(this);'>
					<label for="interest1">헬스</label>
					<input type="checkbox" name="interest" id="interest2" value="무술" onclick='countChecked(this);'>
					<label for="interest2">무술</label>
					<input type="checkbox" name="interest" id="interest3" value="체형교정" onclick='countChecked(this);'>
					<label for="interest3">체형교정</label>
					<input type="checkbox" name="interest" id="interest4" value="종합격투기" onclick='countChecked(this);'>
					<label for="interest4">종합격투기</label>
					<span style='font-size:10px;color:gray;'>(최대 2개선택 가능)</span>
				</td>
			</tr>
			<tr>
				<td colspan='2' align='center';>
					<input type="submit" class='btn xet_btn sky large' id='enrollbtn'  value="가입하기">				
				</td>
			</tr>
		</table>
	</form>
	<form name="checkId">
		<input type="hidden" name="userId"/>
	</form>
</div>



<%@ include file="/views/common/footer.jsp"%>