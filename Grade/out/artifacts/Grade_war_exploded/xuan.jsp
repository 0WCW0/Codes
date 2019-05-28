<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import = "com.yw.bean.AdminBean,com.yw.dao.AdminDao" %>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
    <%--<title>选择页面</title>--%>
        <meta charset="UTF-8">
        <title>选择页面</title>
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

        <!-- content -->
        <div class="col-md-10">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">student管理</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>根据学生名查询学生信息</li>
                                <li>可查询学生的编号、学生名、年龄、分数等</li>
                                <li>可对学生信息进行的操作：新增、修改和删除</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 判断用户是否登录 -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">teacher管理</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>根据教师名查询教师信息</li>
                                <li>可查询教师的编号、教师名、年龄等</li>
                                <li>可对教师信息进行的操作：新增、修改和删除</li>
                            </ul>
                        </div>
                    </div>
                </div>


            </div>


            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">user管理</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>根据用户名查询用户信息</li>
                                <li>可查询用户的编号、用户名、密码、类型等</li>
                                <li>可对用户信息进行的操作：新增、修改和删除</li>
                            </ul>
                        </div>
                    </div>
                </div>


            </div>

        </div>
    </div>


</div>


<!-------------------------------------------------------------->

<form class="form-horizontal" method="post" action="#">   <!--保证样式水平不混乱-->
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
