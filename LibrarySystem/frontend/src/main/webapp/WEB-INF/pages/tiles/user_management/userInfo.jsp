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
<table>
    <tr>
        <td colspan="2">
            <h3><s:message code="pages.userManagement.infoUser.title" arguments="${viewedUser.login}"/></h3>
        </td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.login"/>:</td>
        <td>${viewedUser.login}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.password"/>:</td>
        <td>${viewedUser.password}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.firstName"/>:</td>
        <td>${viewedUser.firstName}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.lastName"/>:</td>
        <td>${viewedUser.lastName}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.passportNumber"/>:</td>
        <td>${viewedUser.passportNumber}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.address"/>:</td>
        <td>${viewedUser.address}</td>
    </tr>
    <tr>
        <td><s:message code="pages.userManagement.infoUser.isActive"/>:</td>
        <td>${viewedUser.active}</td>
    </tr>
</table>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/updateUser" method="POST">
                <input type="hidden" name="user_id" value="${viewedUser.id}"/>
                <s:message code="pages.userManagement.infoUser.update" var="updateInfo"/>
                <input type="submit" value="${updateInfo}"/>
            </form>
        </td>
    </tr>
</table>