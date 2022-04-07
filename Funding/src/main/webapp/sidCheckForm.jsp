<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../header.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
</head>
<script type="text/javascript">
	function blankCheck() {
		var id = p.id.value;
		id=id.trim();
		return true;
	}

</script>
<body>
<div style = "text-align : center;">
		<h3>*아이디 중복확인*</h3>
		<form action="sidCheckProc.jsp" method="get" onsubmit="return blankCheck(this)">
		아이디 : <input type = "text" name = "seller_id" autofocus>
		<input type="submit" value="중복확인">
		</form>
		</div>
</body>
</html>