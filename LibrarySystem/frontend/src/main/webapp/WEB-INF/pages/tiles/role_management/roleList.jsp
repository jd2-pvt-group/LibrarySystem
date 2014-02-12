<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
    <tr>
        <td colspan="2">
            <h3>
            <c:choose>
                <c:when test="${empty viewedRoles}">
                    <s:message code="pages.roleManagement.listRoles.title.notFound"/>
                </c:when>
                <c:otherwise>
                    <s:message code="pages.roleManagement.listRoles.title"/>
                </c:otherwise>
            </c:choose>
            </h3>
        </td>
    </tr>
    <c:if test="${not empty viewedRoles}">
        <tr>
            <th><s:message code="pages.roleManagement.infoRole.name"/></th>
            <th><s:message code="pages.roleManagement.listRoles.actions.info"/></th>
        </tr>
        <c:forEach var="role" items="${viewedRoles}">
        <tr>
            <td>${role.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                    <input type="hidden" name="role_id" value="${role.id}"/>
                    <s:message code="pages.roleManagement.listRoles.actions.info" var="viewInfo"/>
                    <input type="submit" value="${viewInfo}"/>
                </form>
            </td>
        </tr>
        </c:forEach>
    </c:if>
</table>