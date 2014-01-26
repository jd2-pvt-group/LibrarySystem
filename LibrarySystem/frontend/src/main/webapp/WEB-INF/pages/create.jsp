<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 22.01.14
  Time: 20:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Creation of new author</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/create" method="POST" modelAttribute="author">
        <form:input path="firstName"/><br/>
        <form:input path="lastName"/><br/>
        <input type="submit" value="Save new author"/>
    </form:form>
</body>
</html>