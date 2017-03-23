<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	href="/plugins/jqGrid-master/css/ui.jqgrid-bootstrap.css" />

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta charset="utf-8" />
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
				<label for="commercial">商户名称：</label> <select id="commercial"
					name="commercial">
					<option value="">全部</option>
					<c:forEach var="businesses" items="${businesses}">
						<option value="${businesses.applicationId}">${businesses.businessName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-xs-4">
				<label for="userNumber">用户编号：</label> <input id="userNumber"
					type="text">
			</div>
			<div class="col-xs-4">
				<label for="globalId">全&nbsp;局&nbsp;ID：</label> <input id="globalId"
					type="text" name="globalId">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<label for="type">交易类型：</label> <select id="type">
					<option value="">全部</option>
					<option value="BUY">购买</option>
					<option value="CANCEL_BUY">取消购买</option>
					<option value="PAYOUT_MONEY">派息</option>
					<option value="TRANSFER_MONEY">转账</option>
					<option value="PAYMENT_REQUEST_DEBIT">借贷放款</option>
				</select>
			</div>
			<div class="col-xs-4">
				<label>起始时间：</label> <input id="begin" type="text">
			</div>
			<div class="col-xs-4">
				<label>期末时间: </label> <input id="after" type="text">
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
					href="/export/transactionFlow/FeiYongHu?merchantName=YGONLINE&userNumber=&globalId=&operateType=&beginTime=&endTime="
					class="btn btn-primary btn-block">导出 </a>
			</div>
		</div>
	</form>
	<hr>
	<div style="text-align: center;">
		<table id="jqGrid"></table>
		<div id="jqGridPager"></div>
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

		$(document).ready(function() {

			$("#jqGrid").jqGrid({
				url : '/rs/account',
				mtype : "GET",
				styleUI : 'Bootstrap',
				datatype : "json",
				colModel : [ {
					label : '编号',
					name : 'id',
					key : true,
					width : 75
				}, {
					label : '姓名',
					name : 'rsName',
					width : 150
				}, {
					label : '余额',
					name : 'balance',
					width : 150
				}, {
					label : '上次余额',
					name : 'lastBalance',
					width : 150
				}, {
					label : '累计输入',
					name : 'accumulatIncrease',
					width : 150
				}, {
					label : '累计数出',
					name : 'accumulatDecrease',
					width : 150
				}, {
					label : '创建时间',
					name : 'createDate',
					width : 150,
					formatter : formatted
				}, {
					label : '修改时间',
					name : 'modifyDate',
					width : 150,
					formatter : formatted
				}, {
					label : '操作人',
					name : 'operater',
					width : 150
				} ],
				viewrecords : true,
				height : 400,
				rowNum : 20,
				pager : "#jqGridPager",
				autowidth : true
			});
		});

		//确定按钮操作
		$("#sure").click(function() {
			$("#message").hide();
			$("#jqGrid").jqGrid('setGridParam', {
				datatype : 'json',
				postData : {
					'userNumber' : function() {
						return $('#userNumber').val();
					},
					'globalId' : function() {
						return $('#globalId').val();
					},
					'merchantName' : function() {
						return $('#commercial option:selected').val();
					},
					'operateType' : function() {
						return $('#type option:selected').val();
					},
					'beginTime' : function() {
						return $('#begin').val();
					},
					'endTime' : function() {
						return $('#after').val();
					}
				},
				page : 1
			}).trigger("reloadGrid");
			return false;
		})
		//点击重置按钮
		$("#back").click(function() {
			$("#message").hide();
		})
		//         导出按钮操作
		$("#export").click(
				function() {
					var merchantName = $('#commercial option:selected').val();
					var userNumber = $('#userNumber').val();
					var globalId = $('#globalId').val();
					var operateType = $('#type option:selected').val();
					var beginTime = $('#begin').val();
					var endTime = $('#after').val();

					var url = "/export/transactionFlow/FeiYongHu?merchantName="
							+ merchantName + "&userNumber=" + userNumber
							+ "&globalId=" + globalId + "&operateType="
							+ operateType + "&beginTime=" + beginTime
							+ "&endTime=" + endTime;
					console.log(url);
					$("#export").attr("href", url);
				})
	</script>
</body>
</html>