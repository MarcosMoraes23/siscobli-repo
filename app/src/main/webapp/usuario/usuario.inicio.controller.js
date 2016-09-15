(function () {

    'use strict';
    
    function usuarioInicioController ($scope, $rootScope, usuarioService) {

        $scope.listUsuarios = [];
        $scope.usuarioSelected = {};
        
        $scope.findAllUsuarios = function(){
            
            var $promise = usuarioService.get.findAllUsuarios();
            
            $promise
                .success(function(response){
                    $scope.listUsuarios = response.entity;
                })
            
                .error(function(response){
                    console.log(response);
                    var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
                    Materialize.toast($toastContent, 3000);
                });
        }
        
        $scope.selectUsuario = function(usuario){
            
            $scope.usuarioSelected = usuario;
            
        }
        
        
        $scope.labelTipo = function(tipo)
        {
        	return usuarioService.labelTipoUsuario(tipo);
        }
        
        $scope.excluirUsuario = function(usuario){
            
            console.log(usuario)
            if(usuario.id != $rootScope.usuarioLogado.id){
                var $promise = usuarioService.delete(usuario);
                
                $promise
                .success(function(response){
                    var $toastContent = $('<span>' + response.mensagemRetorno + '</span>');
                        Materialize.toast($toastContent, 3000);
                
                    $scope.findAllUsuarios();
                    
                })
            
                .error(function(response){
                    var $toastContent = $('<span>'+response.mensagemRetorno+'</span>');
                    Materialize.toast($toastContent, 3000);
                });
                
            }else{
                var $toastContent = $('<span>Não é permitida a exclusão do usuário logado no momento.</span>');
                    Materialize.toast($toastContent, 3000);
            }
                        
        }
        
        $scope.findAllUsuarios();
    
    }

    
    
  var deps = [
    '$scope',
    '$rootScope',
    'usuarioService',  
    usuarioInicioController
  ];

  angular.module('siscobli')
  .controller('usuarioInicioController',deps);

   
})();

