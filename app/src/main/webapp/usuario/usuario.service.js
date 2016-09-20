function usuarioService($http, APP_CONFIG){
    
    var urlApi = APP_CONFIG.API_REST + '/usuarios';
    
    function cadastrarUsuario(formUsuario){
        return $http.post(urlApi, formUsuario);
     };
    
    function alterarUsuario(id , formUsuario){     
        return $http.put(urlApi + '/' + id, formUsuario);
     };
    
    function findAllUsuarios(){
        return $http.get(urlApi);
    }
    
    function findUsuario(id){
        return $http.get(urlApi + '/' + id);
    }
    
    function deletarUsuario(usuario){
        return $http.delete(urlApi + '/' + usuario.id)
    }
    
    function getLabelTipoUsuario(tipo){
    	switch (tipo) {
		case "A":
			return "Aluno(a)";
			break;
		case "B":
			return "Bibliotecário(a)";
			break;
		case "SE":
			return "Servidor(a)";
			break;
		case "SU":
			return "Supervisor(a)";
			break;
		case "P":
			return "Professor(a)";
			break;
		case "D":
			return "Diretor(a)";
			break;
		default:
			return "";
			break;
		}
    }
    
    return{
        post: cadastrarUsuario,
        put: alterarUsuario,
        get: {
            findAllUsuarios: findAllUsuarios,
            findUsuario: findUsuario
        },
        delete: deletarUsuario,
        labelTipoUsuario : getLabelTipoUsuario
    }
};


var deps = [
    '$http',
    'APP_CONFIG',
    usuarioService  
];

angular.module('siscobli').service('usuarioService',deps);