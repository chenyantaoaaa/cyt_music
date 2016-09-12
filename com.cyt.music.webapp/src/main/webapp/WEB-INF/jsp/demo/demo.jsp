<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>demo</title>
</head>
<body>
<form name="demoFrom" action="${pageContext.request.contextPath }/demo/demoQuery.action">
查询条件：
<table width="100%" border=1>
<tr>
<td>
用户名称<input name="username"/>
</td>
<td><input type="button" value="查询" onclick="queryItems()"/></td>
<td><input type="button" value="批量删除" onclick="deleteItems()"/></td>
</tr>
</table>
用户列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>用户名称</td>
	<td>用户状态</td>
	<td>操作</td>
</tr>
<c:forEach items="${UserItems}" var="item">
<tr>
	<td><input type="checkbox" name="Items_id" value="${item.id}"/></td>	
	<td>${item.username}</td>
	<td>${item.userstatus}</td>
	<td><a href="${pageContext.request.contextPath }/demo/editDemo.action?id=${item.id}">修改</a></td>
	
</c:forEach>

</table>
</form>

<script type="text/javascript">
function deleteItems(){
	document.demoFrom.action="${pageContext.request.contextPath }/demo/deleteItems.action";
	document.demoFrom.submit();
}

function queryItems(){
	document.demoFrom.action="${pageContext.request.contextPath }/demo/demoQuery.action";
	document.demoFrom.submit();
}
</script>
</body>
</html>