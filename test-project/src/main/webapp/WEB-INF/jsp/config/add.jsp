<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Config Add</title>
</head>
<body>
<body>
	<div>
		<a href="list">LIST</a>
	</div>
	<form action="add" method="post">
	<table>
		<tbody>
			<tr>
				<td>Key</td>
				<td><input name="configKey" type="text"/></td>
			</tr>
			<tr>
				<td>Value</td>
				<td><input name="configValue" type="text"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</body>
</html>