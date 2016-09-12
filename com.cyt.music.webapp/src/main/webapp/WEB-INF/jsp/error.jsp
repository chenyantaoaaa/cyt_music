<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误提示</title>
   <style>
   	#mid {background:url(../img/error.png) no-repeat; width: 1340px; height: 626px;background-size: 100%;} 
   	h1 { position: absolute; left: 100px; top: 400px; width:300px; }
   </style>
</head>
<body>
	<div id="mid">
		<h1>${message }</h1>
	</div>
</body>
</html>