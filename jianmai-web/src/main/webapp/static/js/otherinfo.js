/**
 * Created by zhouqi on 2017/4/15.
 */
window.onload = function () {


    var otheruser = new Vue({
        el: "#other-user",
        data: {
            goodsList: [],
            goodscount:''
        },
        created: function () {
            var me = this;
            $.post('/goods/getotherusergoods.do', {a_id: $('#a_id').val()}, function (goods) {
                me.goodsList = goods;
                me.goodscount = goods.length;
            })
        }
    })
}