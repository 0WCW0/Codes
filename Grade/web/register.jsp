<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="bootstrap-admin-vertical-centered">
<head>
    <%--<title>用户登录</title>--%>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-admin-theme.css">

    <script src="static/jQuery/jquery-3.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/login.js"></script>
</head>

<style type="text/css">
    .alert{
        margin: 0 auto 20px;
        text-align: center;
    }
</style>

<body class="bootstrap-admin-without-padding">

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="alert alert-info">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                欢迎登录成绩管理系统
            </div>
            <br>

            <div align="center">
                <label class="control-label"><a href="logout.do">返回</a></label>
                <form action="#" method="post" class="bootstrap-admin-login-form">
                    用户名:<input type="text" name="username"><br>
                    密　码:<input type="password" name="password"><br>

                    <%--<input type="submit" value="注册">--%>
                    <a href="login.jsp">注册</a>

                    <input type="reset" value="重置">
                </form>
            </div>


        </div>
    </div>
</div>


</body>
</html>
