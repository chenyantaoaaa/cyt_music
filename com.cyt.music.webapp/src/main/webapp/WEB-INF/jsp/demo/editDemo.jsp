<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>

</head>
<body> 
<form id="demoForm" action="${pageContext.request.contextPath }/demo/editDemoSubmit.action" method="post" enctype="multipart/form-data">
<!--  enctype="multipart/form-data" -->
<input type="hidden" name="id" value="${userInfo.id}"/>
修改用户信息：
<table width="100%" border=1>
<tr>
	<td>用户名称</td>
	<td><input type="text" name="username" value="${userInfo.username}"/></td>
</tr>
<tr>
	<td>用户状态</td>
	<td><input type="text" name="userstatus" value="${userInfo.userstatus}"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>
</form>
<script type="text/javascript">
</script>
</body>

</html>