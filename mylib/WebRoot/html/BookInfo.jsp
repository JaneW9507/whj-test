<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
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
            max-width:500px;
            height: 400px;
            position: absolute;
            top: 50%;
            margin-top: -356px;

        }
        @media screen and (min-width:500px){
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
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
            height: 370px;
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
    </style>
    <script type="text/javascript" src="/js/jquery-1.11.3.js"></script>
    <script>
     
    </script>
</head>
<body>
<div class="box">
    <br/>
    <h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;图书管理系统</h1>
    <div class="login-box">
        <div class="login-title text-center">
            <h1><small>图书信息</small></h1>
        </div>
        <div class="login-content ">
            <div class="form">
                    <!--  隐藏-->
				<form name="form1" action="/mylib/addBook.action"  method="post">
                    <input type="hidden" name="book.id" value="${book.id}">
                    <input type="hidden" name="book.indate" value="${book.indate}">
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                               <span class="input-group-addon" >书&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                               <s:textfield cssClass="form-control" name="book.name" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                            	<span class="input-group-addon" >作&nbsp;&nbsp;&nbsp;&nbsp;者</span>
                               <s:textfield cssClass="form-control" name="book.author" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                            <span class="input-group-addon" >出版社</span>
                               <s:textfield cssClass="form-control" name="book.press" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                            <span class="input-group-addon" >价&nbsp;&nbsp;&nbsp;&nbsp;格</span>
                               <s:textfield cssClass="form-control" name="book.price" />
                            </div>
                        </div>
                    </div>
					
                    <div class="form-group form-actions">
                        <div class="col-xs-4 col-xs-offset-4 " style="margin: 0 37%;">
                          <input type="submit" class="btn btn-sm btn-info" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/> 
                        </div>
                    </div>

            </form>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    function submit(){
    	window.location.href="/mylib/loginOut.action";
    }
</script>
</body>
</html>