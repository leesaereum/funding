<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Date d = Date.valueOf(request.getParameter("startDate"));



DataSource dataSource;
Context context = new InitialContext();
dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding");

Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

connection = dataSource.getConnection();
String query = "insert into test (startdate) values (?)";
preparedStatement = connection.prepareStatement(query);
preparedStatement.setDate(1, d);

preparedStatement.executeUpdate();

%>