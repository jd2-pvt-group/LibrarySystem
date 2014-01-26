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
    <title>List of authors</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/new" method="POST">
        <input type="submit" value="Create new author"/>
    </form>
    <table>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
            </tr>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.id}</td>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/delete/${author.id}">
                        <input type="submit" value="Remove author"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>