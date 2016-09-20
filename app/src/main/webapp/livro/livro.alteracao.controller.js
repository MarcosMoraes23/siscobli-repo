(function () {

    'use strict';
    
    function livroAlteracaoController ($scope, $stateParams, $state, livroService) {

        $scope.formLivro = {};

        $scope.findLivro = function(){
            
            var $promise = livroService.get.findLivro($stateParams.id);
        
            $promise
                .success(function(response){
                    $scope.formLivro = response.entity;
                    
                    console.log($scope.formLivro);
                
                    if(response.entity === null){
                        var $toastContent = $('<span>Livro inexistente, favor verificar!</span>');
                        Materialize.toast($toastContent, 3000);    
                    }
                })
            
                .error(function(response){
                    var $toastContent = $('<span>Ocorreu um erro interno ao buscar livro!</span>');
                    Materialize.toast($toastContent, 3000);
                });
        };
        
        
        $scope.alterarLivro = function(formLivro){
                
            var $promise = livroService.put($stateParams.id, formLivro);
                
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);

                    $state.go('home.publicacoes.livros');

                })

                .error(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);
                });  
        };
        
        
        $scope.limparCampos = function(){
            $scope.formLivro = {
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
        
        
        $scope.findLivro();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$state',
    'livroService',  
    livroAlteracaoController
  ];

  angular.module('siscobli')
  .controller('livroAlteracaoController',deps);

   
})();
