<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
.signUp__warning {
	margin: 4px 4px 16px;
	font-size: 13px;
	color: red;
}
</style>
</head>
<script type="text/javascript">
	let emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	window.onload = function(){
		let errorCode = "<%=request.getParameter("error")%>"
		console.log(errorCode)
		if(errorCode !== "null"){
			alert("입력하신 정보에 대한 아이다가 없습니다. 다시 확인해주세요")
		}
	}
	
	function validate() {
	const id = document.getElementById('id').value
		if (id.match(emailPattern)) {
			document.getElementById('submit').disabled = false;
		} else {
			document.getElementById('submit').disabled = true;
		}
	}
	function idFocus() {
		document.getElementById('idValidate').innerHTML = ''
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

	
</script>
<body>
	<form name="findId" action="/Funding/findPw.do" method="post">
		<div class="signUp__liner">
			<p class="signUp__subTitle">아이디</p>
			<input class="signUp__input" id="id" name="id"
				placeholder="example@mail.com" onkeyup="validate()"
				onfocus="idFocus()" onblur="idValidate()">
			<p id="idValidate" class="signUp__warning"></p>
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

		<input id="submit" type="submit" value="확인" disabled>
	</form>
</html>