<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Dept</title>
</head>
<body>
<jsp:useBean id="s" class="model.Student"/>
<jsp:setProperty property="*" name="s"/>
Dept of <jsp:getProperty property="studentName" name="s"/> is <b><%=request.getAttribute("dept") %></b><br/>
</body>
</html>