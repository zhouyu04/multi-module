<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>

    <div class="col-lg-7">
        <div class="user pull-right">
            <span class="hy_text">欢迎您！</span>
            <span class="user_name">
                      <security:authorize access="isAuthenticated()">
                          <security:authentication property="principal.username"></security:authentication>
                      </security:authorize>

                </span>
            <span style="padding-right: 10px;color: #56698A;">|</span>
            <a href="/logout" class="loginout_btn">退出</a>
        </div>
    </div>
</head>
<body>
hello!

<div>
    <a href="/rs/coming" ,src="#">列表</a>
</div>
<div>
    <a href="/add/addEvent" ,src="#">添加</a>
</div>
<div>
    <a href="/rs/list/transactionFlow" ,src="#">流水情况</a>
</div>

</body>
</html>