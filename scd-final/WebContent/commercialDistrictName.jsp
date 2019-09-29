<%@page import="bean.CommercialDistrictsDAO"%>
<%@page import="bean.CommercialDistrictsDTO"%>
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
	CommercialDistrictsDAO dao = new CommercialDistrictsDAO();

	ArrayList<CommercialDistrictsDTO> list = dao.selectAllDistricts();
	
	for (int i = 0; i < list.size() ; i++) {
		JSONObject row = new JSONObject();
		CommercialDistrictsDTO dto2 = list.get(i);
		row.put("commercialDistrictName", dto2.getCommercialDistrictName());
		data.add(row);
	}
%>
<%=data.toJSONString()%>