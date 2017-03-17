<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta charset="utf-8" />
<title>添加页</title>
</head>
<body>


		<label for="descript">事件描述:</label>
		<form:form action="/add/inputEvent">
		<input type="text" class="form-control" id="descript" name="description">
			<br>
		<button type="submit" class="btn btn-success">添加</button>
		</form:form>


</body>
</html>