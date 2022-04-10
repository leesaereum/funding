<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open 펀딩 디테일</title>
</head>
<body>
	<table border = "0">
	<tr>
		<th>판매자ID</th>
		<th>펀딩제목</th>
		<th>펀딩배너</th>
		<th>펀딩생성일</th>
		<th>펀딩종료일</th>
		<th>펀딩목표금액</th>
		<th>펀딩</th>
		<th>펀딩상태</th>
		<th>펀딩배송비</th>
	</tr>
	<c:forEach items = "${list }" var="fDtoFunding">
		<tr>
			<td>${fDtoFunding.funding_seller }</td>
			<td>${fDtoFunding.funding_title }</td>
			<td>${fDtoFunding.funding_banner }</td>
			<td>${fDtoFunding.funding_openAt }</td>
			<td>${fDtoFunding.funding_closeAt }</td>
			<td>${fDtoFunding.funding_purpose }</td>
			<td>${fDtoFunding.funding_hits }</td>
			<td>${fDtoFunding.funding_state }</td>
			<td>${fDtoFunding.funding_fee }</td>
		</tr>	
	</c:forEach>
	</table>
</body>
</html>