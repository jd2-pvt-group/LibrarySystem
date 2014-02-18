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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.roleManagement.permission.forRole" arguments="${viewedRole.name}"/></h3>
    <form action="${pageContext.request.contextPath}/management/deletePermissionRole" method="POST">
        <table class="table">
            <c:choose>
                <c:when test="${not empty viewedPermissions}">
                    <thead>
                        <tr>
                            <th><s:message code="pages.roleManagement.permission.code"/></th>
                            <th><s:message code="pages.roleManagement.permission.description"/></th>
                            <th><s:message code="pages.roleManagement.permission.remove"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="viewedPermission" items="${viewedPermissions}">
                            <tr>
                                <td>${viewedPermission.code}</td>
                                <td>${viewedPermission.description}</td>
                                <td><input type="checkbox" class="checkbox" name="selectedPermissions" value="${viewedPermission.id}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </c:when>
                <c:otherwise>
                    <s:message code="pages.roleManagement.permission.notFound"/>
                </c:otherwise>
            </c:choose>
        </table>
        <c:if test="${not empty viewedPermissions}">
            <input type="hidden" name="role_id" value="${viewedRole.id}"/>
            <s:message code="pages.roleManagement.permission.deletePermission" var="deletePermission"/>
            <button class="btn btn-primary" type="submit">${deletePermission}</button>
        </c:if>
    </form>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/addPermissionRole" method="POST">
                    <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                    <s:message code="pages.roleManagement.permission.addPermission" var="addPermission"/>
                    <button class="btn btn-primary" type="submit">${addPermission}</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                    <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                    <s:message code="pages.roleManagement.updateRole.back" var="back"/>
                    <button class="btn btn-primary" type="submit">${back}</button>
                </form>
            </td>
        </tr>
    </table>
</div>