(function () {

    'use strict';
    
    function loginController($scope, $state, $rootScope, loginService) {
    
        $scope.showLoading = false;
           
        $scope.formLogin = {
            login: "",
            senha: ""
        };
        
    
        $scope.efetuarLogin = function (formLogin) {
            $scope.showLoading = true;
            var $promise = loginService.login(formLogin);
            console.log(formLogin);
            $promise
                .success(function(response){
                    $scope.showLoading = false;
                    
                    console.log(response);
                    $rootScope.usuarioLogado = response.entity;
                
                    var $toastContent = $('<span>'+ response.mensagemRetorno +'</span>');
                        Materialize.toast($toastContent, 1500);
                
                    $state.go("home");
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
        '$state',
        '$rootScope',
        'loginService',
        loginController
    ];

    angular.module('siscobli').controller('loginController', deps);
})();