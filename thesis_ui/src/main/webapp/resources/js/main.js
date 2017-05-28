$(document).ready(function() {

    $('body').on('click', function(e){
        var $target = $(e.target);
       
        if(!$target.closest('.modal-content').length && !$target.is('button') && $('div.modal').hasClass('is-active')){
        	 $('div.modal').removeClass('is-active');        	
        }
    });
    
    $('#main_button').on('click', function(){
    	$('#main_button').addClass('is-loading');
    	
    });
    
});