<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    	
    	<script type="text/javascript">
    		function checkSubmit(){
    			var contactWay = document.getElementById("contactWay").value;
    			var subjects = document.getElementById("subjects").value;
    			var content = editor.getContent();
    			
    			if(contactWay==""){
    				alert("请留下联系方式，以便我们和您取得联系!");
    				return false; 
    			}
    			if(subjects==""){
    				alert("请输入要举报的主题!");
    				return false;
    			}
    			if(content==""){
    				alert("请输入要举报的内容!");
    				return false;
    			}
    			
    			return window.confirm("确定要提交吗?",500,500);
    		}
    	</script>
    	
    	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
		<!-- 配置文件 -->
		<script type="text/javascript" src="ueditorForUser/ueditor.config.js"></script>
		<!-- 编辑器源码文件 -->
		<script type="text/javascript" src="ueditorForUser/ueditor.all.js"></script>
		<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
		<script type="text/javascript" src="ueditorForUser/lang/zh-cn/zh-cn.js"></script>

</head>
	
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/indexs/index_top.jsp"></jsp:include>
			
			<form action="/ZgdSjc/Sjxsjb.action">
				<table   style="margin: 0 auto;width: 800px;margin-top: 30px;">
					<tr>
						<td width="100">
							<div align="left" >
								姓　　名:
							</div>
						</td>
						<td width="600">
							<input type="text" name="name" size="110">

						</td>
					</tr>
					<tr>
						<td width="100">
							<div align=""left"" >
								联系方式:
							</div>
						</td>
						<td width="600">
							<input id="contactWay" type="text" name="contactWay" size="110">
							<br>
						</td>
					</tr>
					<tr>
						<td width="100">
							<div align=""left"" >
								主　　题:
							</div>
						</td>
						<td width="600">
							<input id="subjects" type="text" name="subjects" size="110">
						</td>
				</table>
				<div style="margin: 0 auto">
					<script type="text/plain" name="content" id="container" style="width:800px;height:200px;margin: 0 auto">  
						请在此输入内容...
					</script>
					<script type="text/javascript">
						var editor = UE.getEditor('container')
					</script>
				</div>
			
				<p style="text-align: center">
					<input name="sumit" onclick="return checkSubmit()" type="submit" value="提交">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="myButton" type="reset" class="txt" value="清空">
				</p>
				<p style="text-align: center">
					<br>
					*1、举报姓名栏可不填写；
					<br>
					*2、本站对任何举报都采取保密措施。
				</p>
			
			</form>
			
			<jsp:include page="/WEB-INF/indexs/index_bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
