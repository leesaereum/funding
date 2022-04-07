<%@page import="funding.dao.FDaoS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인 결과</title>
</head>
<body>
	<div style="text-align: center;">
		<h3>*아이디 중복확인 결과*</h3>
	<%
	request.getParameter("utf-8");
	String id = request.getParameter("seller_id");
	FDaoS daoS = new FDaoS();
	int result = daoS.duplecateID(id);
	if(result == 0){
		out.print("사용가능한 아이디입니다.");
	}else if(result == 1){
		out.print("중복된 아이디입니다.");
	}else{
		out.print("에러 발생!!!!");
	}
	%>
	<hr>
	<a href="javascript:history.back()">[다시검색]</a>
	&nbsp;&nbsp;
	<a href="javascript:window.close()">[창닫기]</a>
	</div>
	
</body>
</html>