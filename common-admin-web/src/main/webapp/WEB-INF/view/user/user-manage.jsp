<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span>
	用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
				href="javascript:location.replace(location.href);" title="刷新">
				<i class="Hui-iconfont">&#xe68f;</i>
			</a>
</nav>

<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate radius" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate radius" style="width:120px;">
		<input type="text" class="input-text radius" style="width:250px" placeholder="输入会员名称、电话、邮箱"  name="">
		<button type="submit" class="btn btn-success radius"  name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>

	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
			<a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')" class="btn btn-primary radius">
				<i class="Hui-iconfont">&#xe600;</i> 添加用户
			</a>
		</span>
		<span class="r">共有数据：<strong>88</strong> 条</span>
	</div>

	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort radius">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th>姓名</th>
				<th>职位</th>
				<th>状态</th>
				<th>入职时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	</div>
</div>


<script src="${pageContext.request.contextPath}/resources/js/constant.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/datatable-plugin.js"></script>


<script type="text/javascript">
$(function(){

	var opts = {
		columns:[
			CONSTANT.DATA_TABLES.COLUMN.CHECKBOX,
			{
				className : "ellipsis",	//文字过长时用省略号显示，CSS实现
				data: "name",
				render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS,//会显示省略号的列，需要用title属性实现划过时显示全部文本的效果
			},
			{
				className : "ellipsis",
				data: "position",
				render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS,
				//固定列宽，但至少留下一个活动列不要固定宽度，让表格自行调整。不要将所有列都指定列宽，否则页面伸缩时所有列都会随之按比例伸缩。
				//切记设置table样式为table-layout:fixed; 否则列宽不会强制为指定宽度，也不会出现省略号。
				width : "80px"
			},
			{
				data : "status",
				width : "80px",
				render : function(data,type, row, meta) {
					return '<i class="fa fa-male"></i> '+(data?"在线":"离线");
				}
			},
			{
				data : "start_date",
				width : "80px"
			},
			{
				className : "td-manage",
				data: null,
				orderable : false,
				width : "120px",
				render:function(data,type,row,meta){
					var str0 = "<a style=\"text-decoration:none\" onClick=\"member_stop(this,'10001')\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a>";
					var str1 = "<a title=\"编辑\" href=\"javascript:;\"onclick=\"member_edit('编辑','member-add.html','4','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
					var str2 = "<a style=\"text-decoration:none\" class=\"ml-5\" onClick=\"change_password('修改密码','change-password.html','10001','600','270')\" href=\"javascript:;\" title=\"修改密码\"><i class=\"Hui-iconfont\">&#xe63f;</i></a>";
					var str3 = "<a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,'1')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td>";
					return str0+str1+str2+str3;
				}
			}
		],
		url:"${pageContext.request.contextPath}/resources/datasource.jsp",
		pagingType: "full_numbers",
	}
	$.fn.ajaxTable(opts);



//	$('.table-sort').dataTable({
//		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
//		"bStateSave": true,//状态保存
//		"aoColumnDefs": [
//		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
//		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
//		]
//	});
//
//	$('.table-sort tbody').on( 'click', 'tr', function () {
////		if ( $(this).hasClass('selected') ) {
////			$(this).removeClass('selected');
////		}
////		else {
////			table.$('tr.selected').removeClass('selected');
////			$(this).addClass('selected');
////		}
//		//$(this).addClass("active").siblings().removeClass("active");
//	});




});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
</script> 
</body>
</html>