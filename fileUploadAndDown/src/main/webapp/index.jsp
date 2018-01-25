<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Index.jsp</title>
<body>

<h2>欢迎登陆</h2>
	
	<form action="upload" method="post" enctype="multipart/form-data">
		用户名:<input type="text" name="name"/><br>
		密&nbsp;&nbsp;码:<input type="password" name="pwd"/><br>
		上传头像：<input type="file" name="file">
		<input type="submit" value="..."/>
	</form>

</body>
</html>
