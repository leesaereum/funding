<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해피펀딩 회원가입</title>
<link rel="stylesheet" href="../styles/init.css">
<style type="text/css">
html {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	height: 100%;
	z-index: 1;
}

.signUp__wrap {
	z-index: 1;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(-45deg, #00d63f, #c2ffd4);
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@
keyframes gradientBG { 0% {
	background-position: 0% 50%;
}

50


%
{
background-position


:


100


%
50



%;
}
100



%
{
background-position


:


0


%
50


%;
}
}
.signUp__content {
	width: 400px;
	padding: 30px;
	background-color: white;
	border-radius: 16px;
}

.signUp__title {
	margin: 12px 0 16px;
}

.signUp__description {
	color: #555;
	margin: 0 0 24px;
}

.signUp__subTitle {
	font-size: 14px;
	font-weight: bold;
	margin: 4px 0;
}

.signUp__input {
	width: 280px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}

.signUp__warning {
	margin: 4px 4px 16px;
	font-size: 13px;
	color: red;
}

.signUp__submit {
	width: 280px;
	background-color: royalblue;
	color: white;
	height: 44px;
	margin: 24px 0;
	border-radius: 32px;
	cursor: pointer;
}

.signUp__submit:hover {
	filter: brightness(105%);
}

.signUp__submit:disabled {
	background-color: #aaa;
}

.signUp__submit:active {
	filter: brightness(95%);
}

.signUp__info {
	margin: 0;
	font-size: 14px;
}

.signUp__divider {
	padding-bottom: 20px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 20px;
}

#toast {
	position: fixed;
	bottom: 30px;
	left: 50%;
	padding: 15px 20px;
	transform: translate(-50%, 10px);
	border-radius: 30px;
	overflow: hidden;
	opacity: 0;
	visibility: hidden;
	transition: opacity .5s, visibility .5s, transform .5s;
	background: rgba(0, 0, 0, .35);
	color: #fff;
	z-index: 5;
}

#toast.reveal {
	opacity: 1;
	visibility: visible;
	transform: translate(-50%, 0)
}
</style>
</head>
<script type="text/javascript">
	let emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	let namePattern = /^[ㄱ-ㅎ|가-힣|a-z|A-Z]+$/;
	let phonePattern = /[0-9]{3,4}$/;
	function validate() {
	const id = document.getElementById('id').value
	const pw = document.getElementById('pw').value
	const name = document.getElementById('name').value
	const phone2 = document.getElementById('phone2').value
	const phone3 = document.getElementById('phone3').value
		if (id.match(emailPattern) && pw.length >= 4 && name.match(namePattern) && phone2.match(phonePattern) && phone3.match(phonePattern)) {
			document.getElementById('submit').disabled = false;
		} else {
			document.getElementById('submit').disabled = true;
		}
	}
	function idFocus() {
		document.getElementById('idValidate').innerHTML = ''
	}
	function pwFocus() {
		document.getElementById('pwValidate').innerHTML = ''
	}
	function pw2Focus() {
		document.getElementById('pw2Validate').innerHTML = ''
	}
	function nameFocus() {
		document.getElementById('nameValidate').innerHTML = ''
	}
	function phoneFocus() {
		document.getElementById('phoneValidate').innerHTML = ''
	}

	function idValidate() {
		const id = document.getElementById('id').value
		if (!id.match(emailPattern)) {
			document.getElementById('idValidate').innerHTML = '아이디는 이메일 형식으로 입력해야 합니다'
		} else if (id.length > 45) {
			document.getElementById('idValidate').innerHTML = '아이디는 45자 이내로 입력해주세요'
		} else {
			document.getElementById('idValidate').innerHTML = ''
		}
	}
	function pwValidate() {
		const pw = document.getElementById('pw').value
		if (pw.length < 4) {
			document.getElementById('pwValidate').innerHTML = '4자 이상의 패스워드를 입력해주세요'
		} else {
			document.getElementById('pwValidate').innerHTML = ''
		}
	}
	function pw2Validate() {
		const pw = document.getElementById('pw').value
		const pw2 = document.getElementById('pw2').value
		if (pw!=pw2) {
			document.getElementById('pw2Validate').innerHTML = '비밀번호와 다르게 입력되었습니다'
		} else {
			document.getElementById('pw2Validate').innerHTML = ''
		}
	}
	function nameValidate() {
		const name = document.getElementById('name').value
		if (!name.match(namePattern)) {
			document.getElementById('nameValidate').innerHTML = '이름은 한글이나 영어로 입력해주세요'
		} else if (name.length <1 || name.length > 45) {			
			document.getElementById('nameValidate').innerHTML = '이름은 1~45자 이내로 입력해주세요'
		}
		else {
			document.getElementById('nameValidate').innerHTML = ''
		}
	}
	function phoneValidate() {
		const phone2 = document.getElementById('phone2').value
		const phone3 = document.getElementById('phone3').value
		if (!phone2.match(phonePattern)) {
			document.getElementById('phoneValidate').innerHTML = '전화번호는 숫자로 입력해주세요'
		}
		else if(!phone3.match(phonePattern)) {
			document.getElementById('phoneValidate').innerHTML = '전화번호는 숫자로 입력해주세요'
		}
		else {
			document.getElementById('phoneValidate').innerHTML = ''
		}
	}
