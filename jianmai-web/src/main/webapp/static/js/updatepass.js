/**
 * Created by zhouqi on 2017/5/1.
 */
window.onload = function () {
    var updatepass = new Vue({
        el: "#updatepass",
        data: {},
        methods: {
            updateSubmit: function () {
                if ($('#password').val().trim() === '' || $('#repassword').val().trim() === '') {
                    alert("不能为空");
                    return;
                } else if ($('#password').val().trim().length < 6 || $('#repassword').val().trim().length < 6) {
                    alert("密码至少六位字符以上");
                    return;
                } else if ($('#password').val().trim() !== $('#repassword').val().trim()) {
                    alert("两次密码不一致");
                    return;
                }
                $('#update-form').ajaxSubmit({
                    url: '/account/updatepass.do',
                    type: 'post',
                    success: function (affectedRows) {
                        if(affectedRows >= 1){
                            alert("修改成功，回到首页后重新登陆");
                            location.href = '/index.html';
                            return;
                        }else{
                            alert("服务器异常，稍后再试");
                        }
                    }
                })
            }
        }
    })
}