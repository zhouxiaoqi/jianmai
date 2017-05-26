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
    <p>发布商品成功，商品信息待审核后会自行上架，您可以在我的<a href="javascript:void(0);">个人信息</a>中查看详情。</p>
    <p><b id="second"></b>秒后返回首页</p>
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
