<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="list">LIST</a>
	</div>
	<form action="add" method="post">
	<table>
		<tbody>
			<tr>
				<td>name</td>
				<td><input name="name" type="text"/></td>
			</tr>
			<tr>
				<td>url</td>
				<td><input name="url" type="text"/></td>
			</tr>
			<tr>
				<td>cssSelector</td>
				<td><input name="cssSelector" type="text"/></td>
			</tr>
			<tr>
				<td>intervalTime</td>
				<td><input name="intervalTime" type="number"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>