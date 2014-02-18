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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.roleManagement.updateRole.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/changeRole" method="POST" commandName="viewedRole">
        <form:hidden path="id"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.roleManagement.infoRole.name"/>:</td>
                    <td>
                        <form:input cssClass="input-block-level" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.roleManagement.infoRole.description"/>:</td>
                    <td><form:textarea rows="5" cssClass="input-block-level" path="description"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.roleManagement.infoRole.actions.update" var="updateRole"/>
        <button class="btn btn-primary" type="submit">${updateRole}</button>
    </form:form>
    <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
        <input type="hidden" name="role_id" value="${viewedRole.id}"/>
        <s:message code="pages.roleManagement.updateRole.back" var="back"/>
        <button class="btn btn-primary" type="submit">${back}</button>
    </form>
</div>