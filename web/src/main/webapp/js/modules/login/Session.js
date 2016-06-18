/**
 * 
 */
_app.service("Session", Session);

function Session(){
	this.create = create;
	this.destroy = destroy;
	
	function create(sessionId,userId,userRoles){
		this.id=sessionId;
		this.userId = userId;
		this.userRoles = userRoles;
	}
	
	function destroy () {
	    this.id = null;
	    this.userId = null;
	    this.userRoles = null;
	  };
}