angular.module("tipoController",["Service1"])
.controller("tipolistController", ["$scope", "tipos","remoteResources","$location", function($scope, tipos,remoteResources, $location) {

    $scope.url = "getAllTipos.html";
    $scope.url2 = "deleteTipo.html/";
    $scope.tipos = tipos;

    /*remoteResources.list($scope.url).then(function(tipos) {
        $scope.tipos = tipos;
    });*/

    $scope.del = function(id, url) {
        remoteResources.delet(id, url).then(function() {
            $location.path("/tipo/list")
        });
    }        
    
}]).controller("tipoeditController", ["$scope", "remoteResources", "tipo", "$location",
                                      function($scope, remoteResources, tipo, $location) {

    $scope.url = "updateTipo.html";
    $scope.tipo = tipo;
    $scope.modificar = function() {
        remoteResources.update($scope.tipo, $scope.url);
        $location.path("/tipo/list");
    }

}]).controller("tiponuevoController", ["$scope", "$location", "remoteResources", function($scope, $location, remoteResources) {

    $scope.tipo = {
        id: null,
        nombre: ""
    }
    $scope.url = "guardarTipo.html";
    $scope.guardar = function() {
        remoteResources.insert($scope.url, $scope.tipo);
        $location.path("/tipo/list");
    };
}]);