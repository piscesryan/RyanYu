<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.domains.domains.Sjtg.*"%>
<%@page import="com.tools.ToolUtils"%>
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
			<div id="right1">
				<table id="table3" cellspacing="7px">
					
					<%
						ArrayList contents = (ArrayList)request.getAttribute("contentResult");
							if("download".equals(request.getAttribute("contentName"))){
								for(int i=0;i<contents.size();i++){
									ContentDownload each = (ContentDownload)contents.get(i);
									if(i<1){
									%>
										<tr>
											<td>您的位置：<a style="text-decoration: none;" href="/ZgdSjc/index.jsp">首页</a>-><a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=<%=request.getAttribute("contentName") %>&tableType=<%=request.getAttribute("tableType") %>"><%=request.getAttribute("contentNameChinese")%></a></td><td id="tableContentTime" align="center"></td>
										</tr>
									<%
									}
									%>	
											
										<tr>
											<td>
												<a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=downloadFile&fileName=<%=each.getFileName() %>"><img id="tableContentIcon" src="img/item.png"><%=ToolUtils.getListItemName(each.getFileName()) %></a><td id="tableContentTime" align="center">
											</td>
										</tr>
									<%
								}
							}else if("gwzz".equals(request.getAttribute("contentName"))){
								for(int i=0;i<contents.size();i++){
									ContentGwzz each = (ContentGwzz)contents.get(i);
									if(i<1){
									%>	
									<table style="text-align: center;margin-top: 16px;" id="gwzz" cellpadding="0" cellspacing="0" border="1" >			
										<tr>
											<td  width="90" height="39"><font face="宋体"><span style="font-size:15px;">岗位名称</span></font></td>
											<td  width="90"><font face="宋体"><span style="font-size:15px;">责任人</span></font></td>
											<td  width="250"><font face="宋体"><span style="font-size:15px;">岗位职责</span></font></td>
											<td  width="250"><font face="宋体"><span style="font-size:15px;">办公室|联系电话|电子邮箱</span></font></td>
										</tr>
									<% 
									}
									%>				
										<tr>
											<td width="90" height="39"><font face="宋体"><span style="font-size:12px;"><%=each.getJobname() %></span></font></td>
											<td width="90"><font face="宋体"><span style="font-size:12px;"><%=each.getName() %></span></font></td>
											<td width="250"><font face="宋体"><span style="font-size:12px;"><%=each.getDuty() %></span></font></td>
											<td width="250"><font face="宋体"><span style="font-size:12px;"><%=each.getAddrContent() %></span></font></td>
										</tr>
									<%
								}
							%>
							</table><br>
							<%
							}else{
								for(int i=0;i<contents.size();i++){
									Contents_Sjtg each = (Contents_Sjtg)contents.get(i);
									if(i<1){
									%>
										<tr>
											<td>您的位置：<a style="text-decoration: none;" href="/ZgdSjc/index.jsp">首页</a>-><a style="text-decoration: none;" href="/ZgdSjc/Common.action?type=<%=request.getAttribute("contentName") %>"><%=request.getAttribute("contentNameChinese")%></a></td><td id="tableContentTime" align="center">录入时间</td>
										</tr>
									<%
									}
									%>				
										<tr>
											<td><a style="text-decoration: none;"  href="/ZgdSjc/Common.action?type=<%=request.getAttribute("contentName") %>&targetContentId=<%=each.getId() %>"><img id="tableContentIcon" src="img/item.png"><%=each.getTilte() %></a></td><td id="tableContentTime" align="center"><%=each.getTime() %></td>
										</tr>
									<%
								}
							}
					 %>
					<tr><tr><tr/><tr><tr/><tr><tr/>
						<td>
							<% int toalPage = (Integer)request.getAttribute("totalPages"); 
								for(int i=1;i<=toalPage;i++){
									if("download".equals(request.getAttribute("contentName"))){							
									%>
										<a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=<%=request.getAttribute("contentName") %>&tableType=<%=request.getAttribute("tableType") %>&pageNow=<%=i %>"><%=i %></a>
										<%
									}else{	
										 %>
										<a style="text-decoration: none;" href="/ZgdSjc/Common.action?type=<%=request.getAttribute("contentName") %>&pageNow=<%=i %>"><%=i %></a>
									<%
									}
								}
							%>&nbsp;&nbsp;&nbsp;当前第【<%=request.getAttribute("pageNow") %>】页
						</td>
					</tr>
				</table>
			</div>
			<jsp:include page="/WEB-INF/indexs/index_bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
