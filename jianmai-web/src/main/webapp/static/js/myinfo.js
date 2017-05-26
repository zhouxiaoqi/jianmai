$(function ($) {

    var goods_id //全局变量，参数传递

    var userheader = new Vue({
        el: "#userheader",
        data: {
            phover: false,
            headerurl: ''
        },
        methods: {
            showhover: function () {
                this.phover = true;
            },
            hidehover: function () {
                this.phover = false;
            },
            changeheader: function () {

            }
        }
    });

    var userinfo = new Vue({
        el: "#userinfo",
        data: {
            toggletext: false,
            myinfo: {}
        },

        /**
         * vue 生命周期初始化的时候取出用户信息
         */
        created: function () {
            var me = this;
            $.post("info/getmyinfo.do", function (info_data) {
                if (info_data === '') {
                    location.href = '/index.html';
                    alert("登陆信息过期，请重新登陆");
                    return;
                }
                me.myinfo = info_data;
                userheader.headerurl = info_data.u_headerpic;
            });

        },
        methods: {
            edit: function () {
                this.toggletext = true;
            },
            // 修改我的个人信息
            save: function () {
                var me = this;
                var my_nickname = $("#my_nickname_input").val();
                var my_phonenum = $("#my_phonenum_input").val();
                var my_qq = $("#my_qq_input").val();
                if (my_nickname.trim() === null || my_nickname.trim() === '') {
                    alert('昵称不能不填哦!');
                    return;
                }
                $.post('info/update.do', {
                    my_nickname: my_nickname,
                    my_phonenum: my_phonenum,
                    my_qq: my_qq
                }, function (res_userinfo) {
                    if (res_userinfo == null) {
                        alert("登陆信息过期，请重新登陆");
                        location.href = '/';
                        return;
                    }
                    me.myinfo = res_userinfo;
                    actionTip(true);
                    me.toggletext = false;
                })

            },
        }
    });

    // 上传头像
    var mymodal = new Vue({
        el: "#mymodal",
        data: {
            headerarea: false,
            theimg: ''
        },
        methods: {
            addimg: function () {
                var me = this;
                $("#uploadfile").click();
                $("#uploadfile").change(function () {
                    var objUrl = getObjectURL(this.files[0]);
                    if (objUrl) {
                        me.headerarea = true;
                        me.theimg = objUrl;
                    }
                });
            },
            // 修改头像
            changesubmit: function () {
                var me = this;
                var uploadFile = $('#uploadfile').val();
                if (uploadFile.trim() === '' || uploadFile.trim() === null) {
                    alert('请选择你要上传的头像.');
                    return;
                }
                console.log(uploadFile);
                $("#change_headerpic_form").ajaxSubmit({
                    url: 'info/updatemyheader.do',
                    type: 'post',
                    success: function (result) {
                        if (result === -1) {
                            location.href = '/';
                            alert('登陆信息过期，请重新登陆');
                            return;
                        } else if (result === 0) {
                            alert('上传头像失败，请稍后再试');
                            return;
                        }
                        location.reload(true);
                    }
                });
            },
            cancel: function () {
                this.headerarea = false;
                this.theimg = '';
            }
        }
    });

    // 我发布过的商品
    var myreleased = new Vue({
        el: '#releasegoods',
        data: {
            mygoods: [],
            show_hidden: false
        },
        created: function () {
            this.get_myreleased();
        },
        methods: {
            get_id: function (g_id) {
                this.show_hidden = true;
                document.body.style.overflow = 'hidden';
                goods_id = g_id;

            },
            /**
             * 下架
             */
            not_sell: function () {
                var me = this;
                $.post('/goods/offgoods.do', {
                    g_id: goods_id,
                }, function (affectRows) {
                    if (affectRows > 0) {
                        me.show_hidden = false;
                        me.get_myreleased();
                        actionTip(true);
                    } else {
                        location.href = '/error.html';
                    }
                })
            },
            /**
             * 重新上架
             * @param g_id
             */
            grounding_goods: function (g_id) {
                var me = this;
                $.post('/goods/ongoods.do', {g_id: g_id}, function (affectRows) {
                    if (affectRows > 0) {
                        /*alert("重新上架成功");*/
                        actionTip(true);
                        me.get_myreleased();
                    } else {
                        actionTip(false);
                    }
                })
            },
            /**
             * 已售出
             */
            already_sell: function () {
                var me = this;
                $.post('/sellcount/addcount.do', {
                    g_id: goods_id,

                }, function (affectRows) {
                    if (affectRows > 0) {
                        alert("感谢您对简买的支持");
                        me.get_myreleased();
                        me.show_hidden = false;
                    } else {
                        actionTip(false);
                    }
                })
            },

            close_modal: function () {
                this.show_hidden = false;
                document.body.style.overflow = 'scroll';
            },

            get_myreleased: function () {
                var me = this;
                $.post('/goods/getmygoods.do', function (goods) {
                    var str;
                    for (var i = 0; i < goods.length; i++) {
                        if (goods[i].g_desc.length > 43) {
                            str = stringCut(goods[i].g_desc);
                            goods[i].g_desc = str;
                        }
                    }
                    me.mygoods = goods;
                });
            }

        }
    })
});


