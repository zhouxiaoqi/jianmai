<%@ page import="java.rmi.activation.ActivationID" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<%
    String actionUrl;
    if (request.getAttribute("goodsinfo") == null) {
        actionUrl = "/goods/insertgoods.htm";
    } else {
        actionUrl = "/goods/updategoods.htm";
    }
    request.setAttribute("actionUrl", actionUrl);
%>
<div class="grid-fluid head">
    <div class="logo">
        <div class="logo-img">
            <img src="static/image/pencil2.png"/>
        </div>
        <div class="line">
            <img src="static/image/line.png" alt=""/>
        </div>
        <div class="logo-title">
            <img alt="发布商品" src="static/image/releasegoods.png"/>
        </div>
    </div>
</div>
<div class="grid-fluid release-picture" id="release-picture">
    <div class="col-8-12 push-2-12">
        <div class="col-8-12 push-2-12 picture-area">
            <div class="picture-one" @click="loadpicture1">
                <c:choose>
                    <c:when test="${goodsinfo.g_picture1 == null}">
                        <img src="static/image/can1.png" alt="请上传照片" v-show="plusone">
                    </c:when>
                    <c:otherwise>
                        <img src="${goodsinfo.g_picture1}" alt="请上传照片" v-show="plusone">
                    </c:otherwise>
                </c:choose>

                <img :src="pictureoneurl" alt="" v-show="hideimg1"/>
            </div>
            <div class="picture-two" @click="loadpicture2">
                <c:choose>
                    <c:when test="${goodsinfo.g_picture2 == null}">
                        <img src="static/image/can1.png" alt="请上传照片" v-show="plustwo">
                    </c:when>
                    <c:otherwise>
                        <img src="${goodsinfo.g_picture2}" alt="请上传照片" v-show="plustwo">
                    </c:otherwise>
                </c:choose>
                <img :src="picturetwourl" alt="" v-show="hideimg2"/>
            </div>
            <div class="picture-three" @click="loadpicture3">
                <c:choose>
                    <c:when test="${goodsinfo.g_picture3 == null}">
                        <img src="static/image/can1.png" alt="请上传照片" v-show="plusthree">
                    </c:when>
                    <c:otherwise>
                        <img src="${goodsinfo.g_picture3}" alt="请上传照片" v-show="plusthree">
                    </c:otherwise>
                </c:choose>

                <img :src="picturethreeurl" alt="" v-show="hideimg3"/>
            </div>
            <div class="picture-four" @click="loadpicture4">
                <c:choose>
                    <c:when test="${goodsinfo.g_picture4 == null}">
                        <img src="static/image/can1.png" alt="请上传照片" v-show="plusfour">
                    </c:when>
                    <c:otherwise>
                        <img src="${goodsinfo.g_picture4}" alt="请上传照片" v-show="plusfour">
                    </c:otherwise>
                </c:choose>

                <img :src="picturefoururl" alt="" v-show="hideimg4"/>
            </div>
        </div>
    </div>
