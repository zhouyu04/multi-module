<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <meta charset="utf-8"/>
    <title>Insert title here</title>
</head>
<body>
<form:form action="/add/input" method="post"
           modelAttribute="AccountModel">
    <div class="table-responsive">
        <table class="table">
            <tr class="active">
                <th>姓名</th>
                <th>金额</th>
                <th>编号</th>
                <th>描述</th>
                <th>状态</th>
            </tr>
            <c:forEach items="${AccountModel.accounts}" varStatus="s">
                <tr>
                    <td>
                        <form:input path="accounts[${s.index}].rsName"
                                    type="text" disabled="true"/>
                    </td>
                    <td>
                        <form:input path="accounts[${s.index}].operateamount"
                                    type="text" disabled="true"/>
                    </td>
                    <td>
                        <form:input path="accounts[${s.index}].id"
                                    type="text" disabled="true"/>
                    </td>
                    <td><form:input path="accounts[${s.index}].description" value="${description}"
                                    type="text" disabled="true"/></td>
                    <td><form:input path="accounts[${s.index}].status" value="${status}"
                                    type="text" disabled="true"/></td>
                </tr>

            </c:forEach>
        </table>
        <hr>
    </div>
    <button type="submit" class="btn btn-success">保存</button>
</form:form>
</body>
</html>