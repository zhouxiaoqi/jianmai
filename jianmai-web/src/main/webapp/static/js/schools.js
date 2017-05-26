/**
 * Created by zhouqi on 2017/3/22.
 */
window.onload = function () {

    var schools = new Vue({
        el: "#schools-list",
        data: {
            allSchool: []
        },
        created(){
            var me = this;
            $.post('school/allschool.do', function (schools) {
                me.allSchool = schools;
            })
        }
    })
}