<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.categories{
	width:  900px;
	display: flex;
	margin: 54px auto;
	justify-content: space-around;
}
.categories > p {
	display: block;
	min-width: 130px;
	padding: 10px 11px 9px;
	border: 1px solid #cdcdcd;
	border-radius: 4px;
	font-size: 16px;
	letter-spacing: -.3px;
	text-align: center;
	cursor: pointer;
}
.categories > p:hover{
	border: 1px solid #555;
}
</style>

<div class="categories">
	<p><a href = "/Funding/main.do?sort=all">전체</a></p>
	<p><a href = "/Funding/main.do?sort=hits">인기순</a></p>
	<p><a href = "/Funding/main.do?sort=achievement">달성률순</a></p>
	<p><a href = "/Funding/main.do?sort=closeAt">마감임박</a></p>
	<p><a href = "/Funding/main.do?sort=end">마감된 펀딩</a></p>
</div>
