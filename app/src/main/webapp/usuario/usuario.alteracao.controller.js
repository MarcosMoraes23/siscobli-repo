(function () {

    'use strict';
    
    function usuarioAlteracaoController ($scope, $stateParams, $location, usuarioService) {

        $scope.formUsuario = {};
        $scope.senhaAlteracao = "";
        $scope.findUsuario = function(){
            
            var $promise = usuarioService.get.findUsuario($stateParams.id);
            
            $promise
                .success(function(response){
                    $scope.formUsuario = response.entity;
                    
                    if(response.entity === null){
                        var $toastContent = $('<span>Usuário inexistente, favor verificar!</span>');
                        Materialize.toast($toastContent, 3000);    
                    }
                })
            
                .error(function(response){
                    var $toastContent = $('<span>Ocorreu um erro interno ao buscar usuário!</span>');
                    Materialize.toast($toastContent, 3000);
                });
        };
        
        
        $scope.alterarUsuario = function(formUsuario){
                
            if($scope.validarSenhas() != true){
                
                var $toastContent = $('<span>Senhas não coincidem, favor verificar!</span>');
                Materialize.toast($toastContent, 3000);
                $('#senha').focus();

            } else{
                
                $scope.formUsuario.senha = $scope.senhaAlteracao;
                
                var $promise = usuarioService.put($stateParams.id, formUsuario);
                
                $promise
                    .success(function(response){
                        var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                            Materialize.toast($toastContent, 2000);
                    
                        $location.path('usuarios');

                    })

                    .error(function(response){
                        var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                        Materialize.toast($toastContent, 3000);
                    });  
            }
        };
        
        
        $scope.validarSenhas = function(){
            if ($scope.senhaAlteracao != $scope.confirmaSenha){
                
                return false;
                
            } else{
                return true;
            }
            
        };
        
        $scope.limparCampos = function(){
            $scope.formUsuario = {
                nomeCompleto: "",
                login: "",
                senhaAlteracao: "",
                confirmaSenha: "",
                tipoUsuario: ""
            }
        };
        
        
        $scope.findUsuario();
    
    }

    
    
  var deps = [
    '$scope',
    '$stateParams',
    '$location',
    'usuarioService',  
    usuarioAlteracaoController
  ];

  angular.module('siscobli')
  .controller('usuarioAlteracaoController',deps);

   
})();
