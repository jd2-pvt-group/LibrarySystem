<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.02.14
  Time: 15:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:if test="${not empty sessionScope['viewedBookTypeFlow'] and not empty sessionScope['viewedBookTypeFlow'].bookSerial}">
    <div class="data_content">
        <hr/>
        <h3 class="well title"><s:message code="pages.libraryManagement.infoBookSerial.selectBookSerial"/></h3>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.addBookSerial.name"/>:</td>
                    <td>${sessionScope['viewedBookTypeFlow'].bookSerial.name}</td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.addBookSerial.description"/>:</td>
                    <td>${sessionScope['viewedBookTypeFlow'].bookSerial.description}</td>
                </tr>
            </tbody>
        </table>
        <form action="${pageContext.request.contextPath}/management/removeSelectedBookSerial" method="POST">
            <s:message code="pages.libraryManagement.listBookSerials.actions.delete" var="delete"/>
            <c:if test="${not empty param['bookSerial_id']}">
                <input type="hidden" name="bookSerial_id" value="${param['bookSerial_id']}"/>
            </c:if>
            <input type="hidden" name="onPage" value="${param['onPage']}"/>
            <button class="btn btn-primary" type="submit">${delete}</button>
        </form>
    </div>
</c:if>
