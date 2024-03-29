<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//cdn.ckeditor.com/4.16.0/full/ckeditor.js"></script>
<style>
	#subject{width:80%;}
</style>
<script>
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
</script>
<div class="container">
	<h1>게시글 글쓰기</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/EditOk.do">
		<input type="hidden" name="no" value="${vo.no}"/>
		<div> 제목: <input type="text" name="subject" id="subject" value="${vo.subject}" /></div>
		<textarea name="content" id="content">${vo.content}</textarea>
		<input type="submit" value="글수정"/>
		<input type="reset" value="다시쓰기"/>
		<!-- 페이지 번호, 검색어, 검색키 -->
		<input type="hidden" name="pageNum" id="pageNum" value="${pVO.pageNum}"/>
		<c:if test="${pVO.searchWord!=null && pVO.searchWord !=''}">
			<input type="hidden" name="searchKey" value="${pVO.searchKey}"/>
			<input type="hidden" name="searchWord" value="${pVO.searchWord}"/>
		</c:if>
	</form>
</div>