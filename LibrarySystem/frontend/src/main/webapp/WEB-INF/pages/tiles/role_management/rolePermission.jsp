<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form action="${pageContext.request.contextPath}/management/deletePermissionRole" method="POST">
    <table>
        <tr>
            <td colspan="2"><h3><s:message code="pages.roleManagement.permission.forRole" arguments="${viewedRole.name}"/></h3></td>
        </tr>
        <c:choose>
            <c:when test="${not empty viewedPermissions}">
                <tr>
                    <th><s:message code="pages.roleManagement.permission.code"/></th>
                    <th><s:message code="pages.roleManagement.permission.description"/></th>
                    <th><s:message code="pages.roleManagement.permission.remove"/></th>
                </tr>
                <c:forEach var="viewedPermission" items="${viewedPermissions}">
                    <tr>
                        <td>${viewedPermission.code}</td>
                        <td>${viewedPermission.description}</td>
                        <td><input type="checkbox" name="selectedPermissions" value="${viewedPermission.id}"/></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td><s:message code="pages.roleManagement.permission.notFound"/></td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <c:if test="${not empty viewedPermissions}">
        <table>
            <tr>
                <td>
                    <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                    <s:message code="pages.roleManagement.permission.deletePermission" var="deletePermission"/>
                    <input type="submit" value="${deletePermission}"/>
                </td>
            </tr>
        </table>
    </c:if>
</form>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/addPermissionRole" method="POST">
                <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                <s:message code="pages.roleManagement.permission.addPermission" var="addPermission"/>
                <input type="submit" value="${addPermission}"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                <s:message code="pages.roleManagement.updateRole.back" var="back"/>
                <input type="submit" value="${back}"/>
            </form>
        </td>
    </tr>
</table>