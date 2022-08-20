<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List, tagdemo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Student> data = new ArrayList<>();
		data.add(new Student("Vijay", "Kumar"));
		data.add(new Student("Venkata", "Chandu"));
		data.add(new Student("Harsha", "Vardhan"));
		pageContext.setAttribute("mystudents", data);
	%>

	<c:forEach var="student" items="${mystudents}">
		${student.firstName} ${student.lastName}
	</c:forEach>	


</body>
</html>