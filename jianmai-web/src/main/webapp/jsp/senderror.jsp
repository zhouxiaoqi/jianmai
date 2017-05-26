<%--
  Created by IntelliJ IDEA.
  User: zhouqi
  Date: 2017/4/4
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="static/bootstrap/bootstrap_simple.min.css">
    <title>出错了..</title>
    <style>
        #error-content {
            width: 40%;
            margin: 40px auto;
            text-align: center;
        }

        #error-content .error-icon {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="error-content">
    <div class="error-icon">
        <img src="static/image/error.png" alt="">
    </div>
    <p>您输入的邮箱尚未注册。<a href="/forgot.html">返回</a>重新输入</p>
</div>
</body>
</html>
