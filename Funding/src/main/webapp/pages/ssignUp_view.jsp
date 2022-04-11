<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해피펀딩 회원가입</title>

<style type="text/css">
html{
	height: 100%;
}
body{
	margin: 0;
	padding: 0;
	height: 100%;
}
.ssignUp__wrap{
	/* width: 100%;
	height: 100%; */
	background-size : cover;
	display:flex;
	justify-content: center;
	align-items: center;
	background-color: #DADEFD
}
.ssignUp__content{
	width: 50%;
	height: 85%;
	padding: 50px;
	background-color: white;
	border-radius: 16px;
	box-sizing : border-box;
}
.ssignUp__title{
	margin: 12px 0 16px;
}
.ssignUp__description{
	color: #555;
	margin: 0 0 24px;
}
.ssignUp__subTitle{
	font-size: 8px;
	font-weight: bold;
	margin: 5px 0;
}
.ssignUp__liner{
	margin-bottom: 1px;
}
.ssignUp__input{
	width: 220px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}

.ssignUp__idcheck{
	width: 80px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}
.ssignUp__submit{
	width: 200px;
	background-color:royalblue;
	color: white;
	height: 50px;
	margin: 20px 0;
	border-radius: 32px;
	cursor: pointer;
}
.ssignUp__info{
	margin: 0;
	font-size: 14px;
}
#ssignUp__img__preview{
	width: 320px;
	height: 320px;
	overflow: hidden;
	border: 1px solid #333333;
}
#ssignUp__img{
	width: 100%;
	height: auto;
}
</style>

</head>

<script type="text/javascript">

//load own profile by seller 
function Load_profile() {
	
}

//check for singUp
function checksignUp() {
	var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	var regExpName = /^[ㄱ-ㅎ|가-힣|a-z|A-Z]+$/;   //company name
	var regExpPhone = /^\d{2,3}-\d{3,4}-\d{4}$/ //company phone
	var regExpsNum = /^\d{3}-\d{2}-\d{5}$/   //licence no.
	var regExppNum = /^\d{3}-\d{3,4}-\d{4}$/ //phone of person in charge
	
	var form = document.ssignUpForm
	
	var id = form.seller_id.value
	if(form.seller_id.value == ""){
		alert("아이디를 입력해 주세요.")
		form.seller_id.focus()
		return false
	}else if(!regExpEmail.test(id)){
		alert("입력하신 아이디가 이메일 형식이 아닙니다.")
		form.seller_id.select()
		return false
	}
	var pw1 = form.seller_pw1.value
	var pw2 = form.seller_pw2.value
	if(form.seller_pw1.value == ""){
		alert("비밀번호를 입력해 주세요.")
		form.seller_pw1.focus()
		return false
	}else if (form.seller_pw1.value.length < 4 || form.seller_pw1.value.length > 12){
		alert("비밀번호는 4~12자 이내로 입력 가능합니다.")
		form.seller_pw1.select()
		return false
	}else if(form.seller_pw2.value == ""){
		alert("비밀번호 확인을 입력해 주세요.")
		form.seller_pw2.focus()
		return false
	}else if (form.seller_pw2.value.length < 4 || form.seller_pw2.value.length > 12){
		alert("비밀번호 확인은 4~12자 이내로 입력 가능합니다.")
		form.seller_pw2.select()
		return false
	}else if (pw1 != pw2){
		alert("비밀번호가 일치하지 않습니다.")
		form.seller_pw1.select()
		return false
		
	}	
	var sNum = form.seller_number1.value + "-" + form.seller_number2.value + "-" + form.seller_number3.value
	if (!regExpsNum.test(sNum)){
		alert("사업자등록번호는 3자리-2자리-5자리 형식으로 입력 가능합니다.")
		return false
	}
	
	var phoneNum = form.seller_phone1.value + "-" + form.seller_phone2.value + "-" + form.seller_phone3.value
	if (!regExpPhone.test(phoneNum)){
		alert("업체번호를 확인해 주세요.")
		return false
	}	
		
	var person_name = form.seller_person_name.value
	if(form.seller_person_name.value == ""){
		alert("이름을 입력해 주세요.")
		form.seller_person_name.focus()
		return false
	}else if (form.seller_person_name.value.length < 2 || form.seller_person_name.value.length > 20){
		alert("이름은 2~20자 이내로 입력 가능합니다.")
		form.seller_person_name.select()
		return false
	}else if(!regExpName.test(person_name)){
		alert("이름은 문자만 입력해주세요.")
		form.seller_person_name.focus()
		return false
	}
	
	var pNum = form.seller_person_phone1.value + "-" +form.seller_person_phone2.value + "-" + form.seller_person_phone3.value
	if(!regExppNum.test(pNum)){
		alert("담당자 번호를 확인해주세요.")
		return false
	}
	
	alert("회원가입이 완료되었습니다.")
	form.submit()
}
	function idCheck() {
		window.open("sidCheckForm.jsp","popup","width=600,height=600")
	}
	
