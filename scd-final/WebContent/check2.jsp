<%@page import="bean.MembersDAO"%>
<%@page import="bean.MembersDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="bean.MembersDTO">
</jsp:useBean><jsp:setProperty property="*" name="dto" />
<%
	MembersDAO dao = new MembersDAO();
	dao.insert(dto);
	
	String m_id = dto.getM_id();

	session.setAttribute("id", m_id);
	String welcome = (String) session.getAttribute("id");
	String redirectURL = "index.html";
	response.sendRedirect(redirectURL);
%>