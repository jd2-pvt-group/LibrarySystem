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
    <h3 class="well title"><s:message code="pages.userManagement.userFind.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/foundUsers" method="POST" commandName="viewedUser">
        <form:errors cssClass="alert alert-error" path="*"/><hr/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.userManagement.userFind.firstName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="firstName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.userFind.lastName"/>:</td>
                    <td><form:input cssClass="input-block-level" path="lastName"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.userManagement.userFind.passport"/>:</td>
                    <td><form:input cssClass="input-block-level" path="passportNumber"/></td>
                </tr>

                <tr>
                    <td><s:message code="pages.userManagement.userFind.address"/>:</td>
                    <td><form:input cssClass="input-block-level" path="address"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.userManagement.userFind.actions.find" var="findUser"/>
        <button class="btn btn-primary" type="submit">${findUser}</button>
    </form:form>
</div>