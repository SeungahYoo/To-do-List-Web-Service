<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	요청 처리 과정에서 에러가 발생하였습니다.
	<br>
	<br> 에러 타입 : <%=exception.getClass().getName()%><br>
	에러 메세지 : <%=exception.getMessage()%>
</body>
</html>