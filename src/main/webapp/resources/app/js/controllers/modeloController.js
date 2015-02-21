angular.module("modeloController", ["Service1"])
    .controller("modlistController", ["$scope", "remoteResources", "modelos","$location", function($scope, remoteResources,modelos, $location) {

        //$scope.url = "getAllModelos.html";
        $scope.url2 = "deleteModelo.html/";
        $scope.modelos = modelos;

        /*remoteResources.list($scope.url).then(function(modelos) {
            $scope.modelos = modelos;
        });*/

        $scope.del = function(id, url) {
            remoteResources.delet(id, url).then(function() {
                $location.path("/modelo/list")
            });
        }

    }]).controller("modeditController", ["$scope", "remoteResources", "modelo", "$location",
        function($scope, remoteResources, modelo, $location) {

            $scope.url = "updateModelo.html";
            $scope.modelo = modelo;
            $scope.modificar = function() {
                remoteResources.update($scope.modelo, $scope.url);
                $location.path("/modelo/list");
            }
        }
    ]).controller("modnuevoController", ["$scope", "$location", "remoteResources", function($scope, $location, remoteResources) {

        $scope.modelo = {
            id: null,
            nombre: ""
        }
        $scope.url = "guardarModelo.html";
        $scope.guardar = function() {
            remoteResources.insert($scope.url, $scope.modelo);
            $location.path("/modelo/list");
        };
    }]);