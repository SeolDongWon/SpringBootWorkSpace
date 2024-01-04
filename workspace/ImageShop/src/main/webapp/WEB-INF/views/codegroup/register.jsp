<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 범용 spring 태그라이브러리를 선언한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Shop</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		var formObj = $("#codeGroup");
		
		$("#btnRegister").on("click", function() {
			formObj.submit();
		});
		
		$("#btnList").on("click", function() {
			self.location = "/codegroup/list";
		});
	});
</script>

<body>
	<!--HEADER AREA  -->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<!--MENU AREA  -->
	<%@ include file="/WEB-INF/views/common/menu.jsp"%>
	<!--CONTENT AREA  -->
	<h2>
		<spring:message code="codegroup.header.register" />
	</h2>
	<!-- form:태그 사용시 request에 객체를 넣어줘야한다  -->
	<form:form modelAttribute="codeGroup" action="/codegroup/register">
		<table>
			<tr>
				<td><spring:message code="codegroup.groupCode" /></td>
				<td><form:input path="groupCode" /></td>
				<td><font color="red"><form:errors path="groupCode" /></font></td>
			</tr>
			<tr>
				<td><spring:message code="codegroup.groupName" /></td>
				<td><form:input path="groupName" /></td>
				<td><font color="red"><form:errors path="groupName" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">
			<spring:message code="action.register" />
		</button>
		<button type="submit" id="btnList">
			<spring:message code="action.list" />
		</button>
	</div>
	<!--FOOTER AREA  -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

	<!-- 메시지 프로퍼티 파일로부터 메시지 내용을 읽어온다. -->

</body>
</html>