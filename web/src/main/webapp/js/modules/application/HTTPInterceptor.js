_app.factory("HTTPInterceptor",["Session","$injector",HTTPInterceptor]);

function HTTPInterceptor(Session,$injector){
	var self = this;
	
	self.request = function(config){
		config.headers["Authorization"]=Session.id;
		//config.url = config.url+"?time="+new Date().getTime();
		return config;
	}
	
	self.response = function(response){
		try{
			if(response.data.returnCode=="ERROR"){
				showErrorDialog($injector.get("$uibModal"), response.data.text);
			}
		}catch(error){
			console.log(error);
		}
		
		return response;
	}
	
	self.requestError = function(rejectionReason){
		showErrorDialog($injector.get("$uibModal"), "Ocorreu um problema na sua solicitação.");
		console.log(rejectionReason.status +" : "+rejectionReason.statusText);
		return rejectionReason;
	}
	
	self.responseError = function(rejectionReason){
		showErrorDialog($injector.get("$uibModal"), "Ocorreu um problema na sua solicitação.");
		console.log(rejectionReason.status +" : "+rejectionReason.statusText);
		return rejectionReason;
	}
	
	return {
		request: 		self.request,
		response:		self.response,
		requestError: 	self.requestError,
		responseError: 	self.responseError
	}
}


_app.config(["$httpProvider",HTTPInterceptorConfig]);

function HTTPInterceptorConfig($httpProvider){
	$httpProvider.interceptors.push("HTTPInterceptor");
}