_app.service("UFService",UFService);

function UFService($http,CONFIG){
	
	var self = this;

	self.list = function(){
			return $http.get(CONFIG.baseUrl+"rest/uf/list/").then(
					function (response){
						return response.data;
					})
	};
	
	return {
		list : self.list
	}
	
}