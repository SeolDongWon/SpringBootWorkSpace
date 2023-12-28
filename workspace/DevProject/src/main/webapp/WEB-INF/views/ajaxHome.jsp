<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Headers 매핑</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//이벤트설정1
		$("#putBtn").on("click",function(){
			
			//input태그 객체를 가져온다
			let boardNo = $("#boardNo");
			let title = $("#title");
			let content = $("#content");
			let writer = $("#writer");
			
			//입력태그객체 value를 가져온다
			let boardNoVal = boardNo.val();
			let titleVal = title.val();
			let contentVal = content.val();
			let writerVal = writer.val();
			
			//전송할객체를 만든다
			let boardObject = {
					boardNo : boardNoVal,
					title : titleVal,
					content : contentVal,
					writer : writerVal
			};
			
			//비동기식 처리방식을 요청한다.
			$.ajax({
				type : "put",
				url : "/board/"+boardNoVal,
				data : JSON.stringify(boardObject),
				contentType : "application/json; charset=UTF-8",
				success : function(result){
					console.log("result : "+result);
					if(result==="SUCCESS"){
						alert("SUCCESS");
					}
				}
			});
		});
		
		//이벤트설정2
		$("#getBtn").on("click",function(){
			//input태그 객체를 가져온다
			let boardNo = $("#boardNo");
			//입력태그객체 value를 가져온다
			let boardNoVal = boardNo.val();
			//전송할객체를 만든다
			let boardObject = {
					boardNo : boardNoVal,
			};
			//비동기식 처리방식을 요청한다.
			$.ajax({
				type : "get",
				url : "/board/"+boardNoVal,
				/* data : JSON.stringify(boardObject), */
				headers : {"Accept" : "application/json"},
				contentType : "application/json; charset=UTF-8",
				success : function(result){
					console.log("result : "+result);
					if(result!=null){
						/* alert("result"); */
						alert(JSON.stringify(result));
					}
				}
			});
		});

		//이벤트설정2
		$("#putHeaderBtn").on("click", function() {
		});

	});
</script>
<body>
	<h1>Ajax Home</h1>

	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
		title: <input type="text" name="title" value="" id="title"><br>
		content: <input type="text" name="content" value="" id="content"><br>
		writer: <input type="text" name="writer" value="" id="writer"><br>
	</form>

	<div>
		<button id="putBtn">수정(put)</button>
		<button id="getBtn">요청(get)</button>
		<button id="putHeaderBtn">수정(put with header)</button>
	</div>
</body>
</html>