<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	欢迎： ${sessionScope.username}登录
	<form action="login.html" method="post">
		<input type="text" name="username" placeholder="用户名" /><br /> <input
			type="password" name="password" placeholder="密码" /><br />
		<button onclick="javascript:submit()">登录</button>
	</form>
</body>
</html>