<%@page import="java.util.ArrayList"%>
<%@page import="bci.BciDTO"%>
<%@page import="bci.BciDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	
  	BciDAO dao = new BciDAO();
  	ArrayList<BciDTO> list = dao.selectS();
	JSONArray ja = new JSONArray();
  	for(int i=0;i<list.size();i++){
  		BciDTO dto = list.get(i);
  		JSONObject jo = new JSONObject();
  		jo.put("year", dto.getYear());
  		jo.put("quarter", dto.getQuarter());
  		jo.put("sosma", dto.getSosma());
  		jo.put("scsma", dto.getScsma());
  	  	ja.add(jo);
  	};
%>
<%= ja.toJSONString() %>