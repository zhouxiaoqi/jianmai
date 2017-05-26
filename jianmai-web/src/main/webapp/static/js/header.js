/**
 *
 */
function search() {
    alert("!33");
    $('#search-form').submit();
}

$(function ($) {
    // vueJS
    var myheader = new Vue({
        el: "#myheader",
        data: {},
        methods: {}

    });

    var login = new Vue({
        el: "#loginmodal",
        data: {
            email: "", // 登陆的邮箱
            password: "", // 登陆的密码
            errormsg: "",
        },
        methods: {
            goregist: function () {
                $("#loginmodal").modal('hide');
                $("#registmodal").modal('show');
            },
            loginsubmit: function () {
                var me = this;
                if (this.email === '' || this.password === '') {
                    alert("邮箱或密码不能为空");
                } else {
                    $('#login-form').ajaxSubmit({
                        url: 'account/login.do',
                        type: 'post',
                        success: function (result) {
                            if (result === 1) {
                                location.reload(true);
                                return;
                            }
                            alert('账户或密码错误');
                        }
                    })
                }
            },
        }
    });

    var regist = new Vue({
        el: "#registmodal",
        data: {
            r_nickname: "", // 注册的昵称
            r_email: "", // 注册的邮箱
            r_password: "", // 注册密码
            r_repassword: "", // 注册重复密码
            isActive: false,
            btn_value: '注册简买'
        },
        methods: {
            gologin: function () {
                $("#registmodal").modal('hide');
                $("#loginmodal").modal('show');
            },
            registsubmit: function () {
                var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
                var token = $("#token").val();
                var me = this;
                if (this.r_nickname === '' || this.r_email === ''
                    || this.r_password === '' || this.r_repassword === '') {
                    alert("请完整填写注册信息");
                } else if (this.r_email !== '' && !reg.test(this.r_email)) {
                    alert("邮箱格式不正确");
                } else if (this.r_password.length < 6) {
                    alert("密码不能低于六位")
                } else if (this.r_password !== this.r_repassword) {
                    alert("输入的两次密码不一致");
                } else {
                    $.post('account/validate.do', {email: this.r_email}, function (data) {
                        if (data === 1) {
                            me.isActive = true;
                            me.btn_value = '加载中...';
                            $('#registform').ajaxSubmit({
                                url: 'account/regist.do',
                                type: 'post',
                                success: function (result) {
                                    if (result === 1) {
                                        location.reload(true);
                                        return;
                                    }
                                    alert('好像出错了');
                                }
                            })
                        } else {
                            alert('该邮箱已被注册');
                        }
                    })
                }
            }
        }
    });
})