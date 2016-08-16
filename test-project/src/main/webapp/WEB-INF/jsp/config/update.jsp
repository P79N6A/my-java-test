<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Config Update</title>
</head>
<body>
<body>
	<div>
		<a href="list">LIST</a>
	</div>
	<form action="/config/update" method="post">
	<table>
		<tbody>
			<tr>
				<td>Key</td>
				<td><input name="configKey" type="text" readonly="readonly" value="${config.configKey }"/></td>
			</tr>
			<tr>
				<td>Value</td>
				<td><input name="configValue" type="text" value="${config.configValue }"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="id" value="${config.id }"/><input type="submit"/></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</body>
</html>