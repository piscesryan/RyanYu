<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		
 <footer>
		<section id="footer-area">

			<section id="footer-outer-block">
					 
					
					<aside class="footer-segment">
							<a href="/ZgdSjc/index.jsp"><h4>前台首页</h4></a>
					</aside>
					<aside class="footer-segment">
							<a href="/ZgdSjc/Admin.action?type=gotoLogin"><h4>后台首页</h4></a>
					</aside>
					<aside class="footer-segment">
							<a href="/ZgdSjc/Admin.action?type=logout"><h4>管理员退出</h4></a>
					</aside>

			</section><!-- end of footer-outer-block -->

		</section><!-- end of footer-area -->
	</footer>