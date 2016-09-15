(function () {

    'use strict';
    
    function turmaCadastroController ($scope, $location, turmaService) {

        $scope.formTurma = {
            descricao: "",
            serie: "",
            grauEnsino: ""
        };
        
        $scope.cadastrarTurma = function(formTurma){
          
            console.log(formTurma);
            var $promise = turmaService.post(formTurma);
                
            $promise
                .success(function(){
                    var $toastContent = $('<span>Turma cadastrada com sucesso.</span>');
                        Materialize.toast($toastContent, 2000);
                    $location.path('turmas');
                
                })
            
                .error(function(){
                    $scope.showLoading = false;
                    var $toastContent = $('<span>Erro ao cadastrar turma, verifique os dados.</span>');
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
    '$location',
    'turmaService',  
    turmaCadastroController
  ];

  angular.module('siscobli')
  .controller('turmaCadastroController',deps);

   
})();

