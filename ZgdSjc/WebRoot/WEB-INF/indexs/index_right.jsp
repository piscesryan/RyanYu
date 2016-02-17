<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domains.domains.Sjtg.*"%>
<%@page import="com.tools.ToolUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="right">
				<table id="tableGzdt">
					<tr>
						<td bo background="img/gzdt.png" height="25px;" ></td>
					</tr>
					<%
						ArrayList content = (ArrayList)request.getAttribute("contentResult_Gzdt");
						for(int i=0;i<content.size();i++){
						Contents_Sjtg each = (Contents_Sjtg)content.get(i);
						%>
							<tr>
								<td><a style="text-decoration: none;"  href="/ZgdSjc/Common.action?type=gzdt&targetContentId=<%=each.getId() %>"><img id="tableContentIcon" src="img/item.png"><%=ToolUtils.getHomeItemName(each.getTilte()) %></a></td>
							</tr>
						<% 
						}
					 %>
					<tr>
						<td><a href="/ZgdSjc/Common.action?type=gzdt"><img id="tableContentMore" src="img/more.png" ></a></td>
					</tr>
				</table>
				<table id="tableSjgk">
					<tr>
						<td background="img/sjgk.png" height="25px;"></td>
					</tr>
					<%
						ArrayList content1 = (ArrayList)request.getAttribute("contentResult_Sjgk");
						for(int i=0;i<content1.size();i++){
						Contents_Sjtg each1 = (Contents_Sjtg)content1.get(i);
						%>
							<tr>
								<td><a style="text-decoration: none;"  href="/ZgdSjc/Common.action?type=sjgk&targetContentId=<%=each1.getId() %>"><img id="tableContentIcon" src="img/item.png"><%=ToolUtils.getHomeItemName(each1.getTilte()) %></a></td>
							</tr>
						<% 
						}
					 %>
					<tr>
						<td><a href="/ZgdSjc/Common.action?type=sjgk"><img id="tableContentMore" src="img/more.png" ></a></td>
					</tr>
				</table> 
				<table id="tableSjxw">
					<tr>
						<td background="img/sjxw.png" height="25px;"></td>
					</tr>
					<%
						ArrayList content2 = (ArrayList)request.getAttribute("contentResult_sjxw");
						for(int i=0;i<content2.size();i++){
						Contents_Sjtg each2 = (Contents_Sjtg)content2.get(i);
						%>
							<tr>
								<td><a style="text-decoration: none;"  href="/ZgdSjc/Common.action?type=sjxw&targetContentId=<%=each2.getId() %>"><img id="tableContentIcon" src="img/item.png"><%=ToolUtils.getHomeItemName(each2.getTilte()) %></td>
							</tr>
						<% 
						}
					 %>
					<tr>
						<td><a href="/ZgdSjc/Common.action?type=sjxw"><img id="tableContentMore" src="img/more.png" ></a></td>
					</tr>
				</table>  
				<table id="tableSjtg">
					<tr>
						<td background="img/sjtg.png" height="25px;">&nbsp;</td>
					</tr>
					<%
						ArrayList content3 = (ArrayList)request.getAttribute("contentResult_sjtg");
						for(int i=0;i<content3.size();i++){
						Contents_Sjtg each3 = (Contents_Sjtg)content3.get(i);
						%>
							<tr>
								<td><a style="text-decoration: none;"  href="/ZgdSjc/Common.action?type=sjtg&targetContentId=<%=each3.getId() %>"><img id="tableContentIcon" src="img/item.png"><%=ToolUtils.getHomeItemName(each3.getTilte()) %></td>
							</tr>
						<% 
						}
					 %>
					<tr>
						<td><a href="/ZgdSjc/Common.action?type=sjtg"><img id="tableContentMore" src="img/more.png" ></a></td>
					</tr>
				</table> 
			</div>

