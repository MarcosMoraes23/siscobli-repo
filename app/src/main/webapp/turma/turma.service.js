function turmaService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/turmas';
    
    function cadastrarTurma(formTurma){  
        console.log(formTurma);
        return $http.post(urlApi, formTurma);
     };
    
    
    function alterarTurma(id , formTurma){     
        console.log(formTurma);
        return $http.put(urlApi + '/' + id, formTurma);
     };
    
    function findTurma(id){
        return $http.get(urlApi + '/' + id);
    }
    
    function findAllTurmas(){
        return $http.get(urlApi);
    };
    
    function deletarTurma(turma){
        return $http.delete(urlApi + '/' + turma.id)
    };
    
    
    return{
        post: cadastrarTurma,
        put: alterarTurma,
        get: {
            findAllTurmas,
            findTurma
        },
        delete: deletarTurma
        
    }
};


var deps = [
    '$http',
    'APP_CONFIG',
    turmaService  
];

angular.module('siscobli').service('turmaService',deps);