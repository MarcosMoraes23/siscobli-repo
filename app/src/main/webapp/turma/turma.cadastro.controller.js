(function () {

    'use strict';
    
    function turmaCadastroController ($scope, $state, turmaService) {

        $scope.formTurma = {
            descricao: "",
            serie: "",
            grauEnsino: ""
        };
        
        $scope.cadastrarTurma = function(formTurma){
          
            var $promise = turmaService.post(formTurma);
            
            $promise
                .success(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
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
        
    }
    
    
  var deps = [
    '$scope',
    '$state',
    'turmaService',  
    turmaCadastroController
  ];

  angular.module('siscobli')
  .controller('turmaCadastroController',deps);

   
})();

