<%--
  Created by IntelliJ IDEA.
  User: zhouqi
  Date: 2017/4/30
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<title>忘记密码</title>
<jsp:include page="../common/header.jsp"></jsp:include>

<div id="updatepass">
    <h4>修改密码</h4>
    <form id="update-form" method="post" class="update-form">
        <input type="hidden" value="${email}" name="email">
        <label>
            新密码:
            <input type="password" class="form-control" name="password" id="password">
        </label>
        <label>
            确认密码:
            <input type="password" class="form-control" id="repassword">
        </label>
        <button type="button" id="submit" class="btn btn-success btn-group btn-group-justified" @click="updateSubmit">确认修改</button>
    </form>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
<link rel="stylesheet" href="static/css/updatepass.css">
<script src="static/jqeury/jquery.form.js"></script>
<script src="static/js/updatepass.js"></script>

