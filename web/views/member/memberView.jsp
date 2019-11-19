<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.skygym.member.model.vo.Member" %>

<%@ include file="/views/common/header.jsp"%>
<%
   Member m=(Member)request.getAttribute("member");
   
   String[] interests=m.getInterest().split(",");
   String[] email=m.getEmail().split("@");
   String[] phonenum=m.getPhone().split("-");
   String phone1=phonenum[0];
   String[] select=new String[3];
   switch(phone1)
   {
      case "010" : select[0]="selected";break;
      case "011" : select[1]="selected";break;
      case "016" : select[2]="selected";break;
   }
   String[] check=new String[5];
   for(String h : interests)
   {
      switch(h)
      {
         case "헬스" : check[0]="checked";break;
         case "무술" : check[1]="checked";break;
         case "체형교정" : check[2]="checked";break;
         case "종합격투기" : check[3]="checked";break;
      }
   }
   String[] addrArray=m.getAddress().split(" ");
   String cityMain=addrArray[0];
   String citySeoul=null;
   String cityGyeonggi=null;
   String address="";
   String[] mainSelect=new String[2];
   String[] addrSelect1=new String[25];
   String[] addrSelect2=new String[31];
   if(cityMain.equals("서울특별시")) 
   {
      cityMain="seoul";
      citySeoul=addrArray[1];
      switch(citySeoul)
      {
         case "강남구" : addrSelect1[0]="selected";break;
         case "강동구" : addrSelect1[1]="selected";break;
         case "강북구" : addrSelect1[2]="selected";break;
         case "강서구" : addrSelect1[3]="selected";break;
         case "관악구" : addrSelect1[4]="selected";break;
         case "광진구" : addrSelect1[5]="selected";break;
         case "구로구" : addrSelect1[6]="selected";break;
         case "금천구" : addrSelect1[7]="selected";break;
         case "노원구" : addrSelect1[8]="selected";break;
         case "도봉구" : addrSelect1[9]="selected";break;
         case "동대문구" : addrSelect1[10]="selected";break;
         case "동작구" : addrSelect1[11]="selected";break;
         case "마포구" : addrSelect1[12]="selected";break;
         case "서대문구" : addrSelect1[13]="selected";break;
         case "서초구" : addrSelect1[14]="selected";break;
         case "성동구" : addrSelect1[15]="selected";break;
         case "성북구" : addrSelect1[16]="selected";break;
         case "송파구" : addrSelect1[17]="selected";break;
         case "양천구" : addrSelect1[18]="selected";break;
         case "영등포구" : addrSelect1[19]="selected";break;
         case "용산구" : addrSelect1[20]="selected";break;
         case "은평구" : addrSelect1[21]="selected";break;
         case "종로구" : addrSelect1[22]="selected";break;
         case "중구" : addrSelect1[23]="selected";break;
         case "중랑구" : addrSelect1[24]="selected";break;
      }
   }
   else
   {
      cityMain="gyeonggi";
      cityGyeonggi=addrArray[1];
      switch(cityGyeonggi)
      {
         case "과천시" : addrSelect2[0]="selected";break;
         case "광명시" : addrSelect2[1]="selected";break;
         case "광주시" : addrSelect2[2]="selected";break;
         case "고양시" : addrSelect2[3]="selected";break;
         case "구리시" : addrSelect2[4]="selected";break;
         case "군포시" : addrSelect2[5]="selected";break;
         case "김포시" : addrSelect2[6]="selected";break;
         case "남양주시" : addrSelect2[7]="selected";break;
         case "동두천시" : addrSelect2[8]="selected";break;
         case "성남시" : addrSelect2[9]="selected";break;
         case "수원시" : addrSelect2[10]="selected";break;
         case "시흥시" : addrSelect2[11]="selected";break;
         case "안산시" : addrSelect2[12]="selected";break;
         case "안성시" : addrSelect2[13]="selected";break;
         case "안양시" : addrSelect2[14]="selected";break;
         case "양주시" : addrSelect2[15]="selected";break;
         case "여주시" : addrSelect2[16]="selected";break;
         case "오산시" : addrSelect2[17]="selected";break;
         case "용인시" : addrSelect2[18]="selected";break;
         case "의왕시" : addrSelect2[19]="selected";break;
         case "의정부시" : addrSelect2[20]="selected";break;
         case "이천시" : addrSelect2[21]="selected";break;
         case "부천시" : addrSelect2[22]="selected";break;
         case "파주시" : addrSelect2[23]="selected";break;
         case "평택시" : addrSelect2[24]="selected";break;
         case "포천시" : addrSelect2[25]="selected";break;
         case "하남시" : addrSelect2[26]="selected";break;
         case "화성시" : addrSelect2[27]="selected";break;
         case "가평군" : addrSelect2[28]="selected";break;
         case "양평군" : addrSelect2[29]="selected";break;
         case "연천군" : addrSelect2[30]="selected";break;
      }
   }
   //상세주소 합치기
   for(int i=2;i<addrArray.length;i++)
   {
      address+=addrArray[i]+" ";
   }
   switch(cityMain)
   {
      case "seoul" : mainSelect[0]="selected";break;
      case "gyeonggi" : mainSelect[1]="selected";break;
   }
