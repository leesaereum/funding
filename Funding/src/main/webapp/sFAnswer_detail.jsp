<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 펀딩 답변작성하기</title>
</head>

<body>
	<form action="sFAnswer.do?question_content=${FAnswer.question_answer}" method="get">
		<h3>Open 펀딩 답변작성</h3>
		<br>
		내용<br> 
		<textarea name="FAnswer_update" rows="10" cols="50"></textarea>
		<br>
		<input type="submit" value="작성완료">
		<br>
		<a href = "sFAnswer.do?question_num=${FQlist.question_num}">이전으로 돌아가기</a>
	</form>
</body>
</html>