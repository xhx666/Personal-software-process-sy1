<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->

<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<title>BList</title>
</head>
<body>
<table class = "table table-striped">
			<thead>
				<th>序号</th>
				<th>技术需求名称</th>
				<th>研究类型</th>
			<c:if test="${param.n==1 }">
							<th>学科分类</th>
			</c:if>
				<th>需求状态</th>
			</thead>
			<tbody>
				<c:forEach items="${needBeans}" var="item">
					<tr>
						<td>${item.nd_id}</td>
						<td><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=listDetail&nd_id=${item.nd_id}">${ item.nd_name}</a></td>
						<td>${item.yjlx}</td>
						<c:if test="${param.n==1 }">
							<td>${item.xkfl}</td>
						</c:if>
						<c:if test="${item.nd_state==1 }">
							<td>未审核</td>
						</c:if>
						<c:if test="${item.nd_state==2 }">
							<td>已审核</td>
						</c:if>
						<c:if test="${item.nd_state==3 }">
							<td>被退回</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
</body>
</html>