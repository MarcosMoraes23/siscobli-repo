(function () {

    'use strict';
    
    function turmaInicioController ($scope, turmaService) {

        $scope.listTurmas = [];
        $scope.turmaSelected = {};
        
        $scope.selectTurma = function(turma){
            
            $scope.turmaSelected = turma;    
        }
        
        $scope.findAllTurmas = function(){
            
            var $promise = turmaService.get.findAllTurmas();
            
            $promise
                .success(function(response){
                    $scope.listTurmas = response.entity;
                    console.log($scope.listTurmas);
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
                var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);

                $scope.findAllTurmas();

            })

            .error(function(response){
                var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
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

