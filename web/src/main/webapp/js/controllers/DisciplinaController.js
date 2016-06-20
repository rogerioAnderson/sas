/**
 * 
 */_app.controller("DisciplinaController",DisciplinaController)
 
 function DisciplinaController($scope,OPERATION,$uibModal,DisciplinaService,RETURN_CODE){
	 
	 
	 $scope.operation = OPERATION.insertion;
	 $scope.insert = insert;
	 $scope.edit = edit;
	 $scope.remove = remove;
	 $scope.update = update;
	 $scope.cancelUpdate = cancelUpdate;
	 
	 $scope.index;
	 
	 list();
	 function cancelUpdate(){
		 delete $scope.disciplina;
		 $scope.operation=OPERATION.insertion;
	 }
	 
	 function edit(disciplina,index){
		 index = $scope.index;
		 $scope.disciplina = disciplina;
		 $scope.operation = OPERATION.update;
	 }
	 
	 function update(){
		 DisciplinaService.update($scope.disciplina).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
					 list();
				 })
			 }
		 })
	 }
	 
	 function insert(){
		 DisciplinaService.save($scope.disciplina).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
					 list();
				 })
			 }
		 });
		
	 }
	 
	 function remove(disciplina,index){
		 modalInstance = showConfirmDialog($uibModal, "Deseja realmente realizar a exclusão desta disciplina?");
		 modalInstance.result.then(function(){
			 DisciplinaService.remove(disciplina).then(function(response){
				 if(response.returnCode==RETURN_CODE.OK){
					 showSuccessDialog($uibModal,response.text).result.then(function(){
						 list();
					 })
				 }
			 })
		 })
	 }
	 
	 
	 function list(){
		 DisciplinaService.search({}).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 $scope.disciplinas = response.result;
			 }
		 })
	 }
 }