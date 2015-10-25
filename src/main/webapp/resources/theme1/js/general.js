

function loadData(params, action, container, type_insert) 
{
	loadAsync(params, action, container, type_insert);
}


function loadAsync (params, action, container, type_insert)
	{
	
		$.ajax({
			  type: "GET",
			  url: "/springmvc/"+action,
			  data: params,
			  success: function(data){
				  if(container.length > 1)
				    $(container).html(data);
				  }
			});
	}

function loadAsyncPost (params, action, container, type_insert)
{

	$.ajax({
		  type: "POST",
		  url: "./"+action,
		  data: params,
		  mimeType:"text/html; charset=UTF-8",
		  success: function(data){
			  //alert('PDF created succesful');
			  }, error: function (xhr, ajaxOptions, thrownError) {
			        alert(xhr.status);
			        alert(ajaxOptions);
			      }
		});
}


function loadAsyncPDF (params, action, filename)
{

	$.ajax({
		  type: "GET",
		  url: "/springmvc/"+action,
		  success: function(data){
			  loadAsyncPost({pdf: data}, params);
		  }
		});
}


$(document).ready(function(){
	
	$('body').on('click', '#printHumans', function(){

		  
		loadAsyncPDF('printCustomerList', 'getHumans');
		
	});
	
	$('body').on('click', '#printExcel', function(){
		
		loadAsync('', 'printExcel');
		//alert('Excel file created succesfuly.');
		
	});
	
	$('body').on('click', '#printJasper', function(){
		
		loadAsync('', 'printJasper');
		
	})
	
	$('body').on('click','#getList', function()
	        {
		loadData('', 'list', '.body');
	        });
	
	$('body').on('click','.registration', function()
	    {
				$('.login-block').toggle();
				$('.reg-block').show();
	    });
	
	$('body').on('click','.pagination li a.human', function(){
		var page = $(this).html();
	    loadData({page: page}, 'list', '#customer-list');
	});
	
	$('body').on('click','.list-actions .edit', function(){
		var elem = $(this).prop("value");
		var modal = $(this).attr("data-target");
		loadData({userID: elem}, 'edit_customer', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','.add-human', function(){
		var modal = $(this).attr("data-target");
		loadData('', 'add_human', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','.add-company', function(){
		var modal = $(this).attr("data-target");
		loadData('', 'add_company', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','.list-actions .edit-company', function(){
		var elem = $(this).prop("value");
		var modal = $(this).attr("data-target");
		loadData({companyID: elem}, 'edit_company', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','.edit-user', function(){
		var elem = $(this).prop("value");
		var modal = $(this).attr("data-target");
		loadData({userID: elem}, 'edit_user', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','#search-list', function(){
		var post = $('#Industry').val();
		loadData({industry: post}, 'search_list', '#list_campaigns');
	});
	
	$('body').on('click','.add-user', function(){
		var modal = $(this).attr("data-target");
		loadData('', 'add_user', '#main-modal-insert');
		$(modal).modal('show');
	});
	
	$('body').on('click','.company-list', function(){
		var campaignID = $(this).attr('company-id');
		$('.company-list').removeClass('active');
		$(this).addClass('active');
		loadData({ID: campaignID}, 'search_humans_params', '#searched-data');
	});
	
	$('body').on('click', '.join-campaign', function(){
		var campaignID = $('.company-list.active').attr('company-id');
		var customerID = $(this).prop('value');
		$(this).addClass('disabled');
		loadData({campaignID: campaignID, customerID: customerID}, 'connect_human_company', '');
	});
});