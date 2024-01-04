<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 범용 spring 태그라이브러리를 선언한다. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Shop</title>
</head>
<body>
	<!--HEADER AREA  -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<!--MENU AREA  -->
	<%@ include file="/WEB-INF/views/common/menu.jsp" %>
	<!--CONTENT AREA  -->
	<h1>
		<spring:message code="common.homeWelcome"/>
	</h1>
	<P>${serverTime}</P>
	<!--FOOTER AREA  -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

	<!-- 메시지 프로퍼티 파일로부터 메시지 내용을 읽어온다. -->

</body>
</html>