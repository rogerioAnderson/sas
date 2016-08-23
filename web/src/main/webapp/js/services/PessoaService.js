/**
 * 
 */
_app.service("PessoaService",PessoaService);


function PessoaService($http,CONFIG){
	var self = this;
	
	self.save = function(pessoa){
		return $http.post(CONFIG.baseUrl+"rest/pessoa/save",pessoa).then(
				function (response){
					return response.data;
				}
			);
	}
	
	
	self.search = function (pessoa){
		return $http.post(CONFIG.baseUrl+"rest/pessoa/search/",pessoa).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.remove = function (pessoa){
		return $http.post(CONFIG.baseUrl+"rest/pessoa/remove/",pessoa).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.update = function (pessoa){
		return $http.post(CONFIG.baseUrl+"rest/pessoa/update/",pessoa).then(
				function (response){
					return response.data;
				}
			);
	}
	
	return {
		save : self.save,
		search: self.search,
		remove: self.remove,
		update: self.update,
		pessoa:{
			uf:{}
		}
	}
}