(function () {

    'use strict';
    
    function dvdInicioController ($scope, dvdService) {

        $scope.listDvds = [];
        $scope.dvdSelected = {};
        
        
        $scope.selectDvd = function(dvd){
            
            $scope.dvdSelected = dvd;
            
        }
        
        
        $scope.findAllDvds = function(){
            
            var $promise = dvdService.get.findAllDvds();
            
            $promise
                .success(function(response){
                    console.log(response);
                    $scope.listDvds = response.entity;
                })
            
                .error(function(response){
                    console.log(response);
                    var $toastContent = $('<span>Ocorreu um erro ao buscar dvds.</span>');
                    Materialize.toast($toastContent, 3000);
                });
        }
        
        
        $scope.excluirDvd = function(dvd){
            
            var $promise = dvdService.delete(dvd);

            $promise
            .success(function(response){
                var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                    Materialize.toast($toastContent, 3000);

                $scope.findAllDvds();

            })

            .error(function(response){
                var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                Materialize.toast($toastContent, 3000);
            });
                        
        }
        
        $scope.findAllDvds();
    
    }

    
    
  var deps = [
    '$scope',
    'dvdService',  
    dvdInicioController
  ];

  angular.module('siscobli')
  .controller('dvdInicioController',deps);

   
})();

