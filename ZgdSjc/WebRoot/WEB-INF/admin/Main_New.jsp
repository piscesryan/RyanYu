<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
						<h2>
							<a href="/ZgdSjc/Download.action">First Article Title</a>
						</h2>
						<p>paragraph one!</p>				
					</article>
	
					<article>
						<h2>
							<a href="#">Second Article Title</a>
						</h2>
						<p>paragraph two</p>
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
