<%@page import="bci.BciDTO"%>
<%@page import="bci.BciDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	int year = Integer.parseInt(request.getParameter("year"));
  	int quarter = Integer.parseInt(request.getParameter("quarter"));
  	String gu = request.getParameter("gu");
  	BciDAO dao = new BciDAO();
  	BciDTO dto = dao.selectYQG(year, quarter, gu);
  	String ci = dto.getCi(); 
  	%>
<%= ci %>