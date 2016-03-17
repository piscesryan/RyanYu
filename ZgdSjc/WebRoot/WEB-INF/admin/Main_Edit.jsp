<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ page import="com.domains.domains.Sjtg.Contents_Sjtg"%>
<%@page import="com.domains.domains.Sjtg.ContentDownload"%>
<%@page import="com.domains.domains.Sjtg.ContentsFeedback"%>
<%@page import="com.domains.domains.Sjtg.ContentGwzz"%>
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
	
		<script type="text/javascript">
			function deleteConfirm(){
				
				var result = window.confirm("确定要删除吗?");
				
				if(result==true){
					return true;
				}else{
					return false;
				}
			}
			
			function changeType(){
				
				var selectedType = document.getElementById("filetype").value;
				var fileId = document.getElementById("fileId").value;
				var url = "/ZgdSjc/Admin.action?type=edit&operation=save&id="+fileId+"&name=download&fileType="+selectedType+"";
				
				
				var flag = window.confirm("确定要修改该文件的类型吗?");
				if(flag){
					oNewWindow = window.open(url);
					oNewWindow.close();
					alert("修改成功");
					return true;
				}else{
					alert("取消修改");
					return false;
				}
			}
			
		</script>
		
	</head>
	<body>

		<div id="wrapper">
			<!-- #wrapper -->

			<!-- 顶部 -->
			<jsp:include page="/WEB-INF/admin/Main_top.jsp"></jsp:include>

				<section id="main">
				
				<!-- index页面主体 -->
				<section id="content">
	
					<table border="1" width="650px">
					<%
						if("gwzz".equals(request.getAttribute("contentName"))){
						%>
							<tr style="text-align: center;">
								<td class="xl25" style="background-color:transparent;" width="83" height="39"><font face="宋体"><span style="font-size:12px;">岗位名称</span></font></td>
								<td class="xl25" style="background-color:transparent;" width="86"><font face="宋体"><span style="font-size:12px;">责任人</span></font></td>
								<td class="xl25" style="background-color:transparent;" width="251"><font face="宋体"><span style="font-size:12px;">岗位职责</span></font></td>
								<td class="xl25" style="background-color:transparent;" width="225"><font face="宋体"><span style="font-size:12px;">办公室 联系电话 电子邮箱</span></font></td>
								<td class="xl25" style="background-color:transparent;" width="100"><font face="宋体"><span style="font-size:12px;">操作</span></font></td>
							</tr>
						<%
						}
					%>
					<%  ArrayList al = (ArrayList)request.getAttribute("contentResult"); 
						if(al.size()==0){
							al.add("none");
						}
						for(int i=0;i<al.size();i++){
							if("download".equals(request.getAttribute("contentName"))){
								ContentDownload each = (ContentDownload)al.get(i);
								%>
								<tr>
									<td width="80%"><%=each.getFileName()%></td>
									<td>
										<input type="hidden" id="fileId" value="<%=each.getId() %>">
										<select id="filetype" name="filetype" onchange="return changeType()">
											<%
												if("gc".equals(each.getType())){
												%>
													<option value="gc" selected="selected">工程</option>										
													<option value="sj">审计</option>
												<%
												}else{
													%>
													<option value="gc">工程</option>										
													<option value="sj"  selected="selected">审计</option>
													<%
												}
											 %>
											
										</select>
									</td>
									<td><a href="/ZgdSjc/Admin.action?type=download&fileName=<%=each.getFileName() %>">下载</a></td>
									<td><a onclick="return deleteConfirm()" href="/ZgdSjc/Admin.action?type=delete&fileName=<%=each.getFileName() %>&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">删除</a></td>
								</tr>	
								<%
							}else if("xsjb".equals(request.getAttribute("contentName"))){
								if("none".equals(al.get(0))){
								%>
								<h3>暂无举报</h3>
								<%
								}else{
									ContentsFeedback each = (ContentsFeedback)al.get(i);
									%>
									<tr>
										<td width="70%"><a><%=each.getSubjects()%></td>
										<td width="90px"><%=each.getWritetime() %></td>
										<td><a href="/ZgdSjc/Admin.action?type=look&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">查看</a></td>		
										<td><a onclick="return deleteConfirm()" href="/ZgdSjc/Admin.action?type=delete&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">删除</a></td>
									</tr>
									<%
								}
								%>
								<%
							}else if("gwzz".equals(request.getAttribute("contentName"))){
								%>
								<%			 
								ContentGwzz each = (ContentGwzz)al.get(i);
								%>
								<tr style="text-align: center;">
									<td class="xl25" style="background-color:transparent;" width="83" height="39"><font face="宋体"><span style="font-size:12px;"><%=each.getJobname() %></span></font></td>
									<td class="xl25" style="background-color:transparent;" width="86"><font face="宋体"><span style="font-size:12px;"><%=each.getName() %></span></font></td>
									<td class="xl24" style="background-color:transparent;" width="251"><font face="宋体"><span style="font-size:12px;"><%=each.getDuty() %></span></font></td>
									<td class="xl24" style="background-color:transparent;" width="225"><font face="宋体"><span style="font-size:12px;"><%=each.getAddrContent() %></span></font></td>
									<td class="xl24" style="background-color:transparent;" width="100"><font face="宋体"><span style="font-size:12px;">
									<a  href="/ZgdSjc/Admin.action?type=edit&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId()%>">修改</a>&nbsp;
									<a onclick="return deleteConfirm()" href="/ZgdSjc/Admin.action?type=delete&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">删除</a></span></font>
									</td>
								</tr>								 
								<%
							}else{
								Contents_Sjtg each = (Contents_Sjtg)al.get(i);
								%>
								<tr>
									<td width="80%"><%=each.getTilte()%></td>
									<td><a href="/ZgdSjc/Admin.action?type=look&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">查看</a></td>
									<td><a href="/ZgdSjc/Admin.action?type=edit&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">修改</a></td>
									<td><a onclick="return deleteConfirm()" href="/ZgdSjc/Admin.action?type=delete&name=<%=request.getAttribute("contentName") %>&id=<%=each.getId() %>">删除</a></td>
								</tr>	
								<%
							}
						}
					%>							
					</table>
					
					<!-- 如果不是岗位职责，就显示分页 -->
					<%
						if(!request.getAttribute("contentName").equals("gwzz")){
						%>
						<% int toalPage = (Integer)request.getAttribute("totalPages"); 
						for(int i=1;i<=toalPage;i++){
							%>
							<a href="/ZgdSjc/Admin.action?type=show&name=<%=request.getAttribute("contentName") %>&pageNow=<%=i %>"><%=i %></a>
							<%
						}
					%>
					&nbsp;&nbsp;&nbsp;当前第【<%=request.getAttribute("pageNow") %>】页
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
