<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 28.01.14
  Time: 0:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form cssClass="form-signin" action="${pageContext.request.contextPath}/login" method="POST" commandName="loginForm">
    <label><s:message code="pages.personManagement.settings.language"/>:
        <select name="lang" onchange="submitFormForAction('#loginForm','${pageContext.request.contextPath}/');">
            <c:forEach var="language" items="${requestScope['languages']}">
                <c:choose>
                    <c:when test="${not empty sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}">
                        <c:choose>
                            <c:when test="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'] eq language.shortName}">
                                <option value="${language.shortName}" selected="selected">${language.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${language.shortName}">${language.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${empty sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}">
                        <c:choose>
                            <c:when test="${language.shortName eq 'en'}">
                                <option value="${language.shortName}" selected="selected">${language.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${language.shortName}">${language.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <option value="${language.shortName}">${language.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    <h3 class="form-signin-heading"><s:message code="pages.loginForm.title"/></h3>
    <form:label path="login"><s:message code="pages.loginForm.username"/></form:label>
    <form:input cssClass="input-block-level" path="login"/>
    <form:errors cssClass="alert alert-error" path="login"/>
    <br/><br/>
    <form:label path="password"><s:message code="pages.loginForm.password"/></form:label>
    <form:password cssClass="input-block-level" path="password"/>
    <form:errors cssClass="alert alert-error" path="password"/>
    <br/><br/>
    <s:message code="pages.loginForm.submit" var="submit"/>
    <button class="btn btn-large btn-primary" type="submit">${submit}</button>
</form:form>