//我收藏过的商品
var mycolleced = new Vue({
    el: '#collected-goods',
    data: {
        mycollected: []
    },
    created: function () {
        this.getmycollectd();
    },
    methods: {
        /**
         * 取消收藏
         * @param g_id
         */
        remove_collect: function (g_id) {
            var res = confirm("确认不再收藏该商品？");
            if (!res) {
                return;
            } else {
                var me = this;
                $.post('collect/removecollect.do', {
                    g_id: g_id
                }, function (affectRows) {
                    if (affectRows > 0) {
                        me.getmycollectd();
                        actionTip(true);
                    } else {
                        actionTip(false);
                        return;
                    }
                })
            }
        },
        /**
         * 得到我收藏的二手商品
         */
        getmycollectd: function () {
            var me = this;
            $.post('collect/getmycollected.do', function (collect_goods) {
                var str;
                for (var i = 0; i < collect_goods.length; i++) {
                    if (collect_goods[i].goods.g_desc.length > 45) {
                        str = stringCut(collect_goods[i].goods.g_desc);
                        collect_goods[i].goods.g_desc = str;
                    }
                }
                me.mycollected = collect_goods;
            })
        },

    }
});


// 我发布过的求购商品
var mywant = new Vue({
    el: "#want-goods",
    data: {
        allWants: []
    },
    created: function () {
        this.getmywant();
    },
    methods: {
        getmywant: function () {
            var me = this;
            $.post('want/getmywant.do', function (wants) {
                me.allWants = wants;
            })
        },

        /**
         * 上架或下架求购信息
         * @param w_id
         * @param state
         */
        re_grounding: function (w_id, state) {
            if (state === 1) {
                state = 2;
            } else if (state === 2) {
                state = 1;
            }
            var me = this;
            $.post('/want/regrounding.do', {w_id: w_id, state: state}, function (affectRows) {
                if (affectRows > 0) {
                    actionTip(true);
                    me.getmywant();
                    return;
                } else {
                    actionTip(false);
                }
            })
        }
    }
})


//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}
// 如果商品描述大于一定长度，以引号省略
function stringCut(desc) {
    var str = desc.substring(0, 43) + '...';
    return str;
}

// 操作提示

function actionTip(flag) {
    if (flag) {
        $('#success-tip').slideDown();
        setTimeout(function () {
            $('#success-tip').slideUp();
        }, 2000);
        document.body.style.overflow = 'scroll';
        return;
    } else {
        $('#error-tip').slideDown();
        setTimeout(function () {
            $('#error-tip').slideUp();
        }, 2000);
        document.body.style.overflow = 'scroll';
    }

}
