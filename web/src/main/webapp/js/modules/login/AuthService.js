/**
 * 
 */
_app.factory("AuthService", AuthService);

function AuthService ($http, Session,USER_ROLES,RETURN_CODE,CONFIG){
	
	var authService = {}
	
	//TODO REMOVER quando fazer o deploy
	
	var token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE0NjYxNzAxNzIsInN1YiI6InVzdWFyaW8iLCJyb2xlcyI6WyJhZG1pbmlzdHJhZG9yIl0sImV4cCI6MTQ2NjI1NjU3Mn0.zDvF3rlyo9HQOj4zd-s6yNo0LgUCG5G8z3x-iI2Ke3g";
	var id="usuario";
	var roles=["administrador"];
	Session.create(token, id, roles);
	authService.session = Session;

	//fim
	
	authService.login = login;
	authService.isAuthenticated = isAuthenticated;
	authService.isAuthorized = isAuthorized;
	
	
	
	function login (credentials) {
	    return $http
	      .post(config.baseUrl+'rest/seguranca/login', credentials)
	      .then(callbackLogin);
	  };
	
	  
	 function callbackLogin (res) {
		 if(res.data.codigoRetorno==CODIGO_RETORNO.OK){
			 Session.create(res.data.resultado.token, res.data.resultado.userId,
                     res.data.resultado.roles);
			 authService.session = Session;
		 }
		 return res.data;
	       
	 }
	 function isAuthenticated () {
		    return !!Session.userId;
		  }; 
	  
		  
     function isAuthorized (authorizedRoles) {
			    if (!angular.isArray(authorizedRoles)) {
			      authorizedRoles = [authorizedRoles];
			    }
			    if(!authService.isAuthenticated()){
			    	return false;
			    }
			    if(authorizedRoles.indexOf(USER_ROLES.all)!=-1){
			    	return true;
			    }
			    
			    return checkValuesInArray(authorizedRoles,Session.userRoles)
			    
			  };	  
		 return authService;
}