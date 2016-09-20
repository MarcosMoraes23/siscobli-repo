(function () {

    'use strict';
    
    function publicacaoController ($scope, $state) {
        
        
        
    $scope.changePublicacao = function(tipo){
        
        if(tipo === 'livros'){
            $state.go("home.publicacoes.livros");
            $scope.selectTab();
        }
        
        else if (tipo === 'dvds') {
            $state.go("home.publicacoes.dvds");
            $scope.selectTab();
        }            
        
        else {
            $state.go("home.publicacoes.periodicos");
            $scope.selectTab();
        }            
    }

        
    $scope.selectTab = function(){
        
        if($state.current.url === '/livros'){
            
            $("#dvdTab").removeClass("active");
            $("#periodicoTab").removeClass("active");
            $("#livroTab").addClass("active");
            
        } else if ($state.current.url === '/dvds') {
            
            $("#livroTab").removeClass("active");
            $("#periodicoTab").removeClass("active");
            $("#dvdTab").addClass("active");
            
        } else {
            
            $("#livroTab").removeClass("active");
            $("#dvdTab").removeClass("active");
            $("#periodicoTab").addClass("active");
            
        }
        
    };
        
    $scope.selectTab();

    }

    
    
  var deps = [
    '$scope',
    '$state',
    publicacaoController
  ];

  angular.module('siscobli')
  .controller('publicacaoController',deps);

   
})();
