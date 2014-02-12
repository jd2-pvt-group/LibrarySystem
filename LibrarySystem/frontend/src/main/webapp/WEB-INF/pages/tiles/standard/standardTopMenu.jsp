<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<table>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/userManagement" method="POST">
                <s:message code="pages.standard.top_menu.userManagement" var="userManagement"/>
                <input type="submit" value="${userManagement}"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/management/roleManagement" method="POST">
                <s:message code="pages.standard.top_menu.roleManagement" var="roleManagement"/>
                <input type="submit" value="${roleManagement}"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/management/libraryManagement" method="POST">
                <s:message code="pages.standard.top_menu.libraryManagement" var="libraryManagement"/>
                <input type="submit" value="${libraryManagement}"/>
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/management/personalManagement" method="POST">
                <s:message code="pages.standard.top_menu.personalManagement" var="personalManagement"/>
                <input type="submit" value="${personalManagement}"/>
            </form>
        </td>
    </tr>
</table>