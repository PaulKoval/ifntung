

function loadData(params, action, container, type_insert) 
{
	if(!type_insert) 
	{
        $(container).empty().prepend('<div id="loader" class="loader"></div>').show();
	}
	setTimeout(function(){
loadAsync(params, action, container, type_insert);} , 1000);
}


function loadAsync (params, action, container, type_insert)
	{
	
		$.ajax({
			  type: "GET",
			  url: "/springmvc/"+action,
			  data: params,
			  success: function(data){
				    $(container).html(data);
				  }
			});
	}



$(document).ready(function(){
	
	$('body').on('click','#getList', function()
	        {
		loadData('', 'list', '.body');
	        });
	
	$('body').on('click','.registration', function()
	    {
				$('.login-block').toggle();
				$('.reg-block').show();
	    });
	
});