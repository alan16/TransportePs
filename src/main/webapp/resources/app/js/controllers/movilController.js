angular.module("movilController",["Service1"])
.controller("movillistController", ["$scope", "moviles","remoteResources","$location", function($scope, moviles,remoteResources, $location) {

    $scope.url = "getAllMovil.html";
    $scope.url2 = "deleteMovil.html/";
    $scope.moviles = moviles;    

    $scope.del = function(id, url) {
        remoteResources.delet(id, url).then(function() {
            $location.path("/movil/list")
        });
    }        
    
}])
.controller("movileditController", ["$scope", "remoteResources", "movil", "$location",
                                      function($scope, remoteResources, movil, $location) {

    $scope.url = "updateMovil.html";
    $scope.movil = movil;
    $scope.modificar = function() {
        remoteResources.update($scope.movil, $scope.url);
        $location.path("/movil/list");
    }

}])
.controller("movilnuevoController", ["$scope", "remoteResources", "$location",
                                     function($scope, remoteResources, $location) {
   
	$scope.urlModel="getAllModelos.html";
	$scope.urlMarca="getAllMarcas.html";
	$scope.urlTipo="getAllTipos.html";
	
	$scope.movil={
    tuc:"",
    chasis:"",
    motor:"",
    patente:"",
    marca:{
      id:"",
      nombre:""
    },
    modelo:{
      id:"",
      nombre:""
    },
    tipo:{
      id:"",
      nombre:""
    }

   };
   $scope.modelos=[];
   $scope.marcas=[];
   $scope.tipos=[];
   
   remoteResources.list($scope.urlModel).then(function(modelos) {
       $scope.modelos = modelos;
   });
   remoteResources.list($scope.urlMarca).then(function(marcas) {
       $scope.marcas = marcas;
   });
   remoteResources.list($scope.urlTipo).then(function(tipos) {
       $scope.tipos = tipos;
   });
   
   $scope.url = "guardarMovil.html";
   $scope.guardar = function() {
       remoteResources.insert($scope.url, $scope.movil);
       $location.path("/movil/list");
   };

}]);