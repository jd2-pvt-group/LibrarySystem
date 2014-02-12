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
<form:form action="${pageContext.request.contextPath}/management/foundUsers" method="POST" commandName="viewedUser">
    <table>
        <tr>
            <td colspan="2">
                <h3><s:message code="pages.userManagement.userFind.title"/></h3>
            </td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.userFind.firstName"/>:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td colspan="2"><form:errors path="firstName"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.userFind.lastName"/>:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><s:message code="pages.userManagement.userFind.passport"/>:</td>
            <td><form:input path="passportNumber"/></td>
        </tr>

        <tr>
            <td><s:message code="pages.userManagement.userFind.adress"/>:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td>
                <s:message code="pages.userManagement.userFind.actions.find" var="findUser"/>
                <input type="submit" value="${findUser}"/>
            </td>
        </tr>
    </table>
</form:form>
