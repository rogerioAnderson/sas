
_app.controller("LoginController",loginController);

function loginController($scope,$rootScope,$uibModal ,$location,AUTH_EVENTS,AuthService,CODIGO_RETORNO){
	
	$scope.executeLogin = executeLogin;
	
	function executeLogin (credentials) {
	    AuthService.login(credentials).then(loginSuccessCallback, loginFailCallback);
	  
		 function loginSuccessCallback (data) {
			var modalInstance;
			 if(data.codigoRetorno==CODIGO_RETORNO.OK){
				 $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
			      $scope.setCurrentUser(data.resultado);
			      $location.path("/home");
				}else{
					showErrorDialog($uibModal,data.mensagem);
				}
		 }
	 	 
		 function loginFailCallback(data){
			 showErrorDialog($uibModal,"Erro ao autenticar o usuário");
		 }
	 };
	
	if(!!$scope.currentUser){
		$location.path("/home");
	}
}