/**
 * 
 */
_app.service("DisciplinaService",DisciplinaService);


function DisciplinaService($http,CONFIG){
	var self = this;
	
	self.save = function(disciplina){
		return $http.post(CONFIG.baseUrl+"rest/disciplina/save",disciplina).then(
				function (response){
					return response.data;
				}
			);
	}
	
	
	self.search = function (disciplina){
		return $http.post(CONFIG.baseUrl+"rest/disciplina/search/",disciplina).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.remove = function (disciplina){
		return $http.post(CONFIG.baseUrl+"rest/disciplina/remove/",disciplina).then(
				function (response){
					return response.data;
				}
			);
	}
	
	self.update = function (disciplina){
		return $http.post(CONFIG.baseUrl+"rest/disciplina/update/",disciplina).then(
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