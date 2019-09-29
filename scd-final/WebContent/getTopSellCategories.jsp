<%@page import="bean.SellCategoriesDAO"%>
<%@page import="bean.SellCategoriesDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="dto"
	class="bean.SellCategoriesDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />
<%
	JSONArray data = new JSONArray();
	SellCategoriesDAO dao = new SellCategoriesDAO();

	ArrayList<SellCategoriesDTO> list = dao.selectTop3SellCategories();
	
	for (int i = 0; i < list.size() ; i++) {
		JSONObject row = new JSONObject();
		row.put("sellCategoryName", list.get(i).getSellCategoryName());
		row.put("sellAmountPercentage", list.get(i).getSellAmountPercentage());
		data.add(row);
	}
%>
<%=data.toJSONString()%>