(function () {

    'use strict';
    
    function dvdAlteracaoController ($scope, $stateParams, $state, dvdService) {

        $scope.formDvd = {};
        
        
        $scope.findDvd = function(){
            
            var $promise = dvdService.get.findDvd($stateParams.id);
        
            $promise
                .success(function(response){
                    $scope.formDvd = response.entity;
                    
                    console.log($scope.formDvd);
                
                    if(response.entity === null){
                        var $toastContent = $('<span>Dvd inexistente, favor verificar!</span>');
                        Materialize.toast($toastContent, 3000);    
                    }
                })
            
                .error(function(response){
                    var $toastContent = $('<span>Ocorreu um erro interno ao buscar dvd!</span>');
                    Materialize.toast($toastContent, 3000);
                });
        };
        
        
        $scope.alterarDvd = function(formDvd){
                
            var $promise = dvdService.put($stateParams.id, formDvd);
                
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);

                    $state.go('home.publicacoes.dvds');

                })

                .error(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);
                });  
        };
        
        
        $scope.limparCampos = function(){
            $scope.formDvd = {
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
        
        
        $scope.findDvd();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$state',
    'dvdService',  
    dvdAlteracaoController
  ];

  angular.module('siscobli')
  .controller('dvdAlteracaoController',deps);

   
})();
