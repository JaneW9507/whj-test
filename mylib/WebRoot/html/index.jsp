<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<link rel="icon" href="img/logo.png"/> -->
    <title>图书管理系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/mmss.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <style>

    </style>
</head>
<body>
<header>
    <div class="container-fluid navbar-fixed-top bg-primary">
        <ul class="nav navbar-nav  left">
            <li class="text-white h4">
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>图书管理系统</b>
            </li>
        </ul>
        <ul class="nav navbar-nav nav-pills right ">
            <li class="bg-info dropdown">
                <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span>${userName}，欢迎登录。</span><span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                	<li class="text-center"><a href="#" onClick="unavailable()"><span class="text-primary">修改密码</span></a></li>
                    <li class="divider"><a href="#"></a></li>
                    <li class="text-center"><a href="#" onClick="loginOut()"><span class="text-primary">退出</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>

<section>
    <div class="container-fluid">
        <div class="row ">
            <!--左侧导航开始-->
            <div class="col-xs-2 bg-blue">
                <br/>
                <div class="panel-group sidebar-menu" id="accordion" aria-multiselectable="true">
                    <div class="panel panel-default menu-first menu-first-active">
                        <a data-toggle="collapse" data-parent="#accordion" href="index.html" aria-expanded="true"
                           aria-controls="collapseOne">
                            <i class="icon-home icon-large"></i> 主页
                        </a>
                    </div>
					<div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1"
                           aria-expanded="false" aria-controls="collapse1">
                            <i class="icon-book icon-large"></i> 图书管理</a>
                        </a>
                        <div id="collapse1" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
							    <li><a href="html/BookInfo.jsp" ><i class="icon-list"></i>添加图书</a></li>
                                <li><a href="#" onClick="findBooks()"><i class="icon-list"></i>查看图书</a></li>
                            </ul>
                        </div>
                    </div>
					
					<div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse4"
                           aria-expanded="false" aria-controls="collapse4">
                            <i class="icon-book icon-large"></i> 用户管理</a>
                        </a>
                        <div id="collapse4" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#" onClick="unavailable()"><i class="icon-user"></i> 用户列表</a></li>
                            </ul>
                        </div>
                    </div>
					
                </div>
            </div>
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                
                <h1 class="text-center text-white">图书管理系统</h1>
                <!----------------------------------------------------------    ------------------------------------------->
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>

<footer class="bg-primary navbar-fixed-bottom">
    <p class="text-center text-white">版权所有&copy;WHJ</p>
</footer>

<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    
    function loginOut(){
    	parent.location.href="/mylib/loginOut.action";
    }
    function addBook(){
    alert("addBook");
    }
    function findBooks(){
    	parent.location.href="/mylib/findBooks.action";
    }
    function unavailable(){
    	alert("此功能暂未开放，请联系管理员。QQ：1008611");
    }
</script>
</body>
</html>