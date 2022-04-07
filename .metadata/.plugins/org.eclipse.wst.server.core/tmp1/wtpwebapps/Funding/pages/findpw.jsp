<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<div>${customer_id } 님의 비밀번호는 ${customer_pw}입니다.</div>
<div class = "close_button">확인</div>
<script type="text/javascript" src="/Funding/libraries/jQuery.js"></script>
<script type="text/javascript">
$(document).on("click", ".close_button", function(e){
	e.stopPropagation();
	window.close();
})
</script>
</body>
</html>