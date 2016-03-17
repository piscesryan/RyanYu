<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domains.domains.Sjtg.ContentDownload"%>
<%@page import="com.tools.ToolUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="left">
				<table id="xsjb">
					<tr>
						<td><img src="img/sjxsjb.jpg"></td>
					</tr>
					<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
					<tr>
					  <td><a href="/ZgdSjc/Sjxsjb.action?type=gotoWrite"><img style="margin-left: 12px;" border="0px" src="img/jrjb.jpg"></a></td>
					</tr>
					<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
		  	  	</table>
				<table id="bgxz" cellspacing="3px;" >
					<tr>
						<td><img src="img/bgxz.jpg"></td>
					</tr>
					<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
					<tr>
					  <td><strong>工程审计表格</strong></td>
					</tr>
					<%
						ArrayList contents = (ArrayList)request.getSession().getAttribute("contentResult_download_gc");
						for(int i=0;i<contents.size();i++){
						ContentDownload each = (ContentDownload)contents.get(i);
						%>
							<tr>
							  <td> 
							      <img id="downloadItem" src="img/item.png"><a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=downloadFile&fileName=<%=each.getFileName() %>"><%=ToolUtils.getDownloadFileName(each.getFileName()) %></a>
							  </td>
							</tr>
						<%
						}
					 %>
					<tr>
					  <td><a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=download&tableType=gc"><img style="margin-left:100px" src="img/more.png" height="40px"></a></td>
					</tr>
		 			<tr>
						<td><strong>财务审计表格</strong></td>
					</tr>
					<%
						ArrayList contents1 = (ArrayList)request.getSession().getAttribute("contentResult_download_sj");
						for(int i=0;i<contents1.size();i++){
						ContentDownload each1 = (ContentDownload)contents1.get(i);
						%>
							<tr>
							  <td> 
							      <img id="downloadItem" src="img/item.png"><a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=downloadFile&fileName=<%=each1.getFileName() %>"><%=ToolUtils.getDownloadFileName(each1.getFileName())  %></a>
							  </td>
							</tr>
						<%
						}
					 %>
					<tr>
					  <td><a style="text-decoration: none;" href="/ZgdSjc/Download.action?type=download&tableType=sj"><img style="margin-left:100px" src="img/more.png" height="40px"></a></td>
					</tr>
					 
			  	</table>			
			</div>
 