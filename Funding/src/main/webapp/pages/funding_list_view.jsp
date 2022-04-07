<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<style>
.list__wrap {
	width: 960px;
	margin: 0 auto;
	padding: 51px 0;
}
.list__header{
	width:  100%;
	display: flex;
	justify-content: space-between;
}
.list__pageTitle{
	font-size: 21px;
}
.list__search__box{
	width: 238px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}
.list__search{
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}
.list__search__icon{
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}
.list__box{
   list-style:none;
   margin-top: 17px;
   border: 1px solid #eee;
}
.list__liner{
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}

</style>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="list__wrap">
		<div class="list__header">
			<h1 class="list__pageTitle">펀딩 목록</h1>
			<div class="list__search__box">
				<input class="list__search" placeholder="검색어를 입력하세요" id="list__search" name="funding_search">
				<img src="/Funding/assets/search.svg" class="list__search__icon">
			</div>
		</div>
		<ul class="list__box">
			<% for(int i=0; i<10; i++){ %>
			<li class="list__liner">
				<a href="/Funding/pages/detail.jsp?fid=<%= i %>" class="list__title">
				네이버페이 신한은행 계좌간편 및 포인트충전결제 일시 중단 안내 (3/5(토) 00:00~12:00)</a>
				<p class="list__date">2022-04-01</p>
			</li>
			<% } %>
		</ul>
	</div>
	<script src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript">
	$(document).on("click", ".list__search__icon", function(){
		location.href = "/Funding/main.jsp";
	})
	</script>
</body>
</html>