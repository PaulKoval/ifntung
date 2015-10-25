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
        <h4 class="modal-title" id="myModalLabel">Add human</h4>
    </div>
	<form method="post" action="add_customer" >
      <div class="modal-body" >
	    <input type="hidden" name="ID" value="">
		<div class="form-group">
	        <label class="col-sm-4 control-label">First Name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="name" value="">
	        </div>
	    </div>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Last name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="LastName" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Age:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="age" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Gender:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Gender">
	           		<option >Male</option>
	           		<option >Female</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Phone:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="Phone" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Email:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="email" name="Email" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Country:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Country">
	           		<option value="1" >Ukraine</option>
	           		<option value="0" >Poland</option>
	           		<option value="2" >Germany</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">City:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="City" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	   		<label class="col-sm-4 control-label">Industry:</label>
	   		<div class="col-sm-8">
		   		<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" id="industry" name="industry">
		           	<c:forEach var="industry" items="${industryList}" varStatus="stat">
						<option value="${industry.ID}" >${industry.name}</option>
					</c:forEach>
				</select>
			</div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Experience (year):</label>
	        <div class="col-sm-8">
	           	<input class="form-control input-big numbers-only" maxlength="50" name="Experience" type="number" id="CalcStartFrom" value="">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Education:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Education">
	           		<option value="0" >Primary</option>
	           		<option value="1" >Secondary</option>
	           		<option value="2" >Tertiary</option>
	           		<option value="3" >Vocational</option>
	           		<option value="4" >Special</option>
	           	</select>
	        </div>
	   	</div>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
   </form>