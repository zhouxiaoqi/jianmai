<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"/>
<div class="grid-fluid want" id="want">
    <div class="want-logo">
        <img src="static/image/want-title.png"/>
    </div>
    <div class="col-8-12 push-2-12 left-area">
        <div class="want-goods" v-for="w in wantInfo">
            <div class="col-2-12" style="padding-right: 0px;">
                <div class="header-pic">
                    <img :src="w.school.s_badge"/>
                </div>
            </div>
            <div class="col-10-12">
                <div class="goods-info">
                    <div class="goods-title">
                        <span>[求购]&nbsp;{{w.w_name}}</span>
                    </div>
                    <div class="goods-desc">
                        <p>{{w.w_desc}}</p>
                    </div>
                    <div class="price-place-time">
                        <div class="col-2-8 ac">
                            <span>期望价格</span> <span class="price">¥{{w.w_price}}</span>
                        </div>
                        <div class="col-2-8 ac">
                            <span>交易地点</span> <span class="place">{{w.w_place}}</span>
                        </div>
                        <div class="col-2-8 ac">
                            <span>发布时间</span> <span class="time">{{w.w_createdtime}}</span>
                        </div>
                    </div>
                </div>
                <div class="user-info">
                    <div class="user-name mobile-col-1-1">
                        <a :href='"/otheruser/" + w.account.a_id  + ".htm"'><i class="fa fa-user-o"></i>{{w.account.nickname}}</a>
                    </div>
                    <div class="user-contact mobile-col-1-1">
                        <span v-if="w.w_phonenum != '' "><i class="fa fa-phone"></i>{{w.w_phonenum}}</span>
                        <span v-else><i class="fa fa-phone"></i>暂无</span>

                        <span v-if="w.w_qq != '' "><i class="fa fa-qq"></i>{{w.w_qq}}</span>
                        <span v-else><i class="fa fa-qq"></i>暂无</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-2-12 right-area">
        <div class="release-link">
            <c:choose>
                <c:when test="${userinfo == null}">
                    <a class="btn btn-default btn-lg" data-target="#loginmodal" data-toggle="modal">发布求购</a>
                </c:when>
                <c:otherwise>
                    <a href="/want/release.html" class="btn btn-default btn-lg">发布求购</a>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="advertising-area" id="advertisement">
            <div class="title">
                <span>您可能感兴趣</span>
            </div>
            <div class="image">
                <img :src="advers[5].ad_image" :alt="advers[5].ad_desc"/>
                <img :src="advers[6].ad_image" :alt="advers[6].ad_desc"/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>

<script type="text/javascript" src="static/js/want.js"></script>
<script type="text/javascript" src="static/moment/moment.min.js"></script>
<link rel="stylesheet" type="text/css"
      href="static/simplegrid/simplegrid.css"/>
<link rel="stylesheet" href="static/css/want.css"/>
<title>求购专区</title>