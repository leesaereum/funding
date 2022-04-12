<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중인 펀딩 목록</title>
</head>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<style>
.list__wrap {
	width: 1080px;
	margin: 0 auto;
	padding: 51px 0;
}

.list__header {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.list__pageTitle {
	font-size: 21px;
}

.list__search__box {
	width: 250px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.list__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.list__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}

.list__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.list__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.list__date{
	width: 200px;
	text-align: center;
}
.list__seller{
	width: 220px;
	text-align:center;
}
.list__title{
	width: calc(100% - 660px);
	text-align:center;
}
.pages__box{
	display: flex;
	justify-content: center;
	margin: 20px 0;
}
.pages__box > a{
	margin-right: 8px;
	width: 36px;
	height: 32px;
	border: 1px solid #999;
	border-radius: 4px;
	box-sizing: border-box;
	line-height: 32px;
	text-align: center;
}
.pages__box > .selected{
	background-color: #333;
	color: white;
}
</style>

<body>
	<jsp:include page="/components/header.jsp" />
	<div class="list__wrap">
		<div class="list__header">
			<h1 class="list__pageTitle">진행중인 펀딩 목록</h1>
			<div class="list__search__box">
				<input class="list__search" placeholder="검색할 펀딩이나 판매자를 입력하세요."
					id="list__search" name="notice_search"> <img
					src="/Funding/assets/search.svg" class="list__search__icon">
			</div>
		</div>
		
		<ul class="list__box">
			<li class="list__liner"><p class="list__title">펀딩명</p><p class="list__seller">판매자</p><p class="list__date">오픈일</p><p class="list__date">마감일</p></li>
			<div id="list__document"></div>
		</ul>
		
		<div class="pages__box" id="page__box">
		</div>
	</div>
	<script src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript">

		$(document).on("click", ".list__search__icon", function() {
			location.href = "/Funding/fundingSearch.do?funding_search="+$("#list__search").val();
		})
	</script>

<script type="text/javascript">
let txt = "";
let openDate = "";
let closeDate = "";
<c:forEach items="${funding}" var="funding">
 openDate = '${funding.funding_openAt}';
 closeDate = '${funding.funding_closeAt }'
 txt += '<li class="list__liner"><a href="/Funding/fundingContent_view.do?fid=${funding.funding_num}" class="list__title">${funding.funding_title }</a>'
 txt += '<p class="list__seller">${funding.funding_seller }</p>'
 txt += '<p class="list__date">'+openDate.split(" ")[0]+'</p><p class="list__date">'+closeDate.split(" ")[0]+'</p></li>'
</c:forEach>
 $("#list__document").html(txt);
 
 let currentPage = <%=request.getParameter("page")%>*1;
	let count = ${countQuestion}
	console.log(count);
	let pages = Math.floor((count - 1) / 10) + 1;
	let pageTxt = "";
	for (var i = 1; i <= pages; i++) {
		if(i === currentPage){
			pageTxt += '<a class="selected" href="/Funding/funding_list_view.do?page='+i+'">'+i+'</a>'

		}else{
			pageTxt += '<a href="/Funding/funding_list_view.do?page='+i+'">'+i+'</a>'

		}
	}
	$("#page__box").html(pageTxt);
</script>
</body>
</html>