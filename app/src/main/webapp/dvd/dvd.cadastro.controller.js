(function () {

    'use strict';
    
    function dvdCadastroController ($scope, $state, dvdService) {

        $scope.formDvd = {
            descricao: "",
            categoria: "",
            disponibilidade: true,
            quantidadeReal: "",
            quantidadeExemplares: "",
            dataLancamento: "",
            classificacaoEtaria: ""
        };
        
        $scope.cadastrarDvd = function(formDvd){
            
            console.log(formDvd);
            
            var $promise = dvdService.post(formDvd);
            
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);
                    $state.go('home.publicacoes.dvds');
                
                })
            
                .error(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                    Materialize.toast($toastContent, 3000);
                });    
        };
        
        $scope.limparCampos = function(){
            $scope.formDvd = {
                descricao: "",
                categoria: "",
                disponibilidade: true,
                quantidadeReal: "",
                quantidadeExemplares: "",
                dataLancamento: "",
                classificacaoEtaria: ""
            };
        };
        
    }
    
    
  var deps = [
    '$scope',
    '$state',
    'dvdService',  
    dvdCadastroController
  ];

  angular.module('siscobli')
  .controller('dvdCadastroController',deps);

   
})();

