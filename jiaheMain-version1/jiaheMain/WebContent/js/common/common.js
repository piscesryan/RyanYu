$(function(){
	checkSize();
	$(window).resize(checkSize);
});
 
 
 function checkSize(){
	 var winHeight = $(window).height();
	 var mainHeight=winHeight-180-25;
	 $(".mainContent").height(mainHeight);
}