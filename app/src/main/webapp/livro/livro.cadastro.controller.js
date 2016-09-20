(function () {

    'use strict';
    
    function livroCadastroController ($scope, $state, livroService) {

        $scope.formLivro = {
            descricao: "",
            autor: "",
            isbn: "",
            numeroPaginas: "",
            categoria: "",
            disponibilidade: true,
            edicao: "",
            quantidadeReal: "",
            quantidadeExemplares: "",
            dataLancamento: "",
            nomeEditora: ""
        };
        
        $scope.cadastrarLivro = function(formLivro){
            
            var $promise = livroService.post(formLivro);
            
            $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 2000);
                    $state.go('home.publicacoes.livros');
                
                })
            
                .error(function(response){
                    $scope.showLoading = false;
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                    Materialize.toast($toastContent, 3000);
                });    
        };
        
        $scope.limparCampos = function(){
            $scope.formLivro = {
                descricao: "",
                autor: "",
                isbn: "",
                numeroPaginas: "",
                categoria: "",
                disponibilidade: true,
                edicao: "",
                quantidadeReal: "",
                quantidadeExemplares: "",
                dataLancamento: "",
                nomeEditora: ""
            };
        };
        
    }
    
    
  var deps = [
    '$scope',
    '$state',
    'livroService',  
    livroCadastroController
  ];

  angular.module('siscobli')
  .controller('livroCadastroController',deps);

   
})();

