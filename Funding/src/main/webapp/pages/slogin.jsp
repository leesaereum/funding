<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해피펀딩 판매자 로그인</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
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

.signIn__wrap {
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
100%
50%;
}
100
%
{
background-position
:
0%
50%;
}
}
.signIn__content {
	width: 340px;
	padding: 30px;
	background-color: white;
	border-radius: 16px;
}

.signIn__title {
	margin: 12px 0 16px;
}

.signIn__description {
	color: #555;
	margin: 0 0 24px;
}

.signIn__subTitle {
	font-size: 14px;
	font-weight: bold;
	margin: 4px 0;
}

.signIn__input {
	width: 280px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}

.signIn__warning {
	margin: 4px 4px 16px;
	font-size: 13px;
	color: red;
}

.signIn__submit {
	width: 280px;
	background-color: royalblue;
	color: white;
	height: 44px;
	margin: 24px 0;
	border-radius: 32px;
	cursor: pointer;
}

.signIn__submit:hover {
	filter: brightness(105%);
}

.signIn__submit:disabled {
	background-color: #aaa;
}

.signIn__submit:active {
	filter: brightness(95%);
}

.signIn__info {
	margin: 0;
	font-size: 14px;
}

.signIn__divider {
	padding-bottom: 20px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 20px;
}
.signIn__findInfo{
	width: 280px;
	background-color: royalblue;
	color: white;
	height: 44px;
	margin: 10px 0;
	border-radius: 32px;
	cursor: pointer;
}
.signIn__findInfo:hover{
	filter: brightness(105%);
}
.signIn__findInfo:disabled {
	background-color: #aaa;
}

.signIn__findInfo:active {
	filter: brightness(95%);
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
	window.onload = function(){
		let errorCode = "<%=request.getParameter("error")%>"
		console.log(errorCode)
		if(errorCode !== "null"){
			toast("로그인 정보를 확인해주세요")
		}
		if(localStorage.getItem("id")){
			document.getElementById('id').value = localStorage.getItem("id");
			document.getElementById("rememberMe").checked = true;
		}
	}
	

	function validate(){
		const id = document.getElementById('id').value
		const pw = document.getElementById('pw').value
		
		if(id.match(emailPattern) && pw.length >= 4){
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
	function checkCheck(){
		const check = document.getElementById("rememberMe");
		if(check.checked){
			localStorage.setItem('id', document.getElementById('id').value);
		}else{
			localStorage.setItem('id', "");
		}
	}
	
	function toast(string) {
	    const toast = document.getElementById("toast");

	    toast.classList.contains("reveal") ?
	        (clearTimeout(removeToast), removeToast = setTimeout(function () {
	            document.getElementById("toast").classList.remove("reveal")
	        }, 3000)) :
	        removeToast = setTimeout(function () {
	            document.getElementById("toast").classList.remove("reveal")
	        }, 3000)
	    toast.classList.add("reveal"),
	        toast.innerText = string
	}
	
	function signIn_findInfo() {
		alert("관리자에게 요청하세요.")
	}
</script>
<body>
	<div class="signIn__wrap">
		<div class="signIn__content">
			<h1 class="signIn__title">판매자 로그인</h1>
			<div class="signIn__divider"></div>
			<form action="/Funding/slogin.do" name="signInForm" method="post"
				onsubmit="checkCheck()">
				<div class="signIn__liner">
					<p class="signIn__subTitle">아이디</p>
					<input class="signIn__input" id="id" name="seller_id"
						placeholder="example@mail.com" onkeyup="validate()"
						onfocus="idFocus()" onblur="idValidate()">
					<p id="idValidate" class="signIn__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signIn__subTitle">패스워드</p>
					<input class="signIn__input" id="pw" type="password" name="seller_pw"
						onkeyup="validate()" onfocus="pwFocus()" onblur="pwValidate()">
					<p id="pwValidate" class="signIn__warning"></p>
				</div>
				<div class="signIn__rememberLiner">
					<input type="checkbox" name="rememberMe" id="rememberMe"> <label
						for="rememberMe">아이디 저장</label>
				</div>
				<input class="signIn__submit" id="submit" type="submit" value="로그인"
					disabled>
				<input class="signIn__findInfo" id="button" type="button" value="ID / PW 찾기"
					onclick="signIn_findInfo()">
			</form>
			<div class="signIn__infoBox">
				<p class="signIn__info">
					아직 가입하지 않으셨나요? <a href="/Funding/pages/ssignUp_view.jsp">가입하러 가기</a>
				</p>

			</div>
		</div>
	</div>
	<div id="toast"></div>

</body>
</html>