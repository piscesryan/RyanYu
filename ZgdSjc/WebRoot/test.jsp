<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>jQuery+CSS3橙色导航菜单</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/main.css" />
    <script src="js/jquery.js"></script>
</head>
<body>
    <!--nav-->
    <nav>
        <!--导航条-->
        <ul class="nav-main">
            <li>首页</li>
            <li id="li-1">产品信息<span></span></li>
            <li id="li-2">关于我们<span></span></li>
            <li id="li-3">商家信息<span></span></li>
            <li>加入我们</li>
            <li>联系我们</li>
        </ul>
        <!--隐藏盒子-->
        <div id="box-1" class="hidden-box hidden-loc-index">
            <ul>
                <li>关于我们</li>
                <li>产品信息</li>
                <li>关于我们</li>
            </ul>
        </div>
        <div id="box-2" class="hidden-box hidden-loc-us">
            <ul>
                <li>关于我们</li>
                <li>产品信息</li>
                <li>关于我们</li>
                <li>商家信息</li>
            </ul>
        </div>
        <div id="box-3" class="hidden-box hidden-loc-info">
            <ul>
                <li>关于我们</li>
                <li>产品信息</li>
                <li>关于我们</li>
                <li>商家信息</li>
                <li>加入我们</li>
            </ul>
        </div>
    </nav>

    <script src="js/main.js"></script>
<div style="text-align:center;margin:250px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
<html>