</script>


<body>

	<div class="ssignUp__wrap">
	<div class="ssignUp__content">
	<h1 class="ssignUp__title">판매자 회원가입</h1>
	<form name="ssignUpForm"  action="/Funding/ssignUp.do" method="post">
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">아이디</p>
		<input class="ssignUp__input" type="text" id="seller_id" name="seller_id" placeholder="example@mail.com">
		<input type="button" value="ID중복확인" onclick="idCheck()">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">패스워드</p>
		<input class="ssignUp__input" type="password" name="seller_pw1" placeholder="비밀번호는 4~12자 이내로 입력">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">패스워드 확인</p>
		<input class="ssignUp__input" type="password" name="seller_pw2">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">사업자등록번호</p>
		<input class="ssignUp__input" type="text" maxlength="3" size="5" name="seller_number1" placeholder="3자리">
		-<input class="ssignUp__input" type="text" maxlength="2" size="5" name="seller_number2" placeholder="2자리">
		-<input class="ssignUp__input" type="text" maxlength="5" size="6" name="seller_number3" placeholder="5자리">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">업체프로필</p>
		<input class="ssignUp__input" type="hidden" id="ssignUp__img__src" name="seller_profile">
		<input type="file" id="ssignUp__img__upload__btn">
		</div>
		
		<p>프로필 미리보기</p>
		<div id="ssignUp__img__preview"></div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">업체명</p>
		<input class="ssignUp__input" type="text" name="seller_name">
		</div>
		
		<div>
			<div class="ssignUp__liner">
			<p class="ssignUp__subTitle">우편번호</p>
				<input type="hidden" id="confmKey" name="confmKey" value=""  >
				<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
				<input type="button"  value="주소검색" onclick="goPopup();">
			</div>
			<div class="ssignUp__liner">
			<p class="ssignUp__subTitle">도로명 주소</p>
				<input type="text" name="address1" id="roadAddrPart1" style="width:85%">
			</div>
			<div class="ssignUp__liner">
			<p class="ssignUp__subTitle">상세주소</p>
				<input type="text" name="address2" id="addrDetail" style="width:40%" value="">
					<input type="text" name="address3" id="roadAddrPart2"  style="width:40%" value="">
			</div>
		</div>
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">업체번호</p>
		<select name = "seller_phone1">
		<option value = "02">02</option>
		<option value = "031">031</option>
		<option value = "032">032</option>
		<option value = "042">042</option>
		<option value = "043">043</option>
		<option value = "044">044</option>
		<option value = "051">051</option>
		<option value = "052">052</option>
		<option value = "053">053</option>
		<option value = "054">054</option>
		<option value = "061">051</option>
		<option value = "062">062</option>
		<option value = "063">063</option>
		<option value = "064">064</option>
		</select>
		-<input class="ssignUp__input" type="text" maxlength="4" size="5" name="seller_phone2">
		-<input class="ssignUp__input" type="text" maxlength="4" size="5" name="seller_phone3">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">담당자이름</p>
		<input class="ssignUp__input" type="text" name="seller_person_name">
		</div>
		
		<div class="ssignUp__liner">
		<p class="ssignUp__subTitle">담당자전화번호</p>
		<select name = seller_person_phone1>
		<option value = "010">010</option>
		<option value = "011">011</option>
		<option value = "016">016</option>
		<option value = "017">017</option>
		<option value = "018">018</option>
		<option value = "019">019</option>
		</select>
		-<input class="ssignUp__input" type="text" maxlength="4" size = "5" name="seller_person_phone2">
		-<input class="ssignUp__input" type="text" maxlength="4" size = "5" name="seller_person_phone3">
		</div>
		
		<br>
		<input class="ssignUp__submit" type="button" value="가입하기" onclick="checksignUp()">
			</form>
			<div class="ssignUp__infoBox">
				<a href="slogin.jsp">← 이전 페이지</a>
			</div>
		</div>
		</div>
		<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
		<script>
		$("#ssignUp__img__upload__btn").change(function() {
			let txt = '<img id="ssignUp__img" src="">'
			$("#ssignUp__img__preview").html(txt);
			readURL(this, '#ssignUp__img');
		})

		function readURL(input, previewId) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$(previewId).attr('src', e.target.result);
					$("#ssignUp__img__src").val(e.target.result)
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		
		function goPopup(){
		    var pop = window.open("/Funding/apis/addressSearch/addressPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		    
		}
		/** API 서비스 제공항목 확대 (2017.02) **/
		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
								, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
			document.ssignUpForm.roadAddrPart1.value = roadAddrPart1;
			document.ssignUpForm.roadAddrPart2.value = roadAddrPart2;
			document.ssignUpForm.addrDetail.value = addrDetail;
			document.ssignUpForm.zipNo.value = zipNo;
		}
		</script>

	</body>
</html>