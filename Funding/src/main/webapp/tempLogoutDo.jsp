<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("customer_id", null);
session.setAttribute("isSeller", null);
response.sendRedirect("/Funding/main.jsp");
%>