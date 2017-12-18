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
    <title>上传文件</title>
</head>
<body>



<form action="/add/file" enctype="multipart/form-data" method="post">
    <input type="file" class="form-control" name="file" id="doc" onchange="setImagePreview();">
    <div id="localImag">
        <img id="preview" width=-1 height=-1 style="diplay:none" />
    </div>
    <input type="file" class="form-control" name="file" value="send" onchange="setImagePreview('2','send');">
    <input type="file" class="form-control" name="file" value="unSend" onchange="setImagePreview('3','unSend');">
    <br>
    <div class="row">
        <div class="col-xs-2">
            <button type="submit" class="btn btn-primary btn-block">上传</button>
        </div>
        <div class="col-xs-2">
            <a id="export" type="button"
               href="/"
               class="btn btn-primary btn-block">返回首页 </a>
        </div>
    </div>
</form>


<form action="/add/down" method="get">
    <input type="submit" value="下载">
</form>
<script type="text/javascript" src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    function setImagePreview(index,args) {
        alert(index);
        alert(args);
        var value = $(this).attr("value");
        console.log(value);
        alert(value);
    }
</script>

</body>
</html>