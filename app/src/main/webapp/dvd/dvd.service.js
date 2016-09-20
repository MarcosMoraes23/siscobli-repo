function dvdService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/dvds';
    
    function cadastrarDvd(formDvd){     
        return $http.post(urlApi, formDvd);
    };
    
    function alterarDvd(id , formDvd){     
        return $http.put(urlApi + '/' + id, formDvd);
    };
    
    function findAllDvds(){
        return $http.get(urlApi);
    };
    
    function findDvd(id){
        return $http.get(urlApi + '/' + id);
    };
    
    function deletarDvd(dvd){
        return $http.delete(urlApi + '/' + dvd.id)
    };
    
    
    return{
        post: cadastrarDvd,
        put: alterarDvd,
        get: {
            findAllDvds: findAllDvds,
            findDvd: findDvd
        },
        delete: deletarDvd
        
    };
};


var deps = [
    '$http',
    'APP_CONFIG',
    dvdService  
];

angular.module('siscobli').service('dvdService',deps);