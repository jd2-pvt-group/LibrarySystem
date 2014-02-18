<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/addUser">
        <s:message code="pages.userManagement.addUser"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listUsers">
        <s:message code="pages.userManagement.listUsers"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findUser">
        <s:message code="pages.userManagement.findUser"/>
    </a>
</li>