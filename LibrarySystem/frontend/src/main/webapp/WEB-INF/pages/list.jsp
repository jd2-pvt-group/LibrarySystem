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
    <form action="${pageContext.request.contextPath}/create" method="POST">
        <input type="submit" value="Create new address"/>
    </form>
    <table>
            <tr>
                <th>Country</th>
                <th>City</th>
                <th>Street</th>
                <th>Apartment</th>
            </tr>
        <c:forEach var="address" items="${addresses}">
            <tr>
                <td>${address.country}</td>
                <td>${address.city}</td>
                <td>${address.street}</td>
                <td>${address.apartment}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>