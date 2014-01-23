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
    <title>List of addresses</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/create" method="POST" modelAttribute="address">
        <form:input path="country"/><br/>
        <form:input path="city"/><br/>
        <form:input path="street"/><br/>
        <form:input path="apartment"/><br/>
        <input type="submit" value="Save new address"/>
    </form:form>
</body>
</html>