<%@ page import="com.itwanli.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
    <meta charset="UTF-8">
    <title>学生页面</title>
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

    <style>
        .row1{
            background-color: #E4E4F1;
        }
        .row2{
            background-color: #FBD10A;
        }
    </style>
</head>
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
                                <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>

                                <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
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
            <h3>${currentUser.getUsername() }教师</h3>
            <br>
        </div>

        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li>
                    <a href="mainTTT.do"><i class="glyphicon glyphicon-chevron-right"></i> 教师信息</a>
                </li>
                <li>
                    <a href="mainSSS.do"><i class="glyphicon glyphicon-chevron-right"></i> 学生成绩</a>
                </li>
            </ul>
        </div>

        <div align="center">
            <h3>学生成绩</h3>
            <a href="mainTT.jsp">返回选择界面</a>
            <hr>

            <form action="searchSSS.do" method="post">
                搜索：<input type="input" id="searchSSS" name="searchSSS" placeholder="输入学生名" />
                <input type="submit" id="sssubmit" name="sssubmit" value="查询" />
            </form>

            <table id="data_list" class="table table-hover table-bordered" border="1" cellspacing="0" cellpadding="0" width="500px" style="margin:0 auto">
                <caption>学生信息（<a href="insSA.jsp">新增</a>）</caption>
                <tr>
                    <th>学生名</th>
                    <th>课程</th>
                    <th>分数</th>
                </tr>
                <!-- 使用c标签的遍历: 11种c标签; -->
                <c:forEach items="${ssspmList }" var="s" varStatus="i">
                    <tr class="row${i.index % 2 + 1 }">
                        <td>${s.sname }</td>
                        <td>${s.cname }</td>
                        <td>${s.grade }</td>

                    </tr>
                </c:forEach>
            </table>
        </div>


        <div class="page" style="width:350px; margin:0 auto;">
            <div class="page-information">
                <b>共${page.recordsNum}</b>条,当前第<span>${page.pageNum}</span>页
                <a href="${path}listSSS.do?pageNum=1" class='first'>首页</a>
                <a href="${path}listSSS.do?pageNum=${page.pageNum>1?page.pageNum-1:1}" class='pre'>上一页</a>
                <c:forEach begin="1" end="${page.pageTitle}" var="i">
                    <a href="${path}listSSS.do?pageNum=${i}" style="text-decoration: none;">${i}</a>
                </c:forEach>
                <a href="${path}listSSS.do?pageNum=${page.pageNum<page.pageTitle?page.pageNum+1:page.pageTitle}" class='next'>下一页</a>
                <a href="${path}listSSS.do?pageNum=${page.pageTitle}" class='last'>末页</a>
            </div>
        </div>


    </div>
</div>





<!-------------------------------------------------------------->

<form class="form-horizontal" method="post" action="gai.do">   <!--保证样式水平不混乱-->
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="updatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>


                <div class="modal-body">
                    <!--正文-->

                    <input type="hidden" name="tip" value="1">
                    <input type="hidden" name="url" value="admin">


                    <div class="form-group">
                        <label for="firstname" class="col-sm-3 control-label">原密码</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" name="password" id="oldPwd"  placeholder="请输入原密码">
                            <label class="control-label" for="oldPwd" style="display: none"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="firstname" class="col-sm-3 control-label">新密码</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" name="password2" id="newPwd"  placeholder="请输入新密码">
                            <label class="control-label" for="newPwd" style="display: none"></label>
                        </div>
                    </div>

                    <!--正文-->
                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary" >
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</form>
<!-------------------------------------------------------------->


<!-------------------------个人资料模糊框------------------------------------->

<form class="form-horizontal" method="post" action="#">   <!--保证样式水平不混乱-->
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="updateinfo" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="ModalLabel">
                        个人资料
                    </h4>
                </div>

                <div class="modal-body">

                    <!--正文-->
                    <input type="hidden" name="tip" value="2">
                    <input type="hidden" name="url" value="admin">
                    <div class="form-group">
                        <label for="firstname" class="col-sm-3 control-label">真实姓名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入您的真实姓名" ><%--value='<% out.write(admin.getName());%>'--%>
                            <label class="control-label" for="name" style="display: none"></label>
                        </div>
                    </div>


                    <!--正文-->


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary" >
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</form>
<!-------------------------------------------------------------->


</body>
</html>
