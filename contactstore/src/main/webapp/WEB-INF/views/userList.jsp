<!-- Case 1: This will be displayed if data saved into DB -->
<c:if test="${param.action eq 'save'}">
	<div class="row my-4">
		<div class="col-md-12">
			<div class="alert alert-success text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>
					Contact has been saved successfully!</strong>
			</div>
		</div>
	</div>
</c:if>

<!-- Case 2: This will be displayed if data updated into DB -->
<c:if test="${param.action eq 'update'}">
	<div class="row my-4">
		<div class="col-md-12">
			<div class="alert alert-success text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>
					Contact has been updated successfully!</strong>
			</div>
		</div>
	</div>
</c:if>

<!-- Case 3: This will be displayed if data will be deleted from DB -->
<c:if test="${param.action eq 'delete'}">
	<div class="row my-4">
		<div class="col-md-12">
			<div class="alert alert-success text-center">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>
					Contact has been deleted successfully!</strong>
			</div>
		</div>
	</div>
</c:if>
<script type="text/javascript">
	function changeStatus(uid, lstatus) {
		// alert(user_id + " , " + login_status);
		$.ajax({
			
			url:'change_status',
			data: {userId:uid, loginStatus:lstatus},
			success: function(data) {
				alert(data);
			}
		});
	}
	
</script>
<div class="container">
	<div class="row my-4">
		<form class="form-inline col-md-9"></form>
		<!-- Search Functionality using freeText -->
		<form class="form-inline has-search col-md-3"
			action="${contextRoot}/admin/user/search">
			<input type="text" class="form-control" name="freeText"
				value="${param.freeText}" placeholder="Enter Text To Search">
			<span class="fa fa-search form-control-feedback"></span>
		</form>
		<br> <br> <br>
		<!-- Show All contacts associated with logged in user. -->
		<!-- Responsive Data Table  -->
		<table id="contactTable" class="table table-hover table-bordered">
			<thead>
				<tr>
					<th style="width: 5%">#</th>
					<th style="width: 5%">ID</th>
					<th style="width: 15%">Name</th>
					<th style="width: 10%">Phone</th>
					<th style="width: 20%">Email</th>
					<th style="width: 23%">Address</th>
					<th style="width: 10%">Username</th>
					<th class="text-center" style="width: 12%">Status</th>
				</tr>
			</thead>
			<tbody>
				<!-- If there is no contact available in DB for Logged in User -->
				<c:if test="${empty users}">
					<tr>
						<td colspan="8">
							<h4 class="text-center text-danger">No Records Availabe.!</h4>
						</td>
					</tr>
				</c:if>
				<!-- If records are present in DB for logged in User -->
				<c:forEach var="user" items="${users}" varStatus="record">
					<tr>
						<th scope="row">${record.count}</th>
						<td>${user.userId}</td>
						<td>${user.name}</td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td>${user.address}</td>
						<td>${user.loginName}</td>
						<td><a class="btn btn-sm"><i class="fa fa-user-cog"></i>
							<select id="id_${user.userId}" onchange="changeStatus(${user.userId},$(this).val())">
									<option value="1">Active</option>
									<option value="2">Block</option>
							</select></a>
							<!-- Ajax call to show current loginStatus --> 
							<script type="text/javascript"> 
								 $('#id_${user.userId}').val(${user.loginStatus});
							</script> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>