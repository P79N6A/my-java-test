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
		<a href="add">ADD</a>
	</div>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>url</th>
				<th>cssSelector</th>
				<th>intrevalTime</th>
				<th>operation</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="subscribeInfo">
			<tbody>
			<tr>
				<td>${subscribeInfo.id }</td>
				<td>${subscribeInfo.name }</td>
				<td>${subscribeInfo.url }</td>
				<td>${subscribeInfo.cssSelector }</td>
				<td>${subscribeInfo.intervalTime }</td>
				<td><a href="delete/${subscribeInfo.id }">删除</a></td>
			</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>