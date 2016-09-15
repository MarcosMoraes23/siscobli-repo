(function () {

    'use strict';
    
    function livroInicioController ($scope, livroService) {

        $scope.listLivros = [];
        $scope.disponibilidade;
        
        $scope.findAllLivros = function(){
            
            var $promise = livroService.get.findAllLivros();
            
            $promise
                .success(function(response){
                    console.log(response);
                    $scope.listLivros = response.entity;
                })
            
                .error(function(response){
                    console.log(response);
                    var $toastContent = $('<span>Ocorreu um erro ao buscar livros.</span>');
                    Materialize.toast($toastContent, 3000);
                });
        }
        
        
        $scope.excluirLivro = function(livro){
            
            var $promise = livroService.delete(livro);

            $promise
            .success(function(response){
                var $toastContent = $('<span>Livro excluído com sucesso.</span>');
                    Materialize.toast($toastContent, 3000);

                $scope.findAllLivros();

            })

            .error(function(){
                var $toastContent = $('<span>Ocorreu um erro ao excluir o livro.</span>');
                Materialize.toast($toastContent, 3000);
            });
                        
        }
        
        $scope.findAllLivros();
    
    }

    
    
  var deps = [
    '$scope',
    'livroService',  
    livroInicioController
  ];

  angular.module('siscobli')
  .controller('livroInicioController',deps);

   
})();

