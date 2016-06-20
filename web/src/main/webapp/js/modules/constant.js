/**
 * 
 */
_app.constant("AUTH_EVENTS", {
	  loginSuccess: "auth-login-success",
	  loginFailed: "auth-login-failed",
	  logoutSuccess: "auth-logout-success",
	  sessionTimeout: "auth-session-timeout",
	  notAuthenticated: "auth-not-authenticated",
	  notAuthorized: "auth-not-authorized"
	}).constant("USER_ROLES", {
		  all: "*",
		  administrador: "administrador",
		  responsavel: "responsavel",
		  comum: "comum",
		  atendimento:"atendimento",
		  auditor: "auditor"
	}).constant("RETURN_CODE",{
		OK:"OK",
		ERRO:"ERROR"
	}).constant("CONFIG",{
		baseUrl:""
	}).constant("OPERATION",{
		insertion:"insertion",
		update:"update",
		search:"search",
		deletion:"deletion"
	});
