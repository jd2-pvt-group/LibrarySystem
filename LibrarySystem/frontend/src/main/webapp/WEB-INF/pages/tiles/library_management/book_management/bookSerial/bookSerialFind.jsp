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
    <h3 class="well title"><s:message code="pages.libraryManagement.findBookSerial.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/foundBookSerials" method="POST" commandName="viewedBookSerial">
        <form:errors cssClass="alert alert-error" path="*"/><hr/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookSerial.partOfName"/></td>
                    <td><form:input cssClass="input-block-level" path="name"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.findBookSerial.partOfDescription"/></td>
                    <td><form:input cssClass="input-block-level" path="description"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.findBookSerial.actions.find" var="find"/>
        <button class="btn btn-primary" type="submit">${find}</button>
    </form:form>
    <jsp:include page="bookSerialSelected.jsp">
        <jsp:param name="onPage" value="FIND"/>
    </jsp:include>
</div>