<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "bean.*"%>
    <%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/messages_zh.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<style type="text/css">
	.a{color:red;font-weight:bold;}
	.b{font-weight:bold;}
	label.error{color: red;}
</style>
<style type="text/css">
        .wordCount{ position:relative;width: 600px; }
        .wordCount textarea{ width: 100%; height: 100px;}
        .wordCount .wordwrap{ position:absolute; right: 6px; bottom: 6px;}
        .wordCount .word{ color: red; padding: 0 4px;;}
        .wordCount2{ position:relative;width: 600px; }
        .wordCount2 textarea{ width: 100%; height: 100px;}
        .wordCount2 .wordwrap2{ position:absolute; right: 6px; bottom: 6px;}
        .wordCount2 .word2{ color: red; padding: 0 4px;;}
    </style>
<script type="text/javascript">
	$().ready(
			function(){
				$("#form").validate({
					rules:{
						//技术需求名称
						nd_name:{
							required:true
						},
						//重大需求概述
						nd_gs:{
							maxlength:500
						},
						//机构简介
						jgjj:{
							maxlength:200
						},
						//电话
						phone:{
							number:true
						}
					},
					messages : {
						nd_name:{
							required : "技术需求名称不能为空"
						},
						nd_gs:{
							maxlength:"不能超过500字"
						},
						jgjj:{
							maxlength:"不能超过200字"
						},
						phone:{
							number:"必须输入数字"
						}
					}
				});
			});
	
	function disable()
	  {
	    document.getElementById("ssly1").disabled="";
	   //或者document.getElementById("checkbox").disabled=false;
	    document.getElementById("ssly2").disabled="";
	    document.getElementById("ssly3").disabled="";
	    document.getElementById("ssly4").disabled="";
	    document.getElementById("ssly5").disabled="";
	    document.getElementById("ssly6").disabled="";
	    document.getElementById("ssly7").disabled="";
	    document.getElementById("ssly8").disabled="";
	    document.getElementById("ssly9").disabled="";
	    document.getElementById("ssly10").disabled="";
	  }
	function disableOpen()
	  {
	    document.getElementById("ssly1").disabled=true;
	    document.getElementById("ssly2").disabled=true;
	    document.getElementById("ssly3").disabled=true;
	    document.getElementById("ssly4").disabled=true;
	    document.getElementById("ssly5").disabled=true;
	    document.getElementById("ssly6").disabled=true;
	    document.getElementById("ssly7").disabled=true;
	    document.getElementById("ssly8").disabled=true;
	    document.getElementById("ssly9").disabled=true;
	    document.getElementById("ssly10").disabled=true;
	  }
