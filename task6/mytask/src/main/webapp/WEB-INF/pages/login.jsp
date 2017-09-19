<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/13
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>登陆</title>
    <meta charset="UTF-8" />
    <meta name="Designer" content="PremiumPixels.com">
    <meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/structure.css">
</head>
<body>
<form class="box login" action="${pageContext.request.contextPath}/login" method="post">
    <fieldset class="boxBody">
        <label>Username</label>
        <input type="text" name="user" tabindex="1" placeholder="MotherFucker" required>
        <label>Password</label>
        <input type="password" name="password" tabindex="2" required>
    </fieldset>
    <footer>
        <label><a href="${pageContext.request.contextPath}/regist" class="rLink" tabindex="5">Don't hava a account?</a></label>
        <input type="submit" name="Submit" class="btnLogin" value="Login" tabindex="4">
    </footer>
</form>
</body>
</html>
