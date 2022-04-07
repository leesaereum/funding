<%@page import="funding.dao.FDaoS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인 결과</title>
</head>
<script type="text/javascript">
	function setid() {
		opener.f1.id.value = document.f1.id.value;
		opener.f1.idDupChk.value = 't';
		self.close();
	}
</script>
<body>
	<div style="text-align: center;">
		<h3>*아이디 중복확인 결과*</h3>
	<%
	request.getParameter("utf-8");
	String id = request.getParameter("seller_id");
	FDaoS daoS = new FDaoS();
	boolean result = false;
	if(id == null || id.equals("")){
		id = "" + "";
	}else{
		result = daoS.duplecateID(id);
	}
	%>
	<form name = "f1" action="sidCheckProc.jsp">
		<input type="text" name="id" value="<%=id%>" readonly="readonly"/>
	</form>
	<%
		if(id.equals("")){ %>
	<% }else if(result == false){%>
	 <a href = "#" onclick="setid()">사용가능</a>
	<%}else {
		out.print("사용 불가능");
	 } %>
	<hr>
	<a href="javascript:history.back()">[다시검색]</a>
	&nbsp;&nbsp;
	<a href="javascript:window.close()">[창닫기]</a>
	</div>
	
</body>
</html>