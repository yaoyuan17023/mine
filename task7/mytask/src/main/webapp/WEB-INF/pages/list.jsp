<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/18
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${users}" var="users" begin="0" end="3">
    <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
        <div>
                <%--<img src="../picture/01.png">--%>
            <img src="${users.picture}">
            <span>${users.id}：${users.user}</span>
            <p class="text-left">${users.mobile},${users.email}</p>
        </div>
    </li>
</c:forEach>
</body>
</html>
