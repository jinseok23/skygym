<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.skygym.findgym.model.vo.GYM" %>
<%
	GYM g = (GYM)request.getAttribute("gym");

	String category = g.getGYMCategory();
	String[] selected=new String[4];
	switch(category)
	{
	case "헬스": selected[0]="selected"; break;
	case "무술": selected[1]="selected"; break;
	case "체형교정": selected[2]="selected"; break;
	case "종합격투기": selected[3]="selected"; break;
	default: break;
	}
	
	String[] addrArray=g.getGYMAddress().split(" ");
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

<%@ include file="/views/common/header.jsp"%>


<script>
	$(function(){
		var seoul=document.querySelector("#city-seoul");
		var gyeonggi=document.querySelector('#city-gyeonggi');
		$('#city-main').change(function(){
			seoul.style.display='none';
			gyeonggi.style.display='none';
			$('#city-'+this.value).css("display","inline-block");
		});
	});
	function fn_update_gym()
	{
		var frm=$('#gymFrm');
		var url='<%=request.getContextPath()%>/gymUpdate';
		frm.attr("action",url);
		frm.submit();
	}
	function fn_delete_gym()
	{
		var frm=$('#gymFrm');
		var url='<%=request.getContextPath()%>/gymDelete';
		frm.attr("action",url);
		frm.submit();
		
	}

</script>
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

	span{font-size:23px;}
	
	
	
	table#gymInfo
	{
		width : 1000px;
 	    height : 600px;
	}
	#updatebtn{text-align:center;}
	.btn_black{background-color:#0A0A2A; color:white;padding:5px;border:0px;}
	
	#homepage{width:500px;}
	#address{width:500px;}
	#branchName{width:130px;}
	table#gymInfo tr{
		border-top:1px solid gray;
	}
	table#gymInfo td
	{
		padding:5px 15px;
	}
	
	.tbl-header{background-color:#F6F6F6;text-align:center;color:gray;}
	
	#category{
		width:130px;
	}
	#gymNumber{
		 background-color:lightgray;
		 text-align:center;
		 width:50px;
	}
	
</style>
<br>

<div class="container">
  <h2>&ensp;&ensp;&ensp;제휴업체</h2>
  <hr>
  <form id="gymFrm" method="post">
	<table id='gymInfo' align="center">
		<tbody>
			<tr>
				<td class='tbl-header'>지점번호</td>
				<td><input type='text' name="gymNumber" id="gymNumber"
					value="<%=g.getGYMNumber()%>" readonly/></td>
			</tr>
			<tr>
				<td class='tbl-header'>지점이름</td>
				<td><input type='text' name="branchName" id="branchName"
					value="<%=g.getGYMbranchName()%>"/></td>
			</tr>
			<td class='tbl-header'>분류</td>
				<td><select name='category' id='category'>
						<option value='헬스' <%=selected[0] %>>헬스</option>
						<option value='무술' <%=selected[1] %>>무술</option>
						<option value='체형교정' <%=selected[2] %>>체형교정</option>
						<option value='종합격투기' <%=selected[3] %>>종합격투기</option>
				</select>
				</td>
			<tr>
				<td class='tbl-header'>전화번호</td>
				<td><input type='text' name="tel" id="tel"
					value="<%=g.getGYMtel()%>"/></td>
			</tr>
			<td class='tbl-header'>지역</td>
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
				</select>
			<tr>
				<td class='tbl-header'>주소</td>
				<td><input type='text' name="address" id="address"
					value="<%=address%>"/></td>
			</tr>
			
			<tr>
				<td class='tbl-header'>홈페이지</td>
			<td><input type='text' name="homepage" id="homepage" value="<%=g.getGYMHomePage()%>"/></td>
			<td><input type='hidden' name="gymInfo" id="gymInfo" value="<%=g.getGYMInfo()%>"/></td>
			<td><input type='hidden' name="district" id="district" value="<%=g.getGYMdistrict()%>"/></td>
			</tr>
			<tr>
				<td colspan='2' id='updatebtn'>
					<a href="<%=request.getContextPath()%>/admin/gymList" class="btn btn-dark xet_btn large"/>목록으로</a>
					<input type="button" onclick="fn_update_gym();" value="정보수정" class="btn xet_btn large sky" />
					<input type="button" onclick="fn_delete_gym();" value="삭제" class="btn btn-danger xet_btn large" style='width:100px;' />
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</div>


<%@ include file="/views/common/footer.jsp"%>