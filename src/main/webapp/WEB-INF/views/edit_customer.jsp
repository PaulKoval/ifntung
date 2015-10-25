<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!--<c:forEach items="${userData}" var="list">
		<div class="form-group">
          	<label class="col-sm-4 control-label">${list.key}:</label>
          	<div class="col-sm-8">
           		<input class="form-control" type="text" name="name" value="${list.value}">
            </div>
        </div>
	</c:forEach>-->
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Edit human</h4>
    </div>
	<form method="post" action="save_edit_customer" >
      <div class="modal-body" >
	    <input type="hidden" name="ID" value="${userData['ID']}">
		<div class="form-group">
	        <label class="col-sm-4 control-label">First Name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="name" value="${userData['Name']}">
	        </div>
	    </div>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Last name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="LastName" value="${userData['LastName']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Age:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="age" value="${userData['Age']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Gender:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Gender">
	           		<option value="1" <c:if test="${userData['Gender'] == \"1\" }">selected</c:if>>Male</option>
	           		<option value="0" <c:if test="${userData['Gender'] == \"0\" }">selected</c:if>>Female</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Phone:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="Phone" value="${userData['Phone']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Email:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="email" name="Email" value="${userData['Email']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Country:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Country">
	           		<option value="1" <c:if test="${userData['Country'] == \"1\" }">selected</c:if>>Ukraine</option>
	           		<option value="0" <c:if test="${userData['Country'] == \"0\" }">selected</c:if>>Poland</option>
	           		<option value="2" <c:if test="${userData['Country'] == \"2\" }">selected</c:if>>Germany</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">City:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="City" value="${userData['City']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	   		<label class="col-sm-4 control-label">Industry:</label>
	   		<div class="col-sm-8">
		   		<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" id="industry" name="industry">
		           	<c:forEach var="industry" items="${industryList}" varStatus="stat">
						<option value="${industry.ID}" <c:if test="${industry.ID ==  userData['Industry']}">selected</c:if> >${industry.name}</option>
					</c:forEach>
				</select>
			</div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Experience (year):</label>
	        <div class="col-sm-8">
	           	<input class="form-control input-big numbers-only" maxlength="50" name="Experience" type="number" id="CalcStartFrom" value="${userData['Experience']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Education:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Education">
	           		<option value="0" <c:if test="${userData['Education'] == \"0\" }">selected</c:if>>Primary</option>
	           		<option value="1" <c:if test="${userData['Education'] == \"1\" }">selected</c:if>>Secondary</option>
	           		<option value="2" <c:if test="${userData['Education'] == \"2\" }">selected</c:if>>Tertiary</option>
	           		<option value="3" <c:if test="${userData['Education'] == \"3\" }">selected</c:if>>Vocational</option>
	           		<option value="4" <c:if test="${userData['Education'] == \"4\" }">selected</c:if>>Special</option>
	           	</select>
	        </div>
	   	</div>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
   </form>