<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "dao.*"
    %>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>list</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->

<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/108/zgmeruh2/echarts.min.js"></script>
</head>
<body>
	<div class = "container">
	<c:if test="${ param.status==1}">
	<h3 class = "text-center">河北省重大技术需求征集清单</h3>
	<div style = "height:30px;"></div>
	<div>
		<form role = "form" action = "${pageContext.request.contextPath }/servlet/needServlet?method=find" method= "post" class = "form-inline">  
			<div class = "form-group">技术需求名称：</div>
			<div class = "form-group">
			<input name = "nd_name" type ="text" class="form-control" placeholder= "技术需求名称" />
			</div>
			<div class = "form-group">
				审核状态：
						<select class="form-control" name  = "nd_state">
							<option value = "0">所有状态</option>
							<option value = "1">未审核</option>
							<option value = "2">已审核</option>
							<option value = "3">被退回</option>
						</select>
			</div>
			<div class = "form-group">
						<button class = "btn btn-primary" type = "submit">查询</button>
			</div>
		</form>
	</div>
	<div id="chart" style="width:400px;height:400px;"></div>
	<div style = "height:50px;"></div>
		<table class = "table table-striped">
			<thead>
				<th>序号</th>
				<th>技术需求名称</th>
				<th>研究类型</th>
				<th>需求状态</th>
			</thead>
			<tbody>
				<c:forEach items="${needBeans}" var="item">
					<tr>
						<td>${item.nd_id}</td>
						<td><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=listDetail&nd_id=${item.nd_id}">${ item.nd_name}</a></td>
						<td>${item.yjlx}</td>
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
	</c:if>
	<c:if test="${ param.status==2}">
		<div class = "col-md-12 alert alert-danger">
			尚未录入需求信息！
		</div>
	</c:if>
	</div>
<%
	NeedDao needDao = new NeedDao();
	int wsh = needDao.findNoPass();
	int ysh = needDao.findPass();
	int bth = needDao.findNotPass(); 
%>
<script type="text/javascript">
var seriesData=[];
var obj = new Object();
obj.name = "已审核";
obj.value = <%=ysh%>;
seriesData.push(obj);
var obj2 = new Object();
obj2.name = "未审核";
obj2.value = <%=wsh%>;
seriesData.push(obj2);
var obj3 = new Object();
obj3.name = "被退回";
obj3.value = <%=bth%>;
seriesData.push(obj3);
// $.each(item,function(j,quato){ //j 答案， quato 数量
// var obj=new Object();
// if(j == "error"){
// obj.name="答错";
// }else{
// obj.name="答对";
// }
// obj.value=quato;
// seriesData.push(obj);
// })
var myChart = echarts.init(document.getElementById('chart'));
var option = {
tooltip : {
trigger: 'item',
formatter: "{a} {b} : {c} ({d}%)"
},
series : [{
name:'审核状态',
type:'pie',
radius : '55%',
center: ['50%', '50%'],
data:seriesData,
}]
};
myChart.setOption(option);
function eConsole(param) {
	//alert(option.series[0].data.length);
	//alert(option.series[0].data[i]);
	//param.dataIndex 获取当前点击索引，
	//alert(param.dataIndex);
	clickFunc(param.dataIndex);//执行点击效果
}
myChart.on("click", eConsole);
function clickFunc(index){
	if(index == 0){ window.location.href='needServlet?method=findYsh';  }
	else if(index == 1){window.location.href='needServlet?method=findWsh';}
	else{window.location.href='needServlet?method=findBth';}
}
</script>
</body>
</html>