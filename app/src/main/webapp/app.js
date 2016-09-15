(function () {

    'use strict';

    var deps = [
        'ui.router',
        'ui.materialize',
        'angularUtils.directives.dirPagination'
    ];    

    angular.module('siscobli', deps)
        .config(function ($stateProvider, $locationProvider) {

            $stateProvider
              .state("login", {
                url: "/",
                views: {
                    "content":{
                        templateUrl: "login/login.html",
                        controller : "loginController"
                    }
                }
              })

            .state("menu-navegacao", {
                url: "/inicio",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },

                    "content":{
                        templateUrl: "inicio/inicio-content.html",
                        controller : "inicioController"
                    }
                }
              })

            .state("usuarios", {
                url: "/usuarios",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "usuario/lista.html",
                        controller : "usuarioInicioController"
                    }
                }
              })
            
            
            .state("usuarios_cadastro", {
                url: "/usuarios/cadastro",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "usuario/cadastro.html",
                        controller : "usuarioCadastroController"
                    }
                }
              })
            
            .state("usuarios_alteracao", {
                url: "/usuarios/alteracao/:id",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "usuario/alteracao.html",
                        controller : "usuarioAlteracaoController"
                    }
                }
              })
            
            
            .state("livros", {
                url: "/livros",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "livro/lista.html",
                        controller : "livroInicioController"
                    }
                }
              })
            
            
            .state("livros_cadastro", {
                url: "/livros/cadastro",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "livro/cadastro.html",
                        controller : "livroCadastroController"
                    }
                }
              })
            
            
            .state("livros_alteracao", {
                url: "/livros/alteracao/:id",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "livro/alteracao.html",
                        controller : "livroAlteracaoController"
                    }
                }
              })
            
            
            .state("turmas", {
                url: "/turmas",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "turma/lista.html",
                        controller : "turmaInicioController"
                    }
                }
              })
            
            
            .state("turma_cadastro", {
                url: "/turmas/cadastro",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "turma/cadastro.html",
                        controller : "turmaCadastroController"
                    }
                }
              })
            
        
            $locationProvider.html5Mode(false);
        
        })
    
        .constant("APP_CONFIG", {
		  "API_REST" : "http://localhost:8080/app"
	   });

})();
