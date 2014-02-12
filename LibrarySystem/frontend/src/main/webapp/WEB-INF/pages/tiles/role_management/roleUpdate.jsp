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
<form:form action="${pageContext.request.contextPath}/management/changeRole" method="POST" commandName="viewedRole">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td colspan="2"><h3><s:message code="pages.roleManagement.updateRole.title"/></h3></td>
        </tr>
        <tr>
            <td><s:message code="pages.roleManagement.infoRole.name"/>:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.roleManagement.infoRole.description"/>:</td>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="description"/></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <s:message code="pages.roleManagement.infoRole.actions.update" var="updateRole"/>
                <input type="submit" value="${updateRole}"/>
            </td>
        </tr>
    </table>
</form:form>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/infoRole" method="POST">
                <input type="hidden" name="role_id" value="${viewedRole.id}"/>
                <s:message code="pages.roleManagement.updateRole.back" var="back"/>
                <input type="submit" value="${back}"/>
            </form>
        </td>
    </tr>
</table>