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
    <h3 class="well title"><s:message code="pages.userManagement.updateUser.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/changeUser" method="POST" commandName="viewedUser">
        <form:hidden path="id"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.login"/>:</td>
                    <td><form:input cssClass="input-block-level" path="login"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="login"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.password"/>:</td>
                    <td><form:input cssClass="input-block-level" path="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="password"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.firstName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.lastName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.passportNumber"/>:</td>
                    <td><form:input cssClass="input-block-level" path="passportNumber"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="passportNumber"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.address"/>:</td>
                    <td><form:input cssClass="input-block-level" path="address"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.infoUser.isActive"/>:</td>
                    <td><form:checkbox cssClass="checkbox" path="active"/></td>
                </tr>
            </tbody>
        </table>
        <input type="hidden" name="user_id" value="${viewedUser.id}"/>
        <s:message code="pages.userManagement.infoUser.update" var="updateInfo"/>
        <button class="btn btn-primary" type="submit">${updateInfo}</button>
    </form:form>
    <form action="${pageContext.request.contextPath}/management/infoUser" method="POST">
        <input type="hidden" name="user_id" value="${viewedUser.id}"/>
        <s:message code="pages.userManagement.updateUser.back" var="back"/>
        <button class="btn btn-primary" type="submit">${back}</button>
    </form>
</div>