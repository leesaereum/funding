<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Customer List</title>
</head>
<style>
body, table, tr {
	width: 100%;
}

h1 {
	color: gray;
}

.first {
	border-color: gray;
	border-style: solid;
}

.second {
	border-color: gray;
	border-style: double;
	border-top-width: 5px;
}

.bottomline {
	position: fixed;
	bottom: 16px;
	left: 0;
	width: 100%;
	display: flex;
	justify-content: center;
}

.listcontent {
	width: 100%;
}

.dropmenu {
	border: none;
	border: 0px;
	margin: 0px;
	padding: 0px;
	font: "sans-serif";
	font-size: 18px;
}

.dropmenu ul {
	background: #666;
	height: 100px;
	list-style: none;
	margin: 0;
	padding: 0;
}

.dropmenu li {
	float: left;
	padding: 0px;
}

.dropmenu li a {
	background: #666;
	color: #fff;
	display: block;
	line-height: 100px;
	margin: 0px;
	padding: 0px 25px;
	text-align: center;
	text-decoration: none;
}

.dropmenu li a:hover, .dropmenu ul li:hover a {
	background: rgb(31, 31, 31);
	color: #FFFFFF;
	text-decoration: none;
}

.dropmenu li ul {
	background: red;
	display: none;
	height: auto;
	border: 0px;
	position: absolute;
	width: 200px;
	z-index: 200;
	/*top:1em;
/*left:0;*/
}

.dropmenu li:hover ul {
	display: block;
}

.dropmenu li li {
	background: red;
	display: block;
	float: none;
	margin: 0px;
	padding: 0px;
	width: 200px;
}

.dropmenu li:hover li a {
	background: none;
}

.dropmenu li ul a {
	display: block;
	height: 80px;
	font-size: 14px;
	margin: 0px;
	padding: 0px 10px 0px 15px;
	text-align: left;
}

.dropmenu li ul a:hover, .dropmenu li ul li:hover a {
	background: rgb(171, 171, 171);
	border: 0px;
	color: #ffffff;
	text-decoration: none;
}

.dropmenu p {
	clear: left;
}
</style>


<script type="text/javascript">
	function LogOut() {
		location.href = "aLogout.do";
	}
</script>
<body>
	<h1 align="center">해피펀딩 관리자 페이지</h1>

	<input type="button" value="logout" align="center" onclick="LogOut()">

	<div class="dropmenu">
		<ul>
			<li><a href="aCList.do">회원관리</a></li>
			<li><a href="#" id="current">신청관리</a>
				<ul>
					<li><a href="aSQWList.do">판매자승인 대기</a></li>
					<li><a href="aFAWList.do">펀딩승인 대기</a></li>
					<li><a href="aCAWList.do">정산승인 대기</a></li>
				</ul></li>
			<li><a href="#" id="current">문의관리</a>
				<ul>
					<li><a href="#">펀딩문의</a></li>
					<li><a href="#">캠페인문의</a></li>
					<li><a href="#">시스템문의</a></li>
				</ul></li>
			<li><a href="#" id="current">펀딩리스트</a></li>
			<li><a href="#" id="current">공지사항</a></li>


		</ul>
	</div>

	<hr class="first">
	<table border="0">
		<tr>
			<th width="10%" align="center">정산 번호</th>
			<th width="10%" align="center">펀딩 이름</th>
			<th width="10%" align="center">셀러 이름</th>
			<th width="10%" align="center">정산 금액</th>
			<th width="10%" align="center">정산 상태</th>
			<th width="10%" align="center"></th>
		</tr>
	</table>
	<hr class="second">
	<div class="listcontent" style="overflow-x: hidden;">
		<c:forEach items="${calapprovewaitlist }" var="dto04">
			<table border="0">
				<td width="10%" align="center">${dto04.calculate_num}</td>
				<td width="10%" align="center">${dto04.calculate_funding}</td>
				<td width="10%" align="center">${dto04.calculate_seller}</td>
				<td width="10%" align="center">${dto04.calculate_cost}</td>
				<td width="10%" align="center">${dto04.calculate_state}</td>
				<td width="10%" align="center"><a href="aCApprove.do?calNum=${dto04.calculate_num}">승인</a> / <a href="aCReject.do?calNum=${dto04.calculate_num}">반려</a></td>

			</table>
		</c:forEach>
	</div>
	<!--search area-->
	<div class="bottomline">
		<form action="aCList.do">
			<select name="query">
				<option value="customer_id" selected="selected">이름</option>
				<option value="customer_name">아이디</option>
				<option value="customer_phone">전화번호</option>
				<option value="customer_phone">주소</option>
			</select> <input type="text" name="customer_id" size="50"> <input
				type="submit" value="검색">
		</form>
	</div>
</body>
</html>