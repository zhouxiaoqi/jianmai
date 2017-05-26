/**
 *
 */
$(function ($) {
    var want = new Vue({
        el: "#want",
        data: {
            busy: false,
            wantInfo: [],
            advers: []
        },
        created: function () {
            var me = this;
            $.post("/want/getwants.do", function (wantinfo) {
                me.wantInfo = wantinfo;
            });
            $.post('/advers/getall.do', function (advers) {
                me.advers = advers;
            })

        },
        methods: {}
    });
});