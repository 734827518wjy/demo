<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <style>
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="/Admin.jsp"/>
<div class="container">
    <table class="table table-hover table-bordered">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>ID</th>
            <th>借阅人姓名</th>
            <th>借阅书籍名称</th>
            <th>借阅人电话</th>
            <th>借阅时间</th>
            <th>归还时间</th>
            <th>操作</th>
        </tr>
        <%-- 使用jstl中的c:foreach标签 --%>
        <c:forEach items="${borrowers}" var="borrowers">
            <tr>
                <td><input type="checkbox" name="box"></td>
                <td>${borrowers.id}</td>
                <td>${borrowers.username}</td>
                <td>${borrowers.bookName}</td>
                <td>${borrowers.phone}</td>
                <td>${borrowers.borrowing_time}</td>
                <td>${borrowers.return_time}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/errorAdmin.jsp">归还图书</a>
                </td>
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
</body>
</html>
