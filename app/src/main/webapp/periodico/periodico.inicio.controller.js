(function () {

    'use strict';
    
    function periodicoInicioController ($scope, periodicoService) {

        $scope.listPeriodicos = [];
        $scope.periodicoSelected = {};
        
        $scope.selectPeriodico = function(periodico){
            
            $scope.periodicoSelected = periodico;
            
        }
        
        
        $scope.findAllPeriodicos = function(){
            
            var $promise = periodicoService.get.findAllPeriodicos();
            
            $promise
                .success(function(response){
                    console.log(response);
                    $scope.listPeriodicos = response.entity;
                })
            
                .error(function(response){
                    console.log(response);
                    var $toastContent = $('<span>Ocorreu um erro ao buscar periodicos.</span>');
                    Materialize.toast($toastContent, 3000);
                });
        }
        
        
        $scope.excluirPeriodico = function(periodico){
            
            var $promise = periodicoService.delete(periodico);

            $promise
            .success(function(response){
                var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                    Materialize.toast($toastContent, 3000);

                $scope.findAllPeriodicos();

            })

            .error(function(response){
                var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                Materialize.toast($toastContent, 3000);
            });
                        
        }
        
        $scope.findAllPeriodicos();
    
    }

    
    
  var deps = [
    '$scope',
    'periodicoService',  
    periodicoInicioController
  ];

  angular.module('siscobli')
  .controller('periodicoInicioController',deps);

   
})();

