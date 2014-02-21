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
    <h3 class="well title"><s:message code="pages.userManagement.infoUser.title" arguments="${viewedUser.login}"/></h3>
    <table class="table">
        <tbody>
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
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/management/updateUser" method="POST">
        <input type="hidden" name="user_id" value="${viewedUser.id}"/>
        <s:message code="pages.userManagement.infoUser.update" var="updateInfo"/>
        <button class="btn btn-primary" type="submit">${updateInfo}</button>
    </form>

    <table class="table">
        <tbody>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.Roles"/>:</td>

        </tr>
        <c:forEach var="role" items="${viewedRoles}">
            <tr>
                <td>${role.name}</td>



                <td>${role.description}</td>




            <td>
            <form:form action="${pageContext.request.contextPath}/management/deleteUsersRole" method="POST">
                <input type="hidden" name="role" value="${role}"/>
                <s:message code="pages.userManagement.infoUser.Roles.delete" var="remove"/>
                <button class="btn btn-primary" type="submit">${remove}</button>
            </form:form>
            </td>
        </c:forEach>

        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/management/addRoleUser" method="POST">
        <input type="hidden" name="user_id" value="${viewedUser.id}"/>
        <s:message code="pages.userManagement.infoUser.Roles.addRole" var="addRole"/>
        <button class="btn btn-primary" type="submit">${addRole}</button>
    </form>
</div>