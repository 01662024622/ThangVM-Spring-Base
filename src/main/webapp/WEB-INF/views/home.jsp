<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="contact1">
		<div class="container-contact1">
			<div class="contact1-pic js-tilt" data-tilt>
				<img src="resources/images/images.png" alt="IMG">
			</div>

			<form class="contact1-form validate-form" action="upload" method="POST" enctype="multipart/form-data">
				<span class="contact1-form-title"> Upload file CSV </span>

				<div class="form-group">
					<input type="file" name="file" class="form-control-file" id="exampleFormControlFile" accept=".csv">
				</div>


				<div class="container-contact1-form-btn">
					<button class="contact1-form-btn">
						<span>Upload file<i class="fa fa-long-arrow-right"
							aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>


	<!--===============================================================================================-->
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>
