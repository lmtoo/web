<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><t:getAsString name="title" /></title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2"><t:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td><t:insertAttribute name="menu" /></td>
			<td><t:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td colspan="2"><t:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>