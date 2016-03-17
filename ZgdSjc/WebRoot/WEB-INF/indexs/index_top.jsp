<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
			<div id="pic">
				<img src="img/titlePic.jpg" height="150px" width="940px">
			</div>
			<div id="naviBar">
				<nav>
					<!--导航条-->
					<ul class="nav-main">
						<li><a href="/ZgdSjc/Index.action">首页</a></li>
						<li><a href="/ZgdSjc/Common.action?type=gzdt">工作动态</a></li>
						<li><a href="/ZgdSjc/Common.action?type=sjxw">审计新闻</a></li>
						<li><a href="/ZgdSjc/Common.action?type=gzzz">工作职责</a></li>
						<li><a href="/ZgdSjc/Common.action?type=gwzz">岗位职责</a></li>
						<li id="li-2" style="font-weight: bold;">法规制度<span></span></li>
						<li><a href="/ZgdSjc/Common.action?type=sjcx">审计程序</a></li>						
						<li><a href="/ZgdSjc/Common.action?type=sjgk">审计公开</a></li>
						<li><a href="/ZgdSjc/Common.action?type=sjtg">审计通告</a></li>
						<li><a href="/ZgdSjc/Common.action?type=nsyd">内审园地</a></li>
					</ul>
					<!--隐藏盒子-->

					<div id="box-2" class="hidden-box hidden-loc-us">
						<ul>
							<li><a href="/ZgdSjc/Common.action?type=fgzd_gjfg">国家法规</a></li>
							<li><a href="/ZgdSjc/Common.action?type=fgzd_zjfg">浙江法规</a></li>
							<li><a href="/ZgdSjc/Common.action?type=fgzd_xxzd">学校制度</a></li>
						</ul>
					</div>
					<script src="js/main.js"></script>
				</nav>  			
			</div>