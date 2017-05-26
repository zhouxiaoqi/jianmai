/**
 * Created by zhouqi on 2017/4/16.
 */
window.onload = function () {

    var releasewant = new Vue({
        el: "#release-want",
        data: {},
        methods: {
            want_submit: function () {
                $('#want-form').validator({
                    rules: {
                        money: [/^(?!0\.00)(?:0|[1-9]\d*)(?:\.\d{1,2})?$/, "请填写有效的金额"]
                    },
                    fields:{
                        'w_name':'required;length(4~20)',
                        'w_desc':'required;length(12~)',
                        'w_price':'required;money',
                        'w_place':'required',
                        'w_phonenum':'mobile',
                        'w_qq':'qq'
                    },
                    valid:function (form) {
                        if($('#w_phonenum').val().trim() === '' && $('#w_qq').val().trim() === ''){
                            alert("至少选填一个联系方式");
                            return;
                        }
                        var res = confirm('确认信息无误并且发布吗？');
                        if (!res) {
                            return;
                        }
                        form.submit();
                    }
                })
            },
            update_submit:function () {
                var re = confirm("修改后会进入1～3天的审核期，确认修改吗");
                if(!re){
                    return
                }else{
                    this.want_submit();
                }
            }
        }
    })
}