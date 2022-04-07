<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = (String) request.getParameter("email");
session.setAttribute("email", email);
session.setAttribute("loginFirst", "true");
session.setAttribute("isSeller", "true");
RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
rd.forward(request, response);
%>