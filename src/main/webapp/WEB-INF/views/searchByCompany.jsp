<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="contact" items="${userData}" varStatus="status">
	<div class="box shadow box-border-orange">
	    <div class="box-header-collapse no-background">
	        <h3><a data-toggle="collapse" href="#box${contact.value.CUST_ID}" aria-expanded="true" class=""><i class="glyphicon glyphicon-list-alt"></i> ${contact.value.NAME} : ${contact.value.Phone}&nbsp;<i style="" class="glyphicon glyphicon-chevron-down"></i></a></h3>
	    </div>
		<div id="box${contact.value.CUST_ID}" class="collapse"  aria-expanded="false" style="height: 0px;">
	        <div class="box-body padding-top-0">
		        <div class="guide" data-bootstro-title="Step 9" data-bootstro-content="After creating strategic business areas, you can add customer value and prices per strategic business area. " data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="8">
		        	<h5 class="inline" style="font-family: 'Open Sans Condensed', sans-serif;font-weight: 700;color: #8e8071;margin: 0 0 10px 0;">Name</h5>
					<table class="table table-condensed table-noborder table-nopadding-outside">
	                      	<tbody>
								<tr>
	                                <td>${contact.value.NAME}</td>
	                            </tr>
	                     	</tbody>
	                </table>
	            </div>
		        
		        <div class="guide" data-bootstro-title="Step 9" data-bootstro-content="After creating strategic business areas, you can add customer value and prices per strategic business area. " data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="8">
		        	<h5 class="inline" style="font-family: 'Open Sans Condensed', sans-serif;font-weight: 700;color: #8e8071;margin: 0 0 10px 0;">Age</h5>
					<table class="table table-condensed table-noborder table-nopadding-outside">
	                      	<tbody>
								<tr>
	                                <td>${contact.value.AGE}</td>
	                            </tr>
	                     	</tbody>
	                </table>
	            </div>
	           
		        <div class="guide" data-bootstro-title="Step 9" data-bootstro-content="After creating strategic business areas, you can add customer value and prices per strategic business area. " data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="8">
		        	<h5 class="inline"  style="font-family: 'Open Sans Condensed', sans-serif;font-weight: 700;color: #8e8071;margin: 0 0 10px 0;">Phone</h5>
					<table class="table table-condensed table-noborder table-nopadding-outside">
	                      	<tbody>
								<tr>
	                                <td>${contact.value.Phone}</td>
	                            </tr>
	                     	</tbody>
	                </table>
	            </div>
	            
		        <div class="guide" data-bootstro-title="Step 9" data-bootstro-content="After creating strategic business areas, you can add customer value and prices per strategic business area. " data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="8">
		        	<h5 class="inline"  style="font-family: 'Open Sans Condensed', sans-serif;font-weight: 700;color: #8e8071;margin: 0 0 10px 0;">Email</h5>
					<table class="table table-condensed table-noborder table-nopadding-outside">
	                      	<tbody>
								<tr>
	                                <td>${contact.value.Email}</td>
	                            </tr>
	                     	</tbody>
	                </table>
	            </div>
			<button type="button" class="btn btn-warning join-campaign"  data-target="#mainModal" value="${contact.value.CUST_ID}" style="border-radius: 5px!important; width: 100%;">Join</button>
		
			</div>
			
	    </div>
	    		
	</div>
</c:forEach>