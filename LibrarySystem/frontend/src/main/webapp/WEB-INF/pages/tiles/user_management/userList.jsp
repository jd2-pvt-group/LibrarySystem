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
    <td colspan="2">
        <h3><s:message code="pages.userManagement.userList.title"/></h3>
    </td>
</tr>
<tr>
    <td><s:message code="pages.userManagement.userList.login"/></td>
    <td><s:message code="pages.userManagement.userList.password"/></td>
    <td><s:message code="pages.userManagement.userList.firstName"/></td>
    <td><s:message code="pages.userManagement.userList.lastName"/></td>
    <td><s:message code="pages.userManagement.userList.passportNumber"/></td>
    <td><s:message code="pages.userManagement.userList.address"/></td>
    <td><s:message code="pages.userManagement.userList.isActive"/></td>
    <td><s:message code="pages.userManagement.userList.infoUser"/></td>
</tr>
<c:if test="${not empty viewedUsers}" >
<c:forEach var="user" items="${viewedUsers}">
    <tr>
        <td>${user.login}</td>
    <td>${user.password}</td>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
    <td>${user.passportNumber}</td>
    <td>${user.address}</td>
    <td>${user.active}</td>
    <td>
        <form:form action="${pageContext.request.contextPath}/management/infoUser" method="POST">
            <input type="hidden" name="user_id" value="${user.id}"/>
            <s:message code="pages.userManagement.userList.infoUser" var="userInfo"/>
            <input type="submit" value="${userInfo}"/>
        </form:form>
    </td>
    </tr>
</c:forEach>
</c:if>

</table>
