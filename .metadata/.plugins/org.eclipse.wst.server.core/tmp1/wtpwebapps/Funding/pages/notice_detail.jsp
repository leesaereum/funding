<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세정보</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<body>
	<jsp:include page="/components/header.jsp"/>
	<div>공지사항 상세정보</div>
	<div>공지번호 : ${notice.notice_num }</div>
	<div>담당관리자 ${notice.notice_admin } </div>
	<div>공지제목 : ${notice.notice_title }</div>
	<div>공지내용 : ${notice.notice_content }</div>
	<div>공지일 : ${notice.notice_At }</div>
	<div><a href = "notice_list.do">목록으로 돌아가기</a></div>
</body>
</html>