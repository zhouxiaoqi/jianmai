/**
 * 
 */
$(function($){
	var a_id,a_email;
	var usermanage = new Vue({
		el:"#userManage",
		data:{
			userinfos:[],
			s_email:'',
			toggle_mask:false,
			add_blacklist_email:'',
			other_reason:'',
		},
		created:function(){
			this.get_all_user();
		},
		methods:{
			get_all_user:function(){
				var me = this;
				$.post('usermanage/getalluserinfo.do',function(data){
					me.userinfos = data;
					console.log(me.userinfos);
				})
			},
			search_by_email:function(){
				var me = this;
				$.post('usermanage/getuserinfobyemail.do',{email:this.s_email},function(data){
					if(data !== null && data !== ''){
						me.userinfos.splice(0,me.userinfos.length);
						me.userinfos.push(data);
					}else{
						alert("没有此用户");
					}
				})
			},
			get_id_email: function(id,email){
				a_id = id;
				a_email = email;
				this.toggle_mask = true;
				this.add_blacklist_email = email;
			},
			get_Value:function(){
				var radios = document.getElementsByName('reason');
				for(var i = 0;i < radios.length; i++){
					if(radios[i].checked){
						this.other_reason = radios[i].value;
					}
				}
			},
			add_blacklist:function(){
				var me = this;
				if(this.other_reason === ''){
					alert("请选择或填写封号原因...");
				}else{
					$.post('blacklistmanage/insertblacklist.do',{a_id:a_id,reason:this.other_reason},function(result){
						if(result === 1){
							alert("封号成功，可在黑名单选项查看详情");
							//location.reload(true);
							me.get_all_user();
							me.toggle_mask = false;
						}else{
							alert("封号失败，请稍后再试");
						}
					});
				}
			},
			close_mask:function(){
				this.toggle_mask = false;
			}
		}
	})
});