function periodicoService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/periodicos';
    
    function cadastrarPeriodico(formPeriodico){     
        return $http.post(urlApi, formPeriodico);
    };
    
    function alterarPeriodico(id , formPeriodico){     
        return $http.put(urlApi + '/' + id, formPeriodico);
    };
    
    function findAllPeriodicos(){
        return $http.get(urlApi);
    };
    
    function findPeriodico(id){
        return $http.get(urlApi + '/' + id);
    };
    
    function deletarPeriodico(periodico){
        return $http.delete(urlApi + '/' + periodico.id)
    };
    
    
    return{
        post: cadastrarPeriodico,
        put: alterarPeriodico,
        get: {
            findAllPeriodicos: findAllPeriodicos,
            findPeriodico: findPeriodico
        },
        delete: deletarPeriodico
        
    };
};


var deps = [
    '$http',
    'APP_CONFIG',
    periodicoService  
];

angular.module('siscobli').service('periodicoService',deps);