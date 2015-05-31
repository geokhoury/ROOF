<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>ROOF - Find Me a Room!</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700'
	rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">



<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
<!-- datepicker -->
<link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/build/css/bootstrap-datetimepicker.css" rel="stylesheet">


<!-- animate.css -->
<link rel="stylesheet" href="assets/animate/animate.css" />
<link rel="stylesheet" href="assets/animate/set.css" />

<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">

<link rel="stylesheet" href="assets/style.css">
<!-- jQuery -->
<script src="assets/jquery.js"></script>
<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<!-- moments -->
<script src="assets/bootstrap/js/moment.js" type="text/javascript"></script>
<!-- datepicker -->
<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/src/js/bootstrap-datetimepicker.js"></script>

</head>

<body>
	<div class="topbar animated fadeInLeftBig"></div>

	<!-- Header Starts -->
	<div class="navbar-wrapper">
		<div class="container">

			<div class="navbar navbar-default navbar-fixed-top" role="navigation"
				id="top-nav">
				<div class="container">
					<div class="navbar-header">
						<!-- Logo Starts -->
						<a class="navbar-brand" href="#home"><img
							src="images/logo.png" alt="logo"></a>
						<!-- #Logo Ends -->


						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>

					</div>


					<!-- Nav Starts -->
					<div class="navbar-collapse  collapse">
						<ul class="nav navbar-nav navbar-right scroll">
							<li class="active"><a href="#works">Find</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#team">Team</a></li>
							<li><a href='#loginForm' data-toggle="modal" data-target="#loginForm" data-backdrop="true">Login</a></li>
						</ul>
					</div>
					<!-- #Nav Ends -->

				</div>
			</div>

		</div>
	</div>
	<!-- #Header Starts -->

	<!-- Buildings -->
	<%@include file='buildings.jsp'%>
	<!-- #Buildings -->

	<!-- Modals -->

	<!-- Rooms In Building Modal -->
	<%@include file='room.jsp'%>
	<!-- #Rooms In Building Modal -->

	<!-- Room Schedule -->
	<%@include file='roomSchedule.jsp'%>
	<!-- #Room Schedule -->

	<!-- Reservation Modal -->
	<%@include file='reserve.jsp'%>
	<!-- #Reservation Modal -->

	<!-- #Modals -->

	<!-- Cirlce Starts -->
	<div id="about" class="container spacer about">
		<h2 class="text-center wowload fadeInUp">ROOF</h2>
		<div class="row">
			<div class="col-sm-6 wowload fadeInLeft">
				<h4>
					<i class="fa fa-paint-brush"></i> Design
				</h4>
				<p>Creative digital agency for sleek and sophisticated solutions
					for mobile, websites and software designs, lead by passionate and
					uber progressive team that lives and breathes design. Creative
					digital agency for sleek and sophisticated solutions for mobile,
					websites and software designs.</p>


			</div>
			<div class="col-sm-6 wowload fadeInRight">
				<h4>
					<i class="fa fa-code"></i> Frontend & Backend Development
				</h4>
				<p>Lorem Ipsum is simply dummy text of the printing and
					typesetting industry. Lorem Ipsum has been the industry's standard
					dummy text ever since the 1500s, when an unknown printer took a
					galley of type and scrambled it to make a type specimen book.</p>
			</div>
		</div>

		<div class="process">
			<h3 class="text-center wowload fadeInUp">Process</h3>
			<ul class="row text-center list-inline  wowload bounceInUp">
				<li><span><i class="fa fa-history"></i><b>Research</b></span></li>
				<li><span><i class="fa fa-puzzle-piece"></i><b>Plan</b></span>
				</li>
				<li><span><i class="fa fa-database"></i><b>Develop</b></span></li>
				<li><span><i class="fa fa-magic"></i><b>Integration</b></span>
				</li>
				<li><span><i class="fa fa-cloud-upload"></i><b>Deliver</b></span>
				</li>
			</ul>
		</div>
	</div>
	<!-- #Cirlce Ends -->

	<!-- About Starts -->
	<div class="highlight-info">
		<div class="overlay spacer">
			<div class="container">
				<div class="row text-center  wowload fadeInDownBig">
					<div class="col-sm-3 col-xs-6">
						<i class="fa fa-smile-o  fa-5x"></i>
						<h4>24 Clients</h4>
					</div>
					<div class="col-sm-3 col-xs-6">
						<a href="/game.html"><i class="fa fa-rocket  fa-5x"></i></a>
						<h4>75 Projects</h4>
					</div>
					<div class="col-sm-3 col-xs-6">
						<i class="fa fa-cloud-download  fa-5x"></i>
						<h4>454 Downloads</h4>
					</div>
					<div class="col-sm-3 col-xs-6">
						<i class="fa fa-map-marker fa-5x"></i>
						<h4>2 Offices</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About Ends -->



		<!-- team -->
		<%@include file='team.jsp'%>
		<!-- team -->


	<!--Contact Starts-->
	<%@include file='loginForm.jsp'%>
	<%@include file='signupForm.jsp'%>
	<!--Contact Ends-->

	<!-- Footer Starts -->
	<%@include file='footer.jsp'%>
	<!-- # Footer Ends -->

	<a href="#works" class="gototop "><i class="fa fa-angle-up  fa-3x"></i></a>

	<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
	<div id="blueimp-gallery"
		class="blueimp-gallery blueimp-gallery-controls">
		<!-- The container for the modal slides -->
		<div class="slides"></div>
		<!-- Controls for the borderless lightbox -->
		<h3 class="title">Title</h3>
		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a>
		<!-- The modal dialog, which will be used to wrap the lightbox content -->
	</div>

	<!-- jquery -->


	<!-- wow script -->
	<script src="assets/wow/wow.min.js"></script>

	<!-- jquery mobile -->
	<script src="assets/mobile/touchSwipe.min.js"></script>
	<script src="assets/respond/respond.js"></script>

	<!-- gallery -->
	<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>

	<!-- custom script -->
	<script src="assets/script.js"></script>

	<!-- listRoomByBuilding script -->
	<script src="assets/rooms.js"></script>

	<script src="assets/roomSchedule.js"></script>

	<script src="assets/reserve.js"></script>


</body>
</html>
