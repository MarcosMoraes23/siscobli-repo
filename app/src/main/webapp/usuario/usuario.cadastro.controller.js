(function () {

    'use strict';
    
    function usuarioCadastroController ($scope, $state, usuarioService) {

        $scope.formUsuario = {
            nomeCompleto: "",
            login: "",
            senha: "",
            confirmaSenha: "",
            tipoUsuario: " "
        };
        $scope.showLoading = false;
        
        $scope.cadastrarUsuario = function(formUsuario){
            $('html, body').animate({scrollTop: 0}, 250, 'linear');
            $scope.showLoading = true;
          
            if($scope.validarSenhas() != true){
                $scope.showLoading = false;
                var $toastContent = $('<span>Senhas não coincidem, favor verificar!</span>');
                Materialize.toast($toastContent, 3000);
                $('#senha').focus();

            } else{
                var $promise = usuarioService.post(formUsuario);

                $promise
                    .success(function(response){
                        
                        $scope.showLoading = false;
                        var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
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
    '$state',
    'usuarioService',  
    usuarioCadastroController
  ];

  angular.module('siscobli')
  .controller('usuarioCadastroController',deps);

   
})();

