<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/19/14
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.roleManagement.listRoles.title"/></h3>
    <form action="${pageContext.request.contextPath}/management/addRolesToUser" method="POST"  >
        <input type="hidden" name="user_id" value="${viewedUser.id}"/>
    <table class="table">
        <c:choose>
            <c:when test="${not empty viewedRoles}">
                <thead>
                <tr>
                    <th><s:message code="pages.userManagement.addRoles.actions.add"/></th>
                    <th><s:message code="pages.userManagement.addRoles.name"/></th>
                    <th><s:message code="pages.userManagement.addRoles.description"/></th>
                    <th><s:message code="pages.userManagement.addRoles.actions.info"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="role" items="${viewedRoles}">
                    <tr>
                        <td> <input type="checkbox" class="checkbox" name="selectedRoles" value="${role.id}"/></td>
                        <td>${role.name}</td>
                        <td>${role.description}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                                <input type="hidden" name="role_id" value="${role.id}"/>
                                <s:message code="pages.userManagement.addRoles.actions.info" var="viewInfo"/>
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


        <s:message code="pages.userManagement.addRoles.actions.add" var="addRoles"/>
        <button class="btn btn-primary" type="submit">${addRoles}</button>
    </form>
</div>
