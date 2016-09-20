(function () {

    'use strict';
    
    function periodicoCadastroController ($scope, $state, periodicoService) {

        $scope.formPeriodico = {
            descricao: "",
            categoria: "",
            dataLancamento: "",
            disponibilidade: true,
            quantidadeReal: "",
            quantidadeExemplares: "",
            edicao: ""
        };
        
        $scope.cadastrarPeriodico = function(formPeriodico){
            
            var $promise = periodicoService.post(formPeriodico);
            
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);
                    $state.go('home.publicacoes.periodicos');
                
                })
            
                .error(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                    Materialize.toast($toastContent, 3000);
                });    
        };
        
        $scope.limparCampos = function(){
            $scope.formPeriodico = {
                descricao: "",
                categoria: "",
                dataLancamento: "",
                disponibilidade: true,
                quantidadeReal: "",
                quantidadeExemplares: "",
                edicao: ""
            };
        };
        
    }
    
    
  var deps = [
    '$scope',
    '$state',
    'periodicoService',  
    periodicoCadastroController
  ];

  angular.module('siscobli')
  .controller('periodicoCadastroController',deps);

   
})();

