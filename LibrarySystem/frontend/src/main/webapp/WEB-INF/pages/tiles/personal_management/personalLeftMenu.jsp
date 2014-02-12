<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/personalListAssigned" method="POST">
                <s:message code="pages.personManagement.listAssigned" var="listAssigned"/>
                <input type="submit" value="${listAssigned}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/personalFindAssigned" method="POST">
                <s:message code="pages.personManagement.findAssigned" var="findAssigned"/>
                <input type="submit" value="${findAssigned}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/personalSettings" method="POST">
                <s:message code="pages.personManagement.settings" var="settings"/>
                <input type="submit" value="${settings}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/infoUser" method="POST">
                <input type="hidden" name="user_id" value="${sessionScope['loggedUser'].id}"/>
                <s:message code="pages.personManagement.infoUser" var="infoUser"/>
                <input type="submit" value="${infoUser}"/>
            </form>
        </td>
    </tr>
</table>