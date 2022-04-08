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
	<p>전체</p>
	<p>일자리 창출</p>
	<p>친환경</p>
	<p>기부</p>
	<p>작은가게</p>
	<p>미디어</p>
</div>