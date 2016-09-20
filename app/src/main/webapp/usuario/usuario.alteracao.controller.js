(function () {

    'use strict';
    
    function usuarioAlteracaoController ($scope, $stateParams, $state, usuarioService) {

        $scope.formUsuario = {};
        $scope.senhaAlteracao = "";
        $scope.showLoading = false;
        
        
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
            $scope.showLoading = true;
            $('html, body').animate({scrollTop: 0}, 250, 'linear');
            if($scope.validarSenhas() != true){
                $scope.showLoading = false;
                var $toastContent = $('<span>Senhas não coincidem, favor verificar!</span>');
                Materialize.toast($toastContent, 3000);
                $('#senha').focus();

            } else{
                
                $scope.formUsuario.senha = $scope.senhaAlteracao;
                
                var $promise = usuarioService.put($stateParams.id, formUsuario);
                
                $promise
                    .success(function(response){
                        $scope.showLoading = false;
                        var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                            Materialize.toast($toastContent, 2000);
                    
                        $state.go('home.usuarios');

                    })

                    .error(function(response){
                        $scope.showLoading = false;
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
    '$state',
    'usuarioService',  
    usuarioAlteracaoController
  ];

  angular.module('siscobli')
  .controller('usuarioAlteracaoController',deps);

   
})();
