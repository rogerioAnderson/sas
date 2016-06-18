/**
 * 
 */
_app.directive("noCache", noCache);

function noCache(){
	
	function link(scope, elements, attrs){
		attrs.$set('src',attrs.src+"?time="+new Date().getTime());
	}
	
	return{
		link:link
	}
}