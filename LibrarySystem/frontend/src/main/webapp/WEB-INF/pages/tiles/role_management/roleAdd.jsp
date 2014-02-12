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
<form:form action="${pageContext.request.contextPath}/management/addNewRole" method="POST" commandName="viewedRole">
    <table>
        <tr>
            <td colspan="2"><h3><s:message code="pages.roleManagement.addRole.title"/></h3></td>
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
                <s:message code="pages.roleManagement.addRole.createRole" var="createRole"/>
                <input type="submit" value="${createRole}"/>
            </td>
        </tr>
    </table>
</form:form>