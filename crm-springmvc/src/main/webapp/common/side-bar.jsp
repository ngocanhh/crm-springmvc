<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="side-bar">
	<div class="logo">ADMIN PAGE</div>
	<ul class="list-group rounded-0">
		<li class="dashboard">DASHBOARD</li>
		<li>
			<a href="<c:url value='/user'/>"> <i class="fa fa-user mr-2"></i> Quản lý thành viên </a>
		</li>
		<li>
			<a href="<c:url value='/role'/>"> <i class="fa fa-lock mr-2"></i> Quản lý quyền </a>
		</li>
		<li>
			<a href="<c:url value='/project'/>"> <i class="fa fa-book mr-2"></i> Quản lý dự án </a>
		</li>
		<li>
			<a href="<c:url value='/task'/>"> <i class="fa fa-tasks mr-2"></i> Quản lý công việc </a>
		</li>
		<li>
			<a href="#"> <i class="fa fa-cogs mr-2"></i> Cấu hình hệ thống </a>
		</li>
		<li>
			<a href="#"> <i class="fa fa-slack mr-2"></i> Thông tin khác </a>
		</li>
	</ul>
</div>
