<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
	 <!-- top nav -->
		<!-- <div class="menu">
			<ul>
				<li><a href="/ZgdSjz/index.jsp">首页</a></li>
				<li><a href="#">工作动态</a></li>
				<li><a href="/ZgdSjz/Sjxw.action">审计新闻</a></li>
				<li><a href="/ZgdSjz/Gzzz.action">工作职责</a></li>
				<li><a href="/ZgdSjz/Gwzz.action">岗位职责</a></li>
				<li><a href="#">审计程序</a></li>
				<li><a href="#">法规制度</a></li>
				<li><a href="/ZgdSjz/Sjtg.action">审计通告</a></li>
				<li><a href="/ZgdSjz/Nsyd.action">内审园地</a></li>
				
			</ul>
		</div> -->
	 
<nav>	
	<div class="menu">
<ul style="margin-top: 0px; margin-bottom: 0px;margin-left: 0px;margin-right: 0px;">
	<li><a class="hide" href="#">工作动态</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=gzdt" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=gzdt" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">审计新闻</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=sjxw" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=sjxw" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">工作职责</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=gzzz" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=gzzz" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">岗位职责</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=gwzz" title="添加">添加</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=gwzz" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">审计程序</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=sjcx" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=sjcx" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">法规制度</a>
	<ul>
	   <table id="tables" width="200px" height="100px" style="margin-left: 4px;margin-top: 5px;">
	       <tr>
	           <td><a>国家法规</a></td><td><a href="/ZgdSjc/Admin.action?type=new&name=fgzd_gjfg" title="发布">发布</a></td><td><a href="/ZgdSjc/Admin.action?type=show&name=fgzd_gjfg" title="编辑">编辑</a></td>
	       </tr>
	      <tr>
	           <td><a>浙江法规</a></td><td><a href="/ZgdSjc/Admin.action?type=new&name=fgzd_zjfg" title="发布">发布</a></td><td><a href="/ZgdSjc/Admin.action?type=show&name=fgzd_zjfg" title="编辑">编辑</a></td>
	       </tr>
	       <tr>
	           <td><a>学校制度</a></td><td><a href="/ZgdSjc/Admin.action?type=new&name=fgzd_xxzd" title="发布">发布</a></td><td><a href="/ZgdSjc/Admin.action?type=show&name=fgzd_xxzd" title="编辑">编辑</a></td>
	       </tr>
	   </table>
	</ul>
	</li>
	<li><a class="hide" href="#">审计公开</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=sjgk" title="添加">添加</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=sjgk" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">审计通告</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=sjtg" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=sjtg" title="编辑">编辑</a></li>
	    </ul>
	</li>
	<li><a class="hide" href="#">内审园地</a>
		<ul>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=new&name=nsyd" title="发布">发布</a></li>
	    	<li><a style="text-decoration: none;" href="/ZgdSjc/Admin.action?type=show&name=nsyd" title="编辑">编辑</a></li>
	    </ul>
	</li>
</ul>
</div>

	