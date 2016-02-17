<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domains.domains.Sjtg.Contents_Sjtg"%>
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
				if("gwzz".equals(request.getAttribute("contentName"))){
				%>
				<form ACTION="/ZgdSjc/Admin.action?type=new&operation=save&name=<%=request.getAttribute("contentName") %>" METHOD="POST" name="myForm">
				<table width="650" border="1" align="center">
						<tr style="text-align: center;">
							<td class="xl25" style="background-color:transparent;" width="83" height="39"><font face="宋体"><span style="font-size:12px;">岗位名称</span></font></td>
							<td class="xl25" style="background-color:transparent;" width="86"><font face="宋体"><span style="font-size:12px;">责任人</span></font></td>
							<td class="xl25" style="background-color:transparent;" width="251"><font face="宋体"><span style="font-size:12px;">岗位职责</span></font></td>
							<td class="xl25" style="background-color:transparent;" width="225"><font face="宋体"><span style="font-size:12px;">办公室 联系电话 电子邮箱</span></font></td>
						</tr>
						<tr style="text-align: center;">
							<td class="xl25" style="background-color:transparent;" width="83" height="39"><font face="宋体"><span style="font-size:12px;"><input type="text" name="jobname"></span></font></td>
							<td class="xl25" style="background-color:transparent;" width="86"><font face="宋体"><span style="font-size:12px;"><input type="text" name="personname"></span></font></td>
							<td class="xl24" style="background-color:transparent;" width="251"><font face="宋体"><span style="font-size:12px;"><input type="text" name="duty"></span></font></td>
							<td class="xl24" style="background-color:transparent;" width="225"><font face="宋体"><span style="font-size:12px;"><input type="text" name="addrContent"></span></font></td>
						</tr>
					</table>
				<p style="text-align: center">
					<input name="sumit" type="submit" value="提交">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="myButton" type="reset" class="txt" value="清空">
				</p>
				
			</form>	
				<%		
				}else{
				%>
				<form ACTION="/ZgdSjc/Admin.action?type=new&operation=save&name=<%=request.getAttribute("contentName") %>" METHOD="POST" name="myForm">
				<table width="850" border="1">
					<tr>
						<td width="50">
							<div align="right" class="txt">
								标题:
							</div>
						</td>
						<td width="541">
							<input type="text" name="title" size="128"  ><span id="text1" style="display: none;color: red;">不能为空!</span>

						</td>
					</tr>
					<tr>
						<%
							if("download".equals(request.getAttribute("contentName"))){
							%>
							<td width="50">
								<div align="right" class="txt">
									类型:
								</div>
							</td>
							<td width="541">
								<select name="filetype">
									<option value="gc">工程</option>
									<option value="sj">审计</option>
								</select>
								<br>
							</td>
							<% 
							}else{
							%>
								<td width="50">
									<div align="right" class="txt">
										时间:
									</div>
								</td>
								<td width="541">
									<input type="text" name="writetime" size="128" ><span id="text2" style="display: none;color: red;">不能为空!</span>
									<br>
								</td>
							<% 
							}
						 %>
					</tr>
					
					<tr>
						<td width="50">
							<div align="right" class="txt">
								内容:
							</div>
						</td>
						<td width="541">
							<div style="float: left">
								<script type="text/plain" name="content" id="container" style="width:785px;height:200px;">  
									请在此输入内容...
								</script>
								<script type="text/javascript">
									var editor = UE.getEditor('container')
								</script>
							</div>
						</td>
					</tr>
				</table>
				<p style="text-align: center">
					<input name="sumit" type="submit" value="提交">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="myButton" type="reset" class="txt" value="清空">
				</p>
			 
			</form>
				<%
				}
			%>

			
				</section>

		 

			</section>
			<!-- 底部-->
			<jsp:include page="/WEB-INF/admin/Main_bottom.jsp"></jsp:include> 

		</div>
	</body>
</html>
