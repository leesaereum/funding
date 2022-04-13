<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 펀딩 정산 신청페이지</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<style>
.notice__wrap {
	width: 960px;
	margin: 0 auto;
	padding: 51px 0;
}

.notice__header {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.notice__pageTitle {
	font-size: 21px;
}

.notice__search__box {
	width: 238px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.notice__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.notice__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}

.sMFCApply__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.sMFCApply__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.sMFCApply__num{
	width: 66px;
	text-align: center;
}
.sMFCApply__date{
width: 200px;
text-align: center;
}
.sMFCApply__state{
width: 200px;
text-align: center;
}
.sMFCApply__cost{
width: 200px;
text-align: center;
}
.sMFCApply__admin{
width: 300px;
text-align: center;
}
.sMFCApply__seller{
	width: calc(100% - 600px);
	text-align: center;
}
</style>
<script type="text/javascript">
	//function del() {
		
	//}
</script>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 정산관리</h1>
			<div class="notice__search__box">
				<input class="notice__search" placeholder="검색어를 입력하세요"
					id="notice__search" name="notice__search"> <img
					src="/Funding/assets/search.svg" class="notice__search__icon">
			</div>
		</div>
		<ul class="sMFCApply__box">
			<li class="sMFCApply__liner">
				<p class="sMFCApply__seller">판매자ID</p>
				<p class="sMFCApply__admin">관리자ID</p>
				<p class="sMFCApply__cost">정산금액</p>
				<p class="sMFCApply__date">펀딩오픈일</p></li>
			<c:forEach items="${list }" var="list">
				<li class="sMFCApply__liner">
				
				<p class="sMFCApply__seller">${list.calculate_seller }</p>
				<p class="sMFCApply__admin">${list.calculate_admin }</p>
				<p class="sMFCApply__cost">${list.calculate_cost }</p>
				<p class="sMFCApply__date">${list.calculate_createAt }</p>
				<p class="sMFCApply__date">${list.calculate_approveAt }</p>
				<p class="sMFCApply__state">${list.calculate_state }</p>					
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>