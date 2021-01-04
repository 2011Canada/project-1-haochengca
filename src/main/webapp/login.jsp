<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">



<title>Welcome to ERS, please login!</title>
</head>
<body>

	<div class="container" style="background:linear-gradient(to right , #7A88FF, #7AFFAF)">
		<div class="loginform">
			<h1 dir="auto" role="heading"
				style="text-align: center; height: 100px; margin-top: 100px">
				<span>Log in to ERS system</span>
			</h1>

			<form class="col-sm-12 col-lg-2 m-auto align-items-center"
				action="${pageContext.request.contextPath }/loginuser.action" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Username</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="ers_username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						name="ers_password">
				</div>

				<div style="text-align: center">
					<button type="submit" class="btn btn-primary">Log in</button>
				</div>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>