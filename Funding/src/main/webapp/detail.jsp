<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>

<%String funding_num  = request.getParameter("funding_num"); 
String customer_id  =request.getParameter("customer_id");%>

<html>
<head>
<meta charset="UTF-8">
<title>funding_num = <%=funding_num%></title>
</head>
<body>


<h1>like data</h1>

	<form action="fundingLike.do" method="get">
		펀딩고유넘버 : <input type="text" name="funding_num">
		유저아이디 : <input type="text" name="customer_id">
		좋아요 들어간 날짜 : <input type="date" name="like_at">
	<input type= "submit" value="Like">
				
		
	</form>
	
<c:forEach items="${list }" var="dtolike">
${dtolike.funding_title} like : 

</c:forEach>



	<c:forEach items="${list }" var="dto01">
<h1>funding data</h1>
	funding_title: ${dto01.funding_title} 
	<br>
	<br>
	funding_openAt: ${dto01.funding_openAt} <br>
	<br>
	<br>
	funding_closeAt: ${dto01.funding_closeAt} <br>
	<br>
	<br>
	funding_purpose: ${dto01.funding_purpose} <br>
	<br>
	<br>
	content_content: ${dto01.content_content} <br>
	<br>
	<br>
<
		</c:forEach>




<h1>option data</h1>

	<form action="fundingOrder.do" method="get">
				<input type= "submit" value="Order">
	</form>
<%int optionNum = 1; %>

<c:forEach items="${optionList }" var="dtoOption">
	
	Option<%=optionNum%>_name: ${dtoOption.option_name} <br>
	
	<br>
	<br>
	option_price: ${dtoOption.option_price} <br>
	<br>
	<br>
	remain option_amount: ${dtoOption.option_amount} <br>
	<br>
	<br>
	<% optionNum += 1; %>
------------------------------------------------------------------------------------------------------------------------
	<br>
	<br>
	<br>
</c:forEach>



<h1>question data</h1>

	<c:forEach items="${questionList }" var="dtoQuestion">
	
	
	question_customer: ${dtoQuestion.question_customer} <br>
	question_title: ${dtoQuestion.question_title} <br>
	question_content: ${dtoQuestion.question_content}<br>
	question_at: ${dtoQuestion.question_at} <br>
	question_answer: ${dtoQuestion.question_answer} <br>

	<br>
	<br>

</c:forEach>

<h1>order cutomer_id data</h1>

	<c:forEach items="${orderList }" var="orderDtos">
	
	order_customer: ${orderDtos.order_customer} <br>


	<br>
	<br>

</c:forEach>


</body>
</html>