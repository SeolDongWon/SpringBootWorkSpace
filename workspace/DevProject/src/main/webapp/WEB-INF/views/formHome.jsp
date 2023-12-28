<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>Form Home</h3>

	<form action="/board/register" method="get">
		<input type="submit" value="register(get)">
	</form>
	<form action="/board/register" method="post">
		<input type="submit" value="register(post)">
	</form>
	<form action="/board/modify" method="get">
		<input type="submit" value="modify(get)">
	</form>
	<form action="/board/modify" method="post">
		<input type="submit" value="modify(post)">
	</form>
	<form action="/board/remove" method="post">
		<input type="submit" value="remove(post)">
	</form>
	<form action="/board/list" method="get">
		<input type="submit" value="list(get)">
	</form>
</body>
</html>