<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("email", null);
session.setAttribute("isSeller", null);
response.sendRedirect("/funding/main.jsp");
%>