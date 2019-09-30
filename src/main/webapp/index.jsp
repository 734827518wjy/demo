<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .login {
            margin-top: 150px;
        }
        .form {
            border: 1px solid #2aabd2;
            padding: 20px 0;
        }
        h2 {
            padding-bottom:15px;
        }
        p {
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row login">
        <div class="col-md-offset-4 col-md-4 form">
            <h2 class="text-center">图书管理系统</h2>
            <form class="form-horizontal" action="/login" method="post">
                <div class="form-group">
                    <label for="username" class="col-md-4 control-label">用户名:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-4 control-label">密码:</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-6">
                        <p class="text-danger" style="color:red">${error}</p>
                        <p class="text-danger" style="color:red">${error11}</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-6">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="1" name="remember"> 记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group" >
                    <div class="col-md-offset-3">
                        <input type="submit" class="btn btn-primary col-md-8" value="登陆"/>
                    </div>
                </div>
            </form>
                <div class="form-group">
                    <div class="col-md-offset-4">
                        <h5>没有账号?<a href="${pageContext.request.contextPath}/registered.jsp">点击注册</a></h5>
                    </div>
                </div>

        </div>
    </div>
</div>
</body>
</html>
