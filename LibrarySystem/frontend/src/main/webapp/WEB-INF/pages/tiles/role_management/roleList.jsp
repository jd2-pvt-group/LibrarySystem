<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.roleManagement.listRoles.title"/></h3>
    <table class="table">
        <c:choose>
            <c:when test="${not empty viewedRoles}">
                <thead>
                    <tr>
                        <th><s:message code="pages.roleManagement.infoRole.name"/></th>
                        <th><s:message code="pages.roleManagement.infoRole.description"/></th>
                        <th><s:message code="pages.roleManagement.listRoles.actions.info"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="role" items="${viewedRoles}">
                        <tr>
                            <td>${role.name}</td>
                            <td>${role.description}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                                    <input type="hidden" name="role_id" value="${role.id}"/>
                                    <s:message code="pages.roleManagement.listRoles.actions.info" var="viewInfo"/>
                                    <button class="btn btn-primary" type="submit">${viewInfo}</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <s:message code="pages.roleManagement.listRoles.title.notFound"/>
            </c:otherwise>
        </c:choose>
    </table>
</div>