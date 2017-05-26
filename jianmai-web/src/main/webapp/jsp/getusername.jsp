<%--
  Created by IntelliJ IDEA.
  User: zhouqi
  Date: 2017/4/30
  Time: 下午3:49
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
    <script src="static/jqeury/jquery-3.1.0.min.js"></script>
    <title>找回密码</title>
</head>
<body>
<div>
    <h3>输入您的注册邮箱</h3>
    <form method="post" action="/account/sendmail.html" id="sendEmailForm" onsubmit="return s();">
        <input type="text" name="email" id="email" style="width: 200px;height: 25px">
        <input type="submit" class="button" id="submit_bnt" value="提交"></input>
    </form>
    <p>我们会把重置密码的链接发送到你的邮箱</p>
</div>
<script>
    function s() {
        var email = document.getElementById("email").value;
        if (email.trim() === '') {
            alert("请输入邮箱");
            return false;
        } else {
            return true;
        }
    }


</script>
</body>
</html>
