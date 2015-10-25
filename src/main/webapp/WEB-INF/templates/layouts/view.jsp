<%@taglib uri="http://www.springframework.org/tags" prefix="locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<locale:message code="label.square" />${message}<br>
	<locale:message code="label.perimeter" />${perimeter}
	Current Locale : ${pageContext.response.locale}
	
	
	<form action="circle.page" method="POST">
		<input type="text" name="radius" />
		<input type="submit" name="submit value="circle calc" />
		
	</form>
</body>
</html>