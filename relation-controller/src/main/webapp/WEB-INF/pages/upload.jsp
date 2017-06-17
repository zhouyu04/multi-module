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
    <input type="file" class="form-control" name="file" id="doc" onchange="javascript:setImagePreview();">
    <div id="localImag">
        <img id="preview" width=-1 height=-1 style="diplay:none" />
    </div>
    <input type="file" class="form-control" name="file" onchange="javascript:setImagePreview();">
    <input type="file" class="form-control" name="file" onchange="javascript:setImagePreview();">
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

<script type="text/javascript">
    function setImagePreview() {
        var docObj = document.getElementById("doc");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '300px';
            imgObjPreview.style.height = '120px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
            //必须设置初始大小
            localImagId.style.width = "250px";
            localImagId.style.height = "200px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }
</script>

</body>
</html>