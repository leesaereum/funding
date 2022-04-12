$(".my__tab__btn").click(function(){
	let id = $(this).attr("id");
	$(".my__tab__btn").removeClass("selected");
	$(this).addClass("selected");
	
	$(".tab__content").removeClass("selected");
	$("#"+id+"__content").addClass("selected");
})