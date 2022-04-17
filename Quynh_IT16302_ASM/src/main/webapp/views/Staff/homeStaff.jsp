<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Assigment</title>
<link href="/Quynh_IT16302_ASM/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="/Quynh_IT16302_ASM/css/bootstrap.min.css">
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="#">Quản lý và nhân viên</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navba rDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> ${ sessionScope.staff.hoTen } </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Đổi mật khẩu</a> <a
						class="dropdown-item" href="#">Cập nhật tài khoản</a> <a
						class="dropdown-item" href="/Quynh_IT16302_ASM/Logout">Đăng xuất</a>
				</div></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-light"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Chức năng</div>
						<a class="nav-link" href="/Quynh_IT16302_ASM/HomeStaff"> Trang chủ </a> 
						<a class="nav-link" href="/Quynh_IT16302_ASM/QLProduct/index"> Quản lý sản phẩm </a> 
						<a class="nav-link" href="/Quynh_IT16302_ASM/QLCategory/index"> Quản lý thể loại </a> 
						<a class="nav-link" href="/Quynh_IT16302_ASM/QLUser/index"> Quản lý User </a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Xin chào</div>
					${ sessionScope.staff.hoTen }
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main class="col-12">
				<div class="row">
					<div class="col-12">
						<jsp:include page="${ view }"></jsp:include>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-12">
						<jsp:include page="${ table }"></jsp:include>
					</div>
				</div>
			</main>
			<footer class="page-footer text-center font-small mt-4 wow fadeIn"
				style="background-color: grey">
				<div class="footer-copyright py-3 text-center">© Nguyễn Thị Như Quỳnhh ©</div>
			</footer>
		</div>
	</div>

	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/Quynh_IT16302_ASM/js/scripts.js"></script>
	<script type="text/javascript">
		function deleteUser(id){
			var check = confirm("Bạn có chắc muốn xóa");
			if(check === true){
				window.location.href = "/Quynh_IT16302_ASM/QLUser/delete?id="+id;
			}else{
				return;
			}
		}
		function deleteCate(id){
			var check = confirm("Bạn có chắc muốn xóa");
			if(check === true){
				window.location.href = "/Quynh_IT16302_ASM/QLCategory/delete?id="+id;
			}else{
				return;
			}
		}
		function deleteProduct(id){
			var check = confirm("Bạn có chắc muốn xóa");
			if(check === true){
				window.location.href = "/Quynh_IT16302_ASM/QLProduct/delete?id="+id;
			}else{
				return;
			}
		}
	</script>
</body>

</html>