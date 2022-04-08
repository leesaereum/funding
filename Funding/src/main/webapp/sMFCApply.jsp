<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 펀딩 정산 신청페이지</title>
</head>
<body>
	
	<h4>결제금액</h4>
	<h4>정산수수료(결재금액의 3%)</h4>
	<h4>최종 정산금액</h4> 
	<hr>
	<h2>정산내역</h2>
	<table border = "1">
		<tr>
			<th>펀딩명</th>
			<th>판매자ID</th>
			<th>금액</th>
			<th>생성일</th>
			<th>승인일</th>
			<th>정산상태</th>
			<th>관리인이름</th>
		</tr>
		<c:forEach items = "${list }" var="dtoCalculate">
			<tr>
				<td>${dtoCalculate.calculate_funding }</td>
				<td>${dtoCalculate.calculate_seller }</td>
				<td>${dtoCalculate.calculate_cost }</td>
				<td>${dtoCalculate.calculate_createAt }</td>
				<td>${dtoCalculate.calculate_approveAt }</td>
				<td>${dtoCalculate.calculate_state }</td>
				<td>${dtoCalculate.calculate_admin }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>