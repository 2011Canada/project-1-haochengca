<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
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
<title>Add reim</title>
</head>
<body>

	<div class="container"
		style="background: linear-gradient(to right, #7A88FF, #7AFFAF)">
		<div class="loginform">
			<h1 dir="auto" role="heading"
				style="text-align: center; height: 100px; margin-top: 100px">
				<span>Add reimbursement</span>
			</h1>

			<form class="col-sm-12 col-lg-4 m-auto align-items-center"
				action="${pageContext.request.contextPath }/add.action"
				method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label style="font-size: 30px;" for="reimb_amount">reimb_amount</label>
					<input type="text" class="form-control" id="reimb_amount"
						name="reimb_amount">
				</div>

				<div class="form-group">

					<label style="font-size: 30px;">reim_type</label> <select
						class="form-control form-control-lg"
						name="reim_type_id.reimb_type_id">
						<option value=0>lodging</option>
						<option value=1>travel</option>
						<option value=2>food</option>
						<option value=3>other</option>
					</select>
				</div>

				<div class="form-group">
					<label style="font-size: 30px;" for="reimb_description">reimb_description</label>
					<input type="text" class="form-control" id="reimb_description"
						name="reimb_description">
				</div>

				<div class="form-group">
					<label style="font-size: 30px;" >receipt</label>
					<input type="file" class="form-control" name="file" />
				</div>

				<div style="text-align: center">
					<button type="submit" class="btn btn-primary">Add</button>
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