<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Chỉnh sửa quyền</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-4 text-center">Chỉnh sửa quyền</h3>
		<form action="<c:url value='/role/edit'/>" method="post">
			<div class="row">
				<div class="col-md-6 m-auto">
					<div class="form-group">
						<label>Id</label> <input type="text" name="id"
							class="form-control" value="${ROLE.id}" readonly />
					</div>
					<div class="form-group">
						<label>Tên quyền</label> <input type="text" name="name"
							class="form-control" value="${ROLE.name}" />
					</div>
					<div class="form-group">
						<label>Mô tả</label> <input type="text" name="description"
							class="form-control" value="${ROLE.description}" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Lưu lại</button>
						<a class="btn btn-secondary" href="role-list.html">Quay lại</a>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>

</html>