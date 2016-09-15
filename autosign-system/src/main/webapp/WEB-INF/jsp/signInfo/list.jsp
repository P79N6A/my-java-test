<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="pagerForm" method="post" action="/signInfo/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}" />
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
</form>
<div class="pageHeader">
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="/signInfo/add" target="dialog" mask="true" title="新增"><span>添加</span></a></li>
            <li><a class="delete" href="/signInfo/delete/{id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="/signInfo/update/{id}" target="dialog" mask="true" title="修改"><span>修改</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="80">id</th>
            <th>URL</th>
            <th width="120">cookie</th>
            <th width="100">创建时间</th>
            <th width="150">更新时间</th>
            <th width="80">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="row">
        <tr target="id" rel="${row.id}">
            <td>${row.id}</td>
            <td>${row.signUrl}</td>
            <td>${row.cookie}</td>
            <td><fmt:formatDate value="${row.createTime}" type="both" /></td>
            <td><fmt:formatDate value="${row.updateTime}" type="both" /></td>
            <td><a class="button" href="signInfo/exec/${row.id}" target="ajaxTodo"><span>签到</span></a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${totalCount}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

    </div>
</div>

