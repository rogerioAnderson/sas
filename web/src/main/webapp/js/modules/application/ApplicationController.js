/**
 * 
 */
_app.controller("ApplicationController",ApplicationController);

function ApplicationController($scope,USER_ROLES,AuthService,Session,AUTH_EVENTS,$uibModal){

	  $scope.currentUser = null;
	  $scope.userRoles = USER_ROLES;
	  $scope.isAuthorized = AuthService.isAuthorized;
	  $scope.setCurrentUser = setCurrentUser;
	  
	  $scope.$on(AUTH_EVENTS.notAuthorized,notAtuhorizedHandler);
	  
	  function setCurrentUser (user) {
		    $scope.currentUser = user;
	  };
	  
	  function notAtuhorizedHandler(){
		  showErrorDialog($uibModal, "Você não possui autorização para esta página");
	  }
	  
	  
	$scope.setCurrentUser(AuthService.session);
}