<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp"/>
<title>${singleGoods.g_name}</title>
<div id="loading">
    <img src="static/image/loading.gif" alt="">
</div>
<div class="container-fluid">
    <div class="goods" id="goods">
        <div class="row" id="my_action">
            <div class="col-lg-8 plpr">
                <div class="loading-pic" id="loading-pic">
                    <img src="${picList[0]}" alt="${singleGoods.g_name}"/>
                </div>
                <ul class="pic-items">
                    <c:forEach var="pic" items="${picList}">
                        <li class="pic-item" @mouseover="switch_pic($event)">
                            <img src="${pic}" alt="${singleGoods.g_name}">
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-4 plpr">
                <div class="goods-info">
                    <div class="goods-title">
                        <h3>${singleGoods.g_name}</h3>
                    </div>
                    <div class="goods-price">
                        <span>${singleGoods.g_price}</span>
                    </div>
                    <ul class="goods-detail">
                        <li>
                            <div class="title fl">
                                <span>交易地点</span>
                            </div>
                            <div class="value fl">
                                <span>${singleGoods.g_place}</span>
                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>卖家</span>
                            </div>
                            <div class="value fl">
                                <span><a
                                        href="/otheruser/${singleGoods.account.a_id}.htm">${singleGoods.account.nickname}
                                    <i class="fa fa-external-link"></i></a>
                                </span>
                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>卖家QQ</span>
                            </div>
                            <div class="value fl">
                                <c:choose>
                                    <c:when test="${userinfo == null}">
                                        <a data-target="#loginmodal" data-toggle="modal"><span>登陆后查看</span></a>
                                    </c:when>
                                    <c:when test="${singleGoods.g_qq == ''}">
                                        <span>未填写</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>${singleGoods.g_qq}</span>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>卖家电话</span>
                            </div>
                            <div class="value fl">
                                <c:choose>
                                    <c:when test="${userinfo == null}">
                                        <a data-target="#loginmodal" data-toggle="modal"><span>登陆后查看</span></a>
                                    </c:when>
                                    <c:when test="${singleGoods.g_phonenum == ''}">
                                        <span>未填写</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>${singleGoods.g_phonenum}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>发布时间</span>
                            </div>
                            <div class="value fl">
                                <span>${singleGoods.g_createdTime}</span>
                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>所属学校</span>
                            </div>
                            <div class="value fl">
                                <span>${singleGoods.school.s_name}</span>
                            </div>
                        </li>
                        <li>
                            <div class="title fl">
                                <span>浏览次数</span>
                            </div>
                            <div class="value fl">
                                <span>
                                    ${singleGoods.brownTimes}
                                </span>
                            </div>
                        </li>
                    </ul>
                    <div class="action" id="action">
                        <c:if test="${userinfo != null}">
                            <a v-if="isCollect == 1" @click="remove_collect">取消收藏</a>
                            <a @click="collect" v-else>收藏</a>
                        </c:if>
                        <a title="举报" @click="report">举报</a>
                    </div>
                    <input type="hidden" value="${singleGoods.g_id}" id="g_id">
                </div>
            </div>
        </div>
        <div class="row user-said">
            <div class="col-lg-1">
                <img src="static/image/said.png" alt=""/>
            </div>
            <div class="col-lg-10">
                <p>
                    ${singleGoods.g_desc}
                </p>
            </div>
        </div>
        <div class="row comment-advertisement">
            <div class="col-lg-9 comment" id="comment">
                <div id="cloud-tie-wrapper" class="cloud-tie-wrapper"></div>
                <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
                <script>
                    // 网易云跟帖 config
                    var g_id = $('#g_id').val();
                    var cloudTieConfig = {
                        url: '',
                        sourceId: $('#g_id').val(),
                        productKey: "6269e20d42dd486a84fd9bae73e1d1dd",
                        target: "cloud-tie-wrapper"
                    };
                    var yunManualLoad = true;
                    Tie.loader("aHR0cHM6Ly9hcGkuZ2VudGllLjE2My5jb20vcGMvbGl2ZXNjcmlwdC5odG1s", true);
                </script>
            </div>
            <div class="col-lg-3 advertisement" id="advertisement">
                <span>您可能感兴趣</span>
                <img :src="advers[5].ad_image" :alt="advers[5].ad_desc"/>
                <img :src="advers[6].ad_image" :alt="advers[6].ad_desc"/>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"/>
<script type="text/javascript" src="static/js/goodsdetail.js"></script>
<link rel="stylesheet" href="static/css/goodsdetail.css"/>
