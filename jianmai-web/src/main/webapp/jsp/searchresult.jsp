<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../common/header.jsp"/>
<div class="container-fluid" id="search">
    <div class="query-name">
        ${query}
    </div>
    <ul class="action-items">
        <li class="action-item"><a>价格</a></li>
        <li class="action-item"><a>热度</a></li>

        <li class="total-goods"><b>${searchCount}</b> 个结果</li>
    </ul>

    <ul class="goods-items">
        <c:forEach var="g" items="${goodsList}">
            <li class="goods-item">
                <a href="/goods/${g.g_id}.htm">
                    <img src="${g.g_picture1}" alt="" class="goods-image">
                </a>
                <div class="goods-price">
                        ${g.g_price}
                </div>
                <div class="goods-name">
                        ${g.g_name}
                </div>
                <div class="goods-place">
                        ${g.g_place}
                </div>
                <div class="goods-bargain">
                        ${g.g_bargain}
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<jsp:include page="../common/footer.jsp"/>


<title>${query}-搜索结果</title>

<script type="text/javascript" src="static/js/searchresult.js"></script>
<link rel="stylesheet" href="static/css/searchresult.css"/>
<link rel="stylesheet" href="static/bootstrap/bootstrap_simple.min.css">