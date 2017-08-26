<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/8/22
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--SpringMVC处理静态资源
    静态资源被拦截了
    配置一个<mvc:default-servlet-handler>
    --%>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        })
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>

    <%--<form action="" method="post">--%>
        <%--<input type="hidden" name="_method" value="PUT">--%>
    <%--</form>--%>
    <c:if test="${students == null}">
        <h3> 没有信息</h3>
    </c:if>
    <c:if test="${students != null}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>name</th>
                <th>qq</th>
                <th>type</th>
                <th>time</th>
                <th>school</th>
                <th>number</th>
                <th>link</th>
                <th>hope</th>
                <th>referrer</th>
                <th>from_where</th>
                <th>id</th>
                <th>create_at</th>
                <th>update_at</th>
            </tr>

            <c:forEach items="${students}" var="stu">
                <tr>
                    <td>${stu.name}</td>
                    <td>${stu.qq}</td>
                    <td>${stu.type}</td>
                    <td>${stu.time}</td>
                    <td>${stu.school}</td>
                    <td>${stu.number}</td>
                    <td>${stu.link}</td>
                    <td>${stu.hope}</td>
                    <td>${stu.referrer}</td>
                    <td>${stu.from_where}</td>
                    <td>${stu.id}</td>
                    <td>${stu.create_at}</td>
                    <td>${stu.update_at}</td>
                    <td><a href="${pageContext.request.contextPath}/up/${stu.id}">Edit</a></td>
                    <td><a class="delete" href="del/${stu.id}">Delete</a></td>
                    <%--<td><a onclick="del(${stu.id})" href="javascript:void(0)">删除</a></td>--%>

                </tr>
            </c:forEach>
        </table>
    </c:if>

<br><br>
    <a href="${pageContext.request.contextPath}/add">Add New Student</a>

</body>
</html>
