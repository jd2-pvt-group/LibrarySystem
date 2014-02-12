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
            <form action="${pageContext.request.contextPath}/management/bookManagement" method="POST">
                <s:message code="pages.libraryManagement.bookManagement" var="bookManagement"/>
                <input type="submit" value="${bookManagement}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/bookOrderingManagement" method="POST">
                <s:message code="pages.libraryManagement.bookOrderingManagement" var="bookOrderingManagement"/>
                <input type="submit" value="${bookOrderingManagement}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/management/bookHistoryManagement" method="POST">
                <s:message code="pages.libraryManagement.bookHistoryManagement" var="bookHistoryManagement"/>
                <input type="submit" value="${bookHistoryManagement}"/>
            </form>
        </td>
    </tr>
</table>