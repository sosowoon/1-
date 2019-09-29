<%@page import="bean.OpclDTO"%>
<%@page import="bean.OpclDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String year = request.getParameter("year");
	String quarter = request.getParameter("quarter");
	String sellCategoryName = request.getParameter("sellCategoryName");
	String opcl = request.getParameter("opcl");
	OpclDTO dto = new OpclDTO();
	dto.setYear(Integer.parseInt(year));
	dto.setQuarter(Integer.parseInt(quarter));
	dto.setSellCategoryName(sellCategoryName);
	

	JSONArray data = new JSONArray();
	OpclDAO dao = new OpclDAO();
	ArrayList<OpclDTO> list;
	if(opcl.equals("개업률")){
		
		list = dao.selectTop5Opcl(dto);
	}else{
		list = dao.selectTop5Opcl2(dto);
	}
	for (int i = 0; i < list.size() ; i++) {
		JSONObject row = new JSONObject();
		OpclDTO dto2 = list.get(i);
		row.put("commercialDistrictCode", dto2.getCommercialDistrictCode());
		row.put("commercialDistrictName", dto2.getCommercialDistrictName());
		row.put("year", dto2.getYear());
		row.put("quarter", dto2.getQuarter());
		row.put("sellCategoryName", dto2.getSellCategoryName());
		row.put("op", dto2.getOp());
		row.put("cl", dto2.getCl());
		row.put("latitude", dto2.getLatitude());
		row.put("longitude", dto2.getLongitude());
		data.add(row);
	}
%>
<%=data.toJSONString()%>