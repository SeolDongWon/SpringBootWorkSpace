<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE
html>
<html>
<head>
<meta charset="UTF-8">
<title>다중 이미지 업로드</title>
</head>
<body>
	<h2>상품 목록</h2>
	<a href="register">상품 등록</a>
	<table border="1">
		<tr>
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">제거</th>
		</tr>
		<c:forEach items="${item2List}" var="item2">
			<tr>
				<td align="center">${item2.itemId}</td>
				<td align="left">${item2.itemName}</td>
				<td align="right">${item2.price}원</td>
				<td align="center"><a href="modify?itemId=${item2.itemId}">상품
						편집</a></td>
				<td align="center"><a href="remove?itemId=${item2.itemId}">상품
						제거</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>