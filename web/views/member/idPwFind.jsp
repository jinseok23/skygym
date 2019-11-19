<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Lato%7CMontserrat:500%7COpen+Sans:600%7CNanum+Gothic" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/css/find_idPw.css" rel="stylesheet">
    
<%@ include file="/views/common/header.jsp"%>

<script>
	function fn_find_id()
	{
		
		var url="<%=request.getContextPath()%>/memberFindId";
		var title="changePassword";
		var status="left=500px, top=200px, width=500px, height=250px";
		var popup=window.open(url, title, status);
		findIdForm.action=url;
		findIdForm.target=title;
		findIdForm.id_name.value=$('#id_name').val();
		findIdForm.birth.value=$('#birth').val();
		findIdForm.submit();
		
	};
	
	
	

	function fn_find_pw()
	{
		var url="<%=request.getContextPath()%>/memberFindPw";
		findPasswdForm.action=url;
		findPasswdForm.member_id.value=$("#member_id").val();
		findPasswdForm.name.value=$("#pw_name").val();
		findPasswdForm.email.value=$("#email").val();
		console.log($("#name").val());
		
		
	}
</script>

                <form id="findPasswdForm" name="findPasswdForm" method="post" onsubmit="return fn_find_pw()">
                    <input id="nextUrl" name="nextUrl" value="/member/passwd/find_passwd_question.html" type="hidden"  />
                    <input id="resultURL" name="resultURL" value="" type="hidden"  />
                    <div class="xans-member xans-member-findpasswd ">
                    <div class="findPw">
                            <fieldset>
                    <div class="findpasstop">FIND PW<p>비밀번호 찾기</p>
                    </div>
                                <legend>비밀번호 찾기 1단계 정보 입력</legend>
                                <p class="member"><strong>회원유형</strong> 
                                <select id="searchType" name="searchType">
                    <option value="indi" selected="selected">개인회원</option>
                    
                    </select></p>
                                <p class="check">
                                <input id="check_method1" name="check_method" value="2" type="radio" checked="checked"/>
                                <label for="check_method1" >이메일</label>
                                <p class="id">
                                	<strong>아이디</strong>
                                	<input id="member_id" name="member_id" class="lostInput" type="text"  />
                                </p>
                                <p id="name_view" class="name">
                                	<strong id="name_lable">이름</strong> 
                                	<input id="pw_name" name="pw_name" class="lostInput ec-member-name" type="text"  />
                                </p>
                                
                                <p id="email_view" class="email" >
                                	<strong>이메일로 찾기</strong> 
                                	<input id="email" name="email" class="lostInput" type="text" />
                                </p><br><br>
                                <button type='submit' class="btn xet_btn large sky" style="width:450px">확인</button>
                                <!-- <a class="button" href="#none" onclick="">확인</a> -->
                            </fieldset>
                    </div>
                    </div>
                    </form><div class="findpassbot">
                        <ul>
                            <li> * "이메일로 찾기"시 입력하는 정보(아이디/이름/휴대폰)가 모두 일치해야 정상적으로 찾을 수 있습니다.
                            </li>
                        </ul>
                    </div>
                    
                    
<form id="findIdForm" name="findIdForm"  method="post" onsubmit="return fn_find_id()" >
            <input id="returnUrl" name="returnUrl" value="/member/id/find_id_result.html" type="hidden"  />
            <div  class="xans-member xans-member-findid">
                <div class="findId">
                        <fieldset>
                            <div class="findidtop">
                                <ul>
                                    <li>FIND ID</li>
                                    <li>아이디 찾기</li>
                                </ul>
                            </div>
                            <legend>아이디 찾기</legend>
                            <p class="member"><strong>회원유형</strong> 
                                <select id="searchType" name="searchType"  >
                                <option value="indi" selected="selected">개인회원</option>
                                </select>
                            </p>
                            <p class="check">
                            <p id="name_view" class="name">
                            	<strong id="name_lable">이름</strong> 
                            	<input id="id_name" name="id_name" class="lostInput" type="text"  /></p>
                            
                            <p id="birth10" class="birth">
                            	<strong>생년월일</strong> 
                            	<input id="birth" name="birth" class="lostInput"  type="text"  /></p>
                            
                               <br><br>
                             <button type='submit' class="btn xet_btn large sky" style="width:450px">확인</button>
                             <!-- <a class="button" href="#" onclick="fn_find_id()">확인</a> -->
                        </fieldset>
                </div>
                </div>
            </form>
            <div class="findId_bot">
                <ul><li>* 가입하신 "이름", "생년월일"로 아이디 찾기가 가능합니다</li></ul>
            </div>




<%@ include file="/views/common/footer.jsp"%>