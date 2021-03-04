<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ"/></title>
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/style.css' />">
</head>
<body>
	<div class="d-flex justify-content-between">
		<!-- SIDE BAR -->
		<%@ include file="/common/side-bar.jsp" %>
		<div id="admin-wrapper">
			<!-- HEADER -->
			<%@ include file="/common/header.jsp" %>
			<!-- CONTENT -->
			<dec:body />
		</div>
	</div>
	<script src="<c:url value='/static/js/jquery.slim.min.js'/>"></script>
	<script src="<c:url value='/static/js/popper.min.js'/>"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>