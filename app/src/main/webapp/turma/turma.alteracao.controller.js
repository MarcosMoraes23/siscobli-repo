(function () {

    'use strict';
    
    function turmaAlteracaoController ($scope, $stateParams, $state, turmaService) {

        $scope.formTurma = {};
        
        
        $scope.findTurma = function(){
            
            var $promise = turmaService.get.findTurma($stateParams.id);
            
            $promise
                .success(function(response){
                    $scope.formTurma = response.entity;
                    
                    if(response.entity === null){
                        var $toastContent = $('<span>Turma inexistente, favor verificar!</span>');
                        Materialize.toast($toastContent, 3000);    
                    }
                })
            
                .error(function(response){
                    var $toastContent = $('<span>Ocorreu um erro interno ao buscar turma!</span>');
                    Materialize.toast($toastContent, 3000);
                });
        };
        
        
        $scope.alterarTurma = function(formTurma){
                
            var $promise = turmaService.put($stateParams.id, formTurma);

            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);

                    $state.go('home.turmas');

                })

                .error(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);
                });  
        };
        
        
        
        $scope.limparCampos = function(){
            $scope.formTurma = {
                descricao: "",
                serie: "",
                grauEnsino: ""
            }
        };
        
        
        $scope.findTurma();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$state',
    'turmaService',  
    turmaAlteracaoController
  ];

  angular.module('siscobli')
  .controller('turmaAlteracaoController',deps);

   
})();
