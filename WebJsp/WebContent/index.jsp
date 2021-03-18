<!-- 지시부 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.Calendar, java.util.Scanner" %>
<%@ page import ="java.util.Random" %>
<%@ page trimDirectiveWhitespaces="true" %> <!-- jsp 빈자리 삭제 -->
<%! //선언부
	//메소드 또는 변수선언
	public int sum(int a, int b){ //지역변수가 됨
		int total = a+b;
		return total;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		background-color: pink;
	}
</style>
<script>
	//document.write("javaScript...")
</script>
</head>
<body>
<h2>session.ID : <%= session.getId() %></h2>
<%	//session 로그인 여부를 확인한후 선택하여 표시한다.
	if(session.getAttribute("logStatus")==null){//로그인안댐
%>
		<a href="<%=request.getContextPath()%>/login/login_form.html">로그인</a>
<% 	}else if(session.getAttribute("logStatus").equals("Y")){ %>
		<%=session.getAttribute("logName") %>
		<a href="<%=request.getContextPath()%>/login/logout.jsp">로그아웃</a>
<% 	}%>	
	<h1>jsp start!!!</h1>
	<!-- jsp 영역 > java 영역이 된다. 서버에서만 실행됨 out 통한 데이터만 보냄 jsp소스는 보여지지 않는다.
	 	jsp > tomcat이 바꿔줌 > servlet(java) : class랑 java file이 생성
	 -->
	<%
		//calendar 객체 사용하기 > utile에 있기 때문에 import가 필요하다. 위(지시부)에서 import
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
	%>
	<h1>오늘은 <%=year %>년 <%=month %>월 <%=day %>일 입니다.</h1>
	
	<% //스크립트릿 
		int a = 1234;
		int b = 5678;
		String name = "gil-dong hong";
		out.write(name); //out 내장객체 > 사용자(클라이언트)에게 데이터를 보냄(response)
		int result = sum(b, a);
		out.write("<br/>result = "+result);
		out.write("<br/>"+a+"+"+b+"="+sum(a, b));
	%>
	
	<br/>
	<!-- 단순 출력과 단순계산은 아래와 같은 방법으로 가능 
		 이때, %랑 =은 붙어있어야 한다.
	-->
	<%= a %>,
	<%= a+4 %>, 
	<%=b %>, 
	<%=sum(a,b) %>
	
	<hr/>
	<%
		out.write("<h1>jsp에서 문자로 테그 입력하는 중...</h1>");
		out.write("<img src='img/img1.jpg'/>");
	%>
</body>
</html>

<!--
	jsp의 내장객체들...form tag(submit)에서 데이터를 받아옴(받아 오기 전에 js, jq에서 유효성 검사 후)
	
		- request : 서버에서 클라이언트의 정보를 받아옴 (form, client IP, file, path, ...) > form tag, a tag를 통해서 가져 올 수 있음 > DB검색 
		
		- response
		
		- session
		
		- cookie
		
		- error


-->