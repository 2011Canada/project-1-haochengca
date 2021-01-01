<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">



<title>All reimbursement</title>
</head>
<body style="margin: 100px">


	<div class="container"
		style="background: linear-gradient(to right, #7A88FF, #7AFFAF)">
		<div class="col">
			<div class="row">
				<c:if test="${user.user_role_id.ers_user_role_id==0}">
					<button type="button" id="newreim" class="btn btn-success col-lg-2">New
						Reimb</button>
				</c:if>
				<button type="button" id="approve"
											class="btn btn-warning col-lg-1 btn-sm"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/allreim.action'">all</button>
				
				<button type="button" id="approve"
											class="btn btn-warning btn-sm col-lg-1"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/allreim.action?status=1'">pending</button>
				
				<button type="button" id="approve"
											class="btn btn-warning btn-sm col-lg-1"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/allreim.action?status=2'">deny</button>
				
				<button type="button" id="approve"
											class="btn btn-warning btn-sm col-lg-1"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/allreim.action?status=3'">approve</button>
				
				<h2 class="col-lg-2 ml-auto">
					<span class="badge badge-secondary">Hi,${user.ers_username}
					</span>
				</h2>
				<button
					onclick="javascript:window.location.href='${pageContext.request.contextPath }/logout.action'"
					type="button" class="btn btn-info">logout</button>

			</div>

			<table>
				<table class="table table-striped col-lg-12">
					<thead>
						<tr class="text-center">
							<th scope="col">Reimb_id</th>
							<th scope="col"><c:if
									test="${user.user_role_id.ers_user_role_id==1}">UserName</c:if></th>
							<th scope="col">Reimb_type</th>
							<th scope="col">Amount</th>
							<th scope="col">Status</th>
							<th scope="col">Submit time</th>
							<th scope="col">Resolve time</th>
							<th scope="col">Resolver</th>
							<th scope="col">Description</th>
							<th scope="col">receipt</th>
							<th scope="col"><c:if
									test="${user.user_role_id.ers_user_role_id==1}">Action</c:if></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ers_reimbursements }" var="ers_reimbursements">
							<tr class="text-center">
								<td>${ers_reimbursements.reimb_id }</td>
								<td><c:if test="${user.user_role_id.ers_user_role_id==1}">
									${ers_reimbursements.ers_author.ers_username }
								</c:if></td>
								<td>${ers_reimbursements.reim_type_id.reimb_type }</td>
								<td>${ers_reimbursements.reimb_amount }</td>
								<td>${ers_reimbursements.reimb_status_id.reimb_status }</td>
								<td>${ers_reimbursements.reimb_submitted }</td>
								<td>${ers_reimbursements.reimb_resolved }</td>
								<td>${ers_reimbursements.ers_resolver.ers_username }</td>
								<td>${ers_reimbursements.reimb_description }</td>
								<td><img class="dialog" style="width: 50px" " alt=""
									src="/project1/img/${ers_reimbursements.receipt}">
									<div id="dialog_large_image"></div></td>
								<td><c:if
										test="${user.user_role_id.ers_user_role_id==1&&ers_reimbursements.reimb_status_id.reimb_status=='pending'}">
										<button type="button" id="approve"
											class="btn btn-success btn-sm"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/approve.action?id=${ers_reimbursements.reimb_id }&&flag=3'">approve</button>
										<button type="button" id="deny" class="btn btn-danger btn-sm"
											onclick="javascript:window.location.href='${pageContext.request.contextPath }/approve.action?id=${ers_reimbursements.reimb_id }&&flag=2'">deny</button>
									</c:if></td>
							</tr>
						</c:forEach>

					</tbody>
					<div class="container" style="z-index: 100" id="dialog_large_image"></div>
				</table>


			</table>
		</div>
	</div>

	<script src="js/jquery.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$('#newreim')
				.on(
						'click',
						function() {

							window.location.href = "${pageContext.request.contextPath }/views/add.jsp";

						});
		$(function() {
			$("img.dialog").click(
					function() {
						var large_image = '<img src= ' + $(this).attr("src")
								+ '></img>';
						$('#dialog_large_image').html($(large_image).animate({
							height : '100%',
							width : '100%'
						}, 500));
					});
		});

		$(function() {
			$("#dialog_large_image").click(
					function() {
						var large_image = '<img src= ' + $(this).attr("src")
								+ '></img>';
						$('#dialog_large_image').html($(large_image).animate({
							height : '0%',
							width : '0%'
						}, 500));
					});
		});
	</script>



</body>
</html>