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
<form:form action="${pageContext.request.contextPath}/management/changeUser" method="POST" commandName="viewedUser">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td colspan="2">
                <h3><s:message code="pages.userManagement.updateUser.title"/></h3>
            </td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.login"/>:</td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="login"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.password"/>:</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="password"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.firstName"/>:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.lastName"/>:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.passportNumber"/>:</td>
            <td><form:input path="passportNumber"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="passportNumber"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.address"/>:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.infoUser.isActive"/>:</td>
            <td><form:checkbox path="active"/></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <input type="hidden" name="user_id" value="${viewedUser.id}"/>
                <s:message code="pages.userManagement.infoUser.update" var="updateInfo"/>
                <input type="submit" value="${updateInfo}"/>
            </td>
        </tr>
    </table>
</form:form>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/infoUser" method="POST">
                <input type="hidden" name="user_id" value="${viewedUser.id}"/>
                <s:message code="pages.userManagement.updateUser.back" var="back"/>
                <input type="submit" value="${back}"/>
            </form>
        </td>
    </tr>
</table>