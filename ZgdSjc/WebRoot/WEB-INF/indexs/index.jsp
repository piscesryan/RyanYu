<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<meta charset="utf-8" /> 
		  
		<link rel="stylesheet" href="css/styles.css" type="text/css" />
		<link rel="stylesheet" href="css/main.css" />
    	<script src="js/jquery.js"></script>
 
</head>
	
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/indexs/index_top.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/indexs/index_left.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/indexs/index_right.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/indexs/index_bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
