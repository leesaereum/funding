<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 펀딩 정산 신청페이지</title>
</head>
<body>
	
	<h4>결제금액 &emsp;<%=request.getParameter("calculate_cost") %></h4>
	<h4>정산수수료(결재금액의 3%) &emsp;<%=request.getParameter("calculate_cost") %> * 0.03</h4>
	<h4>최종 정산금액 </h4> 
	<hr>
	<h2>정산내역</h2>
	<table border = "1">
		<tr>
			<td align="center"><h4>펀딩명</h4></td>
			<td align="center"><h4>판매자ID</h4></td>
			<td align="center"><h4>금액</h4></td>
			<td align="center"><h4>승인일</h4></td>
			<td align="center"><h4>정산상태</h4></td>
			<td align="center"><h4>관리자이름</h4></td>
		</tr>
		<tr>
			<td><input type="text" name="calculate_funding" value=<%=request.getParameter("calculate_funding") %>></td>
			<td><input type="text" name="calculate_seller" value=<%=request.getParameter("calculate_seller") %>></td>
			<td><input type="text" name="calculate_cost" value=<%=request.getParameter("calculate_cost") %>></td>
			<td><input type="text" name="calculate_createAt" value=<%=request.getParameter("calculate_createAt") %>></td>
			<td><input type="text" name="calculate_approveAt" value=<%=request.getParameter("calculate_approveAt") %>></td>
			<td><input type="text" name="calculate_admin" value=<%=request.getParameter("calculate_admin") %>></td>
		</tr>
		
 	</table>
</body>
</html>