<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정산 신청</title>
</head>
<body>
	<form action="sMFCApply.do" method="get">
		판매자ID <input type="text" value="" readonly="readonly"><br>
		관리자ID<input type="text" value="" readonly="readonly"><br>
		정산금액<input type="text" value="" readonly="readonly"><br>
		정산신청일<input type="text" value="" readonly="readonly"><br>
		펀딩승인일<input type="text" value="" readonly="readonly"><br>
		정산상태<input type="text" value="" readonly="readonly"><br>
		<input type="hidden" name="calculate_funding" value="<%=request.getParameter("calculate_funding")%>">
		<input type="submit" value="신청">
	</form>
</body>
</html>