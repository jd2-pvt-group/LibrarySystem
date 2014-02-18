<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/bookTypeManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookTypeManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/bookExemplarManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookExemplarManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/bookSerialManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookSerialManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/genreManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.genreManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/publisherManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.publisherManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/authorManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.authorManagement"/>
    </a>
</li>
<li><hr/></li>
<li>
    <a href="${pageContext.request.contextPath}/management/libraryManagement">
        <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.backToLibraryManagement"/>
    </a>
</li>
