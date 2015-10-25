<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<div class="row">
			<div class="col-sm-12">
				<h2>Users list <span></span></h2>
					<div class="row plans">
    					<div class="box shadow">
        					<div class="box-body">
            					<div class="row">
            					<span class="pull-right modal-edit" href="#edit-education" style="font-size: 20px; line-height: 40px;"  data-toggle="modal" data-item="0"><button type="button" data-target="#mainModal" style="border-radius: 5px!important;" class="btn btn-default add-human"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;Add</button>
            					<button type="button"  style="border-radius: 5px!important;" id="printHumans" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;Print to PDF</button>
            					<button type="button"  style="border-radius: 5px!important;" id="printExcel" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;Print to Excel</button>
								<button type="button"  style="border-radius: 5px!important;" id="printJasper" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;Print to JasperReports</button></span>
								    <div class="col-md-12 ">
            							<table class="table table-condensed">
								        	<thead>
										        <tr style="background: #ebebeb;">
										        	<th class="col-md-1">ID</th>
										        	<th class="col-md-4">Name</th>
										        	<th class="col-md-3">Email</th>
										        	<th class="col-md-2">Age</th>
										        	<th class="col-md-2">Action</th>
										        </tr>	
										    </thead>
										    <tbody id="customer-list">
												<c:forEach var="result" items="${ResultMap}" varStatus="statusresult">
									        	<tr>
													<td>${result.value.CUST_ID}</td>
													<td>${result.value.NAME}</td>
													<td>${result.value.Email}</td>
													<td>${result.value.AGE}</td>
													<td class="list-actions">
														<button type="button" class="btn btn-warning edit"  data-target="#mainModal" value="${result.value.CUST_ID}" style="border-radius: 5px!important;">Edit</button>
														<a type="button" class="btn btn-warning delete" href="delete_customer?id=${result.value.CUST_ID}" data-target="#mainModal" style="border-radius: 5px!important;">Delete</a>
													</td>	
									        	</tr>
												</c:forEach>
											</tbody>	        	
										</table>
										<div class="text-center">
											<ul class="pagination">
											<c:forEach begin="0" end="${pagination}" var="val">
												  <li><a class="human" href="javascript:;">${val}</a></li>
											</c:forEach>
											</ul>
										</div>
									</div>
								</div>				
							</div>
    					</div>
    				</div>
    			</div>
    		</div>
    		<script>
	    		$(document).ready(function(){
	    		    
	    		    
	    		});
    		</script>
    </tiles:putAttribute>
</tiles:insertDefinition>