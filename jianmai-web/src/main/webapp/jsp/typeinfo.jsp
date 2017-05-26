<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<title>${type.t_typename}-简买</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container type-info" id="typeinfo">
    <div class="row">
        <!--left-->
        <div class="col-lg-8 col-sm-12 main">
            <!--种类头部模块-->
            <div class="main-top">
                <div class="type-picture">
                    <img src="${type.t_typeimgforpc}" alt="${type.t_typename}"/>
                </div>
                <input type="hidden" value="${type.t_id}" id="t_id">
                <input type="hidden" value="${schoolinfo.s_id}" id="s_id">
                <div class="title">
                    ${type.t_typename}
                </div>
                <div class="info">
                    <span>该类型一共有<b>{{countGoods}}</b>个二手商品</span>
                </div>
            </div>

            <!--条件查询或排序-->
            <ul class="sort_menu" id="sort_menu">
                <li>
                    <a href="#">
                        价格
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0)">
                        浏览次数
                    </a>
                </li>
                <li>
                    只看本校
                    <a>
                        <img src="static/image/switch_off.png" alt="只看本校：关" v-if="only_myshcool == 0" @click="open_school_tygoods">
                        <img src="static/image/switch_on.png" alt="只看本校：开" v-else @click="get_all_typegoods">
                    </a>
                </li>
            </ul>
            <!--商品列表-->
            <div class="type-of-goods">
                <ul class="goods-items">
                    <li class="item" v-for="goods in goodsList">
                        <a :href='"/goods/" + goods.g_id + ".htm" '>
                            <img :src="goods.g_picture1" :alt="goods.g_name" class="type-good-picture"/>
                        </a>
                        <div class="type-good-info">
                            <div class="type-good-price">
                                {{goods.g_price}}
                            </div>
                            <div class="type-good-name">
                                <a :href='"/goods/" + goods.g_id + ".htm" '>
                                    {{goods.g_name}}
                                </a>
                            </div>
                            <div class="type-good-place">
                                {{goods.g_place}}
                            </div>
                            <div class="type-good-bargain">
                                {{goods.g_bargain}}
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="load-more" v-if="show_hidden">
                <a href="javascript:void(0);">
                    加载更多
                </a>
            </div>

        </div>
        <!--left end-->

        <!--right-->
        <div class="col-lg-4 col-sm-12">
            <div class="type-of-notice">
                <article>
                    <header>
                        <h5>注意事项</h5>
                    </header>
                    <p>
                        ${type.t_typedesc}
                    </p>
                </article>
            </div>
        </div>
        <!--right end-->
    </div>
</div>

<div class="loading" id="loading">
    <img src="static/image/loading_simple.gif" alt="">
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>

<script type="text/javascript" src="static/js/typeinfo.js"></script>
<link rel="stylesheet" href="static/css/typeinfo.css"/>
