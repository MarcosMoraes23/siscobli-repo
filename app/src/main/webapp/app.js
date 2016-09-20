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
                    "starterContent":{
                        templateUrl: "login/login.html",
                        controller : "loginController"
                    }
                }
              })

            .state("home", {
                url: "/home",
                views: {
                    "starterContent":{
                        templateUrl: "home/home.html"
                    },
                    
                    "mainContent":{
                        templateUrl: "home/home-content.html"
                    }
                }
              })
            
            /*.state("home.content", {
                url: "/home",
                views: {
                    
                }
              })*/

            .state("home.usuarios", {
                url: "/usuarios",
                views: {
                    "mainContent":{
                        templateUrl: "usuario/lista.html",
                        controller : "usuarioInicioController"
                    }
                }
              })
            
            
            .state("home.usuarios.cadastro", {
                url: "/cadastro",
                views: {
                    "mainContent@home":{
                        templateUrl: "usuario/cadastro.html",
                        controller : "usuarioCadastroController"
                    }
                }
              })
            
            .state("home.usuarios.alteracao", {
                url: "/editar/:id",
                views: {
                    "mainContent@home":{
                        templateUrl: "usuario/alteracao.html",
                        controller : "usuarioAlteracaoController"
                    }
                }
              })
            
            
            .state("home.publicacoes", {
                url: "/publicacoes",
                views: {
                    "mainContent@home":{
                        templateUrl: "publicacao/publicacao.html",
                        controller : "publicacaoController"
                    }
                }
              })
            
            .state("home.publicacoes.livros", {
                url: "/livros",
                views: {
                    "publicacaoContent":{
                        templateUrl: "livro/lista.html",
                        controller : "livroInicioController"
                    }
                }
              })
            
            
            .state("home.publicacoes.livros.cadastro", {
                url: "/cadastro",
                views: {
                    "mainContent@home":{
                        templateUrl: "livro/cadastro.html",
                        controller : "livroCadastroController"
                    }
                }
            })
            
            
            .state("home.publicacoes.livros.alteracao", {
                url: "/editar/:id",
                views: {
                    "mainContent@home":{
                        templateUrl: "livro/alteracao.html",
                        controller : "livroAlteracaoController"
                    }
                }
            })
            
            
            .state("home.publicacoes.dvds", {
                url: "/dvds",
                views: {
                    "publicacaoContent":{
                        templateUrl: "dvd/lista.html",
                        controller : "dvdInicioController"
                    }
                }
            })
            
            .state("home.publicacoes.dvds.alteracao", {
                url: "/editar/:id",
                views: {
                    "mainContent@home":{
                        templateUrl: "dvd/alteracao.html",
                        controller : "dvdAlteracaoController"
                    }
                }
            })
            
            
            .state("home.publicacoes.dvds.cadastro", {
                url: "/cadastro",
                views: {
                    "mainContent@home":{
                        templateUrl: "dvd/cadastro.html",
                        controller : "dvdCadastroController"
                    }
                }
            })
            
            
            
            .state("home.publicacoes.periodicos", {
                url: "/periodicos",
                views: {
                    "publicacaoContent":{
                        templateUrl: "periodico/lista.html",
                        controller : "periodicoInicioController"
                    }
                }
            })
            
            
            .state("home.publicacoes.periodicos.alteracao", {
                url: "/editar/:id",
                views: {
                    "mainContent@home":{
                        templateUrl: "periodico/alteracao.html",
                        controller : "periodicoAlteracaoController"
                    }
                }
            })
            
            
            .state("home.publicacoes.periodicos.cadastro", {
                url: "/cadastro",
                views: {
                    "mainContent@home":{
                        templateUrl: "periodico/cadastro.html",
                        controller : "periodicoCadastroController"
                    }
                }
            })
            
            
            .state("home.turmas", {
                url: "/turmas",
                views: {
                    "mainContent":{
                        templateUrl: "turma/lista.html",
                        controller : "turmaInicioController"
                    }
                }
            })
            
            
            .state("home.turmas.cadastro", {
                url: "/cadastro",
                views: {
                    "mainContent@home":{
                        templateUrl: "turma/cadastro.html",
                        controller : "turmaCadastroController"
                    }
                }
            })
            
            
            .state("home.turmas.alteracao", {
                url: "/editar/:id",
                views: {
                    "mainContent@home":{
                        templateUrl: "turma/alteracao.html",
                        controller : "turmaAlteracaoController"
                    }
                }
              })
            
              
              .state("dvds", {
                url: "/dvds",
                views: {
                    "menu":{
                        templateUrl: "inicio/menu-navegacao.html",
                        controller : "inicioController"
                    },
                    "content":{
                        templateUrl: "dvd/lista.html",
                        controller : "dvdInicioController"
                    }
                }
              })
        
            $locationProvider.html5Mode(false);
        
        })
    
        .constant("APP_CONFIG", {
		  "API_REST" : "http://localhost:8080/app"
	   });

})();