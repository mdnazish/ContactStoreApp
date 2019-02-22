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

<div class="container">
	<div class="row my-4">

		<!-- Responsive Data Table  -->

		<table id="contactTable" class="table table-hover table-bordered"
			cellspacing="0">
			<thead>
				<tr>
					<th style="width: 5%">#</th>
					<th style="width: 15%">Name</th>
					<th style="width: 10%">Phone</th>
					<th style="width: 20%">Email</th>
					<th style="width: 25%">Address</th>
					<th style="width: 10%">Remark</th>
					<th class="text-center" style="width: 15%">Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- If there is no contact available in DB for Logged in User -->
				<c:if test="${empty contacts}">
					<tr>
						<td colspan="7">
							<h4 class="text-center text-danger">No Records Availabe.!</h4>
						</td>
					</tr>
				</c:if>
				<!-- If records are present in DB for logged in User -->
				<c:forEach var="contact" items="${contacts}" varStatus="record">
					<tr>
						<th scope="row">${record.count}</th>
						<td>${contact.name}</td>
						<td>${contact.phone}</td>
						<td>${contact.email}</td>
						<td>${contact.address}</td>
						<td>${contact.remark}</td>
						<td><a class="btn btn-sm"
							href="${contextRoot}/user/contact/${contact.contactId}/edit">
								<i class="fa fa-edit"></i> Edit
						</a> <spring:url var="URL_delete" value="/user/contact/delete">
								<spring:param name="cid" value="${contact.contactId}" />
							</spring:url> <a class="btn btn-sm" href="${URL_delete}" data-toggle="modal"
							data-target="#deleteModal"> <i class="fa fa-trash"></i>
								Delete
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<!-- delete Modal Dialog Box -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Are You Sure?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Do You Want to delete this record?</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">No</button>
				<a class="btn btn-primary" href="${URL_delete}">Yes</a>
			</div>
		</div>
	</div>
</div>