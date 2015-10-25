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
        <h4 class="modal-title" id="myModalLabel">Edit user</h4>
    </div>
	<form method="post" action="save_edited_user" >
      <div class="modal-body" >
	    <input type="hidden" name="ID" value="${ResultMap['ID']}">
		<div class="form-group">
	        <label class="col-sm-4 control-label">Name:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="Name" value="${ResultMap['Name']}">
	        </div>
	    </div>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Email:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="Email" value="${ResultMap['Email']}">
	        </div>
	   	</div>
	    <div class="form-group">
	        <label class="col-sm-4 control-label">Industry:</label>
	        <div class="col-sm-8">
	           	<input class="form-control" type="text" name="Password" value="${ResultMap['Password']}">
	        </div>
	   	</div>
	   	<div class="form-group">
	        <label class="col-sm-4 control-label">Gender:</label>
	        <div class="col-sm-8">
	           	<select class="form-control input-medium bs-select getcountrylists" data-live-search="true" name="Access">
	           		<option value="1" <c:if test="${ResultMap['Access'] == \"1\" }">selected</c:if> >Admin</option>
	           		<option value="0" <c:if test="${ResultMap['Access'] == \"0\" }">selected</c:if> >User</option>
	           	</select>
	        </div>
	   	</div>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
   </form>