<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/personalListAssigned">
        <s:message code="pages.personManagement.listAssigned"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/personalFindAssigned">
        <s:message code="pages.personManagement.findAssigned"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/personalSettings">
        <s:message code="pages.personManagement.settings"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/infoUser?user_id=${sessionScope['loggedUser'].id}">
        <s:message code="pages.personManagement.infoUser"/>
    </a>
</li>
