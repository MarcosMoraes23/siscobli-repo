(function () {

    'use strict';
    
    function usuarioCadastroController ($scope, $location, usuarioService) {

        $scope.formUsuario = {
            nomeCompleto: "",
            login: "",
            senha: "",
            confirmaSenha: "",
            tipoUsuario: ""
        };
        
        $scope.cadastrarUsuario = function(formUsuario){
          
            if($scope.validarSenhas() != true){
                
                var $toastContent = $('<span>Senhas não coincidem, favor verificar!</span>');
                Materialize.toast($toastContent, 3000);
                $('#senha').focus();

            } else{
                var $promise = usuarioService.post(formUsuario);

                $promise
                    .success(function(response){
                        var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
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
            if ($scope.formUsuario.senha != $scope.formUsuario.confirmaSenha){
                
                return false;
                
            } else{
                return true;
            }
            
        };
        
                
        $scope.limparCampos = function(){
            $scope.formUsuario = {
            
                nomeCompleto: "",
                login: "",
                senha: "",
                confirmaSenha: "",
                tipoUsuario: ""
            }
        };

   }
    
  var deps = [
    '$scope',
    '$location',
    'usuarioService',  
    usuarioCadastroController
  ];

  angular.module('siscobli')
  .controller('usuarioCadastroController',deps);

   
})();

