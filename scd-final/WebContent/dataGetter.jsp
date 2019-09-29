<%@page import="bean.CommercialDistrictsPerSellCategoriesDAO"%>
<%@page import="bean.CommercialDistrictsPerSellCategoriesDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="dto"
	class="bean.CommercialDistrictsPerSellCategoriesDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />
<%
	JSONArray data = new JSONArray();
	CommercialDistrictsPerSellCategoriesDAO dao = new CommercialDistrictsPerSellCategoriesDAO();

	ArrayList<CommercialDistrictsPerSellCategoriesDTO> list = dao.selectTop10Districts(dto);
	
	for (int i = 0; i < list.size() ; i++) {
		JSONObject row = new JSONObject();
		row.put("commercialDistrictName", list.get(i).getCommercialDistrictName());
		row.put("year", list.get(i).getYear());
		row.put("quarter", list.get(i).getQuarter());
		row.put("sellCategoryName", list.get(i).getSellCategoryName());
		row.put("sellAmount", list.get(i).getSellAmount());
		row.put("latitude", list.get(i).getLatitude());
		row.put("longitude", list.get(i).getLongitude());
		data.add(row);
	}
%>
<%=data.toJSONString()%>