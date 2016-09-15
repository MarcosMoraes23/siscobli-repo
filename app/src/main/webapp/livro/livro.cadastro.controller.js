(function () {

    'use strict';
    
    function livroCadastroController ($scope, $location, livroService) {

        $scope.formLivro = {
            
        };
        
        $scope.month = ['Januar', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        $scope.monthShort = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        $scope.weekdaysFull = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        $scope.weekdaysLetter = ['S', 'M', 'T', 'W', 'T', 'F', 'S'];
        $scope.today = 'Today';
        $scope.clear = 'Clear';
        $scope.close = 'Close';
        var days = 15;
        
        $scope.cadastrarLivro = function(formLivro){
          
            var $promise = livroService.post(formLivro);
                
            $promise
                .success(function(){
                    var $toastContent = $('<span>Livro cadastrado com sucesso.</span>');
                        Materialize.toast($toastContent, 2000);
                    $location.path('livros');
                
                })
            
                .error(function(){
                    $scope.showLoading = false;
                    var $toastContent = $('<span>Erro ao cadastrar livro, verifique os dados.</span>');
                    Materialize.toast($toastContent, 3000);
                });    
        };
        
                
        $scope.limparCampos = function(){
            $scope.formLivro = {
            
            }
        };
        
    }
    
    
  var deps = [
    '$scope',
    '$location',
    'livroService',  
    livroCadastroController
  ];

  angular.module('siscobli')
  .controller('livroCadastroController',deps);

   
})();

