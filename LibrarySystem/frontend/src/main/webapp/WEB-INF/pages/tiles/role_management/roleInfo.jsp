<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table>
    <tr>
        <td colspan="2"><h3><s:message code="pages.roleManagement.infoRole.title" arguments="${viewedRole.name}"/></h3></td>
    </tr>
    <tr>
        <td><s:message code="pages.roleManagement.infoRole.name"/>:</td>
        <td>${viewedRole.name}</td>
    </tr>
    <tr>
        <td><s:message code="pages.roleManagement.infoRole.description"/>:</td>
        <td>${viewedRole.description}</td>
    </tr>
</table>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/updateRole" method="POST">
                <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                <s:message code="pages.roleManagement.infoRole.actions.update" var="updateRole"/>
                <input type="submit" value="${updateRole}"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/management/permissionRole" method="POST">
                <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                <s:message code="pages.roleManagement.infoRole.permissionRole" var="viewPermissionRole"/>
                <input type="submit" value="${viewPermissionRole}"/>
            </form>
        </td>
    </tr>
</table>
