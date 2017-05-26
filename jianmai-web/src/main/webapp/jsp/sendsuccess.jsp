<%--
  Created by IntelliJ IDEA.
  User: zhouqi
  Date: 2017/4/3
  Time: 下午3:16
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

    <style>
        .success-content {
            width: 50%;
            margin: 40px auto;
            text-align: center;
        }

        .success-content .success-icon {
            text-align: center;
        }

        .success-content p {
        }
    </style>
    <title>发布成功</title>
</head>
<body>
<div class="success-content">
    <div class="success-icon">
        <img src="static/image/success.png" alt="">
    </div>
    <p>邮件已成功发送，请查看您的邮箱。</p>
</div>
</body>
</html>
