<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加图书</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/Admin.jsp"/>
<div class="container">
    <div class="row">
        <form class="form-horizontal" action="/insertCommodity" method="post">
            <div class="form-group">
                <label for="name" class="col-md-4 control-label">商品名称</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入"/>
                </div>
            </div>
            <div class="form-group">
                <label for="introduction" class="col-md-4 control-label">商品简介</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="introduction" name="introduction" placeholder="请输入"/>
                </div>
            </div>
            <div class="form-group">
                <label for="press" class="col-md-4 control-label">价格:</label>
                <div class="col-md-6">
                    <input type="number" min="0" value="0" class="form-control" id="press" name="press" placeholder="请输入"/>
                </div>
            </div>
            <div class="form-group">
                <label for="num" class="col-md-4 control-label">添加个数</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="num" name="num" placeholder="请输入"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-4 col-md-6">
                    <p class="text-danger" style="color:red" id="error">${error6}</p>
                </div>
            </div>
            <div class="form-group text-center">
                <input id="id" type="submit" class="btn btn-primary" value="提交"/>
                <a class="btn btn-primary" href="/Admin.jsp">取消</a>
            </div>
        </form>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>