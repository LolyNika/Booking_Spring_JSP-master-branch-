<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:choose>
    <c:when test="${users.userRole.roleId=='2'}">
        <form action='/users/user' method='get'>
            <input type="hidden" value="${nickname}" name="nickname"/>
            <input type="hidden" value="${password}" name="password"/>
            <button type="submit" class="btn btn-primary test_btn">Press to continue</button>
        </form>
<%--        <a href="/users/user">Press to continue</a>--%>
    </c:when>
    <c:otherwise>
        <form action='/users/admin' method='get'>
            <input type="hidden" value="${nickname}" name="nickname"/>
            <input type="hidden" value="${password}" name="password"/>
            <button type="submit" class="btn btn-primary test_btn">Press to continue</button>
        </form>
<%--        <a href="/users/admin">Press to continue</a>--%>
    </c:otherwise>
</c:choose>
</body>
</html>