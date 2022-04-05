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
	height: 100%;
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
	width: 340px;
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
function validate(){
	const id = document.getElementById('id').value
	const pw = document.getElementById('pw').value
	const name = document.getElementById('name').value
	
	if(id.match(emailPattern) && pw.length >= 4 && name.match(namePattern)){
		document.getElementById('submit').disabled = false;
	}else{
		document.getElementById('submit').disabled = true;
	}
}
function idFocus(){
	document.getElementById('idValidate').innerHTML = ''
}
function pwFocus(){
	document.getElementById('pwValidate').innerHTML = ''
}
function nameFocus(){
	document.getElementById('nameValidate').innerHTML = ''
}

function idValidate(){
	const id = document.getElementById('id').value
	if(!id.match(emailPattern)){
		document.getElementById('idValidate').innerHTML = '아이디는 이메일 형식으로 입력해야 합니다'
	}else{

		document.getElementById('idValidate').innerHTML = ''
	}
}
function pwValidate(){
	const pw = document.getElementById('pw').value
	if(pw.length < 4){
		document.getElementById('pwValidate').innerHTML = '4자 이상의 패스워드를 입력해주세요'
	}else{
		document.getElementById('pwValidate').innerHTML = ''
	}
}
function nameValidate(){
	const name = document.getElementById('name').value
	if(!name.match(namePattern)){
		document.getElementById('nameValidate').innerHTML = '이름은 한글이나 영어로 입력해주세요'
	}else{

		document.getElementById('nameValidate').innerHTML = ''
	}
}
</script>
<body>
	<div class="signUp__wrap">
		<div class="signUp__content">
			<h1 class="signUp__title">회원가입</h1>
			<div class="signIn__divider"></div>
			<form action="signUp.do" name="signUpForm" method="post">
				<div class="signUp__liner">
					<p class="signUp__subTitle">아이디</p>
					<input class="signUp__input" id="id" name="customer_id"
						placeholder="example@mail.com" onkeyup="validate()"
						onfocus="idFocus()" onblur="idValidate()">
					<p id="idValidate" class="signUp__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">패스워드</p>
					<input class="signUp__input" id="pw" type="password"
						name="customer_pw" onkeyup="validate()" onfocus="pwFocus()"
						onblur="pwValidate()">
					<p id="pwValidate" class="signUp__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">이름</p>
					<input class="signUp__input" id="name" type="text"
						name="customer_name" onkeyup="validate()" onfocus="nameFocus()"
						onblur="nameValidate()">
					<p id="nameValidate" class="signUp__warning"></p>
				</div>


				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">전화번호</p>

					<select name="customer_phone1">
						<option selected="selected">010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>019</option>
					</select> - <input type="text" id="phone2" name="text" size="5"> - <input
						type="text" id="phone3" name="text" size="5">
				</div>

				<div class="signIn__liner">
					<p class="signUp__warning"></p>
					<p class="signUp__subTitle">비밀번호 찾기 질문:</p>
					<select name="customer_pw_q">
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
					<input class="signUp__input" id="pw_a" type="text"
						name="customer_pw_a">
				</div>
				<input class="signUp__submit" id="submit" type="submit" value="회원가입"
					disabled>
			</form>
		</div>
	</div>
</body>
</html>