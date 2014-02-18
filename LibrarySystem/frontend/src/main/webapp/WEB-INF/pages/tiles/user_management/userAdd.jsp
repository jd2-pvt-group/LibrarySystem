<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 02.02.14
  Time: 0:01
  To change this template use File | Settings | File Templates.
  add user
  button back ?  xz

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.userManagement.addUser.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/createUser" method="POST" commandName="viewedUser">
        <form:hidden path="id"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.login"/>:</td>
                    <td><form:input cssClass="input-block-level" path="login"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="login"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.password"/>:</td>
                    <td><form:input cssClass="input-block-level" path="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="password"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.firstName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.lastName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.passportNumber"/>:</td>
                    <td><form:input cssClass="input-block-level" path="passportNumber"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="passportNumber"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.addUser.address"/>:</td>
                    <td><form:input cssClass="input-block-level" path="address"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.userManagement.addUser.add" var="addUser"/>
        <button class="btn btn-primary" type="submit">${addUser}</button>
    </form:form>
</div>
