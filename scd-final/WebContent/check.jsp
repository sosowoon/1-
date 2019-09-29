<%@page import="bean.MembersDAO"%>
<%@page import="bean.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String m_id = request.getParameter("m_id");
	String pw = request.getParameter("pw");
	MembersDTO dto = new MembersDTO();
	dto.setM_id(m_id);
	dto.setPw(pw);
	MembersDAO dao = new MembersDAO();
	boolean result = dao.login(dto.getM_id(), dto.getPw());
	if(result){
		session.setAttribute("id", dto.getM_id());
	}
%>
<%= result %>