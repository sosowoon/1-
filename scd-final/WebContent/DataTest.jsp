<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "geoDataJsonFile.geojson",
			dataType : "json",
			success : function(result) {
				alert(result.features[0].geometry.coordinates)
 				$.each(result.features, function(i, feature) {
					$("#wrap ol").append("<li>" + feature.geometry.coordinates[0] + "</li>");
				});
			}
		});
	});
</script>
</head>
<body>
	<h1>데이터 확인</h1>
	<div id="wrap">
		<ol></ol>
	</div>
</body>
</html>