<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../jsp04_include/logCheck.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script src="//cdn.ckeditor.com/4.16.0/full/ckeditor.js"></script>
<Style>
	ul,li{margin:0;
		padding:0; list-style-type:none;
	}
	#subject{width:100%;}
</Style>
<Script>
	$(function(){
		CKEDITOR.replace("content");
		$("#frm").submit(function(){
			if($("#subject").val()==""){
				alert("제목을 입력하세요...");
				return false;
			}
			if(CKEITOR.instances.content.getData()==""){
				alert("글내용을 입력하세요..");
				return false;
			}
			return true;
		});
	});
</Script>
</head>
<body>
	<%@ include file="../jsp04_include/jspf_header.jspf" %>
	<div class="container">
		<h1>글쓰기폼</h1>
		<form method="post" id="frm" action="boardWriteOk.jsp">
			<ul>
				<li>제목</li>
				<li><input type="text" name="subject" id="subject"/><br/>
				<li>글내용</li>
				<li><textarea name="content" id="content"></textarea></li>
				<li><input type="submit" value="등록"/></li>
			</ul>
		</form>
	</div>
</body>
</html>