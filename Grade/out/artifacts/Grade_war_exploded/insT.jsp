<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
    <meta charset="UTF-8">
    <title>新增页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" href="static/css/bootstrap-admin-theme.css">
    <script src="static/jQuery/jquery-3.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/bootstrap-dropdown.min.js"></script>
    <script src="static/js/reader.js"></script>
    <script src="static/js/readerUpdateInfo.js"></script>
    <script src="static/js/readerUpdatePwd.js"></script>
<body class="bootstrap-admin-with-small-navbar">

<nav class="navbar navbar-inverse navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="collapse navbar-collapse main-navbar-collapse">
                    <a class="navbar-brand" href="img.jsp"><strong>欢迎使用系统</strong></a>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <%--欢迎您，<s:property value="#session.reader.name"/>--%>
                                <font>欢迎您,${currentUser.getUsername() }使用我们的系统</font>
                                <i class="caret"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="#" data-toggle="modal">修改密码</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="logout.do">安全退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>


<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
        <!-- left, vertical navbar -->

        <div>
            <h3>${currentUser.getUsername() }管理员</h3>
            <br>
        </div>

        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li>
                    <a href="mainS.do"><i class="glyphicon glyphicon-chevron-right"></i> student管理</a>
                </li>

                <li>
                    <a href="mainG.do"><i class="glyphicon glyphicon-chevron-right"></i> grade管理</a>
                </li>

                <li>
                    <a href="mainT.do"><i class="glyphicon glyphicon-chevron-right"></i> teacher管理</a>
                </li>
                <li>
                    <a href="mainU.do"><i class="glyphicon glyphicon-chevron-right"></i> user管理</a>
                </li>
            </ul>
        </div>

        <div align="center">
            <h3>教师信息录入</h3><br>
            <a href="mainT.jsp">返回</a>
            <hr>
            <form action="insT.do" method="post" class="bootstrap-admin-login-form">
                教师名:<input type="text" id="tname" name="tname" /><br>
                年&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" id="tage" name="tage" /><br>
                <input type="submit" id="submit" name="submit" value="新增" onclick="alert('添加成功!')" />
            </form>
        </div>

    </div>
</div>


</body>
</html>
