<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${result==1}">
	<!-- 가입시 -->
	<Script>
		location.href="<%=request.getContextPath()%>/member/login.do";
	</Script>
</c:if>
<c:if test="${result==0}">
	<!-- 가입실패시 -->
	<script>
		alert("로그인 실패");
		history.back();
	</script>
</c:if>