<#include "/common/tlds.ftl">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#assign basePath=request.contextPath> 
<#assign saicf=JspTaglibs["http://it.saic.com/saicf"]>
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<form name="employee" action="save" method="POST">
	<@saicf.noRepeatSubmit formName="employee"/>
		<table>
			<TR>
				<TD>姓名:</TD>
				<TD><input type="text" name="userName"></input></TD>
				<TD>部门:</TD>
				<TD><input type="text" name="dept"></input></TD>
			</TR>
		</table>
		<br/>
		<input type="submit"/>
	</form>
</body>
</html>
