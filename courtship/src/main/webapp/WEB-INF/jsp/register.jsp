<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div align="center">
    <font>欢迎${user.username}使用我们的系统</font>
    &nbsp;&nbsp;<br>
    <a href="${path}/user/logout">安全退出</a>
    <br><br><br>
</div>
${msg}
<div align="center">
    <form action="${path}/user/register" method="post">
        用户名:<input type="text" name="username"><br>
        密　码:<input type="password" name="password"><br>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
</div>

</body>
</html>
