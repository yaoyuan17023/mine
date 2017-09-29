<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/12
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="keywords" content="注册">
    <meta name="content" content="注册">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/regist/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/regist/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/t10/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#sendCode').click(

                function () {
                    var data={
                        mobile:$("#mobile").val()
                    }
                    $.ajax({
                        type:"GET",
                        url: "${pageContext.request.contextPath}/mobile",
                        data:data,
                        dataType:JSON,
                        success:function () {
                            alert("success");
                        }
                    })
                }
            );

        });
    </script>


</head>
<body class="login_bj" >

<div class="zhuce_body">
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <h3>欢迎注册</h3>
                <form action="${pageContext.request.contextPath}/register" method="post">
                    <input type="text" name="user" class="kuang_txt phone" placeholder="your username">
                    <input type="password" name="password" class="kuang_txt possword" placeholder="your password">
                    <input type="text" name="mobile" class="kuang_txt phone" id="mobile" placeholder="your phone number">
                    <input type="button" value="Get Message" id="sendCode">
                    <input type="text" name="message" class="kuang_txt yanzm" placeholder="your message">
                    <input type="text" name="email" class="kuang_txt email" placeholder="your email">
                    <input type="submit" name="Submit" class="btn_zhuce" value="Register">
                </form>
            </div>
            <div class="bj_right">
                <p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="${pageContext.request.contextPath}/login">立即登录</a></p>
            </div>
        </div>
    </div>

</div>

</body>
</html>


