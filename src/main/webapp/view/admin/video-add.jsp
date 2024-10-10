<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<form action="${pageContext.request.contextPath }/admin/video/insert" method="post" enctype="multipart/form-data">
  
  <label for="fname"> Video ID:</label><br>
  <input type="text" id="videoid" name="videoid"><br>
  <label for="fname"> Title name:</label><br>
  <input type="text" id="titlename" name="titlename"><br>
  <label for="lname">Link Images:</label><br>
  <input type="text" id="poster" name="poster">
  
  <label for="lname">Upload file: </label><br>
  <input type="file" id="poster1" name="poster1"><br>
  
  
  <label for="description">Description</label><br>
  <input type="text" id="description" name="description" value=""><br>
  
  <label for="views">Views</label><br>
  <input type="text" id="views" name="views" value=""><br>
  
  <label for="active">Active</label><br>
  <input type="text" id="active" name="active" value=""><br>
  
  
  <input type="submit" value="Submit">
</form>