<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style>
	footer{background-color:#ddd; height:100px;}
	header{height:100px; background-color:pink;}
	
</style>
</head>
<body>
	<div class="container">
		<!-- header include -->
		<jsp:include page="jsp_header.jsp"/>
		<!-- 현재 컨텐츠 -->
		<div style="border:1px solid black">
		<%
			//include 파일 변수 사용하기
			//변수, 데이터
			//out.write("이름 = " + username);
			//out.write("번호 = " + num);
		%>
			<img src="../img/1.jpg"/>
		</div>
		<!-- footer include -->
		<jsp:include page="jsp_footer.jsp"/>
	</div>
</body>
</html>