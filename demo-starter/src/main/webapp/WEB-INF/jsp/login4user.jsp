<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title><c:if test="${title == ''}">管理平台</c:if><c:if test="${title != ''}">${title}</c:if></title>
<script> var basePath = '${basePath}';</script>

<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/vendor/font-awesome/css/font-awesome.min.css">
<!-- 自定义登入css -->
<link rel="stylesheet" href="/css/loginCss.css">
<!-- jquery confirm -->
<link rel="stylesheet" href="/css/jquery-confirm.css"/>
</head>
<body class="hold-transition login-page">
<div class="container">
        <form action="" method="" id="signInForm" class="form row">
            <div class="form-horizontal" id="login_form">
            <div class="form-group">
                <div class="col-md-5">
	                <i class="fa fa-user fa-lg"></i>
	                <input class="form-control required" type="text" placeholder="试试扣扣账户" id="username" autofocus="autofocus" maxlength="20"
                    style="width: 200px"/>
	            </div>
                <div class="col-md-1"></div>
                <div class="col-md-5">
                	<i class="fa fa-lock fa-lg"></i>
                	<input class="form-control required" type="password" placeholder="请输入密码" id="password"  maxlength="8" style="width: 200px"/>
                </div>
             </div>
             <div class="form-group">
             	<div class="col-md-6"></div>
              	<div class="col-md-2">
                	<button type="button" class="btn btn-danger btn-block" id="signIn" style="width: 200px">登录</button>
              	</div>
              	<div class="col-md-2">
                	<button type="button" class="btn btn-danger btn-block" id="revert" style="width: 200px">重置</button>
              	</div>
             </div>
            </div>
        </form>
    </div>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/base.js"></script>
</body>
</html>
<script>
	$(function(){
		var loginUrl = "/demo/login4info";
		
		$('#signIn').click(function(){
		    alert("123131");
			$.ajax({
				url:loginUrl,
				type:'POST',
				data:{
					userName : $('#username').val(),
					password : $('#password').val(),
					rememberMe : $('#rememberMe').is(':checked')
				},
				success:function(result){
				    if(result == "ok"){
                        location.href="/demo/home";
                    }
					/*if(result.code==0000){
						console.log(result.msg);
						location.href=result.msg;
					}else{
						$.hdConfirm({
							content: result.msg,
							autoClose: 'confirm|3000',
							buttons: {confirm: {text: '取消'}}
						});
					}*/
				},
				error:function(error){
					console.log(error);
				}
			});
		});
		
		$('#register').click(function(){
			$.hdConfirm({
				content:"暂无法注册",
				autoClose: 'confirm|3000',
				buttons:{
					confirm:{text:'确认'}
				}
			});
		});
		
		$('#forgetPassword').click(function(){
			$.hdConfirm({
				content:"请登入后再修改",
				autoClose: 'confirm|3000',
				buttons:{
					confirm:{text:'确认'}
				}
			});
		});
	});
</script>