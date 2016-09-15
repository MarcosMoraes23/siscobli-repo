function turmaService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/turmas';
    
    function cadastrarTurma(formTurma){     
        return $http.post(urlApi, formTurma);
     };
    
    function findAllTurmas(){
        return $http.get(urlApi);
    }
    
    function deletarTurma(turma){
        return $http.delete(urlApi + '/' + turma.id)
    }
    
    
    return{
        post: cadastrarTurma,
        get: findAllTurmas,
        delete: deletarTurma
        
    }
};


var deps = [
    '$http',
    'APP_CONFIG',
    turmaService  
];

angular.module('siscobli').service('turmaService',deps);