/**
 * Created by zhouqi on 2017/4/2.
 */
document.onreadystatechange = function () {
    var loading = document.getElementById('loading');
    var content = document.getElementById('goods');
    if (document.readyState === 'complete') {
        loading.style.display = 'none';
        content.style.display = 'block';
        document.body.style.backgroundColor = '#E3EEEC';
    } else {
        loading.style.display = 'block';
        content.style.display = 'none';
        document.body.style.backgroundColor = '#fff';
    }
}

window.onload = function () {

    var my_action = new Vue({
        el: '#my_action',
        data: {
            isCollect: ''
        },
        created: function () {
            this.getcollect();
        },
        methods: {
            switch_pic: function (evnet) {
                var el = evnet.currentTarget;
                var thisImg = $(el)[0].children[0];
                $('#loading-pic')[0].children[0].src = thisImg.src;
            },
            collect: function () {
                var me = this;
                $.post('collect/collectgoods.do', {g_id: $('#g_id').val()}, function (affectRows) {
                    if (affectRows > 0) {
                        alert('收藏成功');
                        me.getcollect();
                    } else {
                        alert("服务器异常，请稍后再试");
                        return;
                    }
                });
            },
            remove_collect: function () {
                var me = this;
                $.post('collect/removecollect.do', {g_id: $('#g_id').val()}, function (affectRows) {
                    if (affectRows > 0) {
                        alert('取消成功');
                        me.getcollect();
                    } else {
                        alert("服务器异常，请稍后再试");
                        return;
                    }
                });
            },
            getcollect: function () {
                var me = this;
                $.post('collect/getcollect.do', {g_id: $('#g_id').val()}, function (result) {
                    if (result === -1) {
                        return;
                    }else{
                        console.log(result);
                        me.isCollect = result;
                    }
                })
            },
            report: function () {
                $.post('/report/insertreport.do', {g_id: $('#g_id').val()}, function (result) {
                    if(result === 1){
                        alert("举报成功，我们会尽快处理");
                    }else {
                        alert("请稍后再试");
                    }
                })
            }
        }
    });

    var advertisement = new Vue({
        el: "#advertisement",
        data: {
            advers: []
        },
        created: function () {
            var me = this;
            $.post('/advers/getall.do', function (advers) {
                me.advers = advers;
            })
        }
    })
};


/*'/gd/getuinfo.do'*/