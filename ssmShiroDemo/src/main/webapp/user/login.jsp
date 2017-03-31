<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
<link   rel="icon" href="https://open.itboy.net/favicon.ico" type="image/x-icon" />
<link   rel="shortcut icon" href="https://open.itboy.net/favicon.ico" />
<!-- 判断加载那些浏览器 -->
<!--[if lt IE 9]>
          <script src="http://static.supportfolios.com/js/www/html5shiv.js"></script>
<![endif]-->
<script src="http://open.itboy.net/common/MD5.js"></script>
<script  src="${basePath}/js/common/layer/layer.js"></script>
</head>
<body>
	
		邮箱：<input name="account" class="username" placeholder="请输入邮箱"/><br>
		密码：<input name="password" class="password" placeholder="请输入密码"/><br>
		<label><input type="checkbox" checked="checked"  id="rememberMe"style="width: 10px; height: 10px;">记住我</label><br>
		<button type="button" id ="login"  > 登录</button>
		<button type="button" id="register" class="register">${basePath}注册</button>
	 <script >
			jQuery(document).ready(function() {
				try{
					var _href = window.location.href+"";
					if(_href && _href.indexOf('?kickout')!=-1){
						layer.msg('您已经被踢出，请重新登录！');
					}
				}catch(e){
					
				}
				//回车事件绑定
				document.onkeydown=function(event){
					var e = event || window.event || arguments.callee.caller.arguments[0];
					if(e && e.keyCode==13){ 
						$('#login').click();
					}
				}; 
			
				//登录操作
			    $('#login').click(function(){
			    	
			        var username = $('.username').val();
			        var password = $('.password').val();
			        if(username == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '27px').show();
			            });
			            $('.error').fadeIn('fast', function(){
			                $('.username').focus();
			            });
			            return false;
			        }
			        if(password == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '96px').show();
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $('.password').focus();
			            });
			            return false;
			        }
			        var pswd = MD5(username +"#" + password),
			        	data = {pswd:pswd,email:username,rememberMe:$("#rememberMe").is(':checked')};
			        var load = layer.load();
			        $.post("${basePath}/u/submitLogin.action",data ,function(result){
			        	layer.close(load);
			    		if(result && result.status != 200){
			    			layer.msg(result.message,function(){});
			    			$('.password').val('');
			    			return;
			    		}else{
			    			layer.msg('登录成功！');
			    			setTimeout(function(){
			    				//登录返回
			    				alert(""+result.back_url);
				    			window.location.href= result.back_url || "${basePath}/";
			    			},1000)
			    		}
			    	},"json");
			        
			    });
			    $('.page-container form .username, .page-container form .password').keyup(function(){
			        $(this).parent().find('.error').fadeOut('fast');
			    });
			    //注册
			    $("#register").click(function(){
			    	window.location.href="register.jsp";
			    });
			});
        </script>
</body>
</html>