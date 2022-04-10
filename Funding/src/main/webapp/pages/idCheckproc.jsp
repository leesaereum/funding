<%@page import="funding.dao.FDaoS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인 결과</title>
</head>
<div style="text-align: center"></div> 
<h3>* 아이디 중복 확인 결과 *</h3> 
<% 
	String id=request.getParameter("id"); 
	FDaoS daoS = new FDaoS();
	boolean id_check=daoS.checkDuplicateId(id);
	int cnt =0;
	out.println("입력 ID : <strong>" + id + "</stong>"); 
	if(id_check==true){ out.println("<p>사용 가능한 아이디입니다.</p>"); 
	out.println("<a href='javascript:apply(\"" + id + "\")'>[적용]</a>"); %> 
	<script> 
	function apply(id){
		alert("apply");
		opener.document.signUpForm.id.value=id; 
		window.close(); 
		}
	</script>
	 <% }else{ 
		 out.println("<p style='color: red'>해당 아이디는 사용하실 수 없습니다.</p>"); 
		 }//if end 
		 %> 
		 <hr>
		  <a href="javascript:history.back()">[다시시도]</a> 
		  &nbsp; &nbsp; 
		  <a href="javascript:window.close()">[창닫기]</a>

</body>
</html>