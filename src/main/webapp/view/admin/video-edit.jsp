<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
    
<form action="${pageContext.request.contextPath }/admin/video/update" method="post" enctype="multipart/form-data">
	<input type="text" name="videoid" hidden="hidden" value="${vid.videoid }">
  <label for="fname">Title name:</label><br>
  <input type="text" id="titlename" name="titlename" value="${vid.title}"><br>
  <label for="lname">Link poster:</label><br>
  <c:if test = "${vid.poster.substring(0,5)  != 'https'}" >
					<c:url value="/image?fname=${vid.poster}" var="imgUrl"></c:url>
				</c:if>
				<c:if test = "${vid.poster.substring(0,5)  == 'https'}" >
					<c:url value="${vid.poster}" var="imgUrl"></c:url>
				</c:if>
					<img height="150" width="200" src="${imgUrl}" />
  
  <input type="text" id="poster" name="poster" value="${vid.poster }">
  
  <label for="lname">Upload file: </label><br>
  <input type="file" id="poster1" name="poster1"><br>
  
  <label for="active">Active</label><br>
  <input type="text" id="active" name="active" value=""><br>
  
  
  <input type="submit" value="Submit">
</form>