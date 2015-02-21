angular.module("app", ['ngRoute','marcaController','modeloController','tipoController','movilController']).config(['$routeProvider',function($routeProvider) {
   
  /*bloque de Marcas */

  $routeProvider.when('/marca/list', {
    templateUrl: "resources/views/marca/mlist.html",
    controller: "listController"   
  });
   
  $routeProvider.when('/marca/edit/:id', {
    templateUrl: "resources/views/marca/medit.html",
    controller: "editController",
    resolve: {
    	marca: ['remoteResources', '$route', function(remoteResources, $route) {
            return remoteResources.get($route.current.params.id,"getMarca.html/");
        }]
    }	
  });
   
  $routeProvider.when('/marca/nuevo', {
    templateUrl: "resources/views/marca/mnuevo.html",
    controller: "nuevoController"
  });

   /*bloque de Modelos*/

  $routeProvider.when('/modelo/list', {
    templateUrl: "resources/views/modelo/modlist.html",
    controller: "modlistController",
    resolve: {
    	modelos:['remoteResources', function(remoteResources) {
    		return remoteResources.list("getAllModelos.html");
        }]    
    }
  });
   
  $routeProvider.when('/modelo/edit/:id', {
    templateUrl: "resources/views/modelo/modedit.html",
    controller: "modeditController",
    resolve: {
    	modelo: ['remoteResources', '$route', function(remoteResources, $route) {
            return remoteResources.get($route.current.params.id,"getModelo.html/");
        }]
    }
    	
  });
   
  $routeProvider.when('/modelo/nuevo', {
    templateUrl: "resources/views/modelo/modnuevo.html",
    controller: "modnuevoController"
  });

  /*bloque de tipos*/

  $routeProvider.when('/tipo/list', {
    templateUrl: "resources/views/tipo/tiplist.html",
    controller: "tipolistController",
    resolve: {
    	tipos:['remoteResources', function(remoteResources) {
    		return remoteResources.list("getAllTipos.html");
        }]    
    }
    
  });
   
  $routeProvider.when('/tipo/edit/:id', {
    templateUrl: "resources/views/tipo/tipedit.html",
    controller: "tipoeditController",
    resolve: {
    	tipo: ['remoteResources', '$route', function(remoteResources, $route) {
            return remoteResources.get($route.current.params.id,"getTipo.html/");
        }]
    }
  });
   
  $routeProvider.when('/tipo/nuevo', {
    templateUrl: "resources/views/tipo/tipnuevo.html",
    controller: "tiponuevoController"
  });

  /*Bloque de moviles  */
  
  $routeProvider.when('/movil/list', {
    templateUrl: "resources/views/movil/movlist.html",
    controller: "movillistController"
  });
   
  $routeProvider.when('/movil/edit', {
    templateUrl: "resources/views/movil/movedit.html",
    controller: "movileditController"
  });
   
  $routeProvider.when('/movil/nuevo', {
    templateUrl: "resources/views/movil/movnuevo.html",
    controller: "movilnuevoController"
  });

  $routeProvider.otherwise({
        redirectTo: '/marca/list'
  });   
 
}]);