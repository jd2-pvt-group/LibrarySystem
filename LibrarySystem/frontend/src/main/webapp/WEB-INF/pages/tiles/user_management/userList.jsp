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
    <h3 class="well title"><s:message code="pages.userManagement.userList.title"/></h3>
    <table class="table">
        <c:choose>
            <c:when test="${not empty listViewedUser}" >
            <thead>
                <tr>
                    <th><s:message code="pages.userManagement.userList.login"/></th>
                    <th><s:message code="pages.userManagement.userList.firstName"/></th>
                    <th><s:message code="pages.userManagement.userList.lastName"/></th>
                    <th><s:message code="pages.userManagement.userList.passportNumber"/></th>
                    <th><s:message code="pages.userManagement.userList.isActive"/></th>
                    <th><s:message code="pages.userManagement.userList.actions.info"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${listViewedUser}">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.passportNumber}</td>
                        <td>${user.active}</td>
                        <td>
                            <form:form action="${pageContext.request.contextPath}/management/infoUser" method="POST">
                                <input type="hidden" name="user_id" value="${user.id}"/>
                                <s:message code="pages.userManagement.userList.actions.info" var="userInfo"/>
                                <button class="btn btn-primary" type="submit">${userInfo}</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            </c:when>
            <c:otherwise>
                <s:message code="pages.userManagement.userList.noFound"/>
            </c:otherwise>
        </c:choose>
    </table>
</div>