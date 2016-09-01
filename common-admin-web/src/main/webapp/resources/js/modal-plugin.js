(function($){
	
	var str1 = "<div id='myModal' class='modal hide fade' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>";
	var str2 = "<div class='modal-header'>";
	var str3 = "<h3 id='myModalLabel'>系统信息</h3>";
	var str4 = "<a class='close' data-dismiss='modal' aria-hidden='true' href='javascript:void();'>×</a></div>";
	var str5 = "<div class='modal-body'></div>";
	var str6 = "<div class='modal-footer'>";
	var str7 = "<button class='btn btn-danger radius' data-dismiss='modal' aria-hidden='true'>关闭</button>"; 
	var str8 = "</div></div>";	
	
	var content = str1 + str2 + str3 + str4 + str5 +str6 +str7 +str8;
	console.log(content);
	
	$.fn.showCustomModal = function(opts){
		var settings = $.extend({
			dialogId : "myModal"
		}, opts || {});
		$("#myDialog").html(content);
		$("#myModal").modal("show");
	}
})(jQuery);