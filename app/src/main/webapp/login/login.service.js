function loginService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/efetuarLogin';
    
    
    function efetuarLogin(formLogin){
         
        return $http.post(urlApi, formLogin);

     };
    
    
    return{
        login: efetuarLogin

    }
};


var deps = [
    '$http',
    'APP_CONFIG',
    loginService  
];

angular.module('siscobli').service('loginService',deps);