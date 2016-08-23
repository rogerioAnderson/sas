/**
 * 
 */_app.controller("CursoController",CursoController)
 
 function CursoController($scope,OPERATION,$uibModal,CursoService,RETURN_CODE){
	 
	 
	 $scope.operation = OPERATION.insertion;
	 $scope.insert = insert;
	 $scope.edit = edit;
	 $scope.remove = remove;
	 $scope.update = update;
	 $scope.cancelUpdate = cancelUpdate;
	 
	 $scope.index;
	 
	 list();
	 function cancelUpdate(){
		 delete $scope.curso;
		 $scope.operation=OPERATION.insertion;
	 }
	 
	 function edit(curso,index){
		 index = $scope.index;
		 $scope.curso = curso;
		 $scope.operation = OPERATION.update;
	 }
	 
	 function update(){
		 CursoService.update($scope.curso).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
					 list();
				 })
			 }
		 })
	 }
	 
	 function insert(){
		 CursoService.save($scope.curso).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
					 list();
				 })
			 }
		 });
		
	 }
	 
	 function remove(curso,index){
		 modalInstance = showConfirmDialog($uibModal, "Deseja realmente realizar a exclusão desta curso?");
		 modalInstance.result.then(function(){
			 CursoService.remove(curso).then(function(response){
				 if(response.returnCode==RETURN_CODE.OK){
					 showSuccessDialog($uibModal,response.text).result.then(function(){
						 list();
					 })
				 }
			 })
		 })
	 }
	 
	 
	 function list(){
		 CursoService.search({}).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 $scope.cursos = response.result;
			 }
		 })
	 }
 }