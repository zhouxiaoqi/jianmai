<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<jsp:include page="../common/header.jsp"/>
<div id="other-user">
    <div class="grid-fluid other">
        <div class="col-8-12 push-2-12 other-info">
            <div class="col-3-12 other-header-left">
                <div class="other-headerimg">
                    <img src="${otherinfo.u_headerpic}"/>
                </div>
            </div>
            <input type="hidden" value="${otherinfo.account.a_id}" id="a_id">
            <div class="col-9-12 other-info-right">
                <div class="other-name">
                    <h2>${otherinfo.account.nickname}</h2>
                </div>
                <div class="selling-goods">
                    <span>正在出售<b>{{goodscount}}</b>件商品</span>
                </div>
            </div>
        </div>
    </div>
    <div class="grid-fluid other-goods">
        <div class="col-8-12 push-2-12">
            <div class="other-goods-title">
                <span>TA正在出售的商品</span>
            </div>
            <div class="other-goods-info" v-for="goods in goodsList">
                <div class="col-2-12">
                    <div class="other-goods-picture">
                        <img :src="goods.g_picture1"/>
                    </div>
                </div>
                <div class="col-10-12">
                    <div class="other-goods-name">
                        <h4>{{goods.g_name}}</h4>
                    </div>
                    <div class="other-goods-desc">
                        <p>
                            {{goods.g_desc}}
                        </p>
                    </div>
                    <div class="other-goods-place-price">
                        <span class="place">{{goods.g_place}}</span>
                        <span class="price">{{goods.g_price}}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>


<title>xxx-个人主页</title>
<script type="text/javascript"
        src="static/jqeury/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="static/js/otherinfo.js"></script>
<link rel="stylesheet" type="text/css"
      href="static/simplegrid/simplegrid.css"/>
<link rel="stylesheet" type="text/css"
      href="static/bootstrap/bootstrap_simple.min.css"/>
<link rel="stylesheet" href="static/css/otherinfo.css"/>