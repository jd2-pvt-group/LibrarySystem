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
            <form action="${pageContext.request.contextPath}/management/addRole" method="POST">
                <s:message code="pages.roleManagement.addRole" var="addRole"/>
                <input type="submit" value="${addRole}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/listRoles" method="POST">
                <s:message code="pages.roleManagement.listRoles" var="listRoles"/>
                <input type="submit" value="${listRoles}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/findRole" method="POST">
                <s:message code="pages.roleManagement.findRole" var="findRole"/>
                <input type="submit" value="${findRole}"/>
            </form>
        </td>
    </tr>
</table>