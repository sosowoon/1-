<%@page import="java.util.ArrayList"%>
<%@page import="bci.BciDTO"%>
<%@page import="bci.BciDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	int year = Integer.parseInt(request.getParameter("year"));
  	int quarter = Integer.parseInt(request.getParameter("quarter"));
  	BciDAO dao = new BciDAO();
  	ArrayList<BciDTO> list = dao.selectYQ(year, quarter);
	JSONArray ja = new JSONArray();
  	for(int i=0;i<list.size();i++){
  		BciDTO dto = list.get(i);
  		JSONObject jo = new JSONObject();
  		jo.put("bciid", dto.getBciid());
  		jo.put("year", dto.getYear());
  		jo.put("quarter", dto.getQuarter());
  		jo.put("sigungucode", dto.getSigungucode());
  		jo.put("sigungucodename", dto.getSigungucodename());
  		jo.put("ci", dto.getCi());
  		jo.put("ciname", dto.getCiname());
  	  	ja.add(jo);
  	};
%>
<%= ja.toJSONString() %>