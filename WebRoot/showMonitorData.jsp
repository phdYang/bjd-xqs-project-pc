<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>检测数据</title>
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
	
<script src="${pageContext.request.contextPath}/highcharts/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/highcharts/themes/dark-blue.js"></script>
</head>
<body>
<form id="ff" action="showMonitodataServlet" method="post">
	选择传感器:   <input id="cc" name="sensorId" value="">
	选择开始日期: <input id="dd" name="starDate" type="text">
	选择结束日期: <input id="dd2" name="endDate" type="text">
	<div style="text-align:left;padding:10px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
	</div>
</form>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script>
	
	$('#cc').combobox({
	    url:'showSensorAllServlet',
	    method:'post',
	    valueField:'sensorId',
	    textField:'sensorName'
	});
	
	$('#dd').datebox({
	    required:true
	});
	$('#dd2').datebox({
	    required:true
	});
	
	function submitForm(){
		$('#ff').form('submit', {
			success:function(data){
				data_j = JSON.parse(data);
				showHighcharts(data_j);
			}
		});
	}
	function clearForm(){
		$('#ff').form('clear');
	}

	var chart = Highcharts.chart('container', {
		title: {
				text: '铁路线桥隧状态数据显示'
		},
		subtitle: {
				text: '数据来源: 北京交大515'
		},
		yAxis: {
				title: {
						text: '线 桥 隧 监 测 值'
				}
		},
		legend: {
				layout: 'vertical',
				align: 'right',
				verticalAlign: 'middle'
		},
		plotOptions: {
				series: {
						label: {
								connectorAllowed: false
						}
						//pointStart: 2010
				}
		},
		series: [{
	        name: $('#cc').combobox('getText'),
	        data: []
	    }],
		responsive: {
				rules: [{
						condition: {
								maxWidth: 500
						},
						chartOptions: {
								legend: {
										layout: 'horizontal',
										align: 'center',
										verticalAlign: 'bottom'
								}
						}
				}]
		}
	});

	function showHighcharts(data){
		
		var x = []
		for(var i = 0;i<data.length;i++){
			x[i] = data[i].monitorDate
		}
		var s = []
		for(var i = 0;i<data.length;i++){
			s[i] = data[i].monitorValue
		}
		chart.update({
			xAxis: {
		        categories: x
		    },
		    series: [{
		        name: $('#cc').combobox('getText'),
		        data: s
		    }]
		})
	}



</script>
</body>
</html>