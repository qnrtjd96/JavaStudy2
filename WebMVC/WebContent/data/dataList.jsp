<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#dataList>li{
		float:left; width:10%; height:40px; line-height:40px; border-bottom:1px solid #ddd;
	}
	#dataList>li:nth-child(7n+2){
		width:40%;
	}
	#dataList{overFlow:auto;}
	.wordCut{white-space:nowrap; overflow:hidden; text-overflow:ellipsis;}
</style>
<script>
	$(function(){
		$(document).on('click', '#dataList img', function(){
			//레코드 번호 받아오기
			var no = $(this).parent().parent().prev().prev().prev().prev().text();
	//			var gtNo = $(this).$("#dataList >")
			//console.log("no? ", no);
			var downObj  = $(this).parent().parent().next()
			
			var params = "no="+no;
			$.ajax({
				url: '/WebMVC/data/downcount.do',
				data: params,
				success: function(result){
					var downarr = result.split("<hr class='down'/>");
					downObj.text(downarr[1].trim());
				},
				error: function(){
					console.log("다운횟수 카운트 에러...");
				}
			})
		})
	})
</script>
<div class="container">
	<h1>자료실 리스트</h1>
	<div>
		<c:if test="${userid != null && userid != '' }">
			<a href="<%=request.getContextPath()%>/data/dataForm.do">자료실 글올리기</a>
		</c:if>
	</div>
	<ul id="dataList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>hit</li>
		<li>첨부</li>
		<li>Down</li>
		<li>등록일</li>
		
		<!-- 반복 할 구역 -->
		<c:forEach var="dataVO" items="${lst }">
			<li>${dataVO.no} </li>
			<li id="liTitle" class="wordCut"><a href="<%=request.getContextPath() %>/data/dataView.do?no=${dataVO.no}">${dataVO.title }</a></li>
			<li>${dataVO.userid }</li>
			<li>${dataVO.hit }</li>
			<li>
				<a href="<%=request.getContextPath() %>/upload/${dataVO.filename1}" download><img src="<%=request.getContextPath() %>/img/disk.png" title="${dataVO.filename1 }" width="20px" height="20px"></a>
				<c:if test="${dataVO.filename2!=null && dataVO.filename2!='' }">
					<a href="<%=request.getContextPath() %>/upload/${dataVO.filename2}" download><img src="<%=request.getContextPath() %>/img/disk.png" title="${dataVO.filename2 }" width="20px" height="20px"></a>
				</c:if>
			</li>
			<li>${dataVO.downCount }</li>
			<li>${dataVO.writedate }</li>
		</c:forEach>
	</ul>
</div>