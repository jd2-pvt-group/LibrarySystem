<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.personManagement.updateSettings.title"/></h3>
    <form action="${pageContext.request.contextPath}/management/changePersonalSettings" method="POST">
        <table class="table">
            <tbody>
            <tr>
                <td>
                    <label><s:message code="pages.personManagement.settings.language"/>:
                        <select id="language" name="lang">
                            <c:forEach var="language" items="${requestScope['languages']}">
                                <c:choose>
                                    <c:when test="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'] eq language.shortName}">
                                        <option value="${language.shortName}" selected="selected">${language.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${language.shortName}">${language.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" type="submit"><s:message code="pages.personManagement.settings.actions.update"/></button>
    </form>
    <form action="${pageContext.request.contextPath}/management/personalSettings" method="GET">
        <button class="btn btn-primary" type="submit"><s:message code="pages.personManagement.settings.actions.back"/></button>
    </form>
</div>