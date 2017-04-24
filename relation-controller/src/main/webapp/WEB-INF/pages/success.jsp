<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript"
            src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript"
            src="/plugins/jqGrid-master/js/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript"
            src="/plugins/daterangepicker/moment.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript"
            src="/plugins/jqGrid-master/js/jquery.jqGrid.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
        <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen"
          href="/plugins/jqGrid-master/css/ui.jqgrid-bootstrap.css"/>

    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <meta charset="utf-8"/>
    <title>显示页</title>
    <content tag="customCss">
        <style>
            .hrline {
                display: inline-block;
                width: 30px;
                margin: 0;
                background-color: black;
                color: black;
                height: 1px;
                margin-bottom: 5px;
                margin-right: 8px;
            }
            table th {
                text-align: center;
            }
            table td {
                text-align: center;
            }
            form.form-horizontal label {
                width: 100px;
            }
            form.form-horizontal input, select {
                width: 60%;
                height: 26px;
            }
            form.form-horizontal div {
                padding-top: 10px;
            }
        </style>
    </content>
</head>
<body>
success!!!
<form class="form-horizontal" id="update" method="post">
    <div class="row">
        <div class="col-xs-4">
            <label for="userNumber">编号：</label> <input id="userNumber"
                                                       type="text">
        </div>
        <div class="col-xs-4">
            <label for="userName">姓名：</label> <input id="userName"
                                                     type="text" name="userName">
        </div>
    </div>
    <div class="row">
        <div class="col-xs-2">
            <button type='submit' class="btn btn-primary btn-block" id="sure">确定</button>
        </div>
        <div class="col-xs-2">
            <button id="back" type="reset" class="btn btn-primary btn-block">重置</button>
        </div>
        <div class="col-xs-2">
            <a id="export" type="button"
               href="/"
               class="btn btn-primary btn-block">返回首页 </a>
        </div>
    </div>
</form>
<hr>
<div style="text-align: center;">
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>

<br/><br/>

<input class="btn btn-default" type="button" value="随出" onclick="getSelectedRows()"/>

<br/><br/>

<div id="detailsPlaceholder" style="text-align: center">
    <table id="jqGridDetails"></table>
    <div id="jqGridDetailsPager"></div>
</div>

<script type="text/javascript">
    function formatted(cellValue, options, rowObject) {
        if (cellValue != null) {
            var day = moment(cellValue);
            var formatted = day.format("YYYY-MM-DD HH:mm:ss");
            return formatted;
        } else {
            return "";
        }
    }
    function statusFormatted(cellValue, options, rowObject) {
        var formatted = null;
        if (cellValue == true) {
            formatted = "成功";
            return formatted;
        } else if (cellValue == false) {
            formatted = "失败";
            return formatted;
        } else {
            formatted = cellValue;
            return formatted;
        }
    }
    $(document).ready(function () {
        $("#jqGrid").jqGrid({
            url: '/rs/account',
            mtype: "GET",
            styleUI: 'Bootstrap',
            datatype: "json",
            colModel: [{
                label: '编号',
                name: 'id',
                key: true,
                width: 150
            }, {
                label: '姓名',
                name: 'rsName',
                width: 150
            }, {
                label: '余额',
                name: 'balance',
                width: 150
            }, {
                label: '上次余额',
                name: 'lastBalance',
                width: 150
            }, {
                label: '累计输入',
                name: 'accumulatIncrease',
                width: 150
            }, {
                label: '累计数出',
                name: 'accumulatDecrease',
                width: 150
            }, {
                label: '创建时间',
                name: 'createDate',
                width: 150,
                formatter: formatted
            }, {
                label: '修改时间',
                name: 'modifyDate',
                width: 150,
                formatter: formatted
            }, {
                label: '操作人',
                name: 'operater',
                width: 150
            }],
            viewrecords: true,
            height: 300,
            rowNum: 20,
            pager: "#jqGridPager",
            autowidth: true,
            multiselect: true,
            onSelectRow: function (rowid, selected) {
                if (rowid != null) {
                    jQuery("#jqGridDetails").jqGrid('setGridParam', {
                        url: "/rs/detail/transactionFlow?rowId=" + rowid,
                        datatype: 'json'
                    }); // the last setting is for demo only
                    jQuery("#jqGridDetails").jqGrid('setCaption', '编号::' + rowid);
                    jQuery("#jqGridDetails").trigger("reloadGrid");
                }
            }, // use the onSelectRow that is triggered on row click to show a details grid
            onSortCol: clearSelection,
            onPaging: clearSelection
        });
    });
    $("#jqGridDetails").jqGrid({
        url: '/rs/empty',
        mtype: "GET",
        datatype: "json",
        styleUI: 'Bootstrap',
        page: 1,
        colModel: [
            {label: '姓名', name: 'rsName', key: true, width: 75},
            {label: '编号', name: 'rsNum', width: 100},
            {label: '操作金额', name: 'operateamount', width: 100},
            {label: '日期', name: 'dateCreate', width: 100, formatter: formatted},
            {label: '描述', name: 'description', width: 75},
            {label: '状态', name: 'status', width: 75, formatter: statusFormatted}
        ],
        rowNum: 5,
        autowidth: true,
        height: '200',
        viewrecords: true,
        caption: '编号::',
        pager: "#jqGridDetailsPager"
    });
    function clearSelection() {
        jQuery("#jqGridDetails").jqGrid('setGridParam', {url: "/rs/empty", datatype: 'json'}); // the last setting is for demo purpose only
        jQuery("#jqGridDetails").jqGrid('setCaption', '编号:: none');
        jQuery("#jqGridDetails").trigger("reloadGrid");
    }
    function getSelectedRows() {
        var grid = $("#jqGrid");
        var rowKey = grid.getGridParam("selrow");
        if (!rowKey)
            alert("请选择一个对象!");
        else {
            var selectedId = grid.getGridParam("selarrrow");
            var selectedId = selectedId[0];
            var rowData = grid.getRowData(selectedId);
            var name = rowData.rsName;
            alert(name);
            console.log(name);
            window.location.href = "/add/repay?selectedId=" + selectedId + "&rsName=" + name;
        }
    }
    //确定按钮操作
    $("#sure").click(function () {
        $("#message").hide();
        $("#jqGrid").jqGrid('setGridParam', {
            datatype: 'json',
            postData: {
                'userNumber': function () {
                    return $('#userNumber').val();
                },
                'userName': function () {
                    return $('#userName').val();
                }
            },
            page: 1
        }).trigger("reloadGrid");
        return false;
    })
    //点击重置按钮
    $("#back").click(function () {
        $("#message").hide();
    })
    //         导出按钮操作
    $("#export").click(
    )
</script>
</body>
</html>