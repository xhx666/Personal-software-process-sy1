<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jQuery treeview</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/jquery.treeview.css" />


<script src="${pageContext.request.contextPath }/static/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.async.js" type="text/javascript"></script>
<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
		
	</script>
<style type="text/css">
	a{
		text-decoration:none;
		color:#000;
	}
	body{

		margin:0px;
		border-top:3px solid #ccc;
		border-right:3px solid #ccc;
	}

</style>
</head>
<body>

<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">收起所有</a> | <a href="?#">展开所有</a></div>

<ul id="tree" style = "width:220px;height:430px;">
	<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=1" target="mainActionList"><strong>科技活动类型</strong></a>
	<ul>
		<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=2" target="mainActionList">基础研究</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=4" target="mainActionList">学科A</a></li>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=5" target="mainActionList">学科B</a></li>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=6" target="mainActionList">学科C</a></li>
		</ul>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=3" target="mainActionList">其他类型</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=7" target="mainActionList">应用研究</a></li>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=8" target="mainActionList">实验发展</a></li>
			<li><a href="${pageContext.request.contextPath }/servlet/needServlet?method=BlistNeed&n=9" target="mainActionList">研究发展</a></li>
		</ul>
		</li>

	</ul>
	</li>
	<li><a href="${pageContext.request.contextPath }/main/main.jsp" target="_parent"><strong>返回主系统</strong></a></li>
</ul>
</div>

</body>

</html>