<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="freemarker.template.SimpleDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<meta charset="utf-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
		<title>浙工大审计处后台</title>
		<link rel="stylesheet" href="css/adminPagestyles.css" type="text/css"media="screen" />
		<link rel="stylesheet" type="text/css" href="css/adminPageprint.css" media="print" />
		<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	</head>
	<body>

		<div id="wrapper">
			<!-- #wrapper -->

			<!-- 顶部 -->
			<jsp:include page="/WEB-INF/admin/Main_top.jsp"></jsp:include>

				<section id="main">
				
				<!-- index页面主体 -->
				<section id="content">
	
					<article>
						<h1 style="text-align: center;">欢迎登陆浙江工业大学审计处后台！</h1>
						 
							<h4>如有问题请与开发人员联系</h4>
							<ul>
								<li>单　　位：浙江工业大学</li>
								<li>开发人员：俞皓凡</li>
								<li>长　　号：18868816455</li>
								<li>短　　号：538974</li>
								<li>电子邮箱：bravepeter@hotmail.com</li>
							</ul>
							<h4>今天是</h4>
						 	<%!
						 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  E");		 		
						 	%>
						 	<%=
						 		sdf.format(new Date()) 
						 	%>			
					</article>
				</section>

		 	<!-- 右边-->
			<jsp:include page="/WEB-INF/admin/Main_right.jsp"></jsp:include>

			</section>
			<!-- 底部-->
			<jsp:include page="/WEB-INF/admin/Main_bottom.jsp"></jsp:include> 

		</div>
	</body>
</html>
