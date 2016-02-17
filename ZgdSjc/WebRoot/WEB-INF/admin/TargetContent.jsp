<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domains.domains.Sjtg.Contents_Sjtg"%>
<%@page import="com.domains.domains.Sjtg.ContentsFeedback"%>
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
		<!-- 配置文件 -->
		<script type="text/javascript" src="ueditorForAdmin/ueditor.config.js"></script>
		<!-- 编辑器源码文件 -->
		<script type="text/javascript" src="ueditorForAdmin/ueditor.all.js"></script>
		<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
		<script type="text/javascript" src="ueditorForAdmin/lang/zh-cn/zh-cn.js"></script>
	</head>
	<body>

		<div id="wrapper">
			<!-- #wrapper -->

			<!-- 顶部 -->
			<jsp:include page="/WEB-INF/admin/Main_top.jsp"></jsp:include>
								
				<section id="main">
				
				<!-- index页面主体 -->
				<section id="content">
					
					<%
						ArrayList al = (ArrayList)request.getAttribute("contentResult");
						String type = (String)request.getAttribute("contentName"); 
					  	
					  	if("xsjb".equals(type)){
					  	ContentsFeedback each = (ContentsFeedback)al.get(0);
					  	%>
					  	<table width="650" border="1" align="center">
					<tr>
						<td width="204">
							<div align="right" class="txt">
								姓名:
							</div>
						</td>
						<td width="541">
							<input type="text" name="name" size="86" readonly="readonly" value="<%=each.getName() %>"><span id="text1" style="display: none;color: red;">不能为空!</span>

						</td>
					</tr>
					<tr>
						<td width="204">
							<div align="right" class="txt">
								联系方式:
							</div>
						</td>
						<td width="541">
							<input type="text" name="contactWay" size="86" readonly="readonly" value="<%=each.getContactWay() %>"><span id="text2" style="display: none;color: red;">不能为空!</span>
							<br>
						</td>
					</tr>
					<tr>
						<td width="204">
							<div align="right" class="txt">
								主题:
							</div>
						</td>
						<td width="541">
							<input type="text" name="subjects" size="86" readonly="readonly" value="<%=each.getSubjects() %>"><span id="text3" style="display: none;color: red;">不能为空!</span>
						</td>
					</tr>
					<tr>
						<td width="204">
							<div align="right" class="txt">
								举报内容:
							</div>
						</td>
						<td width="541">
							<div >
								<script id="container" name="content" type="text/plain">
    						<%=each.getContent() %>
							</script>
								<script type="text/javascript">
	    							var editor = UE.getEditor('container')
								</script>
							</div>
						</td>
					</tr>
				</table>
					  	<%
					  	}
					  	else{
					  	Contents_Sjtg each = (Contents_Sjtg)al.get(0);
					  	
					%>
					
					 <h1><%=each.getTilte()%></h1>
					 
					 <div id="writeTimeTotal">录入时间<div style="color: red"><%=each.getTime()%></div></div><br><br><br><br><br><br><br><br>
					 				
					<%=each.getContent()%>
					<%
						}
				%>
				</section>

			<!-- 右边-->
			<jsp:include page="/WEB-INF/admin/Main_right.jsp"></jsp:include>

			</section>
			<!-- 底部-->
			<jsp:include page="/WEB-INF/admin/Main_bottom.jsp"></jsp:include>

		</div>
	</body>
</html>
