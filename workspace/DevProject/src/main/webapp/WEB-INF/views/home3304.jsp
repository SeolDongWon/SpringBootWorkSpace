<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home3304</title>
</head>
<body>
	<p>now : ${now}</p>
	<p>
		pattern :
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd E요일 HH:mm:ss" />
	</p>
	<p>
		pattern :
		<fmt:formatDate value="${now}" pattern="a h:mm" />
	</p>
	<p>
		pattern :
		<fmt:formatDate value="${now}" pattern="z a h:mm" />
	</p>
	<p> 
		pattern :
		<fmt:formatDate value="${now}" pattern="E" />
	</p>
</body>
</html>