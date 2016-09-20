(function () {

    'use strict';
    
    function periodicoAlteracaoController ($scope, $stateParams, $state, periodicoService) {

        $scope.formPeriodico = {};
        
        
        $scope.findPeriodico = function(){
            
            var $promise = periodicoService.get.findPeriodico($stateParams.id);
        
            $promise
                .success(function(response){
                    $scope.formPeriodico = response.entity;
                    
                    console.log($scope.formPeriodico);
                
                    if(response.entity === null){
                        var $toastContent = $('<span>Periódico inexistente, favor verificar!</span>');
                        Materialize.toast($toastContent, 3000);    
                    }
                })
            
                .error(function(response){
                    var $toastContent = $('<span>Ocorreu um erro interno ao buscar periodico!</span>');
                    Materialize.toast($toastContent, 3000);
                });
        };
        
        
        $scope.alterarPeriodico = function(formPeriodico){
                
            var $promise = periodicoService.put($stateParams.id, formPeriodico);
                
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);

                    $state.go('home.publicacoes.periodicos');

                })

                .error(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);
                });  
        };
        
        
        $scope.limparCampos = function(){
            $scope.formPeriodico = {
                descricao: "",
                autor: "",
                numeroPaginas: "",
                categoria: "",
                disponibilidade: true,
                edicao: "",
                quantidadeReal: "",
                dataLancamento: "",
                nomeEditora: ""
            }
        };
        
        
        $scope.findPeriodico();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$state',
    'periodicoService',  
    periodicoAlteracaoController
  ];

  angular.module('siscobli')
  .controller('periodicoAlteracaoController',deps);

   
})();
