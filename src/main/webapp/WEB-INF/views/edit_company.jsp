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
        <h4 class="modal-title" id="myModalLabel">Edit company</h4>
    </div>
	<form method="post" action="save_edited_company" >
      <div class="modal-body" >
	    <input type="hidden" name="ID" value="${companyData['ID']}">
		<div class="form-group">
	        <label class="col-sm-4 control-label">Name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="name" value="${companyData['Name']}">
	        </div>
	    </div>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Country:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="country" value="${companyData['Country']}">
	        </div>
	   	</div>
	   	<label>Requirements</label>
	   	<hr>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Industry:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" id="industry" name="industry">
	           	<c:forEach var="industry" items="${industryList}" varStatus="stat">
					<option value="${industry.ID}" <c:if test="${industry.ID ==  Integer.parseInt(companyData['Industry'])}">selected</c:if> >${industry.name}</option>
				</c:forEach>
				</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Age: </label>
			<label class="col-sm-1 control-label">From</label>
	        <div class="col-sm-3">
	            <input class="form-control" type="text" name="ageFrom" value=" <c:out value="${ResultMap['From']}"/> ">
	        </div>
			<label class="col-sm-1 control-label">To</label>
	        <div class="col-sm-3">
	            <input class="form-control" type="text" name="ageTo" value=" <c:out value="${ResultMap['To']}"/> ">
	        </div>
    	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Gender:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Gender">
	           		<option value="1" <c:if test="${ResultMap['Gender'] == \"1\" }">selected</c:if> >Male</option>
	           		<option value="0" <c:if test="${ResultMap['Gender'] == \"0\" }">selected</c:if> >Female</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Country:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="requireCountry">
	           		<option value="1" <c:if test="${ResultMap['requireCountry'] == \"1\" }">selected</c:if> >Ukraine</option>
	           		<option value="0" <c:if test="${ResultMap['requireCountry'] == \"0\" }">selected</c:if> >Poland</option>
	           		<option value="2" <c:if test="${ResultMap['requireCountry'] == \"2\" }">selected</c:if> >Germany</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">City:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="City" value="<c:out value=" ${ResultMap['City']}"/> ">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Experience (year):</label>
	        <div class="col-sm-8">
	           	<input class="form-control input-big numbers-only" maxlength="50" name="Experience" type="number" id="CalcStartFrom" value="<c:out value="${ResultMap['Experience']}"/>">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Education:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Education">
	           		<option value="0"  <c:if test="${ResultMap['Education'] == \"0\" }">selected</c:if> >Primary</option>
	           		<option value="1"  <c:if test="${ResultMap['Education'] == \"1\" }">selected</c:if> >Secondary</option>
	           		<option value="2"  <c:if test="${ResultMap['Education'] == \"2\" }">selected</c:if> >Tertiary</option>
	           		<option value="3"  <c:if test="${ResultMap['Education'] == \"3\" }">selected</c:if> >Vocational</option>
	           		<option value="4"  <c:if test="${ResultMap['Education'] == \"4\" }">selected</c:if> >Special</option>
	           	</select>
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Count (peoples):</label>
	        <div class="col-sm-8">
	           	<input class="form-control input-big numbers-only" maxlength="50" name="Count" type="number" id="CalcStartFrom" value="<c:out value="${ResultMap['Count']}"/>">
	        </div>
	   	</div>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
   </form>