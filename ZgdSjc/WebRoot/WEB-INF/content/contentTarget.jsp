<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.domains.domains.Sjtg.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
			<jsp:include page="/WEB-INF/indexs/index_left.jsp"></jsp:include>
			<div id="right">
				<table id="table3">
				<%
					ArrayList content = (ArrayList)request.getAttribute("contentResult");
					Contents_Sjtg each = (Contents_Sjtg)content.get(0);
				 %>
					<tr>
						<td>您的位置：<a style="text-decoration: none;" href="/ZgdSjc/index.jsp">首页</a>-><a style="text-decoration: none;" href="/ZgdSjc/Common.action?type=<%=request.getAttribute("contentName") %>"><%=request.getAttribute("contentNameChinese")%></a></td>
					</tr>
					<tr></tr>
					<tr>
						<td height="50px;" align="center" style="margin-right:10px;"><h2><%= each.getTilte() %></h2></td>
					</tr>
					<tr></tr>
					<tr height="50px;">
						<td align="right"><div style="float:right;margin-right: 50px"><div style="float:left">录入时间:&nbsp;&nbsp;</div><div style="float:left;color: red;"><%=each.getTime() %></div></div></td>
					</tr>
					<tr>
						<td><%=each.getContent() %></td>
					</tr>
				</table>
			</div>
			<jsp:include page="/WEB-INF/indexs/index_bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
