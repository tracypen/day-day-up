<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>
<thead>
<tr>
    <th>权限编号</th>
    <th>权限名称</th>
    <th>权限标识</th>
    <th>描述</th>
    <th><input type="checkbox" name="123" id="checkAll" onclick='checkAllPerm()' ></th>
</tr>
</thead>
<tbody >

<c:if test="${not empty allPermission}">
    <c:forEach var="permissionItem" items="${allPermission}" varStatus="var">
        <tr>
            <th>${var.index + 1}</th>
            <th>${permissionItem.name}</th>
            <th>${permissionItem.identity}</th>
            <th>${permissionItem.description}</th>
            <th><input type="checkbox" name="myCheck" value="${permissionItem.id}" <c:if test="${permissionItem.checked}">checked</c:if> ></th>

        </tr>
    </c:forEach>


</c:if>

</tbody>


