<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<div class="row">
			<div class="col-sm-12">
				<h2>Administration dashboard<span></span></h2>
				<div class="row">
		            <div class="col-md-12">
		                <div class="box shadow guide" data-bootstro-title="Step 7" data-bootstro-content="Here you will find all the necessary tools to implement your projects. Based on the 7-key model, you can create all the necessary analyzes and the business plan. Say goodbye to Word and Excel, from now you are able to work from anywhere on your idea!" data-bootstro-width="100%" data-bootstro-placement="bottom" data-bootstro-step="6">
		                    <div class="box-header">
		                        <h4>User list<span class="pull-right modal-add" href="#add-admin" style="font-size: 20px; line-height: 40px;" data-toggle="modal" data-item="0"><button type="button" class="btn btn-warning add-user"  data-target="#mainModal" value="" style="border-radius: 5px!important;"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add</button></span>
		                   </h4>
		                        
		                    </div>
		                    <div class="box-body tasks">
		                     	<table class="table table-striped table-hover">
									<thead>
									    <tr>
								            <th style="width:150px;">ID</th>
										    <th style="width:150px;">Name</th>
										    <th style="width:20px;">Email</th>
										    <th>Access lvl. (0/1)</th>
										    <th>Actions</th>
									    </tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${UserList}" varStatus="stat">
										    <tr>
									            <td>${user.value.ID}</td>
											    <td>${user.value.Name}</td>
											    <td>${user.value.Email}</td>
											    <td>${user.value.Access}</td>
											    <td class="no-break">
											    	<button type="button" class="btn btn-warning edit-user"  data-target="#mainModal" value="${user.value.ID}" style="border-radius: 5px!important;">Edit</button>
													<a type="button" class="btn btn-warning delete-user" href="delete_user?id=${user.value.ID}" data-target="#mainModal" style="border-radius: 5px!important;">Delete</a>
												</td>
										    </tr>
										</c:forEach>
									</tbody>
								</table>
		                   	</div>
		              	</div>
		         	</div>
		      	</div>
    		</div>
    	</div>
    </tiles:putAttribute>
</tiles:insertDefinition>