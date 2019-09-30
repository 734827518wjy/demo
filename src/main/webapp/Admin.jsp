<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <style>
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <ol class="breadcrumb">
        <li>管理员</li>
        <li class="active">列表</li>
    </ol>
    <div style="margin-bottom: 10px;">
        <a href="${pageContext.request.contextPath}/addCommodity.jsp" class="btn btn-success">添加商品</a>
        <a href="${pageContext.request.contextPath}/selectCommodityMore" class="btn btn-info">查询商品</a>
        <a href="${pageContext.request.contextPath}/selectUser" class="btn btn-info">查看用户</a>
<%--        <a href="${pageContext.request.contextPath}/errorAdmin.jsp" class="btn btn-info">查看图书</a>--%>
<%--        <a href="${pageContext.request.contextPath}/errorAdmin.jsp" class="btn btn-info">查看借阅人</a>--%>
        <a href="${pageContext.request.contextPath}/commodity" class="btn btn-primary">退出</a>
    </div>
</div>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/my.js"></script>
</body>
</html>