</div>
<div class="grid-fluid release-form" id="release-form">
    <div class="col-8-12 push-2-12">
        <div class="col-8-12 push-2-12 form-area">
            <form action="${actionUrl}" method="post"
                  data-validator-option="{timely:2, theme:'yellow_top',showOk:''}" enctype="multipart/form-data">
                <c:if test="${actionUrl == '/goods/updategoods.htm'}">
                    <input type="hidden" name="account.a_id" value="${goodsinfo.account.a_id}">
                    <input type="hidden" name="type.t_id" value="${goodsinfo.type.t_id}">
                    <input type="hidden" name="school.s_id" value="${goodsinfo.school.s_id}">
                </c:if>
                <div class="files" v-show="files">
                    <c:choose>
                        <c:when test="${goodsinfo.g_picture1 == null}">
                            <input type="file" name="picture1" id="file1" @click="file1" accept="image/*"/>
                        </c:when>
                        <c:otherwise>
                            <input type="file" name="picture1" id="file1" @click="file1" accept="image/*"
                                   value="${goodsinfo.g_picture1}"/>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${goodsinfo.g_picture2 == null}">
                            <input type="file" name="picture2" id="file2" @click="file2" accept="image/*"/>
                        </c:when>
                        <c:otherwise>
                            <input type="file" name="picture2" id="file2" @click="file2" accept="image/*"
                                   value="${goodsinfo.g_picture2}"/>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${goodsinfo.g_picture3 == null}">
                            <input type="file" name="picture3" id="file3" @click="file3" accept="image/*"/>
                        </c:when>
                        <c:otherwise>
                            <input type="file" name="picture3" id="file3" @click="file3" accept="image/*"
                                   value="${goodsinfo.g_picture3}"/>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${goodsinfo.g_picture4 == null}">
                            <input type="file" name="picture4" id="file4" @click="file4" accept="image/*"/>
                        </c:when>
                        <c:otherwise>
                            <input type="file" name="picture4" id="file4" @click="file4" accept="image/*"
                                   value="${goodsinfo.g_picture4}"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-10-12 push-1-12" style="margin-top: 10px;">
                    <input type="hidden" name="g_id" value="${goodsinfo.g_id}">
                    <div class="goods-title">
                        <div class="form-key">
                            <span>商品名</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_name == null}">
                                    <input type="text" placeholder="最多20个字" name="g_name"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" placeholder="最多20个字" name="g_name" value="${goodsinfo.g_name}"/>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                    <div class="goods-desc">
                        <div class="form-key">
                            <span>商品描述</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_desc == null}">
                                    <textarea name="g_desc" rows="5"
                                              placeholder="尽量填写物品的损坏程度，物品用途，原价之类的的有效信息，至少12个字"></textarea>
                                </c:when>
                                <c:otherwise>
                                    <textarea name="g_desc" rows="5"
                                              placeholder="尽量填写物品的损坏程度，物品用途，原价之类的的有效信息，至少12个字">${goodsinfo.g_desc}</textarea>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                    <div class="goods-place">
                        <div class="form-key">
                            <span>交易地点</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_place == null}">
                                    <input type="text" placeholder="交易地点" name="g_place"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" placeholder="交易地点" name="g_place" value="${goodsinfo.g_place}"/>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                    <div class="goods-price">
                        <div class="form-key">
                            <span>价格</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_price == null}">
                                    <input type="number" min="0" name="g_price" placeholder="¥"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="number" min="0" name="g_price"
                                           value="${goodsinfo.g_price}" placeholder="¥"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="goods-bargain">
                        <div class="form-key">
                            <span>是否可还价</span>
                        </div>
                        <div class="form-value">
                            <select name="g_bargain">
                                <option value="">请选择</option>
                                <option value="可讲价">可讲价</option>
                                <option value="一口价">一口价</option>
                            </select>
                        </div>
                    </div>
                    <div class="goods-type">
                        <div class="form-key">
                            <span>分类</span>
                        </div>
                        <div class="form-value">
                            <select name="type.t_id">
                                <option value="">请选择</option>
                                <option v-for="type in alltypes" :value="type.t_id">
                                    {{type.t_typename}}
                                </option>
                            </select>
                        </div>
                    </div>
                    <hr size="1"/>
                    <div class="contact-tip">
                        <span>联系方式<small>(至少填一种)</small></span>
                    </div>
                    <div class="telnum">
                        <div class="form-key">
                            <span>手机</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_phonenum == null}">
                                    <input type="text" name="g_phonenum" id="phonenum"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="g_phonenum" id="phonenum" value="${goodsinfo.g_phonenum}"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="qq">
                        <div class="form-key">
                            <span>QQ</span>
                        </div>
                        <div class="form-value">
                            <c:choose>
                                <c:when test="${goodsinfo.g_qq == null}">
                                    <input type="text" name="g_qq" id="qq"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="g_qq" id="qq" value="${goodsinfo.g_qq}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <c:if test="${goodsinfo == null}">
                        <div class="agree-rule">
                            <label for="">
                                <input type="checkbox" v-model="checked"/>
                                <span>同意<a href="#" data-toggle="modal" data-target="#rule-modal">商品发布规则</a></span>
                            </label>
                        </div>
                    </c:if>
                </div>

                <div class="submit-btn">
                    <c:choose>
                        <c:when test="${goodsinfo == null}">
                            <button type="submit" class="btn btn-success btn-lg" :class="{disabled:!checked}"
                                    @click="release_submit">发布商品
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-success btn-lg" @click="update_submit">确认修改</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal" id="rule-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">发布规则</h4>
            </div>
            <div class="modal-body">
                <ol type="I" class="rules">
                    <li>
                        <p>上传的商品图一定要与实物一致，管理员发现后将删除该商品。</p>
                    </li>
                    <li>
                        <p>不得上传虚假诈骗色情暴力的信息，管理员发现后永久封号</p>
                    </li>
                    <li>
                        <p>相同的商品不得恶意多次发布， 管理员发现后将删除该商品，并进行封号处理。</p>
                    </li>
                    <li>
                        <p>不得发布违法物品，如：枪支弹药、毒品等， 管理员发现后永久封号。</p>
                    </li>
                    <li>
                        <p>商品发布后30天后自行下架，在个人页面重新上架即可。</p>
                    </li>
                </ol>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<div id="canvas-area">
    <canvas id="canvas" width="1440px" height="1000px"></canvas>
</div>

<jsp:include page="../common/footer.jsp"/>

<c:choose>
    <c:when test="${goodsinfo == null}">
        <title>发布二货</title>
    </c:when>
    <c:otherwise>
        <title>修改我的二货</title>
    </c:otherwise>
</c:choose>
<script src="static/js/release.js"></script>
<script src="static/js/mycanvas.js"></script>
<script src="static/nice-validator/jquery.validator.min.js?local=zh-CN"></script>
<link rel="stylesheet" href="static/simplegrid/simplegrid.css"/>
<link rel="stylesheet" href="static/nice-validator/jquery.validator.css">
<link rel="stylesheet" href="static/css/release.css"/>