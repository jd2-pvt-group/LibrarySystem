<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 28.01.14
  Time: 0:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/login" method="POST" commandName="user">
    <table>
        <tr>
            <td><form:label path="login"><s:message code="pages.loginForm.username"/></form:label></td>
            <td><form:input path="login"/></td>
        </tr>
        <tr><td></td>
            <td><form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password"><s:message code="pages.loginForm.password"/></form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr><td></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <s:message code="pages.loginForm.submit" var="submit"/>
                <input type="submit" value="${submit}">
            </td>
        </tr>
    </table>
</form:form>