</script>
<body>
	<div class="signUp__wrap">
		<div class="signUp__content">
			<h1 class="signUp__title">회원가입</h1>
			<div class="signIn__divider"></div>
			<form action="/Funding/signUp.do" name="signUpForm" method="post">
				<div class="signUp__liner">
					<p class="signUp__subTitle">아이디</p>
					<input class="signUp__input" id="id" name="id"
						placeholder="example@mail.com" onkeyup="validate()"
						onfocus="idFocus()" onblur="idValidate()">
					<p id="idValidate" class="signUp__warning"></p>
					<input type="button" value="ID중복확인" onclick="idCheck()">
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">비밀번호</p>
					<input class="signUp__input" id="pw" type="password" name="pw"
						onkeyup="validate()" onfocus="pwFocus()" onblur="pwValidate()">
					<p id="pwValidate" class="signUp__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">비밀번호 확인</p>
					<input class="signUp__input" id="pw2" type="password" name="pw2"
						onkeyup="validate()" onfocus="pw2Focus()" onblur="pw2Validate()">
					<p id="pw2Validate" class="signUp__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">이름</p>
					<input class="signUp__input" id="name" type="text" name="name"
						onkeyup="validate()" onfocus="nameFocus()" onblur="nameValidate()">
					<p id="nameValidate" class="signUp__warning"></p>
				</div>
				<div>
					<div class="signIn__liner">
						<p class="signUp__subTitle">우편번호</p>
						<input type="hidden" id="confmKey" name="confmKey" value="">
						<input type="text" id="zipNo" name="zipNo" readonly
							style="width: 100px"> <input type="button" value="주소검색"
							onclick="goPopup();">
					</div>
					<div class="signIn__liner">
						<p class="signUp__subTitle">도로명 주소</p>
						<input type="text" name="address1" id="roadAddrPart1"
							style="width: 85%">
					</div>
					<div class="signIn__liner">
						<p class="signUp__subTitle">상세주소</p>
						<input type="text" name="address2" id="addrDetail"
							style="width: 40%" value=""> <input type="text"
							name="address3" id="roadAddrPart2" style="width: 40%" value="">
					</div>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">전화번호</p>

					<select name="phone1">
						<option selected="selected">010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>019</option>
					</select> - <input id="phone2" type="text" name="phone2" size="5"
						maxlength="4" onkeyup="validate()" onfocus="phoneFocus()"
						onblur="phoneValidate()"> - <input id="phone3" type="text"
						maxlength="4" name="phone3" size="5" onkeyup="validate()"
						onfocus="phoneFocus()" onblur="phoneValidate()">
					<p id="phoneValidate" class="signUp__warning"></p>
				</div>

				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">비밀번호 찾기 질문:</p>
					<select name="pw_q">
						<option selected="selected">가장 좋아하는 캐릭터는?</option>
						<option>가장 좋아하는 음식은?</option>
						<option>가장 좋아하는 영화는?</option>
						<option>기억에 남는 장소는?</option>
						<option>부모님 성함은?</option>

					</select>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">비밀번호 찾기 답변</p>
					<input class="signUp__input" id="pw_a" type="text" name="pw_a">
				</div>
				<input class="signUp__submit" id="submit" type="submit" value="회원가입"
					disabled>
			</form>
		</div>
	</div>
	<script>
	function goPopup(){
	    var pop = window.open("/Funding/apis/addressSearch/addressPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	    
	}
	function idCheck(){
		window.open("/Funding/pages/idCheck.jsp","popup","width=600,height=600")
	}
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		document.signUpForm.roadAddrPart1.value = roadAddrPart1;
		document.signUpForm.roadAddrPart2.value = roadAddrPart2;
		document.signUpForm.addrDetail.value = addrDetail;
		document.signUpForm.zipNo.value = zipNo;
		
	}
	let error = "<%=request.getAttribute("error")%>";
	console.log(error)
	if(error !== "null"){
		<%request.setAttribute("error", null);%>
		alert(error);
	}
	</script>
</body>
</html>