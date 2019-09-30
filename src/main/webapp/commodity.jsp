<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <style>
        td, th {
            text-align: center;
        }
        input{
            border-radius: 5px;
            float: left;
        }
    </style>
</head>
<body>
<jsp:include page="/head.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li>商品</li>
        <li class="active">列表</li>
    </ol>
    <table class="table table-hover table-bordered" >
        <tr class="success">
            <th>ID</th>
            <th>商品名称</th>
            <th>商品简介</th>
            <th>单价</th>
            <th>剩余个数</th>
            <th>操作</th>
        </tr>
        <%-- 使用jstl中的c:foreach标签 --%>
        <c:forEach items="${commodity}" var="commodity">
            <tr>
                <td>${commodity.id}</td>
                <td>${commodity.name}</td>
                <td>${commodity.introduction}</td>
                <td><fmt:formatNumber value="${commodity.press}" type="currency"/></td>
                <td>${commodity.num}</td>
                <td>
                   <form action="/UserError.jsp">
                       <input type="text" placeholder="需要购买的个数" name="number">
                   </form>
                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/shopping">添加到购物车</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.currentPage > 1}">
                    <li>
                        <a href="${pageScope.request.contextPath}/book/list?p=${page.currentPage - 1}">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${page.pageCount}" step="1" var="p">
                    <c:if test="${page.currentPage == p}">
                        <li class="active">
                            <a href="${pageScope.request.contextPath}/book/list?p=${p}">${p}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.currentPage != p}">
                        <li>
                            <a href="${pageScope.request.contextPath}/book/list?p=${p}">${p}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.currentPage < page.pageCount}">
                    <li>
                        <a href="${pageScope.request.contextPath}/book/list?p=${page.currentPage + 1}">
                            <span>&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/my.js"></script>
</body>
</html>
