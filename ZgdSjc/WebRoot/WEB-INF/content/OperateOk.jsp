<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=10" />
		<meta charset="utf-8" /> 
		<link rel="stylesheet" href="css/styles.css" type="text/css" />
		<link rel="stylesheet" href="css/main.css" />
    	<script src="js/jquery.js"></script>

</head>
	
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/indexs/index_top.jsp"></jsp:include>
			
			 	<br>
				<div style="margin-left: 500px"><h1>操作成功!</h1></div>
				<br>
				<a style="text-decoration: none;margin-left: 520px" href="/ZgdSjc/index.jsp">返回主界面</a>
			 
			
			<jsp:include page="/WEB-INF/indexs/index_bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
