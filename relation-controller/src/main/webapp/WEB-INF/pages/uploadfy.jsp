<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13 0013
  Time: 上午 11:27
  To change this template use File | Settings | File Templates.
--%>
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

<form action="/add/fileUpload3" method="POST" enctype="multipart/form-data" onsubmit="showStatus()">
    <div id="uploadDiv">
        <input type="file" name="file" multiple id="uploadFile"/>
    </div>

    <input type="submit" value="提交"/>

</form>

<button id="ajaxtSubmit">ajax提交</button>

<div style="border:black solid 1px; width: 800px;height: 10px;">
    <div id="result" style="height: 8px;background: green;position: relative; top: 1px;left: 1px;"></div>
</div>

</body>
<script type="text/javascript" src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">



    function showStatus(){
        var intervalId = setInterval(function(){
            $.get("/add/getStatus",{},function(data,status){
                console.log(showStatus+data);
                var percent = data.percent;
                if(percent >= 100){
                    clearInterval(intervalId);
                    percent = 100;//不能大于100
                }
                $("#result").width(percent+"%");
            },"json");
        },500);
    }


    $("#ajaxtSubmit").click(function(){
        ajaxtSubmit();

        var eventFun = function(){
            $.get("/add/getStatus",{},function(data,status){
                console.log(showStatus+data);
                var percent = data.percent;
                if(percent >= 100){
                    clearInterval(intervalId);
                    percent = 100;//不能大于100
                }
                $("#result").width(percent+"%");
            },"json");
        }
        var intervalId = window.setInterval(eventFun,500);
    });

    function ajaxtSubmit(){

        var files = document.getElementById("uploadFile").files;
        alert(files.length);
        var formData = new FormData();
        for(var i=0;i<files.length;i++){
            formData.append("file",files[i]);
            formData.append("username","zxm");
            formData.append("password","123456");
        }
        $.ajax({
            type:"post",
            url:"/add/fileUpload3",
            data:formData,
            processData : false,
            contentType : false,
            /*beforeSend: function(request) {
             request.setRequestHeader("filePath", file_path);
             }, */
            success:function(data){
                console.log("fileUpload3"+data);
            },
            error:function(e){
                console.log(e);
            }
        });

    }

</script>
</html>
