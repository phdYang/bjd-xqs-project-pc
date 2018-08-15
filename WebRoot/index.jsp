<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主界面</title>
<!-- 引入JQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.5/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.5/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.5/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.5/themes/bootstrap/easyui.css"
	type="text/css" />
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.5/themes/icon.css"
	type="text/css" />
<script>
	function addTab(title, url){
		if ($('#tt').tabs('exists', title)){
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; padding: 10px">铁路线桥隧状态监测预警</div>
	<div class="easyui-accordion"
		data-options="region:'west',split:true,title:'菜单栏'"
		style="width: 250px; padding: 10px;">
		<div title="查询功能" 
			style="overflow: auto; width: 300px;height: 200px;padding: 1px;">
			<div title="TreeMenu" data-options="iconCls:'icon-search'" style="padding:1px;">
				<ul class="easyui-tree">
					<li>
						<a onclick="addTab('查询传感器','showSensor.jsp')">查询传感器</a>
					</li>
					<li><a onclick="addTab('查询检测数据','showMonitorData.jsp')">查询检测数据</a></li>
				</ul>
			</div>
		</div>
		<div title="预测功能"
			style=" width: 100%;padding: 10px;">
			<div title="TreeMenu" data-options="iconCls:'icon-search'" style="padding:1px;">
				<ul class="easyui-tree">
					<li>
						<a onclick="addTab('查询传感器','showSensor.jsp')">神经网络预测模型</a>
					</li>
				</ul>
			</div>
		</div>
		<div title="报警功能"
			style=" width: 100%;padding: 10px;">
			<div title="TreeMenu" data-options="iconCls:'icon-search'" style="padding:1px;">
				<ul class="easyui-tree">
					<li>
						<a onclick="addTab('查询传感器','showSensor.jsp')">报警阈值参数设置</a>
					</li>
					<li><a onclick="addTab('查询检测数据','showMonitorData.jsp')">报警信息查询</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; padding: 10px;">北京交大 © Copyright 2018-08
		515</div>
	<div id="tt" class="easyui-tabs" data-options="region:'center',title:''">
	</div>
</body>
</html>