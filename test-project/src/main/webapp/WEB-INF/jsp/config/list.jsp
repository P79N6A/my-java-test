<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Config List</title>
</head>
<body>
<div style="margin:0 auto">
<div>
<a href="add">ADD</a>
</div>
	<table>
		<thead>
			<tr>
			<th>id</th>
			<th>key</th>
			<th>value</th>
			<th>createTime</th>
			<th>updateTime</th>
			<th>operation</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="config">
			<tr>
				<td>${config.id }</td>
				<td>${config.configKey }</td>
				<td>${config.configValue }</td>
				<td>${config.createTime }</td>
				<td>${config.updateTime }</td>
				<td><a href="update/${config.id }">EDIT</a> | <a href="delete/${config.id }">DELETE</a></td>
				<td></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>