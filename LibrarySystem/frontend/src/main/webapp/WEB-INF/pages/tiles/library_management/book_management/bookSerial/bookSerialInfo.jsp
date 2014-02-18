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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.infoBookSerial.title" arguments="${viewedBookSerial.name}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.addBookSerial.name"/>:</td>
                <td>${viewedBookSerial.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.addBookSerial.description"/>:</td>
                <td>${viewedBookSerial.description}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/updateBookSerial" method="POST">
                    <input type="hidden" name="bookSerial_id" value="${viewedBookSerial.id}"/>
                    <s:message code="pages.libraryManagement.infoBookSerial.actions.update" var="updateBookSerial"/>
                    <button class="btn btn-primary" type="submit">${updateBookSerial}</button>
                </form>
            </td>
            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                <td>
                    <form action="${pageContext.request.contextPath}/management/addBookSerialToBookType" method="POST">
                        <input type="hidden" name="bookSerial_id" value="${viewedBookSerial.id}"/>
                        <s:message code="pages.libraryManagement.addBookType.actions.addToBookType" var="addToBookType"/>
                        <button class="btn btn-primary" type="submit">${addToBookType}</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </table>
    <jsp:include page="bookSerialSelected.jsp">
        <jsp:param name="bookSerial_id" value="${viewedBookSerial.id}"/>
        <jsp:param name="onPage" value="INFO"/>
    </jsp:include>
</div>
