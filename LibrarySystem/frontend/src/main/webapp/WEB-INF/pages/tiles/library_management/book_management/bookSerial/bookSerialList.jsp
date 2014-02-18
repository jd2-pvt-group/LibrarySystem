<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<s:message code="pages.libraryManagement.listBookSerials.actions.apply" var="apply"/>
<s:message code="pages.libraryManagement.listBookSerials.actions.delete" var="delete"/>
<s:message code="pages.libraryManagement.listBookSerials.actions.info" var="info"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.listBookSerials.title"/></h3>
    <table>
        <c:choose>
            <c:when test="${not empty viewedBookSerials}">
                <thead>
                    <tr>
                        <th><s:message code="pages.libraryManagement.addBookSerial.name"/></th>
                        <th><s:message code="pages.libraryManagement.addBookSerial.description"/></th>
                        <th>${info}</th>
                        <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                            <th>${apply}</th>
                        </c:if>
                        <th>${delete}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bookSerial" items="${viewedBookSerials}">
                        <tr>
                            <td>${bookSerial.name}</td>
                            <td>${bookSerial.description}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/infoBookSerial" method="POST">
                                    <input type="hidden" name="bookSerial_id" value="${bookSerial.id}">
                                    <button class="btn btn-primary" type="submit">${info}</button>
                                </form>
                            </td>
                            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                                <td>
                                    <form action="${pageContext.request.contextPath}/management/addBookSerialToBookType" method="POST">
                                        <input type="hidden" name="bookSerial_id" value="${bookSerial.id}">
                                        <button class="btn btn-primary" type="submit">${apply}</button>
                                    </form>
                                </td>
                            </c:if>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/deleteBookSerial" method="POST">
                                    <input type="hidden" name="bookSerial_id" value="${bookSerial.id}">
                                    <button class="btn btn-primary" type="submit">${delete}</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <s:message code="pages.libraryManagement.listBookSerials.notFound"/>
            </c:otherwise>
        </c:choose>
    </table>
    <jsp:include page="bookSerialSelected.jsp">
        <jsp:param name="onPage" value="LIST"/>
    </jsp:include>
</div>
