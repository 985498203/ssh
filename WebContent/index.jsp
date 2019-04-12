<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-3.2.1.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
a:hover {
	color: #F00;
	cursor: pointer;
}

#trcolor:hover {
	background-color: #e4e4e4 !important;
}
</style>
<title>书籍列表</title>
</head>
<body>
	欢迎： ${sessionScope.username},
	<a href="login.html">注销</a>
	<br />
	<h2>书籍列表</h2>
	<table class="table table-bordered">
		<thead>
			<th><input type="checkbox" name="all" autocomplete="off"
				onclick="Mychack(this)" /></th>
			<th>书名</th>
			<th>作者</th>
			<th>价格</th>
			<th>操作</th>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book" varStatus="index">
				<tr id="trcolor">
					<td><input autocomplete="off" type="checkbox" name="qita"
						value="${book.id}" onclick="Mychack(this)" /></td>
					<td><a>${book.bookname}</a></td>
					<td><a>${book.user.username}</a></td>
					<td>${book.price}</td>
					<td>

						<button type="button" class="btn btn-warning" data-toggle="modal"
							data-target="#myModal" id="${book.id}">修改</button>
						<button class="btn btn-danger">删除</button>
					</td>
				</tr>
			</c:forEach>
			<!-- 修改窗口开始 -->
			<div class="modal fade" id="myModal" data-backdrop="static"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">修改书籍信息</h4>
						</div>
						<div class="modal-body">
							<p>书名：</p>
							<input type="text" class="form-control" name="bookname"
								value="${book.bookname}">
						</div>
						<div class="modal-body">
							<p>作者：</p>
							<select class="form-control">
								<option>Java</option>
								<option>Html</option>
								<option>IOS</option>
							</select>
						</div>
						<div class="modal-body">
							<p>价格：</p>
							<input type="text" class="form-control" name="price"
								value="${book.price}">
						</div>

						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" type="button">修改</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- 修改窗口结束 -->
			<tr>
				<td colspan="5"><input type="checkbox" autocomplete="off"
					name="all" onclick="Mychack(this)" />全选
					<button style="margin-left: 15px;" class="btn btn-success">批量导出</button>
					<button style="margin-left: 20px;" class="btn btn-danger">批量删除</button>
				</td>
			</tr>
		</tbody>
	</table>

</body>
<script type="text/javascript">
	function Mychack(obj) {
		var allArray = document.getElementsByName("all");
		var qitaArray = document.getElementsByName("qita");
		var qitachack = true;

		if (obj.name == "all") {
			if (obj.checked == true) {
				for (var i = 0; i < allArray.length; i++) {//遍历所有全选框
					allArray[i].checked = "checked";
				}
				for (var i = 0; i < qitaArray.length; i++) {//遍历所有其他选择框
					qitaArray[i].checked = "checked";
				}
			} else {
				for (var i = 0; i < allArray.length; i++) {//遍历所有全选框
					allArray[i].checked = "";
				}
				for (var i = 0; i < qitaArray.length; i++) {//遍历所有其他选择框
					qitaArray[i].checked = "";
				}
			}
		}

		for (var i = 0; i < qitaArray.length; i++) {//遍历所有其他选择框
			if (qitaArray[i].checked == false) {//其他选择框有一个未勾选就为false
				qitachack = false;
			}
		}

		if (qitachack) {
			for (var i = 0; i < allArray.length; i++) {//遍历所有全选框
				allArray[i].checked = "checked";
			}
		} else {
			for (var i = 0; i < allArray.length; i++) {//遍历所有全选框
				allArray[i].checked = "";
			}
		}
		for (var i = 0; i < qitaArray.length; i++) {//遍历所有其他选择框
			if (qitaArray[i].checked == true) {//其他选择框有一个未勾选就为false
				qitaArray[i].parentNode.parentNode.style.background = "#e4e4e4";
			} else {
				qitaArray[i].parentNode.parentNode.style.background = "#FFF";
			}
		}

	}
</script>
</html>