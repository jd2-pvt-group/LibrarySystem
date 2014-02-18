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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.roleManagement.infoRole.title" arguments="${viewedRole.name}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.roleManagement.infoRole.name"/>:</td>
                <td>${viewedRole.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.roleManagement.infoRole.description"/>:</td>
                <td>${viewedRole.description}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/updateRole" method="POST">
                    <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                    <s:message code="pages.roleManagement.infoRole.actions.update" var="updateRole"/>
                    <button class="btn btn-primary" type="submit">${updateRole}</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/management/permissionRole" method="POST">
                    <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                    <s:message code="pages.roleManagement.infoRole.permissionRole" var="viewPermissionRole"/>
                    <button class="btn btn-primary" type="submit">${viewPermissionRole}</button>
                </form>
            </td>
        </tr>
    </table>
</div>
