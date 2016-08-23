/**
 * 
 */_app.controller("PessoaController",PessoaController)
 
 function PessoaController($scope,OPERATION,$uibModal,PessoaService,RETURN_CODE, UFService,$location){
	 
	 
	 $scope.operation = OPERATION.insertion;
	 $scope.insert = insert;
	 $scope.edit = edit;
	 $scope.remove = remove;
	 $scope.update = update;
	 $scope.cancelUpdate = cancelUpdate;
	 $scope.search = search;
	 $scope.pessoa = PessoaService.pessoa;
	 delete PessoaService.pessoa;
	 $scope.index;
	 
	 UFService.list().then(function(response){
		 $scope.ufs = response.result;
	 })
	 
	 function cancelUpdate(){
		 delete $scope.pessoa;
		 $scope.operation=OPERATION.insertion;
	 }
	 
	 function edit(pessoa,index){
		 PessoaService.pessoa = pessoa;
		 $location.path("/pessoa/editar")
	 }
	 
	 function update(){
		 PessoaService.update($scope.pessoa).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
				 })
			 }
		 })
	 }
	 
	 function insert(){
		 PessoaService.save($scope.pessoa).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				 modalInstance = showSuccessDialog($uibModal,response.text);
				 modalInstance.result.then(function(){
				 })
			 }
		 });
		
	 }
	 
	 
	 function search(){
		 PessoaService.search($scope.pessoa).then(function(response){
			 if(response.returnCode==RETURN_CODE.OK){
				$scope.result = response.result; 	
			 }
		 });
	 }
	 
	 function detail(pessoa){
		 
	 }
	 
	 function remove(pessoa,index){
		 modalInstance = showConfirmDialog($uibModal, "Deseja realmente realizar a exclusão desta pessoa?");
		 modalInstance.result.then(function(){
			 PessoaService.remove(pessoa).then(function(response){
				 if(response.returnCode==RETURN_CODE.OK){
					 showSuccessDialog($uibModal,response.text).result.then(function(){
					 })
				 }
			 })
		 })
	 }

 }