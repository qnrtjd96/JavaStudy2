<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 본인 글이 아닐때 -->
<c:if test="${result==100 }">
	<Script>
		location.href="<%=request.getContextPath()%>"/board/list.do";
	</Script>
</c:if>

<!-- 글 수정됬을때 -->
<c:if test="${result==1}">
	<script>
			location.href="<%=request.getContextPath()%>/board/boardView.do?${addrParam}";	
	</script>
</c:if>

<c:if test="${result==0}">
	<Script>
		history.back();
	</Script>
</c:if>