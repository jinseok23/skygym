<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<%
	Cookie[] cookies=request.getCookies();
	String saveId=null;
	if(cookies!=null)
	{
		for(Cookie c : cookies)
		{
			if(c.getName().equals("saveId"))
			{
				saveId=c.getValue();
			}
		}
	}
%>
<style>
	section{padding:50px;}
	div#container-login{
		position : absolute;
	    width : 500px;
	    height : 350px;
	    left : 50%;
	    top : 45%;
	    margin-left : -150px;
	    margin-top : -60px;
	    background-color : rgb(242, 242, 242);
	    border-top:2px solid gray;
	    border-bottom:2px solid gray;
	}
	
	table#login-box td{
		padding: 8px;
	}
	#loginbtn{width:250px;background-color:#0A0A2A; color:white;padding:5px;border:0px;}
	div#login-header{padding:0 100px;}
	div#login-header h1{padding:0 100px;}
	
	 */
	
/*  */
	
.flex1 { -webkit-box-flex: 1; -webkit-flex-grow: 1; -ms-flex-positive: 1; flex-grow: 1; }
	
/* -------------------------------------------------------- */
/* Breadcrumb */
/* -------------------------------------------------------- */

.breadcrumb-container { padding: 0px; }
.breadcrumb-container h1 { float: left; margin: 0px; }
.breadcrumb { background: transparent; text-align: left; text-transform: uppercase; font-family: 'Arial', sans-serif; margin: 0px; padding: 0px; }
.breadcrumb a { color: #9aa5ad; }
.breadcrumb a:hover { color: #3395E8; text-decoration: none; }
.breadcrumb > .active { color: #9aa5ad; }
.breadcrumb > li + li:before { color: #9aa5ad; }


label { display: block; margin-bottom: 0px; font-size: 14px; font-weight: normal; }

label.required:before, span.required:before { content: '*'; color: #fb6f7e; margin-right: 3px; }

.space20  {
  height:  20px;
  clear:  both;
}
.space30 { height: 30px; clear: both; }

.form-group{margin-bottom:15px}

table { /* border-collapse: collapse; */ border-spacing: 0; }hidden-print
/* change border colour to suit your needs */
hr { display: block; height: 1px; border: 0; border-top: 1px solid #cccccc; margin: 1em 0; padding: 0; }

.col-lg-1, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-xs-1, .col-xs-10, .col-xs-11, .col-xs-12, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9 {
 position: relative;
 min-height: 1px;
 padding-right: 15px;
 padding-left: 15px;
}

.col-sm-offset-2 {
 margin-left: 16.66666667%}
 .col-md-offset-3 {
 margin-left: 25%}
 
 .text-center {
 text-align: center;
}

.salmon{
  color:salmon;
}
.deconone{
 text-decoration: none;
}

.darkblue a{
text-decoration: none;
color:#0d2240;
}

.skyblue{
color:#8ccdff;
}


/*  */
.xet_btn.small {
	line-height:18px !important;
	font-size: 11px !important;
	padding:0 8px !important; 
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border-radius: 2px;
}

.xet_btn.medium {
	line-height:25px !important;
	font-size:12px !important;	
	padding:0 12px !important;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}
.xet_btn.large {
	line-height:40px !important;
	font-size: 14px !important;	
	padding:0 20px !important; 
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

.xet_btn.sky {
	color: #fff !important;
	text-shadow: 0 -1px -1px rgba(255, 255, 255, 0.75);
	background: #3395E8;
}
.xet_btn.sky:active,
.xet_btn.sky:hover {
	background: #0d2240;	
}	
</style>
<script>
   function validate(){
      //아이디를 적었는지 체크
      if($('#userId').val().trim().length==0)
      {
         alert("아이디를 입력하세요!");
         //id입력란에 커서를 옮겨주는 기능
         $('#userId').focus();
         return false;
      }
      //비밀번호 있는지 체크
      if($('#password').val().trim().length==0)
      {
         alert("비밀번호를 입력하세요!");
         $('#password').focus();
         return false;
      }
   }
</script>
<br><br><br><br><br><br>

<div id= "container">
<div class="col-xs-12 text-center m-bottom15">
<!--TITLE-->
<div class="space20"></div>
<div class="container" id="title">
    <div class="row">
        <div class="col-md-12">
            <h1>Login</h1>
        </div>
    </div>
</div>
  </div>         
        
       <!--CONTENT AREA-->
<div id="layout-content" class="flex1">
    <div class="space30"></div>
    	<div class="container">
		<div class="row">
    <div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
    	
        <form action="<%= request.getContextPath() %>/login" method="post" id="loginFrm" onsubmit="return validate()">
	
	<div class="form-group">
        <label for="saveId" class="required">Id
        <input type="checkbox" title="remember Id" name="saveId" id="saveId" <%=saveId!=null?"checked":"unchecked" %>/>
        </label>
        <input type='text' name='userId' id='userId' class="form-control" value='<%=saveId!=null?saveId:"" %>' data-parsley-required/>
        <!-- <input type="text" name="id" id="id" class="form-control" placeholder="Id" data-parsley-required> -->
		
	</div>
	<div class="form-group">
         <label for="password" class="required">Password</label>
         <input type='password' name='password' id='password' class="form-control" placeholder="password"/>
         <!-- <input type="password" id="password" name="password" class="form-control" placeholder="Password" data-parsley-required data-parsley-minlength="6" data-parsley-minlength-message="This value is too short"> -->
	</div>
	<input type="hidden" name="login_csrf" value="29ad0a4b1fc0b7ea6a4377b158912a91-ef8e615c2b142bc8800d19550fa2d2b3">
	<input type="hidden" name="s_redirect" value="">
	<div class="form-group m-top20">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 darkblue">
        	<br>
        	<button type="submit" class="btn xet_btn large sky" style="width:100%">Login</button>
        	<span style="font-size: 10pt;">
            <div class="col-xs-12 text-center m-bottom15">
	            <a href="<%=request.getContextPath()%>/idPwFind"/>
	            <br>
	         
	            	혹시 <span class="salmon">비밀번호</span>를 잊으셨나요?</a>
            </div>
            <div class="col-xs-12 text-center m-bottom15">
	            <a href="<%=request.getContextPath() %>/memberEnroll">
	            <br>
	            	아직 <span class="skyblue">회원</span>이 아니신가요?</a>
            </div>
            </span>
        </div>
    </div>
</div>
</form>
    </div>
</div>
</div>
  </div>  



<br><br><br><br><br>

<%@ include file="/views/common/footer.jsp"%>