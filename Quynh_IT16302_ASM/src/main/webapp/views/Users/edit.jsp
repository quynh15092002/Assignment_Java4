
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<form action="/Quynh_IT16302_ASM/QLUser/update?id=${ user.id }" method="post" enctype="multipart/form-data" >
	<div class="card">
		<div class="card-header text-center">
			<p style="font-size: x-large;">Quản lý User</p>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="">Họ Tên</label> 
				<input class="form-control" type="text" name="hoTen" id="" value="${ user.hoTen }" required>
			</div>
			<div class="form-group">
				<label for="">Địa chỉ</label> 
				<input class="form-control" type="text" name="diaChi" id="" value="${ user.diaChi }" required>
			</div>
			<div class="form-group">
				<label for="">Email</label> 
				<input class="form-control" type="email" name="email" id="" value="${ user.email }" required>
			</div>
			<div class="form-group">
				<label for="">SĐT</label> 
				<input class="form-control" type="number" name="sdt" id="" value="${ user.sdt }" placeholder="SĐT" required>
			</div>
			<div class="form-group">
				<label for="">Vai Trò: </label> 
				<input type="radio" name="vaiTro" id="" value="1" ${ user.vaiTro == 1 ? "checked" : "" }>Quản lý 
				<input type="radio" name="vaiTro" id="" value="0" ${ user.vaiTro == 0 ? "checked" : "" }>Khách hàng
			</div>
			<div class="form-group">
				<label for="">Avatar</label>
				<input class="form-control" type="file" name="avatar" value="${ user.avatar }" id="" placeholder="Vui lòng chọn Avatar">
				<img src="/Quynh_IT16302_ASM/files/${ user.avatar }" width="150px" height="150px" >
			</div>
		</div>
		<div class="card-footer text-center">
			<button class="btn btn-info">Update</button>
		</div>
	</div>
</form>