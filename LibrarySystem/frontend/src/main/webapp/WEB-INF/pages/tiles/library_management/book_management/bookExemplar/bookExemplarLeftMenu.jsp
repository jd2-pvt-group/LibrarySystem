<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/addBookExemplar">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.addBookExemplar"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listBookExemplars">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.listBookExemplar"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findBookExemplar">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.findBookExemplar"/>
    </a>
</li>
<li><hr/></li>
<li>
    <a href="${pageContext.request.contextPath}/management/bookManagement">
        <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.bookManagement.back"/>
    </a>
</li>