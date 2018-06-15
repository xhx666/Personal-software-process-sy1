<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/messages_zh.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/distpicker.min.js"></script>
<style type="text/css">
	.a{color:red;font-weight:bold;}
	.b{font-weight:bold;}
	 label.error{color: red;}
</style>
<!-- 利用jquery的validate验证（这种验证方法简单便捷） -->

<script type="text/javascript">
	function setFocus(){
		form.username.focus();
	}
	$().ready(
			function(){
				$("#form").validate({
					rules:{
						username:{
							required:true
						},
						password:{
							required:true,
							minlength:6
						},
						password1:{
							required:true,
							equalTo:"#password"
						},
						phone:{
							required:true,
							rangelength:[11,11],
							digits:true
						},
						workplace:{
							required:true
						},
						institution:{
							required:true
						},
						truename:{
							required:true
						},
						userid:{
							required:true,
							rangelength:[18,18]
						},
					},
					messages : {
						username:{
							required : "用户姓名不能为空"
						},
						password:{
							required:"密码不能为空",
							minlength:"密码最少为6位"
						},
						password1:{
							required:"重复密码不能为空",
							equalTo:"重复密码需要和密码相同"
						},
						phone:{
							required:"联系电话不能为空",
							rangelength:"电话号码为11位数字",
							digits:"电话号码只能是数字"
						},
						workplace:{
							required:"所属单位不能为空"
						},
						institution:{
							required:"组织机构不能为空"
						},
						truename:{
							required:"真实姓名不能为空"
						},
						userid:{
							required:"身份证号不能为空",
							rangelength:"身份证号为18位"
						},
					}
				});
			});
</script>
</head>
<body  onload="setFocus()">
	<div class = "container">
	<div style = "height:30px"></div>

	<h3 class = "text-center">用户注册界面</h3>
	<div class = "col-md-6 col-md-push-3">
		<form action = "${pageContext.request.contextPath }/servlet/UserServlet?method=register" method = "post" class = "form" id = "form" name="form">
			<div class = "form-group">
				<span class="a">*</span><span class="b" >用户姓名:</span><input type ="text" class = "form-control" name = "username" placeholder = "不能为空">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">密码：</span><input type = "password" class = "form-control" id = "password" name = "password" placeholder = "密码(至少6位)">
			</div>
			<div class = "form-group">
				<span class="a">*</span><span class="b">重复密码：</span><input type = "password" class = "form-control" name = "password1" placeholder = "重复密码(至少6位)">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">所属单位：</span><input type = "text" class = "form-control" name = "workplace" placeholder = "不能为空">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">组织机构：</span><input type = "text" class = "form-control" name = "institution" placeholder = "不能为空">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">真实姓名：</span><input type = "text" class = "form-control" name = "truename" placeholder = "不能为空">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">身份证号：</span><input type = "text" class = "form-control" name = "userid" placeholder = "身份证号请输入18位">
			</div>
			<div class = "form-group">
				<span class="a" ">*</span><span class="b">手机号码：</span><input type = "text" class = "form-control" name = "phone" placeholder = "请输入11位手机号码">
			</div>
			<div class="form-group">
				<span class="a">*</span><span class="b">所在地域：</span>
			<div data-toggle="distpicker">
                <select data-province="---- 选择省 ----" class="form-control" ></select>
                <select data-city="---- 选择市 ----" class="form-control"></select>
                <select data-district="---- 选择区 ----" class="form-control"></select>
            </div>
			</div>
			<button type = "submit" class = "btn btn-primary" style = "margin-left:70%;">提交</button>
			<a href = "./login.jsp" class = "btn btn-primary" target= "_parent" >登录</a><!-- 在父框架集中打开 -->
		</form>
		<div class = "col-md-12">
		<c:if test="${param.status==1 }">
			<div class= "alert alert-success">
				注册成功！
			</div>

		</c:if>
		<c:if test="${param.status==2 }">
			<div class= "alert alert-danger">
				注册失败！
			</div>

		</c:if>
		<c:if test="${param.status==3 }">
			<div class= "alert alert-danger">
				用户名已存在！
			</div>

		</c:if>
	</div>
		</div>
	</div>
</body>
</html>