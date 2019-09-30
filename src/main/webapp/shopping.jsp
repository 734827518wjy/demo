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
<jsp:include page="/head.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li>购物车</li>
        <li class="active">列表</li>
    </ol>
    <div style="margin-bottom: 10px;">
        <a href="${pageContext.request.contextPath}/commodity" class="btn btn-success">添加商品</a>
        <a href="${pageContext.request.contextPath}/shopping?method=del" class="btn btn-danger">取消商品</a>
        <a href="${pageContext.request.contextPath}/shopping?method=del" class="btn btn-info">购买商品</a>
    </div>

    <table class="table table-hover table-bordered">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>个数</th>
            <th>总价</th>
            <th>操作</th>
        </tr>
        <%-- 使用jstl中的c:foreach标签 --%>
        <c:forEach items="${shopping}" var="shopping">
            <tr>
                <td><input type="checkbox" name="box"></td>
                <td>${shopping.id}</td>
                <td>${shopping.username}</td>
                <td>${shopping.commodity}</td>
                <td>${shopping.press}</td>
                <td>${shopping.number}</td>
                <td>${shopping.totalPrice}</td>
<%--                <td>--%>
<%--                    <a class="btn btn-primary btn-sm" href="/UserError.jsp">购买商品</a>--%>
<%--                    <a class="btn btn-primary btn-sm" href="/UserError.jsp">取消商品</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.currentPage > 1}">
                    <li>
                        <a href="${pageScope.request.contextPath}/shopping?method=list&p=${page.currentPage - 1}">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${page.pageCount}" step="1" var="p">
                    <c:if test="${page.currentPage == p}">
                        <li class="active">
                            <a href="${pageScope.request.contextPath}/shopping?method=list&p=${p}">${p}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.currentPage != p}">
                        <li>
                            <a href="${pageScope.request.contextPath}/shopping?method=list&p=${p}">${p}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.currentPage < page.pageCount}">
                    <li>
                        <a href="${pageScope.request.contextPath}/shopping?method=list&p=${page.currentPage + 1}">
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
<script>
    $(function (){
    });
    function del(id) {
        my.confirm({message:'是否要删除数据?'}).on(function(e){
            if(!e){
                return;
            }
        })
    }
</script>
</body>
</html>
