<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>登录</title>
</head>
<body>

<div align="center">

    <h3>用户登录</h3>
    <hr>
    ${msg}
    <form action="${path }/user/login" method="post">
        用户名：<input type="text" name="username"><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password" name="password"><br>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
        <br>
    </form>
    <a href="${path }/user/toregister">注册</a>
</div>

</body>
</html>
