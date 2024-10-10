<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
    
<form action="${pageContext.request.contextPath }/admin/category/update" method="post" enctype="multipart/form-data">
	<input type="text" name="categoryid" hidden="hidden" value="${cate.categoryid }">
  <label for="fname"> Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
  <label for="lname">Link Images:</label><br>
  <c:if test = "${cate.images.substring(0,5)  != 'https'}" >
					<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
				</c:if>
				<c:if test = "${cate.images.substring(0,5)  == 'https'}" >
					<c:url value="${cate.images}" var="imgUrl"></c:url>
				</c:if>
					<img height="150" width="200" src="${imgUrl}" />
  
  <input type="text" id="images" name="images" value="${cate.images }">
  
  <label for="lname">Upload file: </label><br>
  <input type="file" id="images1" name="images1"><br>
  
  
  <label for="lname">Status</label><br>
  <input type="radio" id="stoff" name="status" value=0 ${cate.status!=1?'checked':'' }>
  <label for="javascript">Khoá</label>
   <input type="radio" id="css" name="status" value="1" ${cate.status==1?'checked':'' }>
  <label for="css">Hoạt Động</label><br>
  
  <input type="submit" value="Submit">
</form>