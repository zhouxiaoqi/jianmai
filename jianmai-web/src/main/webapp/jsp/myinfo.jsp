<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="../common/header.jsp"/>

<link rel="stylesheet" href="static/simplegrid/simplegrid.css"/>
<link rel="stylesheet" href="static/css/myinfo.css"/>
<link rel="stylesheet" href="static/tab/css/tabs.css"/>
<link rel="stylesheet" type="text/css" href="static/tab/css/tabstyles.css"/>

<div class="grid-fluid myinfo">
    <div class="col-8-12 push-2-12">
        <div class="col-4-12 mobile-col-1-1 userheader">
            <div id="userheader">
                <div class="userheader-img">
                    <img src="${userinfo.u_headerpic}" @mouseover="showhover"/>
                    <img id="personhover" src="static/image/person_hover.png"
                         v-show="phover" @mouseout="hidehover" data-toggle="modal"
                         data-target="#mymodal"/>
                </div>
            </div>
        </div>
        <div class="col-8-12 mobile-col-1-1 userinfo" id="userinfo">
            <div class="user-nickname">
                <h2>{{myinfo.account.nickname}}</h2>
            </div>
            <div class="account-info">
                <div class="info-title">
                    <h4>账户信息</h4>
                </div>
                <div class="account">
                    <div class="info-key">
                        <span>账号</span>
                    </div>
                    <div class="info-value">
                        <span>{{myinfo.account.email}}</span>
                    </div>
                </div>
            </div>
            <div class="base-info">
                <div class="info-title">
                    <h4>基本信息</h4>
                    <span @click="edit" v-show="!toggletext">编辑&nbsp;<i class="fa fa-cog"></i></span>
                    <span @click="save" v-show="toggletext">保存&nbsp;<i class="fa fa-check"></i></span>
                </div>

                <div class="nickname">
                    <div class="info-key">
                        <span>昵称</span>
                    </div>
                    <div class="info-value">
                        <span v-show="!toggletext">{{myinfo.account.nickname}}</span>
                        <input type="text" v-show="toggletext" placeholder="修改个人信息" v-model=myinfo.account.nickname
                               id="my_nickname_input"/>
                    </div>
                </div>
                <div class="telnum">
                    <div class="info-key">
                        <span>手机</span>
                    </div>
                    <div class="info-value">
                        <span v-show="!toggletext">{{myinfo.u_phonenum}}</span>
                        <input type="text" v-show="toggletext" placeholder="修改个人信息" v-model=myinfo.u_phonenum
                               id="my_phonenum_input"/>
                    </div>
                </div>
                <div class="qq">
                    <div class="info-key">
                        <span>QQ</span>
                    </div>
                    <div class="info-value">
                        <span v-show="!toggletext">{{myinfo.u_qq}}</span>
                        <input type="text" v-show="toggletext" placeholder="修改个人信息" v-model=myinfo.u_qq
                               id="my_qq_input"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" id="mymodal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">设置头像</h4>
            </div>
            <form enctype="multipart/form-data" id="change_headerpic_form">
                <div class="modal-body">
                    <div class="add-header" v-show="!headerarea">
                        <a @click="addimg"><i>+</i>&nbsp;添加图片</a>
                    </div>
                    <div class="header-area" v-show="headerarea">
                        <input type="file" accept="image/*" id="uploadfile" name="file"/>
                        <img :src="theimg" alt="happy"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" @click="changesubmit">确定</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" @click="cancel">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="grid-fluid my-etc">
    <div class="col-8-12 push-2-12">
        <section>
            <div class="tabs tabs-style-bar">
                <nav>
                    <ul>
                        <li><a href="#my-release"><span>我发布的商品</span></a></li>
                        <li><a href="#my-want"><span>我的求购商品</span></a></li>
                        <li><a href="#my-collect"><span>我的收藏</span></a></li>
                        <li><a href="#my-message"><span>消息中心</span><span class="badge">2</span></a></li>
                    </ul>
                </nav>
                <div class="content-wrap">
                    <section id="my-release">
                        <div id="releasegoods">
                            <div class="released" v-for="goods in mygoods" v-if="goods.g_showornot != 3">
                                <div class="col-2-12 mobile-col-1-1 released-picture">
                                    <a :href='"/goods/" + goods.g_id + ".htm" '>
                                        <img :src="goods.g_picture1" :alt="goods.g_name"/>
                                    </a>
                                </div>
                                <div class="col-10-12 mobile-col-1-1 released-info">
                                    <div class="goods-title">
                                        <a :href='"/goods/" + goods.g_id + ".htm" '><h4>{{goods.g_name}}</h4></a>
                                    </div>
                                    <div class="goods-desc">
                                        <p>
                                            {{goods.g_desc}}
                                        </p>
                                    </div>

                                    <div class="goods-action" v-if="goods.g_showornot === -1">
                                        <span style="color: #F75450;">驳回：{{goods.g_rejectreason}}</span>
                                        <a :href=' "/goods/update/" +goods.g_id+ ".htm" '
                                           class="editlink btn btn-success btn-sm">修改</a>
                                        <a class="off btn btn-danger btn-sm">取消发布</a>
                                    </div>

                                    <div class="goods-action" v-if="goods.g_showornot === 1">
                                        <span>出售中</span>
                                        <a :href=' "/goods/update/" +goods.g_id+ ".htm" '
                                           class="editlink btn btn-success btn-sm">修改</a>
                                        <a class="off btn btn-danger btn-sm"
                                           @click="get_id(goods.g_id)">下架</a>
                                    </div>


                                    <div class="goods-action" v-if="goods.g_showornot === 0">
                                        <span>审核中...</span>
                                    </div>

                                    <div class="goods-action" v-if="goods.g_showornot === 2">
                                        <span>已下架</span>
                                        <a class="editlink btn btn-success btn-sm" @click="grounding_goods(goods.g_id)">重新上架</a>
                                    </div>
                                    <%-- -1:驳回 修改  0:审核中 1:出售中 修改 下架 2:已下架  重新上架 --%>
                                </div>

                                <%--模态框 confirm --%>
                                <div id="mask" v-show="show_hidden">
                                    <div class="modal-dialog">
                                        <span class="close-modal" @click="close_modal">&times;</span>
                                        <div class="modal-hd">
                                            下架商品
                                        </div>
                                        <div class="modal-body">
                                            您为什么要下架该商品?
                                        </div>
                                        <div class="modal-footer">
                                            <span class="modal-btn" @click="not_sell">
                                                时间太久，不想出售了。
                                            </span>
                                            <span class="modal-btn" @click="already_sell">
                                                已成功售出
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <%-- 模态框 confirm 结束 --%>
                            </div>
                        </div>
                    </section>
                    <%--我发布的求购商品--%>
                    <section id="my-want">
                        <div id="want-goods">
                            <div class="want" v-for="want in allWants">
                                <div class="want-title">
                                    <h4>[求购] {{want.w_name}}</h4>
                                </div>
                                <div class="want-desc">
                                    <p>
                                        {{want.w_desc}}
                                    </p>
                                </div>
                                <div class="want-place-price">
                                    <span class="want-place">交易地点：<b>{{want.w_place}}</b></span>
                                    <span class="want-price">期望价格：<b>{{want.w_price}}</b></span>
                                </div>
                                <div class="want-action" v-if="want.w_showornot == 1">
                                    <a :href=' "/want/update/" + want.w_id + ".htm" ' class="btn btn-success btn-sm">点击修改</a>
                                    <a class="btn btn-danger btn-sm" @click="re_grounding(want.w_id,want.w_showornot)">下架求购信息</a>
                                </div>
                                <div class="want-action" v-if="want.w_showornot == 2">
                                    <a class="btn btn-danger btn-sm" @click="re_grounding(want.w_id,want.w_showornot)">重新上架</a>
                                </div>
                                <div class="want-action" v-if="want.w_showornot == 0">
                                    <span>审核中...</span>
                                </div>
                                <div class="want-action" v-if="want.w_showornot == -1">
                                    <span>驳回：{{want.w_rejectreason}}</span>
                                    <a :href=' "/want/update/" + want.w_id + ".htm" ' class="btn btn-success btn-sm">点击修改</a>
                                </div>

                                <%--0:待审核状态 1:上架状态 -1:驳回状态 2：下架状态--%>
                            </div>
                        </div>
                    </section>
                    <section id="my-collect">
                        <div id="collected-goods">
                            <div class="collect" v-for="collected in mycollected"
                                 v-if="collected.goods.g_showornot == 1">
                                <div class="col-2-12 mobile-col-1-1 collect-picture">
                                    <a :href='"/goods/" + collected.goods.g_id + ".htm" '>
                                        <img :src="collected.goods.g_picture1" alt=""/>
                                    </a>
                                </div>
                                <div class="col-10-12 mobile-col-1-1"
                                     style="background: #FFFFFF;">
                                    <div class="goods-title">
                                        <a :href=' "/goods/" + collected.goods.g_id + ".htm" '><h4>
                                            {{collected.goods.g_name}}</h4></a>
                                    </div>
                                    <div class="goods-desc">
                                        <p>
                                            {{collected.goods.g_desc}}
                                        </p>
                                    </div>
                                    <div class="goods-action">
                                        <span class="status">出售中</span>
                                        <a class="cancel-collect btn btn-primary btn-sm"
                                           @click="remove_collect(collected.goods.g_id)">取消收藏</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section id="my-message">
                        <div class="message">
                            <div class="message-title">
                                <h4>消息列表</h4>
                            </div>
                            <ul class="message-list list-group">
                                <li class="list-group-item">

                                </li>
                            </ul>
                        </div>
                    </section>
                </div>
            </div>
        </section>
    </div>
</div>

<%--操作成功提示--%>
<div class="tip" id="success-tip">
    <img src="static/image/small_success.png" alt="">
    操作成功
</div>

<div class="tip" id="error-tip">
    <img src="static/image/small_error.png" alt="">
    请稍后再试
</div>

<%--操作失败提示--%>


<jsp:include page="../common/footer.jsp"/>


<script type="text/javascript" src="static/js/myinfo.js"></script>
<script src="static/tab/js/cbpFWTabs.js"></script>

<title>我的信息</title>
<script>
    (function () {
        [].slice.call(document.querySelectorAll('.tabs')).forEach(function (el) {
            new CBPFWTabs(el);
        })
    })();
</script>