%>

<style>
   <%if(cityMain.equals("seoul")){%>
   #city-seoul
   {
      display:inline;
   }
   #city-gyeonggi
   {
      display:none;
   }
   <%}
   else{%>
   #city-gyeonggi
   {
      display:inline;
   }
   #city-seoul
   {
      display:none;
   }
   <%}%>
   h1{padding:0 100px;}
   hr{padding:0 100px;}
   span{font-size:23px;}
   .tel{width:60px;}
   .email{width:110px;}
   .address{width:450px;margin-top:8px;}
   table#memberInfo
   {
      width : 1000px;
        height : 600px;
   }
   #updatebtn{text-align:center;}
   .btn_black{background-color:#0A0A2A; color:white;padding:5px;border:0px;}
   table#memberInfo tr{
      border-top:1px solid gray;
   }
   table#memberInfo td
   {
      padding:10px 30px;
   }
   .tbl-header{background-color:#F6F6F6;text-align:center;color:gray;}
</style>
<script>
   function fn_update_member()
   {
      var frm=$('#memberFrm');
      var url='<%=request.getContextPath()%>/memberUpdate';
      frm.attr("action",url);
      frm.submit();
   }
   function fn_update_password()
   {
      var url="<%=request.getContextPath()%>/changePassword?userId=<%=m.getUserId() %>";
      var title="changePassword";
      var status="left=500px, top=200px, width=400px, height=250px, menubar=no, status=no, scrollbars=no";
      
      var popup=window.open(url, title, status);
   }
   function confirmDelete()
   {
      var frm=$('#memberFrm');
      var url='<%=request.getContextPath()%>/memberDelete';
      frm.attr("action",url);
      frm.submit();
   }
   $(function(){
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
   $(function(){
      var seoul=document.querySelector("#city-seoul");
      var gyeonggi=document.querySelector('#city-gyeonggi');
      $('#city-main').change(function(){
         seoul.style.display='none';
         gyeonggi.style.display='none';
         $('#city-'+this.value).css("display","inline-block");
      });
   });
   var maxChecked = 2;   //선택가능한 체크박스 갯수
   var totalChecked=0;
   <%for(int i=0;i<interests.length;i++)
   {%>
      totalChecked += 1; // 설정 끝
   <%}%>
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
<div class="container">
<br>
  <h2>&ensp;&ensp;&ensp;&ensp;마이페이지</h2>
  <hr>
  <form id="memberFrm" method="post">
   <table id='memberInfo' align="center">
      <tbody>
         <tr>
            <td class='tbl-header'>아이디</td>
            <td><input type='text' name="userId_" id="userId_"
               value="<%=m.getUserId()%>" style="background-color: lightgray;"
               readonly /></td>
         </tr>
         <tr>
            <td class='tbl-header'>패스워드</td>
            <td><input type="text" style="background-color: lightgray;" readonly />
            &ensp;<button onclick="fn_update_password();" class="btn xet_btn medium sky"> 비밀번호 변경</button></td>
         </tr>
         <tr>
            <td class='tbl-header'>이름</td>
            <td><input type="text" name="userName" id="userName"
               value="<%=m.getUserName()%>"></td>
         </tr>
         <tr>
            <td class='tbl-header'>생년월일</td>
            <td><input type="text" name="residentNum" id="residentNum"
               minlength='6' value="<%=m.getResidentNum()%>" required></td>
         </tr>
         <tr>
            <td class='tbl-header'>휴대폰</td>
            <td><select name='tel1' id='tel1'>
                  <option value='010' <%=select[0]%>>010</option>
                  <option value='011' <%=select[1]%>>011</option>
                  <option value='016' <%=select[2]%>>016</option>
            </select><span>-</span> <input type="text" name="tel2" class='tel' id="tel2"
               value="<%=phonenum[1]%>"><span>-</span> <input type="text"
               name="tel3" class='tel' id="tel3" value="<%=phonenum[2]%>">
            </td>
         </tr>
         <tr>
            <td class='tbl-header'>이메일</td>
            <td><input type="text" name="email1" id="email1"
               value="<%=email[0]%>"><span>@</span> <input type="text"
               name="email2" id="email2" value="<%=email[1]%>"> <select
               name='emailselect' id='emailselect'>
                  <option value="1" selected>직접입력</option>
                  <option value="naver.com">naver.com</option>
                  <option value="nate.com">nate.com</option>
                  <option value="daum.net">daum.net</option>
                  <option value="gmail.com">gmail.com</option>
                  <option value="empas.com">empas.com</option>
                  <option value="dreamwiz.com">dreamwiz.com</option>
                  <option value="freechal.com">freechal.com</option>
            </select></td>
         </tr>
         <tr>
            <td class='tbl-header'>주소</td>
            <td><select name='city-main' id='city-main'>
                  <option value='seoul' <%=mainSelect[0]%>>서울특별시</option>
                  <option value='gyeonggi' <%=mainSelect[1]%>>경기도</option>
            </select> <select name='city-seoul' id='city-seoul'>
                  <option value='강남구' <%=addrSelect1[0]%>>강남구</option>
                  <option value='강동구' <%=addrSelect1[1]%>>강동구</option>
                  <option value='강북구' <%=addrSelect1[2]%>>강북구</option>
                  <option value='강서구' <%=addrSelect1[3]%>>강서구</option>
                  <option value='관악구' <%=addrSelect1[4]%>>관악구</option>
                  <option value='광진구' <%=addrSelect1[5]%>>광진구</option>
                  <option value='구로구' <%=addrSelect1[6]%>>구로구</option>
                  <option value='금천구' <%=addrSelect1[7]%>>금천구</option>
                  <option value='노원구' <%=addrSelect1[8]%>>노원구</option>
                  <option value='도봉구' <%=addrSelect1[9]%>>도봉구</option>
                  <option value='동대문구' <%=addrSelect1[10]%>>동대문구</option>
                  <option value='동작구' <%=addrSelect1[11]%>>동작구</option>
                  <option value='마포구' <%=addrSelect1[12]%>>마포구</option>
                  <option value='서대문구' <%=addrSelect1[13]%>>서대문구</option>
                  <option value='서초구' <%=addrSelect1[14]%>>서초구</option>
                  <option value='성동구' <%=addrSelect1[15]%>>성동구</option>
                  <option value='성북구' <%=addrSelect1[16]%>>성북구</option>
                  <option value='송파구' <%=addrSelect1[17]%>>송파구</option>
                  <option value='양천구' <%=addrSelect1[18]%>>양천구</option>
                  <option value='영등포구' <%=addrSelect1[19]%>>영등포구</option>
                  <option value='용산구' <%=addrSelect1[20]%>>용산구</option>
                  <option value='은평구' <%=addrSelect1[21]%>>은평구</option>
                  <option value='종로구' <%=addrSelect1[22]%>>종로구</option>
                  <option value='중구' <%=addrSelect1[23]%>>중구</option>
                  <option value='중랑구' <%=addrSelect1[24]%>>중랑구</option>
            </select> <select name='city-gyeonggi' id='city-gyeonggi'>
                  <option value='과천시' <%=addrSelect2[0]%>>과천시</option>
                  <option value='광명시' <%=addrSelect2[1]%>>광명시</option>
                  <option value='광주시' <%=addrSelect2[2]%>>광주시</option>
                  <option value='고양시' <%=addrSelect2[3]%>>고양시</option>
                  <option value='구리시' <%=addrSelect2[4]%>>구리시</option>
                  <option value='군포시' <%=addrSelect2[5]%>>군포시</option>
                  <option value='김포시' <%=addrSelect2[6]%>>김포시</option>
                  <option value='남양주시' <%=addrSelect2[7]%>>남양주시</option>
                  <option value='동두천시' <%=addrSelect2[8]%>>동두천시</option>
                  <option value='성남시' <%=addrSelect2[9]%>>성남시</option>
                  <option value='수원시' <%=addrSelect2[10]%>>수원시</option>
                  <option value='시흥시' <%=addrSelect2[11]%>>시흥시</option>
                  <option value='안산시' <%=addrSelect2[12]%>>안산시</option>
                  <option value='안성시' <%=addrSelect2[13]%>>안성시</option>
                  <option value='안양시' <%=addrSelect2[14]%>>안양시</option>
                  <option value='양주시' <%=addrSelect2[15]%>>양주시</option>
                  <option value='여주시' <%=addrSelect2[16]%>>여주시</option>
                  <option value='오산시' <%=addrSelect2[17]%>>오산시</option>
                  <option value='용인시' <%=addrSelect2[18]%>>용인시</option>
                  <option value='의왕시' <%=addrSelect2[19]%>>의왕시</option>
                  <option value='의정부시' <%=addrSelect2[20]%>>의정부시</option>
                  <option value='이천시' <%=addrSelect2[21]%>>이천시</option>
                  <option value='부천시' <%=addrSelect2[22]%>>부천시</option>
                  <option value='파주시' <%=addrSelect2[23]%>>파주시</option>
                  <option value='평택시' <%=addrSelect2[24]%>>평택시</option>
                  <option value='포천시' <%=addrSelect2[25]%>>포천시</option>
                  <option value='하남시' <%=addrSelect2[26]%>>하남시</option>
                  <option value='화성시' <%=addrSelect2[27]%>>화성시</option>
                  <option value='가평군' <%=addrSelect2[28]%>>가평군</option>
                  <option value='양평군' <%=addrSelect2[29]%>>양평군</option>
                  <option value='연천군' <%=addrSelect2[30]%>>연천군</option>
            </select><br>
            <input type="text" name="subaddress" id="subaddress" class='address'
                  placeholder='상세주소' value='<%=address%>' required></td>
         </tr>
         <tr>
            <td class='tbl-header'>관심분야</td>
            <td>
               <input type="checkbox" name="interest" id="interest1" value="헬스" <%=check[0]%> onclick='countChecked(this);'>
               <label for="interest1">헬스</label>
               <input type="checkbox" name="interest" id="interest2" value="무술" <%=check[1]%> onclick='countChecked(this);'>
               <label for="interest2">무술</label>
               <input type="checkbox" name="interest" id="interest3" value="체형교정"   <%=check[2]%> onclick='countChecked(this);'>
               <label for="interest3">체형교정</label>
               <input type="checkbox" name="interest" id="interest4" value="종합격투기" <%=check[3]%> onclick='countChecked(this);'>
               <label for="interest4">종합격투기</label>
            </td>
         </tr>
         <tr>
            <td colspan='2' id='updatebtn'>
               <input type="button" onclick="fn_update_member();" value="정보수정" class="btn xet_btn large sky" />
               <input type="button" onclick="confirmDelete();" value="탈퇴" class="btn btn-danger xet_btn large" style='width:100px;'/>
            </td>
         </tr>
      </tbody>
   </table>
   </form>
</div>



<%@ include file="/views/common/footer.jsp"%>