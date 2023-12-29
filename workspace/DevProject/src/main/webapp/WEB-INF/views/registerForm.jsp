<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 데이터 처리 애너테이션</title>
</head>
<body>

	<h1>요청 데이터 처리 애너테이션</h1>
	<a href="register/hong">register/hong</a>
	<br>
	<a href="register/hong/100">register/hong/100</a>
	<br>
	<form action="/register01" method="post">
		userId: 
		<input type="text" name="userId" value="hong"><br>
		password: 
		<input type="text" name="password" value="1234"><br>
		coin: 
		<input type="text" name="coin" value="100"><br> 
		<inputtype="submit" value="register01">
	</form>
	<form action="/register02" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> 
		<input type="submit" value="register02">
	</form>

	<h1>요청 처리 자바빈즈</h1>
	<form action="/registerbeans01" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> 
		<input type="submit" value="registerbeans01">
	</form>
	<form action="/registerbeans02" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br>
		<input type="submit" value="registerbeans02">
	</form>

	<h1>Date 타입 처리</h1>
	<form action="/registerdate" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		dateOfBirth: <input type="text" name="dateOfBirth" value="2000/10/20"><br>
		<!-- localDateOfBirth: <input type="text" name="localDateOfBirth" value="2000/10/20"><br> -->
		<input type="submit" value="registerdate">
	</form>

	<h1>@DateTimeFormat 애너테이션 처리</h1>
	<br>
	<a href="registerByDateFormat03?userId=hong&dateOfBirth=20001020">
	registerByDateFormat03?userId=hong&ampdateOfBirth=20001020</a>
	<br>
	<form action="registerByDateFormat03" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
		<input type="submit" value="registerByDateFormat03">
	</form>
	<h2>폼 양식 요청 처리</h2>
	<form action="/registerUserId" method="post">
		userId: 
		<input type="text" name="userId" /><br> 
		<input	type="submit" value="registerUserId">
	</form>
	<form action="/registerMemberUserId" method="post">
		userId: 
		<input type="text" name="userId" /><br> 
		<input	type="submit" value="registerMemberUserId">
	</form>
	<form action="/registerPassword" method="post">
		password: 
		<input type="password" name="password" /><br> 
		<input	type="submit" value="registerPassword">
	</form>
	<form action="/registerRadio" method="post">
		gender: <br> 
		<input type="radio" name="gender" value="male"checked> Male<br> 
		<input type="radio" name="gender"	value="female"> Female<br> 
		<input type="radio"	name="gender" value="other"> Other<br> 
		<input	type="submit" value="registerRadio">
	</form>
	<form action="/registerSelect" method="post">nationality:</form>
	<select name="nationality">
		<option value="Korea" selected>대한민국</option>
		<option value="Germany">독일</option>
		<option value="Australia">호주</option>
		<option value="Canada">캐나다</option>
	</select>
	<br>
	<input type="submit" value="registerSelect">
	<form action="/registerMultipleSelect01" method="post">
		cars: 
		<select name="cars" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect01">
	</form>
	<form action="/registerMultipleSelect02" method="post">
		carArray: 
		<select name="carArray" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect02">
	</form>
	<form action="/registerMultipleSelect03" method="post">
		carList: 
		<select name="carList" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect03">
	</form>
	<form action="/registerCheckbox01" method="post">
		hobby: <br> 
		<input type="checkbox" name="hobby" value="Sports">	Sports<br> 
		<input type="checkbox" name="hobby" value="Music">	Music<br> 
		<input type="checkbox" name="hobby" value="Movie">	Movie<br> 
		<input type="submit" value="registerCheckbox01">
	</form>
	<form action="/registerCheckbox02" method="post">
		hobbyList: <br> 
		<input type="checkbox" name="hobbyArray"	value="Sports"> Sports<br> 
		<input type="checkbox" name="hobbyArray" value="Music"> Music<br> 
		<input type="checkbox" name="hobbyArray" value="Movie"> Movie<br>
		<input type="submit" value="registerCheckbox02">
	</form>
	<form action="/registerCheckbox03" method="post">
		developer: 
		<input type="checkbox" name="developer" value="Y"><br>
		<input type="submit" value="registerCheckbox03">
	</form>
	<form action="/registerCheckbox04" method="post">
		foreigner: 
		<input type="checkbox" name="foreigner" value="false"><br>
		<input type="submit" value="registerCheckbox04">
	</form>
	<form action="/registerAddress" method="post">
		postCode: 
		<input type="text" name="postCode" /><br> 
		location: 
		<input type="text" name="location" /><br>
		<input type="submit"value="registerAddress">
	</form>
	<form action="/registerUserAddress" method="post">
		address.postCode: 
		<input type="text" name="address.postCode" /><br>
		address.location: 
		<input type="text" name="address.location" /><br>
		<input type="submit" value="registerUserAddress">
	</form>
	<form action="/registerUserCardList" method="post">
		카드1 - 번호 : 
		<input type="text" name="cardList[0].no" /><br> 
		카드1 -	유효년월 : 
		<input type="text" name="cardList[0].validMonth" /><br><br>
		카드2 - 번호 : 
		<input type="text" name="cardList[1].no" /><br> 
		카드2 - 유효년월 :
		<input type="text" name="cardList[1].validMonth"/><br><br>
		<input type="submit" value="registerUserCardList">
	</form>
	<form action="/registerTextArea" method="post"> 
		introduction: <br>
		<textarea name="introduction" rows="6" cols="50"></textarea><br>
		<input type="submit" value="registerTextArea">
	</form>
	<form action="/registerDate01" method="post">
		dateOfBirth: 
		<input type="text" name="dateOfBirth" /><br>
		<input type="submit" value="registerDate01">
	</form>
</body>
</html>
