<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터 전달 화면</h1>

	<form action="/registerModelForm01" method="post">
		userId: <input type="text" name="userId" value="hong01"><br>
		password: <input type="text" name="password" value="1234"><br>
		<input type="submit" value="registerModelForm01">
	</form>
</body>
</html>