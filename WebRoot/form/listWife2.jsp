<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<html>
<head>
<title>JSP for WifeForm form</title>
<style type="text/css">
body, td, th, input {
	font-size: 12px;
}

table {
	border-collapse: collapse;
	border: 1px solid #000000;
}

th, td {
	border-collapse: collapse;
	border: 1px solid #000000;
	padding: 4px;
}
</style>
</head>
<body>
	<html:form action="/wife2">
		<input type="hidden" name="action" value="add" />
		<html:text property="name" />
		<html:submit value="添加" />
	</html:form>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>CreateDate</th>
		</tr>
		<logic:iterate id="wife" name="wifeList">
			<tr>
				<td><bean:write name="wife" property="id" /></td>
				<td><bean:write name="wife" property="name" /></td>
				<td><bean:write name="wife" property="createdDate"
						format="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</logic:iterate>
	</table>

</body>
</html>

