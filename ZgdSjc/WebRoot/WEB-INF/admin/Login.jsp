<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>浙工大审计处后台登录</title>
		<link rel="stylesheet" href="sjc.css" type="text/css" media="screen" />
	</head>

	<body bgcolor="#C6DEEF">
		<form method="POST" action="/ZgdSjc/Admin.action?type=login">
			<table width="500" border="1px" align=center cellpadding="0"
				cellspacing="0" style="margin-top: 90px">
				<tr>
					<td width="100%" align="center">
						<font color="#ff9900"><b><img
									src="img/login.gif" width="500" height="120">
						</b>
						</font>
					</td>
				</tr>
				<tr>
					<td width="100%" align="center" bgcolor="#C6DEEF" height="200">
						<table width="350" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<%!
									String errInfo;
								 %>
								<%
									if(request.getAttribute("loginError")!=null){
										errInfo = (String)request.getAttribute("loginError");
										%>
										<span style="color: red;"><%=errInfo %></span>
										<%
									}
								 %>
								 
							</tr>
							<tr>
								<td height="30" align="center" valign="middle">
									<div align="center" class="txt">
									   管理员：
										<input name="userName" size="19" style="font-size: 9pt">
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" align="center" valign="middle">
									<div align="center" class="txt">
										密　码：
										<input type="password" name="passwd" size="20"
											style="font-size: 9pt">
									</div>
								</td>
							</tr>
							<tr>
								<td height="50" align="center" valign="middle">
									<p>
										<input type="submit" name="Submit" value="登录" class="txt">
										&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
										<input type="reset" name="Submit2" value="清空" class="txt">
									</p>
								</td>
							</tr>
						</table>
						<br><a href="/ZgdSjc/index.jsp" style="font-size: 15px;text-decoration: none">返回首页</a>
						<div align="left" class="txt">
							<br>
							<br>
							&nbsp;*&nbsp;非管理人员请勿尝试登陆，密码遗忘请联系管理员！
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>
