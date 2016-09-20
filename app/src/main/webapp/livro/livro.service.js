function livroService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/livros';
    
    function cadastrarLivro(formLivro){
        console.log(formLivro);
        return $http.post(urlApi, formLivro);
    };
    
    function alterarLivro(id , formLivro){     
        return $http.put(urlApi + '/' + id, formLivro);
    };
    
    function findAllLivros(){
        return $http.get(urlApi);
    };
    
    function findLivro(id){
        return $http.get(urlApi + '/' + id);
    };
    
    function deletarLivro(livro){
        return $http.delete(urlApi + '/' + livro.id)
    };
    
    
    return{
        post: cadastrarLivro,
        put: alterarLivro,
        get: {
            findAllLivros: findAllLivros,
            findLivro: findLivro
        },
        delete: deletarLivro
        
    };
};


var deps = [
    '$http',
    'APP_CONFIG',
    livroService  
];

angular.module('siscobli').service('livroService',deps);