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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.addBookSerial.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/addNewBookSerial" method="POST" commandName="viewedBookSerial">
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.addBookSerial.name"/>:</td>
                    <td><form:input cssClass="input-block-level" path="name"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors cssClass="alert alert-error" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.addBookSerial.description"/>:</td>
                    <td><form:textarea rows="5" cssClass="input-block-level" path="description"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.addBookSerial.actions.create" var="createBookSerial"/>
        <button class="btn btn-primary" type="submit">${createBookSerial}</button>
    </form:form>
    <jsp:include page="bookSerialSelected.jsp">
        <jsp:param name="onPage" value="ADD"/>
    </jsp:include>
</div>