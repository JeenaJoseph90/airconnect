  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.1/Chart.js"></script>
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
				<div class="col-lg-6">
					<div class="card">
						<div class="card-body">
							<canvas id="pieChart" style="max-width: 500px;"></canvas>
						</div>
					</div>

					<div class="card card-primary card-outline">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>

							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="card-link">Card link</a> <a href="#"
								class="card-link">Another link</a>
						</div>
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col-md-6 -->
				<div class="col-lg-6">
					<div class="card">
						<div class="card-header">
							<h5 class="m-0">Test</h5>
						</div>
						<div class="card-body">
							<h6 class="card-title">Special title treatment</h6>

							<p class="card-text">With supporting text below as a natural
								lead-in to additional content.</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>

					<div class="card card-primary card-outline">
						<div class="card-header">
							<h5 class="m-0">Featured</h5>
						</div>
						<div class="card-body">
							<h6 class="card-title">Special title treatment</h6>

							<p class="card-text">With supporting text below as a natural
								lead-in to additional content.</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
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
//pie
  var ctxP = document.getElementById("pieChart").getContext('2d');
  var myPieChart = new Chart(ctxP, {
    type: 'pie',
    data: {
      labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
      datasets: [{
        data: [300, 50, 100, 40, 120],
        backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
        hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
      }]
    },
    options: {
      responsive: true
    }
  });
  </script>