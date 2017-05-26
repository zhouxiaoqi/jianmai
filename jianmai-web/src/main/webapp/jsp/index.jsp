<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 导航条 -->
<jsp:include page="../common/header.jsp"/>

<!--轮播图，分类，商品展示，广告-->
<div class="container">
    <div class="row">
        <!--0.轮播图-->
        <div id="banner" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <%--<ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>--%>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img :src="banners[0].ad_image" alt="...">
                </div>
                <div class="item">
                    <img :src="banners[1].ad_image" alt="...">
                </div>
                <div class="item">
                    <img :src="banners[2].ad_image" alt="...">
                </div>
                <div class="item">
                    <img :src="banners[3].ad_image" alt="...">
                </div>
                <div class="item">
                    <img :src="banners[4].ad_image" alt="...">
                </div>
            </div>
            <!-- Controls -->
            <a class="prev" href="#banner" role="button" data-slide="prev">
                <img src="static/image/arrowl.png"/>
            </a>
            <a class="next" href="#banner" role="button" data-slide="next">
                <img src="static/image/arrowr.png"/>
            </a>
        </div>
        <div class="main-content ">
            <div class="left-content col-lg-10" id="left-content">
                <!--1.类别-->
                <div class="category">
                    <!--1.1 pc端显示-->
                    <div class="items on-pc">
                        <a :href=' "/type/typeinfo/" + type.t_id + ".htm" ' class="item" target="_blank"
                           v-for="type in types">
                            <img :src="type.t_typeimgforpc" :alt="type.t_typename">
                            <div class="type-name">
                                {{type.t_typename}}
                            </div>
                        </a>
                    </div>
                    <!--1.2 手机上显示-->
                    <div class="on-phone">
                        <ul class="beans">
                            <li class="bean" v-for="type in types">
                                <div class="type-img">
                                    <a :href=' "/type/typeinfo/" + type.t_id + ".htm" '>
                                        <img :src="type.t_typeimgforphone" alt="">
                                    </a>
                                </div>
                                <div class="type-name">
                                    <a :href=' "/type/typeinfo/" + type.t_id + ".htm" '>
                                        {{type.t_typename}}
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--2.商品展示-->
                <!--phone  ：div居中，商品浮动左或者右-->
                <div class="recomment-line">
                    <span class="recomment-for-you">为您推荐</span>
                </div>
                <div class="goods">
                    <ul class="items clearfix">
                        <li class="item" v-for="single_goods in goods">
                            <a :href='"/goods/" + single_goods.g_id + ".htm" ' target="_blank">
                                <img :src="single_goods.g_picture1" class="good-picture" :alt="single_goods.g_name"/>
                            </a>
                            <div class="good-info">
                                <div class="good-price">{{single_goods.g_price}}</div>
                                <div class="good-name">
                                    <a :href='"/goods/" + single_goods.g_id + ".htm" '>{{single_goods.g_name}}</a>
                                </div>
                                <div class="good-place">
                                    <span>{{single_goods.g_place}}</span>
                                </div>
                                <!--能还价还是一口价-->
                                <div class="bargain">
                                    <span>{{single_goods.g_bargain}}</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="load-more" v-if="has_more">
                    <a href="javascript:void(0);" @click="load_more"> {{loadmore_text}} </a>
                </div>
            </div>
            <div class="right-content col-lg-2" id="right-content">
                <div class="location">
                    <c:choose>
                        <c:when test="${schoolinfo == null}">
                            <span>未选择学校</span><br/>
                            <a href="school.htm" class="btn">选择学校</a>
                        </c:when>
                        <c:otherwise>
                            <span>${schoolinfo.s_name}</span> <br/>
                            <a href="school.htm" class="btn">切换学校</a>
                        </c:otherwise>
                    </c:choose>
                    <input type="hidden" value="${schoolinfo.s_id}" id="s_id">
                </div>
                <div class="helped">
                    <span class="helpers">{{helpCount}}</span>
                </div>
                <hr>
                <div class="sina-wechat">
                    <a href="javascript:void(0);" @click="share_sina">
                        <img src="/static/image/sina_weibo.png" alt="分享至微博" title="分享至新浪微博">
                    </a>
                    <a href="javascript:void(0);" @click="wechat_config">
                        <img src="/static/image/wechat.png" alt="分享至朋友圈" title="分享至朋友圈">
                    </a>
                </div>
                <div class="recomment">
                    <div class="title">
                        <span>推荐商品</span>
                    </div>
                    <ul class="list">
                        <li  v-for="r in recomments">
                            <a :href='"/goods/" + r.g_id + ".htm" ' class="avatar">
                                <img :src="r.g_picture1" :alt="r.g_name">
                            </a>
                            <a :href='"/goods/" + r.g_id + ".htm" ' class="name">
                                {{r.g_name}}
                            </a>
                            <p>
                                <i class="fa fa-eye">&nbsp;<b>{{r.brownTimes}}</b></i>
                            </p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="to_top" id="to_top"></div>

<jsp:include page="../common/footer.jsp"/>
<title>简买-
    <c:choose>
        <c:when test="${schoolinfo == null}">
            首页
        </c:when>
        <c:otherwise>
            ${schoolinfo.s_name}
        </c:otherwise>
    </c:choose>
</title>
<script type="text/javascript" src="static/js/index.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<link rel="stylesheet" href="static/css/index.css">