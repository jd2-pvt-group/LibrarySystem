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
        <i class="icon-chevron-right"></i> <s:message code="pages.userManagement.addUser"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listUsers">
        <i class="icon-chevron-right"></i> <s:message code="pages.userManagement.listUsers"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findUser">
        <i class="icon-chevron-right"></i> <s:message code="pages.userManagement.findUser"/>
    </a>
</li>