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
	}).constant("CODIGO_RETORNO",{
		OK:"0",
		ERRO:"-1"
	}).constant("CONFIG",{
		baseUrl:""
	});
