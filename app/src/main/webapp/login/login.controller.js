(function () {

    'use strict';
    
    function loginController($scope, $location, $rootScope, loginService) {
    
        $scope.campoLoginValidado = false;
        $scope.campoSenhaValidado = false;
        $scope.pageTitle = "Login - SISCOBLI";
        $scope.showLoading = false;
           
        $scope.formLogin = {
            login: "",
            senha: ""
        };
        
    
        $scope.efetuarLogin = function (formLogin) {
            $scope.showLoading = true;
            var $promise = loginService.login(formLogin);

            $promise
                .success(function(response){
                    $scope.showLoading = false;
                    
                    console.log(response);
                    $rootScope.usuarioLogado = response.entity;
                
                    var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
                        Materialize.toast($toastContent, 1500);
                
                    $location.path("inicio");
                })
            
                .error(function(response){
                    $scope.showLoading = false;
                
                    var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
                    Materialize.toast($toastContent, 3000);
                });
            
            
        };

    }

    var deps = [
        '$scope',
        '$location',
        '$rootScope',
        'loginService',
        loginController
    ];

    angular.module('siscobli').controller('loginController', deps);
})();