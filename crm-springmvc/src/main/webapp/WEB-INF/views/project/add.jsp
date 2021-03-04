<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Tạo dự án</title>
</head>
<body>
	<section id="admin-content" class="p-3">
		<h3 class="mb-4 text-center">Tạo dự án</h3>
		<form action="<c:url value='/project/add'/>" method="post">
			<div class="row">
				<div class="col-md-6 m-auto">
					<div class="form-group">
						<label>Tên dự án</label> <input type="text" name="name"
							class="form-control" placeholder="Project Name" />
					</div>
					<div class="form-group">
						<label>Ngày bắt đầu</label> <input type="date" name="startDate"
							class="form-control" placeholder="Start date" />
					</div>
					<div class="form-group">
						<label>Ngày kết thúc</label> <input type="date" name="endDate"
							class="form-control" placeholder="End date" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Tạo</button>
						<a class="btn btn-secondary" href="role-list.html">Quay lại</a>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>