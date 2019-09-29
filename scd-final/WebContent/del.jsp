<%@page import="bean.MembersDAO"%><%@page import="bean.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="bean.MembersDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />
<%
	MembersDAO dao = new MembersDAO();
	dao.dele(dto);
	session.invalidate();
%>
