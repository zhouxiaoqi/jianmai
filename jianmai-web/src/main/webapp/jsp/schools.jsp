<%--
  Created by IntelliJ IDEA.
  User: zhouqi
  Date: 2017/3/22
  Time: 下午4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="static/jqeury/jquery-3.1.0.min.js"></script>
    <script src="static/vue/vue.js"></script>
    <script type="text/javascript" src="static/js/schools.js"></script>
    <link rel="stylesheet" href="static/bootstrap/bootstrap_simple.min.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/schools.css">
    <title>选择学校</title>

</head>
<body>

<div id="cs-header">
    <div class="cs-logo">
        <img src="static/image/cslogo.png" alt="简买"/>
    </div>
    <div class="cs-desc">
        <p></p>
    </div>
    <div class="search-area">
        <form action="" method="" class="search-form">
            <input type="text" placeholder="输入学校名进行搜索"/>
            <button>
                <!--<img src="img/search-icon.png"/>-->
                <i class="fa fa-lg fa-search"></i>
            </button>
        </form>
    </div>
</div>

<!--学校列表-->
<div id="schools-list">
    <div class="opened-schools">
        已开通的学校
    </div>
    <ul class="schools-items">
        <li class="school-item" v-for="school in allSchool">
            <div class="school-info">
                <a :href='"school/" + school.s_id + ".htm"'>
                    <img :src="school.s_badge" :alt="school.s_name" class="school-badge"/>
                </a>
                <div class="school-name">
                    <a :href='"school/" + school.s_id + ".htm"'>{{school.s_name}}</a>
                    <span v-if="school.s_campus != ''">({{school.s_campus}})</span>
                </div>
            </div>
        </li>
    </ul>
    <div class="apply-line">
        申请开通
    </div>
    <div class="apply-open">
        <a href="javascript:void(0);">
            申请开通学校
        </a>
    </div>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
</html>
