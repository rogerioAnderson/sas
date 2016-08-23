/**
 * 
 */
_app.service("CursoService",CursoService);


function CursoService($http,CONFIG){
	var self = this;
	
	self.save = function(curso){
		return $http.post(CONFIG.baseUrl+"rest/curso/save",curso).then(
				function (response){
					return response.data;
				}
			);
	}
	
	
	self.search = function (curso){
		return $http.post(CONFIG.baseUrl+"rest/curso/search/",curso).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.remove = function (curso){
		return $http.post(CONFIG.baseUrl+"rest/curso/remove/",curso).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.update = function (curso){
		return $http.post(CONFIG.baseUrl+"rest/curso/update/",curso).then(
				function (response){
					return response.data;
				}
			);
	}
	
	return {
		save : self.save,
		search: self.search,
		remove: self.remove,
		update: self.update
	}
}