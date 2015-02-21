angular.module("marcaController", ["Service1"]).controller(
    "listController", ["$scope", "remoteResources","$location",
        function($scope,remoteResources, $location) {

            $scope.url = "getAllMarcas.html";
            $scope.url2 = "deleteMarca.html/";
            $scope.marcas = [];
            

            remoteResources.list($scope.url).then(function(marcas) {
                $scope.marcas = marcas;
            });

            $scope.del = function(id, url) {
                remoteResources.delet(id, url).then(function() {
                    $location.path("/marca/list")
                });
            }

        }
    ]).controller(
    "editController", ["$scope", "remoteResources", "marca", "$location",
        function($scope, remoteResources, marca, $location) {

            $scope.url = "updateMarca.html";
            $scope.marca = marca;
            $scope.modificar = function() {
                remoteResources.update($scope.marca, $scope.url);
                $location.path("/marca/list");
            }

        }
    ]).controller("nuevoController", ["$scope", "remoteResources","$location", function($scope, remoteResources,$location) {
    $scope.marca = {
        id: null,
        nombre: ""
    }
    $scope.url = "guardarMarca.html";
    $scope.guardar = function() {
        remoteResources.insert($scope.url, $scope.marca);
        $location.path("/marca/list");
    };
}]);