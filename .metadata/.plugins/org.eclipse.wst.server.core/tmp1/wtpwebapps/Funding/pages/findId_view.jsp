<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
.signUp__warning {
	margin: 4px 4px 16px;
	font-size: 13px;
	color: red;
}
</style>
</head>
<script type="text/javascript">
	let namePattern = /^[ㄱ-ㅎ|가-힣|a-z|A-Z]+$/;
	let phonePatern = /^[0-9]+$/;
	window.onload = function(){
		let errorCode = "<%=request.getParameter("error")%>"
		console.log(errorCode)
		if(errorCode !== "null"){
			alert("입력하신 정보에 대한 아이다가 없습니다. 다시 확인해주세요")
		}
	}
	
	function validate() {
	const name = document.getElementById('name').value
	const phone2 = document.getElementById('phone2').value
	const phone3 = document.getElementById('phone3').value
		if (name.match(namePattern)) {
			document.getElementById('submit').disabled = false;
		} else {
			document.getElementById('submit').disabled = true;
		}
	}
	function nameFocus() {
		document.getElementById('nameValidate').innerHTML = ''
	}
	function phoneFocus() {
		document.getElementById('phoneValidate').innerHTML = ''
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
		if (!phone2.match(phonePattern) || !phone3.match(phonePattern)) {
			document.getElementById('phoneValidate').innerHTML = '전화번호는 숫자로만 입력해주세요'
		} else {

			document.getElementById('phoneValidate').innerHTML = ''
		}
	}
	
</script>
<body>
	<form name="findId" action="/Funding/findId.do" method="post">
		<div>
			이름 <input id="name" type="text" name="name" onkeyup="validate()"
				onfocus="nameFocus()" onblur="nameValidate()">
			<p id="nameValidate" class="signUp__warning"></p>
		</div>
		<div>
			전화번호 <select name="phone1">
				<option selected="selected">010</option>
				<option>011</option>
				<option>016</option>
				<option>017</option>
				<option>019</option>
			</select> - <input id="phone2" type="text" name="phone2" size="5"
				onkeyup="validate()" onfocus="phoneFocus()" onblur="phoneValidate()">
			- <input id="phone3" type="text" name="phone3" size="5"
				onkeyup="validate()" onfocus="phoneFocus()" onblur="phoneValidate()">
			<p id="phoneValidate" class="signUp__warning"></p>
		</div>

		<input id="submit" type="submit" value="확인" disabled>
	</form>
</body>
</html>