/**
 * 
 */              
_app.controller("ModalController",modalController);

function modalController($scope, $uibModalInstance, text, title, isError, isSuccess,isConfirm){
	
	
	if(!isConfirm){
		if(isError && isSuccess){
			isError=false;
		}
	}else{
		isSuccess=false;
		isError=false;
	}
	
	$scope.okButtonLabel=(isSuccess||isError)?"Fechar":"OK";
	$scope.cancelButtonLabel="Cancelar";
	$scope.error = isError;
	$scope.success = isSuccess;
	$scope.confirm= isConfirm;
	
	 if (!angular.isArray(text)) {
		 text = [text];
	 }
	$scope.text = text;
	$scope.title = title;
	
	
	$scope.ok = function () {
		    $uibModalInstance.close();
	};

	
	$scope.close = function () {
	    $uibModalInstance.dismiss("close");
	};
	
	
	$scope.cancel = function () {
		    $uibModalInstance.dismiss("cancel");
	};
}