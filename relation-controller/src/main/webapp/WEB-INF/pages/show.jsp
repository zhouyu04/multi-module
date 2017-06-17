<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <meta charset="utf-8"/>
    <title>查看文件</title>
</head>
<body>

    <c:forEach items="${lists}" var="fileName" varStatus="status">
        <tr aria-disabled="1" bgcolor="black" align="center">
            <td>
                    ${fileName}
            </td>
            <td>
                &nbsp;&nbsp;&nbsp;<a href="/show/name?fileName=${fileName}">查看</a>
            </td>
            <br>
        </tr>

    </c:forEach>
    <form action="">

    </form>

<form action="/add/down" method="get">
    <input type="submit" value="下载">
</form>


</body>
</html>