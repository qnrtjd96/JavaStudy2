<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pVO.searchWord != null && pVO.searchWord !=''}"> <!-- 검색어가 있을때 -->
<script>
   $(function(){
      $("#del").click(function(){
         if(confirm("글을 삭제하시겠습니까?")){
            location.href="<%=request.getContextPath()%>/board/DelCommand.do?no=${vo.no}&pageNum=${pVO.pageNum}&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}";   // 글번호, 아이디, 현재페이지, 검색키, 검색어
         }
      });
   });
</script>
</c:if>
<c:if test="${pVO.searchWord==null || pVO.searchWord=='' }"> <!-- 검색어가 없을때 -->
<script>
   $(function(){
      $("#del").click(function(){
         if(confirm("글을 삭제하시겠습니까?")){
            location.href="<%=request.getContextPath()%>/board/DelCommand.do?no=${vo.no}&pageNum=${pVO.pageNum}";   // 글번호, 아이디, 현재페이지, 검색키, 검색어
         }
      });
   });
</script>
</c:if>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호: ${vo.no}</li>
		<li>작성자: ${vo.userid}</li>
		<li>등록일: ${vo.writedate}  , 조회수: ${vo.hit}</li>
		<li>제목: ${vo.content}</li>
	</ul>
	
	<div>
		<a href="<%=request.getContextPath()%>/board/list.do?pageNum=${pVO.pageNum}<c:if test="${pVO.searchWord!=null && pVO.searchWord!=''}">&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">글목록</a>
		<c:if test="${userid==vo.userid }">
			<a href="<%=request.getContextPath()%>/board/boardEdit.do?no=${vo.no}&pageNum=${pVO.pageNum}<c:if test="${pVO.searchWord!=null && pVO.searchWord!=''}">&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">수정</a>
			<span id="del">삭제</span> <!-- <a hef="javavscript:delCheck()">삭제</a> -->
		</c:if>
	</div>
</div>