</script>
<%
	UserBean userBean = (UserBean)session.getAttribute("userBean");
	if(userBean==null){
		String msg="未登录，请登陆后再进行填报！";
%>
	<script>window.alert('<%=msg%>');</script>
		response.Write("<script language='JavaScript'>parent.window.location='/Test2/user/login.jsp';</script>") ;
<%
	}else{
%>
</head>
<body>
	<div class = "container">
	<h3 class="text-center">河北省重大技术需求征集表</h3>
	<div class= "col-md-10 col-md-push-1">
	<form id = "form" role = "form" class = "form" method = "post" action = "${pageContext.request.contextPath }/servlet/needServlet?method=addNeed">
	<table class = " table table-bordered ">
		<tr>
			<td><lable for = "jgmc"><span class="a">*</span><span class="b">机构名称</span></lable></td>
			<td colspan = "5"><input type = "text" name = "jgmc" value=<%=userBean.getInstitution()%> style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><lable for = "txdz"><span class="a">*</span><span class="b">通讯地址</span></lable></td>
			<td colspan = "5"><input type = "text" name = "txdz" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><lable for = "dwwz"><span class="b">单位网址</span></lable></td>
			<td colspan = "1"><input type = "text" name = "dwwz" style = "width:100%;height:20px;border:none;outline:none;"></td>
			<td><lable for = "email"><span class="b">电子邮箱</span></lable></td>
			<td colspan = "2"><input type = "text" name = "email" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td rowspan = "2"><lable for = "lxr"><span class="a">*</span><span class="b">联系人</span></lable></td>
			<td rowspan = "2"><input type = "text" name = "lxr" style = "width:100%;height:20px;border:none;outline:none;"></td>
			<td><lable for = "phone"><span class="a">*</span></lable><span class="b">电话</span></lable></td>
			<td colspan = "3"><input type = "text" name = "phone" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr><td><lable for = "cz"><span class="b">传真</span></lable></lable></td>
			<td colspan = "3"><input type = "text" name = "cz" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><span class="a">*</span><span class="b">机构属性</span></td>
			<td colspan = "5">
				<input type = "checkbox" name  = "jgsx" value = "1">企业
				<input type = "checkbox" name  = "jgsx" value = "2">高等院校
				<input type = "checkbox" name  = "jgsx" value = "3">研究机构
				<input type = "checkbox" name  = "jgsx" value = "4">其他
			</td>
		</tr>
		<tr>
			<td colspan = "6" ><div class="wordCount2" id="wordCount2"><textarea name = "jgjj" class = "textarea" placeholder="机构简介（单位基本情况，研究基础等，限200字）" style = "width:100%;height:120px;border:none;outline:none;"></textarea>
			<span class="wordwrap2"><var class="word2">200</var>/200</span></div>
			</td>
		</tr>
		<tr>
			<td><lable for = "nd_name"><span class="a">*</span><span class="b">技术需求名称</span></lable></td>
			<td colspan = "5"><input type = "text" name = "nd_name" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td colspan = "6" ><div class="wordCount" id="wordCount"><textarea name = "nd_gs" class = "textarea" placeholder="重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）" style = "width:100%;height:120px;border:none;outline:none;" ></textarea>
			<span class="wordwrap"><var class="word">500</var>/500</span></div>
			</td>
		</tr>
		<tr>
			<td><lable for = "key"><span class="a">*</span></lable><span class="b">关键字</span></lable></td>
			<td colspan = "5"><input type = "text" name = "key" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><span class="a">*</span><span class="b">研究类型</span></td>
			<td colspan = "5">
				<input type = "radio" id="yjlx" name  = "yjlx" value = "1" onclick=  "disableOpen();this.form.xkfl.disabled  =  !this.checked;this.form.yyhy.disabled  =  this.checked;">基础研究
				<input type = "radio" id="yjlx" name  = "yjlx" value = "2" onclick=  "disable();this.form.yyhy.disabled  =  !this.checked;this.form.xkfl.disabled  =  this.checked;">应用研究
				<input type = "radio" id="yjlx" name  = "yjlx" value = "3" onclick=  "disable();this.form.ssly.disabled  =  !this.checked;this.form.yyhy.disabled  =  !this.checked;this.form.xkfl.disabled  =  this.checked;">试验发展
				<input type = "radio" id="yjlx" name  = "yjlx" value = "4" onclick=  "disable();this.form.ssly.disabled  =  !this.checked;this.form.yyhy.disabled  =  !this.checked;this.form.xkfl.disabled  =  this.checked;">研究发展与成果应用
				<input type = "radio" id="yjlx" name  = "yjlx" value = "5" onclick=  "disable();this.form.ssly.disabled  =  !this.checked;this.form.yyhy.disabled  =  !this.checked;this.form.xkfl.disabled  =  this.checked;">技术推广与科技服务
			</td>
		</tr>
		<tr>
			<td><lable for = "xkfl" ><span class="b">学科分类</span></lable></td>
			<td colspan = "5"><input type = "text" name = "xkfl" disabled style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><span class="b">需求技术所属领域</span></td>
			<td colspan = "5">
				<input type =  "checkbox"   id = "ssly1" disabled name = "ssly" value = "1">电子信息技术
				<input type =  "checkbox"   id = "ssly2" disabled name = "ssly" value = "2">光电一体化
				<input type =  "checkbox"   id = "ssly3" disabled name = "ssly" value = "3">软件
				<input type =  "checkbox"   id = "ssly4" disabled name = "ssly" value = "4">生物制药技术
				<input type =  "checkbox"   id = "ssly5" disabled name = "ssly" value = "5">新材料及应用技术
				<input type =  "checkbox"   id = "ssly6" disabled name = "ssly" value = "6">先进制造技术
				<input type =  "checkbox"   id = "ssly7" disabled name = "ssly" value = "7">现代农业技术
				<input type =  "checkbox"   id = "ssly8" disabled name = "ssly" value = "8">新能源与高校节能技术
				<input type =  "checkbox"   id = "ssly9" disabled name = "ssly" value = "9">资源与环境保护新技术
				<input type =  "checkbox"   id = "ssly10" disabled name = "ssly" value = "10">其他技术
			</td>
		</tr>
		<tr>
			<td><lable for = "yyhy"><span class="b">需求技术应用行业</span></lable></td>
			<td colspan = "5"><input type = "text" disabled name = "yyhy" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td><span class="a">*</span><span class="b">技术需求合作模式</span></td>
			<td colspan = "5">
				<input type =  "checkbox" name = "hzms" value = "1">独立开发
				<input type =  "checkbox" name = "hzms" value = "2">技术转让
				<input type =  "checkbox" name = "hzms" value = "3">技术入股
				<input type =  "checkbox" name = "hzms" value = "4">合作开发
				<input type =  "checkbox" name = "hzms" value = "5">其他
			</td>
		</tr>
		<tr>
			<td rowspan = "2"><span class="b">项目资金需求及来源</span></td>
			<td><span class="b">计划总投资</td>
			<td><input type = "text" name = "ztz" style = "width:100%;height:20px;border:none;outline:none;"></td>
			<td><span class="b">企业自筹</td>
			<td><input type = "text" name = "qyzc" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>

			<td><span class="b">银行贷款</td>
			<td><input type = "text" name = "yhdk" style = "width:100%;height:20px;border:none;outline:none;"></td>
			<td><span class="b">其他融资</td>
			<td><input type = "text" name = "qtrz" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>

	</table>
	<div>
	<button class = "btn btn-primary "  type = "submit" style = "margin-left:90%;">提交</button>
	</div>
	</form>
	<div class = "col-md-12">
		<c:if test="${param.status==1 }">
			<div class= "alert alert-success">
				添加成功！
			</div>

		</c:if>
		<c:if test="${param.status==2 }">
			<div class= "alert alert-danger">
				添加失败！
			</div>

		</c:if>
	</div>
	</div>
	</div>
<script src="http://lib.sinaapp.com/js/jquery/1.10.2/jquery-1.10.2.min.js"></script>
<script>
    $(function(){
    	var wordCount2 = $("#wordCount2"),
        textArea2 = wordCount2.find("textarea"),
        word2 = wordCount2.find(".word2");
    	
    	statInputNum(textArea2,word2);
        //先选出 textarea 和 统计字数 dom 节点
        var wordCount = $("#wordCount"),
        textArea = wordCount.find("textarea"),
        word = wordCount.find(".word");
        //调用
        statInputNum(textArea,word);

    });
    /*
     * 剩余字数统计
     * 注意 最大字数只需要在放数字的节点哪里直接写好即可 如：<var class="word">200</var>
     */
    function statInputNum(textArea,numItem) {
        var max = numItem.text(),
                curLength;
        textArea[0].setAttribute("maxlength", max);
        curLength = textArea.val().length;
        numItem.text(max - curLength);
        textArea.on('input propertychange', function () {
            var _value = $(this).val().replace(/\n/gi,"");
            numItem.text(max - _value.length);
        });
    }
</script>
</body>
<%} %>
</html>
