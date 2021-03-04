<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Thêm mới thành viên</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-4">Thêm mới thành viên</h3>
		<form method="post" action="">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Mã nhân viên</label> <input type="text" name="id"
							class="form-control" readonly value="${USER.id}" />
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							class="form-control" value="${USER.email}" />
					</div>
					<div class="form-group">
						<label>Mật khẩu</label> <input type="password" name="password"
							class="form-control" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Họ tên</label> <input type="text" name="fullName"
							class="form-control" value="${USER.fullName}" />
					</div>
					<div class="form-group">
						<label>Vai trò</label> <select name="roleId" class="form-control">
							<c:forEach var="item" items="${ROLES}">
								<option value="${item.id}"
									<c:if test="${USER.roleId == item.id}">selected</c:if>>${item.description}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Avatar</label> <input type="text" name="avatar"
							class="form-control" value="${USER.avatar}" />
					</div>
				</div>
				<div class="col-12 mt-3">
					<button type="submit" class="btn btn-success">Lưu lại</button>
					<a class="btn btn-secondary" href="user-list.html">Quay lại</a>
				</div>
			</div>
		</form>
	</section>
</body>
</html>