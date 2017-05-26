$(function ($) {

    var releasepicture = new Vue({
        el: "#release-picture",
        data: {
            plusone: true,
            plustwo: true,
            plusthree: true,
            plusfour: true,
            pictureoneurl: '',
            picturetwourl: '',
            picturethreeurl: '',
            picturefoururl: '',
            hideimg1: false,
            hideimg2: false,
            hideimg3: false,
            hideimg4: false,
        },
        methods: {
            loadpicture1: function () {
                releaseform.file1();
            },
            loadpicture2: function () {
                releaseform.file2();
            },
            loadpicture3: function () {
                releaseform.file3();
            },
            loadpicture4: function () {
                releaseform.file4();
            }
        }
    });


    /**
     * 表单
     */
    var releaseform = new Vue({
        el: "#release-form",
        data: {
            files: false,
            checked: false,
            alltypes: []
        },
        created: function () {
            var me = this;
            $.post('goods/gettypes.do', function (types) {
                me.alltypes = types;
            })
        },
        methods: {
            file1: function () {
                $('#file1').click();
                $('#file1').change(function () {
                    var objurl = getObjectURL(this.files[0]);
                    if (objurl) {
                        releasepicture.plusone = false;
                        releasepicture.pictureoneurl = objurl;
                        releasepicture.hideimg1 = true;
                    }
                });
            },
            file2: function () {
                $("#file2").click();
                $('#file2').change(function () {
                    var objurl = getObjectURL(this.files[0]);
                    if (objurl) {
                        releasepicture.plustwo = false;
                        releasepicture.picturetwourl = objurl;
                        releasepicture.hideimg2 = true;
                    }
                });
            },
            file3: function () {
                $("#file3").click();
                $('#file3').change(function () {
                    var objurl = getObjectURL(this.files[0]);
                    if (objurl) {
                        releasepicture.plusthree = false;
                        releasepicture.picturethreeurl = objurl;
                        releasepicture.hideimg3 = true;
                    }
                });
            },
            file4: function () {
                $("#file4").click();
                $('#file4').change(function () {
                    var objurl = getObjectURL(this.files[0]);
                    if (objurl) {
                        releasepicture.plusfour = false;
                        releasepicture.picturefoururl = objurl;
                        releasepicture.hideimg4 = true;
                    }
                });
            },
            // 发布二手商品
            release_submit: function () {
                if (this.checked === false) {
                    alert("请先同意发布规则！");
                }

                $('#release-form').validator({
                    rules: {
                        money: [/^(?!0\.00)(?:0|[1-9]\d*)(?:\.\d{1,2})?$/, "请填写有效的金额"]
                    },
                    fields: {
                        'g_name': 'required;length(4~20)',
                        'g_desc': 'required:length(12~)',
                        'g_place': 'required',
                        'g_price': 'required money',
                        'g_bargain': 'required',
                        'type': 'required',
                        'g_phonenum': 'mobile',
                        'g_qq': 'qq'
                    },
                    valid: function (form) {
                        if ($('#file1').val().trim() === ''
                            && $('#file2').val().trim() === ''
                            && $('#file3').val().trim() === ''
                            && $('#file4').val().trim() === '') {
                            alert('至少上传一张商品照片');
                            return;
                        }
                        if ($('#phonenum').val().trim() === '' && $('#qq').val().trim() === '') {
                            alert('至少留下一个联系方式');
                            return;
                        }
                        var res = confirm('确认信息无误并且发布吗？');
                        if (!res) {
                            return;
                        }
                        form.submit();
                    },

                })
            },

            // 修改二手商品
            update_submit: function () {
                $('#release-form').validator({
                    rules: {
                        money: [/^(?!0\.00)(?:0|[1-9]\d*)(?:\.\d{1,2})?$/, "请填写有效的金额"]
                    },
                    fields: {
                        'g_name': 'required;length(4~20)',
                        'g_desc': 'required:length(12~)',
                        'g_place': 'required',
                        'g_price': 'required money',
                        'g_bargain': 'required',
                        'type': 'required',
                        'g_phonenum': 'mobile',
                        'g_qq': 'qq'
                    },
                    valid: function (form) {
                        if ($('#phonenum').val().trim() === '' && $('#qq').val().trim() === '') {
                            alert('至少留下一个联系方式');
                            return;
                        }
                        var res = confirm('提交后会重新进行审核，确认提交吗？');
                        if (!res) {
                            return;
                        }
                        form.submit();
                    },
                });
            },
        }
    });
});

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
