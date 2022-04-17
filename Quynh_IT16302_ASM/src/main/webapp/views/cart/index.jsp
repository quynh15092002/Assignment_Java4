<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
<div class="row">
<div class="col-md-12">
<h1>Danh sách sản phẩm</h1>
</div>
</div>
<div class="row">
<c:forEach items="${ products }"> var="product">
<div class="col-md-3">
<div class="card">
</div>
</div>

</c:forEach>
</div>
</div>
</body>
</html>