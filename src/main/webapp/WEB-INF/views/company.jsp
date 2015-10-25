<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<div class="row">
			<div class="col-sm-12">
				<h2>Companies campaigns<span></span></h2>
					<div class="row plans">
    					<div class="box shadow">
        					<div class="box-body">
            					<div class="row">
            					<span class="pull-right modal-edit" href="#edit-education" style="font-size: 20px; line-height: 40px;"  data-toggle="modal" data-item="0"><button type="button" data-target="#mainModal" style="border-radius: 5px!important;" class="btn btn-default add-company"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;Add</button></span>
								    <div class="col-md-12 ">
            							<table class="table table-condensed">
								        	<thead>
										        <tr style="background: #ebebeb;">
										        	<th class="col-md-1">ID</th>
										        	<th class="col-md-2">Name</th>
										        	<th class="col-md-3">Country</th>
										        	<th class="col-md-3">Industry</th>
										        	<th class="col-md-3">Action</th>
										        </tr>	
										    </thead>
										    <tbody id="customer-list">
												<c:forEach var="company" items="${companyList}" varStatus="stat">
									        	<tr>
													<td>${company.ID}</td>
													<td>${company.name}</td>
													<td>${company.country}</td>
													<td>${company.industry}</td>
													<td class="list-actions">
														<button type="button" class="btn btn-warning edit-company"  data-target="#mainModal" value="${company.ID}" style="border-radius: 5px!important;">Edit</button>
														<a type="button" class="btn btn-warning delete-company" href="delete_company?id=${company.ID}" data-target="#mainModal" style="border-radius: 5px!important;">Delete</a>
													<a class="btn btn-primary collapsed" role="button" data-toggle="collapse" href="#collapseExample${company.ID}" aria-expanded="false" style="border-radius: 5px!important;" aria-controls="collapseExample">Show joined</a>
													</td>	
									        	</tr>
									        	<tr>
													<td colspan="5">
													<div id="collapseExample${company.ID}" class="box shadow box-border-green not_vis collapse" aria-expanded="false" style="height: 0px;">
											                <div class="box-header">
											                    <h3 class="inline"><a>Joined staff</a></h3>
											                </div>
											                <div class="box-body">
											                	<table class="table table-condensed  table-nopadding-outside">
				                                                     <thead>
				                                                          <tr style="background: #ebebeb;">
				                                                               <th>Name</th>
				                                                               <th>Last name</th>
				                                                               <th>Email</th>
				                                                               <th>Phone</th>
				                                                               <th>Age</th>
				                                                               <th>Action</th>
				                                                          </tr>
				                                                      </thead>
				                                                  <tbody>
													                	<c:forEach var="customer" items="${CustomerList}" varStatus="stat">
														                	<c:if test="${customer.value.Assigned == company.ID }">
															                    <tr>
																                    <td>${customer.value.NAME}</td>
																                    <td>${customer.value.LastName}</td>
																                    <td>${customer.value.Email}</td>
																                    <td>${customer.value.Phone}</td>
																                    <td>${customer.value.AGE}</td>
																                    <td><a type="button" class="btn btn-warning delete-company" href="unjoin_company?id=${customer.value.CUST_ID}&companyID=${company.ID}" data-target="#mainModal" style="border-radius: 5px!important;">Unjoin</a></td>
															                    </tr>                                                         
						                                                    </c:if>
													                    </c:forEach>
											                       </tbody>
											                     </table>
											               </div>
											          </div>    
													</td>
												</tr>
												</c:forEach>
											</tbody>	        	
										</table>
										<div class="text-center">
											<ul class="pagination">
											<c:forEach begin="0" end="${pagination}" var="val">
												  <li><a class="company" href="javascript:;">${val}</a></li>
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
    		</script>
    </tiles:putAttribute>
</tiles:insertDefinition>