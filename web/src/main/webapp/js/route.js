/**
 * 
 */
_app.config(routeConfig).run(routeAuthorizer);

function routeConfig($routeProvider,$locationProvider,USER_ROLES){
	
	$locationProvider.html5Mode(false);
	
	$routeProvider
	
	.when("/home",{
		templateUrl:"view/home.html",
		data: {
			      authorizedRoles: [USER_ROLES.all]
			  }
	})
	.otherwise ({ redirectTo: '/' });
}

function routeAuthorizer($rootScope, AUTH_EVENTS, AuthService){
	$rootScope.$on('$routeChangeStart', function (event, next) {
	    if(!next.data){
	    	return;
	    }
		var authorizedRoles = next.data.authorizedRoles;
	    if (!AuthService.isAuthorized(authorizedRoles)) {
	      event.preventDefault();
	      if (AuthService.isAuthenticated()) {
	        
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
	      } else {
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
	      }
	    }
	  });
}