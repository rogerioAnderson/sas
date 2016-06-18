/*
$(document).ready(function() {
	$("#inputCpf").mask("999.999.999-99");
	$("#inputDataNascimento").mask("99/99/9999");
});
*/
//verifica se existe valores presentes de um array dentro de outro
function checkValuesInArray(container, content){
	for(i=0; i<content.length; i++){
		if(container.indexOf(content[i])!=-1)
			return true;
	}
	return false;
}


function showConfirmDialog(uibModal, msg){
	return uibModal.open(
	   		  {
	   			  animation:true,
	   			  backdrop:'static',
	   			  keyboard:false,
	   			  templateUrl:"ui/ui-modal.html",
	   			  controller:"ModalController",
	   			  resolve:{
	   				  text : function (){
	   					  return msg;
	   				  },
	   				  title:function(){
	   					  return "Aviso";
	   				  },
	   				  isError: false,
	   				  isSuccess:false,
	   				  isConfirm:true
	   			  }
	   		  });
}

function showErrorDialog(uibModal,msg){
	 return uibModal.open(
   		  {
   			  animation:true,
   			  backdrop:'static',
   			  keyboard:false,
   			  templateUrl:"ui/ui-modal.html",
   			  controller:"ModalController",
   			  resolve:{
   				  text : function (){
   					  return msg;
   				  },
   				  title:function(){
   					  return "Atenção";
   				  },
   				  isError: true,
   				  isSuccess:false,
   				  isConfirm:false
   			  }
   		  }
     );
}

function showSuccessDialog(uibModal,msg){
	return uibModal.open(
	  		  {
	  			  animation:true,
	  			  backdrop:'static',
	  			  keyboard:false,
	  			  templateUrl:"ui/ui-modal.html",
	  			  controller:"ModalController",
	  			  resolve:{
	  				  text : function (){
	  					  return msg
	  				  },
	  				  title:function(){
	  					  return "Sucesso";
	  				  },
	  				  isError: false,
	  				  isSuccess:true,
	  				  isConfirm:false
	  			  }
	  		  }
	    )
}


function marcarPerfisSelecionados(aplicacoes,aplicacoesAtuais){
	//marca seleciona as aplicacoes atuais
	
	
	for(var indexAtual=0; indexAtual<aplicacoesAtuais.length;indexAtual++){
		var aplicacaoAtual = aplicacoesAtuais[indexAtual];
		
		for(var indexGeral=0; indexGeral<aplicacoes.length;indexGeral++){
			var aplicacao = aplicacoes[indexGeral];
			
			if(aplicacaoAtual.nomeAplicacao != aplicacao.nomeAplicacao){
				continue;
			}
			
			//percorrer os perfis
			for(var indexPerfilAtual=0;indexPerfilAtual<aplicacaoAtual.perfis.length;indexPerfilAtual++){
				
				var perfilAtual = aplicacaoAtual.perfis[indexPerfilAtual];
				
				for(var indexPerfil=0;indexPerfil<aplicacao.perfis.length;indexPerfil++){
				
					var perfil = aplicacao.perfis[indexPerfil];
					if(perfil.nome!=perfilAtual.nome){
						continue;
					}
					perfil.selecionado=true;
				}
			}
			
			
		}
	}
}
