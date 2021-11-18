<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Person List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Password</th>
        </tr>
        <c:forEach  items="${users}" var ="users">
            <tr>
                <td>${users.nameUser}</td>
                <td>${users.password}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>