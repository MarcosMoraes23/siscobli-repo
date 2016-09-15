(function () {

    'use strict';
    
    function livroAlteracaoController ($scope, $stateParams, $location, livroService) {

        $scope.formLivro = {};

        $scope.month = ['Januar', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        $scope.monthShort = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        $scope.weekdaysFull = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        $scope.weekdaysLetter = ['S', 'M', 'T', 'W', 'T', 'F', 'S'];
        $scope.today = 'Today';
        $scope.clear = 'Clear';
        $scope.close = 'Close';
        var days = 15;
        
        
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
                
            if($scope.validarSenhas() != true){
                
                var $toastContent = $('<span>Senhas não coincidem, favor verificar!</span>');
                Materialize.toast($toastContent, 3000);
                $('#senha').focus();

            } else{
                
                $scope.formLivro.senha = $scope.senhaAlteracao;
                
                var $promise = livroService.put($stateParams.id, formLivro);
                
                $promise
                    .success(function(response){
                        var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                            Materialize.toast($toastContent, 2000);
                    
                        $location.path('livros');

                    })

                    .error(function(response){
                        var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                        Materialize.toast($toastContent, 3000);
                    });  
            }
        };
        
        
        $scope.limparCampos = function(){
            $scope.formLivro = {
                
            }
        };
        
        
        $scope.findLivro();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$location',
    'livroService',  
    livroAlteracaoController
  ];

  angular.module('siscobli')
  .controller('livroAlteracaoController',deps);

   
})();
