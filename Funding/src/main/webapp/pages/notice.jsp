<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해피펀딩 공지사항</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
<style>
.loadMore {
	width: 100%;
	height: 52px;
	line-height: 52px;
	border: 1px solid rgba(0, 0, 0, .07);
	background-color: #f6f6f6;
	font-size: 15px;
	text-align: center;
	overflow-anchor: none;
	cursor: pointer;
}
#toast {
    position: fixed;
    bottom: 30px;
    left: 50%;
    padding: 15px 20px;
    transform: translate(-50%, 10px);
    border-radius: 30px;
    overflow: hidden;
    opacity: 0;
    visibility: hidden;
    transition: opacity .5s, visibility .5s, transform .5s;
    background: rgba(0, 0, 0, 0.5);
    color: #fff;
    z-index: 5;
}
#toast.reveal {
    opacity: 1;
    visibility: visible;
    transform: translate(-50%, 0)
}
</style>
</head>
<body>
	<jsp:include page="/components/header.jsp"/>
	<div>공지번호 제목 공지일</div>
	<c:forEach items="${notice}" var="notice">
	<div>${notice.notice_num } / <a href = "notice_detail.do?notice_num=${notice.notice_num}">${notice.notice_title }</a> / ${notice.notice_At }</div>
	</c:forEach>
</body>
</html>