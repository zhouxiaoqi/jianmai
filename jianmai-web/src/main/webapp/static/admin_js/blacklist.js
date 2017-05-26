/**
 * 黑名单
 */

$(function($){
	var blacklist = new Vue({
		el:"#blacklist_users",
		data:{
			blacklists:[]
		},
		created:function(){
			this.get_all_blacklist_user();
		},
		methods:{
			get_all_blacklist_user:function(){
				var me = this;
				$.post('blacklistmanage/getallblacklist.do',function(data){
					me.blacklists = data;
				})
			},
			remove_user:function(b_id){
				var me = this;
				$.post('blacklistmanage/removeblacklist/' + b_id + '.do',function(result){
					if(result === 1){
						alert("移除成功");
						me.get_all_blacklist_user();
					}else{
						alert("移除失败，请稍后再试");
					}
				});
			}
		}
	})
})