// 首页
$(function ($) {

    $(".carousel").carousel({
        interval: 4000
    })
    var banner = new Vue({
        el: "#banner",
        data: {
            banners: []
        },
        created: function () {
            var me = this;
            $.post('/advers/getall.do', function (advers) {
                for (var i = 0; i < 5; i++) {
                    me.banners.push(advers[i]);
                }
            })
        },
        methods: {}
    })


    // Vue------
    var left_content = new Vue({
        el: "#left-content",
        data: {
            loadmore_text: '加载更多',
            goods: [],
            currntGoods: [],
            types: [],
            has_more: false,
            currentPage: 1,
            pageSize: 20
        },
        created: function () {
            this.getTypes();
            this.getSchoolGoods();

        },
        methods: {
            load_more: function () {
                this.currentPage += 1;
                this.getSchoolGoods();
            },
            getSchoolGoods: function () {
                var me = this;
                $.post('goods/getgoodsinschool.do', {
                    currentPage: this.currentPage,
                    pageSize: this.pageSize
                }, function (goods) {
                    for (var i = 0; i < goods.length; i++) {
                        if (goods[i].g_name.length > 10) {
                            goods[i].g_name = goods[i].g_name.substring(0, 10) + "..";
                        }
                        me.goods.push(goods[i]);
                    }
                    if (goods.length < 20) {
                        me.has_more = false;
                    } else {
                        me.has_more = true;
                    }
                })
            },
            getTypes: function () {
                var me = this;
                $.post('type/gettypes.do', function (types) {
                    me.types = types;
                })
            }
        }
    });

    var right_content = new Vue({
        el: "#right-content",
        data: {
            config: {},
            helpCount: 0,
            recomments: []
        },
        created: function () {
            var me = this;
            $.post('/sellcount/counthelp.do', function (count) {
                me.helpCount = count;
            })
            this.recomment_goods();
        },
        methods: {
            share_sina: function () {
                window.sharetitle = '快来关注简买，好礼相送送不停!!! @加个小括号_';
                window.shareUrl = 'http://www.zhouqifun.cn/group1/M00/00/00/CocSmFjc47-ANHDfAAAT8s-f7jw94.jpeg';
                share();
            },
            wechat_config: function () {
                var me = this;
                $.post('/wechatconfig.do', function (config) {
                    wx.config({
                        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                        appId: 'wxf9caa71a96f42cb3', // 必填，公众号的唯一标识
                        timestamp: config.timestamp, // 必填，生成签名的时间戳
                        nonceStr: config.noncestr, // 必填，生成签名的随机串
                        signature: config.signature,// 必填，签名，见附录1
                        jsApiList: ['onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                    });
                    wx.error(function () {
                        console.log('失败');
                    });
                    wx.ready(function () {
                        console.log('成功');
                    });
                });
            },
            recomment_goods: function () {
                var me = this;
                $.post('/goods/recomment.do', function (recomments) {
                    me.recomments = recomments;
                })
            }
        }
    })

});


//分享微博
function share() {
    //d指的是window
    (function (s, d, e) {
        try {
        } catch (e) {
        }
        var f = 'http://v.t.sina.com.cn/share/share.php?',
            u = d.location.href,
            p = ['url=', e(u), '&title=', e(window.sharetitle), '&appkey=2317208847', '&pic=', e(window.shareUrl)].join('');

        function a() {
            if (!window.open([f, p].join(''), 'mb', ['toolbar=0,status=0,resizable=1,width=620,height=450,left=', (s.width - 620) / 2, ',top=', (s.height - 450) / 2].join(''))) u.href = [f, p].join('');
        };
        if ((/Chrome/ || /Firefox/).test(navigator.userAgent)) {
            setTimeout(a, 0)
        } else {
            a()
        }
    })(screen, document, encodeURIComponent);
}


// 回到顶部
window.onscroll = function () {
    if (document.body.scrollTop || document.documentElement.scrollTop > 0) {
        document.getElementById("to_top").style.display = 'block';
    } else {
        document.getElementById("to_top").style.display = 'none';
    }
}

document.getElementById('to_top').onclick = function () {
    gotoTop(0.2,10);
}

/**
 2 * JavaScript脚本实现回到页面顶部示例
 3 * @param acceleration 速度
 4 * @param stime 时间间隔 (毫秒)
 5 **/
function gotoTop(acceleration, stime) {
    acceleration = acceleration || 0.1;
    stime = stime || 10;
    var y1 = 0;
    x1 = document.documentElement.scrollLeft || 0;
    y1 = document.documentElement.scrollTop || 0;

    if (document.body) {
        x2 = document.body.scrollLeft || 0;
        y2 = document.body.scrollTop || 0;
    }
    var x3 = window.scrollX || 0;
    var y3 = window.scrollY || 0;

// 滚动条到页面顶部的水平距离
    var x = Math.max(x1, Math.max(x2, x3));
// 滚动条到页面顶部的垂直距离
    var y = Math.max(y1, Math.max(y2, y3));

// 滚动距离 = 目前距离 / 速度, 因为距离原来越小, 速度是大于 1 的数, 所以滚动距离会越来越小
    var speeding = 1 + acceleration;
    window.scrollTo(Math.floor(x / speeding), Math.floor(y / speeding));

// 如果距离不为零, 继续调用函数
    if (x > 0 || y > 0) {
        var run = "gotoTop(" + acceleration + ", " + stime + ")";
        window.setTimeout(run, stime);
    }
}


