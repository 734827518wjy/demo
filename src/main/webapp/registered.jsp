
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
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
            <h2 class="text-center">注册账号</h2>
            <form class="form-horizontal" action="/registered" method="post">
                <div class="form-group">
                    <label for="registeredName" class="col-md-4 control-label">注册用户名:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="registeredName" name="registeredName" placeholder="请输入用户名"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="registPwd" class="col-md-4 control-label">输入密码:</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" id="registPwd" name="registPwd" placeholder="请输入密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="registPwd2" class="col-md-4 control-label">确认密码:</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" id="registPwd2" name="registPwd2" placeholder="请输入密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-6">
                        <p class="text-danger" style="color:red">${error2}</p>
                        <p class="text-danger" style="color:red">${error3}</p>
                        <p class="text-danger" style="color:blue">${error4}</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3">
                        <input type="submit" class="btn btn-primary col-md-8" value="注册"/>
                    </div>
                </div>
            </form>
            <form action="/index.jsp" class="form-horizontal">
                <div class="col-md-offset-3">
                    <input type="submit" class="btn btn-primary col-md-8" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>