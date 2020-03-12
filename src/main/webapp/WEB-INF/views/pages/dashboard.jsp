<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">Dashboard</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Dashboard</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-info">
						<div class="inner">
							<h3>${dataPointsList.get(0).size()}</h3>

							<p>Countries</p>
						</div>
						<div class="icon">
							<i class="ion ion-android-globe"></i>
						</div>
						<a href="#" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-success">
						<div class="inner">
							<h3>
								${dashBoardData.get("buyersData").size()}
							</h3>

							<p>Airlines</p>
						</div>
						<div class="icon">
							<i class="ion ion-plane"></i>
						</div>
						<a href="#" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-warning">
						<div class="inner">
							<h3>${dashBoardData.get("totalBuyers")}</h3>

							<p>Buyer Available</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-stalker"></i>
						</div>
						<a href="${pageContext.request.contextPath}/buyers" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-danger">
						<div class="inner">
							<h3>${dashBoardData.get("totalUsers")}</h3>

							<p>User Registrations</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="${pageContext.request.contextPath}/users" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="card card-primary card-outline">
						<div class="card-body">
							<div id="chartContainer" style="height: 370px; width: 100%;"></div>
						</div>
					</div>


				</div>
				<!-- /.col-md-6 -->
				<div class="col-lg-6">
					<div class="card card-primary card-outline">
						<div class="card-body">
							<div id="buyerChartContainer" style="height: 370px; width: 100%;"></div>
						</div>
					</div>


				</div>
				
				<!-- /.col-md-6 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content -->
</div>
<script type="text/javascript">
	window.onload = function() {

		CanvasJS.addColorSet("customShades", [//colorSet Array

		'#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de' ]);

		var dps = [ [] ];

		var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			exportEnabled : true,
			colorSet : "customShades",
			theme : "light2",
			title : {
				text : "Airlines by Country",
				fontFamily: "Times New Romen",
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				indexLabel : "{y}",
				indexLabelPlacement : "inside",
				indexLabelFontColor : "white",
				dataPoints : dps[0]
			} ]
		});

		var yValue;
		var name;

		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		name = "${dataPoint.name}";
		dps[parseInt("${loop.index}")].push({
			name : name,
			y : yValue
		});
		</c:forEach>
		</c:forEach>

		chart.render();

	}
</script>