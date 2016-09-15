(function () {

    'use strict';
    
    function turmaInicioController ($scope, turmaService) {

        $scope.listTurmas = [];

        
        $scope.findAllTurmas = function(){
            
            var $promise = turmaService.get();
            
            $promise
                .success(function(response){
                    $scope.listTurmas = response.entity;
                })
            
                .error(function(response){
                    console.log(response);
                    var $toastContent = $('<span>Ocorreu um erro ao buscar turmas.</span>');
                    Materialize.toast($toastContent, 3000);
                });
        }
        
        
        $scope.excluirTurma = function(turma){
            
            var $promise = turmaService.delete(turma);

            $promise
            .success(function(response){
                var $toastContent = $('<span>Turma excluído com sucesso.</span>');
                    Materialize.toast($toastContent, 3000);

                $scope.findAllTurmas();

            })

            .error(function(){
                var $toastContent = $('<span>Ocorreu um erro ao excluir o turma.</span>');
                Materialize.toast($toastContent, 3000);
            });
                        
        }
        
        $scope.findAllTurmas();
    
    }

    
    
  var deps = [
    '$scope',
    'turmaService',  
    turmaInicioController
  ];

  angular.module('siscobli')
  .controller('turmaInicioController',deps);

   
})();

