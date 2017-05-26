$(function ($) {

    // li 追加 active
    $('#sort_menu li a').click(function () {
        $('#sort_menu li a').css('color', '#999696');
        $(this).css('color', '#4BC0A5');
    })

    var typeinfo = new Vue({
        el: "#typeinfo",
        data: {
            goodsList: [],
            show_hidden: false,
            only_myshcool: 0,       //只看本校
            countGoods: ''
        },
        created: function () {
            this.get_all_typegoods();

            this.count_type_goods();
        },
        methods: {
            /**
             * 打开只看本校
             */
            open_school_tygoods: function () {
                this.only_myshcool = 1;
                for (var i = 0; i < this.goodsList.length; i++) {
                    if (this.goodsList[i].school.s_id != s_id) {
                        this.goodsList.splice(1, i);
                    }
                }
            },
            /**
             * 取出该类型下所有商品
             */
            get_all_typegoods: function () {
                this.only_myshcool = 0;
                var me = this;
                var loading = $('#loading');
                loading.css('display', 'block');
                $.post('/goods/alltypegoods.do', {t_id: $('#t_id').val(),}, function (goodsList) {
                    for (var i = 0; i < goodsList.length; i++) {
                        goodsList[i].g_name = goodsList[i].g_name.substring(0, 10) + '..';
                    }
                    loading.css('display', 'none');
                    me.goodsList = goodsList;
                })
            },

            only_myschool_off: function () {
                this.only_myshcool = 0;
                this.get_all_typegoods();
            },
            only_myschool_on: function () {
                this.only_myshcool = 1;
                this.get_school_tygoods();
            },

            /**
             * 统计
             */
            count_type_goods: function () {
                var me = this;
                $.post('/goods/countgoods.do', {t_id: $('#t_id').val()}, function (count) {
                    me.countGoods = count;
                })
            }
        }
    })
})


