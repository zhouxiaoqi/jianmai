<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<%
    String actionUrl;
    if(request.getAttribute("wantinfo") == null){
        actionUrl = "/want/insertwant.do";
    }else{
        actionUrl = "/want/updatewant.do";
    }
    request.setAttribute("actionUrl",actionUrl);
%>
<div class="grid-fluid releasewant-title">
    <div class="releasewant-logo">
        <img src="static/image/pencil_3.png"/>
    </div>
    <div class="line">
        <img src="static/image/line.png"/>
    </div>
    <div class="releasewant-word">
        <img src="static/image/releasewant.png"/>
    </div>
</div>
<div class="grid-fluid releasewant-form" id="release-want">
    <div class="col-2-3 push-1-6" style="background: #FFFFFF;">
        <div class="col-1-2 push-1-4 form-div">
            <form action="${actionUrl}" method="post" id="want-form"
                  data-validator-option="{timely:2, theme:'yellow_top',showOk:''}">
                <input type="hidden" name="w_id" value="${wantinfo.w_id}">
                <div class="goods-title mb">
                    <div class="form-key">
                        <span>商品名称</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <input type="text" name="w_name" placeholder="少于20字"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="w_name" placeholder="少于20字" value="${wantinfo.w_name}"/>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="goods-desc mb">
                    <div class="form-key">
                        <span>商品描述</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <textarea name="w_desc" rows="5"></textarea>
                            </c:when>
                            <c:otherwise>
                                <textarea name="w_desc" rows="5">${wantinfo.w_desc}</textarea>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="goods-price mb">
                    <div class="form-key">
                        <span>期望价格</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <input type="text" placeholder="¥" name="w_price"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" placeholder="¥" name="w_price" value="${wantinfo.w_price}"/>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="goods-place mb">
                    <div class="form-key">
                        <span>交易地点</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <input type="text" name="w_place" placeholder="如：校内，宿舍等"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="w_place" placeholder="如：校内，宿舍等" value="${wantinfo.w_place}"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <hr/>
                <div class="contact-tip">
                    <span>联系方式<small>(至少填一种)</small></span>
                </div>
                <div class="phonenum mb">
                    <div class="form-key">
                        <span>手机</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <input type="text" name="w_phonenum" id="w_phonenum"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="w_phonenum" id="w_phonenum" value="${wantinfo.w_phonenum}"/>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="qq mb">
                    <div class="form-key">
                        <span>QQ</span>
                    </div>
                    <div class="form-value">
                        <c:choose>
                            <c:when test="${wantinfo == null}">
                                <input type="text" name="w_qq" id="w_qq"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="w_qq" id="w_qq" value="${wantinfo.w_qq}"/>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="submit-btn mb">
                    <c:choose>
                        <c:when test="${wantinfo == null}">
                            <button type="submit" class="btn btn-success btn-lg" @click="want_submit">发布需求</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-danger btn-lg" @click="update_submit">确认修改</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>


<title>发布求购 - 简买</title>
<script type="text/javascript" src="static/js/releasewant.js"></script>
<script src="static/nice-validator/jquery.validator.min.js?local=zh-CN"></script>
<link rel="stylesheet" href="static/simplegrid/simplegrid.css"/>
<link rel="stylesheet" href="static/css/releasewant.css"/>
