<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/addUser" method="POST">
                <s:message code="pages.userManagement.addUser" var="addUser"/>
                <input type="submit" value="${addUser}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/listUsers" method="POST">
                <s:message code="pages.userManagement.listUsers" var="listUsers"/>
                <input type="submit" value="${listUsers}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/findUser" method="POST">
                <s:message code="pages.userManagement.findUser" var="findUser"/>
                <input type="submit" value="${findUser}"/>
            </form>
        </td>
    </tr>
</table>