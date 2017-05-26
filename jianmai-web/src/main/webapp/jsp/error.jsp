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
    <p>服务器异常，请稍后再试</p>
    <p><b id="second">5</b>秒后回到<a href="/index.html">首页</a></p>
</div>
</body>

<script>
    window.onload = function () {
        var s = 5;
        var t;

        function time() {
            var second = document.getElementById('second');
            second.innerHTML = s;
            s = s - 1;
            t = setTimeout(time, 1000);
            if (s < 0) {
                location.href = '/index.html';
                clearTimeout(t);
            }
        }

        time();
    }

</script>
</html>
