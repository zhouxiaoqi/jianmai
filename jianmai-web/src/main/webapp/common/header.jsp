<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script src="static/jqeury/jquery-3.1.0.min.js"></script>
    <script src="static/vue/vue.min.js"></script>
    <link rel="stylesheet" href="static/css/header.css">
    <link rel="stylesheet" href="static/bootstrap/bootstrap_simple.min.css">
    <link rel="stylesheet"
          href="static/font-awesome/css/font-awesome.min.css">

</head>
<body>
<%
    long token = System.currentTimeMillis(); // 产生时间戳的token
    String t = Long.toString(token);
    session.setAttribute("token", t);
%>
<nav class="navbar navbar-default" role="navigation" style="padding-bottom: 0px">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/index.html">
            <img src="static/image/logo.png" alt="logo"/>
        </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/index.html"> <span>首页</span></a></li>
            <li><a href="/want.html"> <span>求购专区</span></a></li>
        </ul>
        <form action="/search/q.do" class="navbar-form navbar-left" role="search" id="search-form">
            <input type="text" name="keyword" placeholder="搜你喜欢的" value="${query}">
            <input type="submit"  value="" class="search-go"/>
        </form>
        <ul class="nav navbar-nav navbar-right" id="myheader">
            <c:choose>
                <c:when test="${userinfo == null }">
                    <li class="center">
                        <a class="log-in" data-target="#loginmodal" data-toggle="modal"> <span>登陆</span></a>
                    </li>
                    <li class="center">
                        <a class="regist" data-target="#registmodal" data-toggle="modal"> <span>注册</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="release-goods"><a href="/release.html"><span>发布二手商品</span></a></li>
                    <li class="dropdown">
                        <img src="${userinfo.u_headerpic}" class="us-header" data-toggle="dropdown"/>
                        <ul class="dropdown-menu">
                            <li><a href="info.htm"><i class="fa fa-user"></i>&nbsp;我的主页</a></li>
                            <li><a href="#"><i class="fa fa-bookmark"></i>&nbsp;我的收藏</a></li>
                            <li><a href="#"><i class="fa fa-commenting"></i>&nbsp;我的消息</a></li>
                            <li class="divider"></li>
                            <li><a href="account/logout.do" style="cursor: pointer;">退出登陆</a></li>
                        </ul>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

<!-- 登陆弹出框 -->
<div class="modal bs-example-modal-sm fade" tabindex="-1" role="dialog"
     id="loginmodal">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <img alt="" src="static/image/logo.png">
            </div>
            <form id="login-form">
                <div class="modal-body">
                    <p>
                        <input type="text" class="form-control input-sm"
                               placeholder="邮箱" v-model="email" name="email"/>
                    </p>
                    <br/>
                    <p>
                        <input type="password" class="form-control input-sm"
                               placeholder="密码" v-model="password" name="password"/>
                    </p>
                    <div class="forgetpassword">
                        <a href="/forgot.html">忘记密码</a>
                    </div>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-default" @click="loginsubmit">登陆简买</a>
                    <div class="goregist">
                        <span @click="goregist">马上注册</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 注册弹出框 -->
<div class="modal bs-example-modal-sm fade" tabindex="-1" role="dialog"
     id="registmodal">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <img alt="" src="static/image/logo.png">
            </div>
            <form id="registform">
                <div class="modal-body">
                    <p>
                        <input type="text" class="form-control input-sm"
                               placeholder="昵称" v-model="r_nickname" name="nickname"/>
                    </p>
                    <p>
                        <input type="text" class="form-control input-sm"
                               placeholder="邮箱" v-model="r_email" name="email"/>
                    </p>
                    <p>
                        <input type="password" class="form-control input-sm"
                               placeholder="密码" v-model="r_password" name="password"/>
                    </p>
                    <p>
                        <input type="password" class="form-control input-sm"
                               placeholder="重复密码" v-model="r_repassword"/>
                    </p>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            :class="{disabled:isActive}" @click="registsubmit">{{btn_value}}
                    </button>
                    <div class="gologin">
                        <span @click="gologin">马上登陆</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
