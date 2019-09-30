<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看商品</title>
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
    <table class="table table-hover table-bordered" >
        <tr class="success">
            <th><input type="checkbox" id="checkbox"></th>
            <th>ID</th>
            <th>商品名称</th>
            <th>商品简介</th>
            <th>单价</th>
            <th>剩余个数</th>
            <th>操作</th>
        </tr>
        <%-- 使用jstl中的c:foreach标签 --%>
        <c:forEach items="${commodity1}" var="commodity1">
            <tr>
                <td><input type="checkbox" id="box" name="box"/></td>
                <td>${commodity1.id}</td>
                <td>${commodity1.name}</td>
                <td>${commodity1.introduction}</td>
                <td><fmt:formatNumber value="${commodity1.press}" type="currency"/></td>
                <td>${commodity1.num}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/deleteCommodity">删除</a>
                    <a class="btn btn-primary btn-sm" href="/errorAdmin.jsp">修改</a>
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
<script>
    $(function (){
        var $info = $('#box');
        var ids = [];
        // 获取选择的个数
        var num = function(){
            var num = 0;
            $info.each(function(){
                if (this.checked === true){
                    ids[num] = this.value;
                    num ++;
                }
            });
            return num;
        };

        // 监听点击
        $info.click(function() {
            if($info.length === num()){
                $("#checkbox").prop("checked",true);
            } else{
                $("#checkbox").prop("checked",false);
            }
        });

        // 全选
        $("#checkbox").click(function (){
            // 获取当前是否选择
            var checked = this.checked;
            // = 赋值
            // == 等于   '1' == 1  true
            // === 等于   '1' === 1  false
            if (checked === true){
                $info.prop('checked',true);
            } else {
                $info.prop('checked',false);
            }
        });
        $('#deleteAll').click(function() {
            // 使用ajax
            if (ids.length === 0){
                my.alert("请选择需要删除的数据");
                return;
            }
            my.confirm({message:'是否要删除数据?'}).on(function(e){
                if(!e){
                    return;
                }
                // 通过ajax删除数据,然后同步刷新页面
                // jq ajax
                $.ajax({
                    url: '${pageContext.request.contextPath}/selectCommodityMore',
                    type: 'post',
                    data: {'id':ids},
                    success: function (result){
                        // 刷新页面
                        // toastr.success("数据删除成功");
                        window.location.reload();
                    },
                    error: function (){

                    }
                });
            })

        })
    });
    // 删除数据
    function del(id) {
        var ids = [];
        ids[0] = id;
        my.confirm({message:'是否要删除数据?'}).on(function(e){
            if(!e){
                return;
            }
            // 通过ajax删除数据,然后同步刷新页面
            // jq ajax
            $.ajax({
                url: '${pageContext.request.contextPath}/deleteCommodity',
                type: 'post',
                data: {'id':ids},
                success: function (result){
                    // 刷新页面
                    // toastr.success("数据删除成功");
                    window.location.reload();
                },
                error: function (){

                }
            })
        })
    }
</script>
</body>
</html>
