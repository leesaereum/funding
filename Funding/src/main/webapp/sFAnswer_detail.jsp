<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 펀딩 답변작성하기</title>
</head>

<body>
	<form action="/Funding/sFAnswer.do" method="post">
		<h3>Open 펀딩 답변작성</h3>
		<br>
		내용<br> 
		<textarea name="answer_content" rows="10" cols="50"></textarea>
		<br>
		<input type="submit" value="작성완료"><br>
		<input type="hidden" name="question_num" value="<%=request.getParameter("question_num")%>">
		<a href ="javascript:history.back();" >이전으로 돌아가기</a>
	</form>
</body>
</html>