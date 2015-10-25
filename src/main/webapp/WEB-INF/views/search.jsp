<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<div class="row">
				<div class="row form-horizontal">
		            <div class="col-md-2">
		                <div class="box shadow guide" data-bootstro-title="Step 7" data-bootstro-content="Here you will find all the necessary tools to implement your projects. Based on the 7-key model, you can create all the necessary analyzes and the business plan. Say goodbye to Word and Excel, from now you are able to work from anywhere on your idea!" data-bootstro-width="100%" data-bootstro-placement="bottom" data-bootstro-step="6">
		                    <div class="box-header">
		                        <h4>Filters</h4>
		                    </div>
		                    <form action="" method="post" id="search-form">
		                	<div class="box-body tasks">
							   	
							   	<select class="form-control input-small bs-select getcountrylists" data-live-search="true" id="Industry" name="Industry">
								   	<c:forEach var="result" items="${ResultIndustry}" varStatus="statusresult">
							           		<option value="${result.value.ID}" selected="">${result.value.NameIndustry}</option>
									</c:forEach>
								</select>
		                	</div>
		                   	<div class="box-footer text-right">
		                   		<button type="button" id="search-list" class="btn btn-warning" data-dismiss="modal">Search</button>
		                   	</div>
		                   	</form>
		              	</div>
		            </div>
		            <div class="col-md-5">
		                <div class="box shadow guide" data-bootstro-title="Step 7" data-bootstro-content="Here you will find all the necessary tools to implement your projects. Based on the 7-key model, you can create all the necessary analyzes and the business plan. Say goodbye to Word and Excel, from now you are able to work from anywhere on your idea!" data-bootstro-width="100%" data-bootstro-placement="bottom" data-bootstro-step="6">
		                    <div class="box-header">
		                        <h4>Companies campaigns</h4>
		                    </div>
		                    <form action="" method="post" id="search-form">
		                    
		                    <div class="box-body tasks navbar" id="">
			                	<div class="box-body tasks">
				                	<div class="list-group" id="list_campaigns">
				                	
					                	<c:forEach var="result" items="${ResultMap}" varStatus="statusresult">
										  <a href="#" class="list-group-item company-list" company-id="${result.value.ID}">
									        <h5 class="list-group-item-heading">${result.value.Name} : ${result.value.NameIndustry}</h5>
									        <table>
									      	<tr>
										      	<td style="padding: 5px;"><label>Age From:</label></td>
										      	<td style="padding: 5px;">${result.value.From}</td>
										      	<td style="padding: 5px;"><label>Age To:</label></td>
										      	<td style="padding: 5px;">${result.value.To}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Gender:</label></td>
										      	<td style="padding: 5px;">
											      	<c:if test="${result.value.Gender ==  \"1\"}">Male</c:if>
											      	<c:if test="${result.value.Gender ==  \"0\"}">Female</c:if>
										      	</td>
										      	<td style="padding: 5px;"><label>Count:</label></td>
										      	<td style="padding: 5px;">${result.value.Count}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Country:</label></td>
										      	<td style="padding: 5px;">
											      	<c:if test="${result.value.requireCountry ==  \"1\"}">Ukraine</c:if>
											      	<c:if test="${result.value.requireCountry ==  \"0\"}">Poland</c:if>
											      	<c:if test="${result.value.requireCountry ==  \"2\"}">Germany</c:if>
										      	</td>
										      	<td style="padding: 5px;"><label>City:</label></td>
										      	<td style="padding: 5px;">${result.value.City}</td>
									      	</tr>
									      	<tr>
										      	<td style="padding: 5px;"><label>Experience:</label></td>
										      	<td style="padding: 5px;">${result.value.Experience} years</td>
										      	<td style="padding: 5px;"><label>Education:</label></td>
										      	<td style="padding: 5px;">
										      	<c:if test="${result.value.Education == \"0\" }">Primary</c:if> 
								           		<c:if test="${result.value.Education == \"1\" }">Secondary</c:if> 
								           		<c:if test="${result.value.Education == \"2\" }">Tertiary</c:if> 
								           		<c:if test="${result.value.Education == \"3\" }">Vocational</c:if> 
								           		<c:if test="${result.value.Education== \"4\" }">Special</c:if> 
										      	</td>
									      	</tr>
									      	</table>
									      </a>
										</c:forEach>	
								    </div>
			                	</div>
			                </div>
		                   	</form>
		              	</div>
		            </div>
		      		<div class="col-md-5">
		                <div class="box shadow guide" data-bootstro-title="Step 7" data-bootstro-content="Here you will find all the necessary tools to implement your projects. Based on the 7-key model, you can create all the necessary analyzes and the business plan. Say goodbye to Word and Excel, from now you are able to work from anywhere on your idea!" data-bootstro-width="100%" data-bootstro-placement="bottom" data-bootstro-step="6">
		                    <div class="box-header">
		                        <h4>Users</h4>
		                    </div>
		                    <div class="box-body tasks navbar" id="searched-data">
		                    	
		                    </div>
		                </div>
		            </div>
		      	</div>
    	</div>
    </tiles:putAttribute>
</tiles:insertDefinition>