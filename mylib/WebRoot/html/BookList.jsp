<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
    <link rel="icon" href="img/logo.png"/>
    <title>图书管理系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">

    <style>
        html,body {
            height: 100%;
        }
        .box {
            background-repeat: no-repeat;
            background-size: 100%;
            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }
        .login-box {
            width: 100%;
            max-width:800px;
            height: 400px;
            position: absolute;
        }
        @media screen and (min-width:500px){
            .login-box {
                left: 10%;
            }
        }

        .form {
            width: 100%;
            max-width:500px;
            height: 275px;
            margin: 25px auto 0px auto;
            padding-top: 25px;
        }
        .login-content {
            height: 300px;
            width: 100%;
            max-width:500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }


        .input-group {
            margin: 0px 0px 30px 0px !important;
        }
        .form-control,
        .input-group {
            height: 40px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }
        .login-title {
            padding: 6px 10px;
            background-color: rgba(0, 0, 0, .6);
        }
        .login-title h1 {
            margin-top: 6px !important;
        }
        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }
        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }
        .text-white{
            color: white;
        }
        .td_top{
        	font-size: 18px ;
        	margin-bottom: 10px
			padding: 4px;
			height:30px;
			border-collapse:collapse;
			border-top: 1px #98ACC3 solid;
			border-right: 0px solid;
			border-bottom: 1px #5088BA solid;
			border-left: 0px solid;
        }
    </style>
</head>
<body>
<div class="box">
    <br/>
    <h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;图书管理系统</h1>
    <!-- login-title text-center" -->
    <div class="login-box">
        <div class="login-title text-center height="6px">
            <h1><small>查询结果</small></h1>
        </div>
        <form action="">
	<table width="95%" border="0" align="center" cellpadding="2" cellspacing="0" class="table01">
      <tr>
        <td width="25%" class="td_top">书名</td>
        <td width="20%" class="td_top">作者</td>
        <td width="16%" class="td_top">出版社</td>
        <td width="8%" class="td_top">价格</td>
        <td width="10%" class="td_top">入库时间</td>
        <td width="10%" class="td_top">操作</td>
      </tr>
      <s:iterator id="book" value="list" status="s">
	   <tr>
	        <td class="td_02"><s:property value="#book.name"/></td>
	        <td class="td_02"><s:property value="#book.author"/></td>
	        <td class="td_02"><s:property value="#book.press"/></td>
	        <td class="td_02"><s:property value="#book.price"/></td>
	        <td class="td_02"><s:property value="#book.indate"/></s:property></td>
	        <td class="td_02">
	        	<a href="/mylib/updateBook.action?id=<s:property value='#book.id'/>">修 改</a>&nbsp;&nbsp;&nbsp;&nbsp;
	        	<a href="/mylib/delBook.action?id=<s:property value='#book.id'/>">删除</a>
	        </td>
	      </tr>
      </s:iterator>
    </table>
    </form>
    </div>
</div>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script>

</script>
</body>
</html>