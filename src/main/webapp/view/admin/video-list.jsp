<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<a href="<c:url value='/admin/video/add'/>">Add Video</a><br>
<table border = "1", width= 100%>
	<tr>
		<th>STT</th>
		<th>Title</th>
		<th>Description</th>
		<th>Poster</th>
		<th>Views</th>
		<th>Active</th>
	</tr>
	<c:forEach items="${listvid}" var="vid" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<td>
				<c:if test = "${vid.poster.substring(0,5)  != 'https'}" >
					<c:url value="/image?fname=${cate.poster}" var="imgUrl"></c:url>
				</c:if>
				<c:if test = "${vid.poster.substring(0,5)  == 'https'}" >
					<c:url value="${vid.poster}" var="imgUrl"></c:url>
				</c:if>
					<img height="150" width="200" src="${imgUrl}" />
			</td>
			
			
			<td>${cate.categoryname }</td>
			<td>${vid.active ? "hoat dong" : "dung hoat dong"}</td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${vid.videoid }'/>">Sửa</a>
				| <a href="<c:url value='/admin/category/delete?id=${vid.videoid }'/>">Xóa</a></td>
		</tr>
	</c:forEach>
</table>