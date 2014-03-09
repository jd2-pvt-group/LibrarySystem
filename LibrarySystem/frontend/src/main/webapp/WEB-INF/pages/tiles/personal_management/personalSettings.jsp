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
    <h3 class="well title"><s:message code="pages.personManagement.settings.title"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td>
                    Some data here
                </td>
            </tr>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/management/updatePersonalSettings" method="POST">
        <button class="btn btn-primary" type="submit"><s:message code="pages.personManagement.settings.actions.update"/></button>
    </form>
</div>