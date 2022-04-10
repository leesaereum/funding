<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open 펀딩 디테일</title>
</head>
<body>
	<table border = "1">
	<tr>
		<th>판매자ID</th>
		<th>펀딩제목</th>
		<th>펀딩배너</th>
		<th>펀딩생성일</th>
		<th>펀딩종료일</th>
		<th>펀딩목표금액</th>
		<th>펀딩hits</th>
		<th>펀딩상태</th>
		<th>펀딩배송비</th>
	</tr>
	<c:forEach items = "${list }" var="dtoFunding">
		<tr>
			<td>${dtoFunding.funding_seller }</td>
			<td>${dtoFunding.funding_title }</td>
			<td>${dtoFunding.funding_banner }</td>
			<td>${dtoFunding.funding_openAt }</td>
			<td>${dtoFunding.funding_closeAt }</td>
			<td>${dtoFunding.funding_purpose }</td>
			<td>${dtoFunding.funding_hits }</td>
			<td>${dtoFunding.funding_state }</td>
			<td>${dtoFunding.funding_fee }</td>
		</tr>	
	</c:forEach>
	</table>
</body>
</html>