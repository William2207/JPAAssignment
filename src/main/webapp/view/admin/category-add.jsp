<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<form action="${pageContext.request.contextPath }/admin/category/insert" method="post" enctype="multipart/form-data">
  <label for="fname"> Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="lname">Link Images:</label><br>
  <input type="text" id="images" name="images">
  
  <label for="lname">Upload file: </label><br>
  <input type="file" id="images1" name="images1"><br>
  
  
  <label for="lname">Status</label><br>
  <input type="radio" id="stoff" name="status" value=0>
  <label for="javascript">Khoá</label>
   <input type="radio" id="css" name="status" value="1">
  <label for="css">Hoạt Động</label><br>
  
  <input type="submit" value="Submit">
</form>