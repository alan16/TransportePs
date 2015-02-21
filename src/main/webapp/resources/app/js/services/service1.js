function RemoteResources($http, baseUrl, $q) {

    this.insert = function(url, dato) {
        var defered = $q.defer();
        var promise = defered.promise;       

        $http({
            method: 'POST',
            url: url,
            data: dato
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(
            function(data, status, headers, config) {
                if (status === 400) {
                    defered.reject(data);
                } else {
                    throw new Error("Fallo obtener los datos:" + status + "\n" + data);
                }
            });

        return promise;
    };

    this.get = function(id, url) {
        var defered = $q.defer();
        var promise = defered.promise;


        $http({
            method: 'GET',
            url: url + id
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;

    };

    this.list = function(url) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: "GET",
            url: url,
            headers: {
                'Content-type': 'application/json'
            }
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(
            function(data, status, headers, config) {
                if (status === 400) {
                    defered.reject(data);
                } else {
                    throw new Error("Fallo obtener los datos:" + status + "\n" + data);
                }
            });
        return promise;
    };

    this.update = function(data, url) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: url,
            data: data
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(
            function(data, status, headers, config) {
                if (status === 400) {
                    defered.reject(data);
                } else {
                    throw new Error("Fallo obtener los datos:" + status + "\n" + data);
                }
            });

        return promise;
    };

    this.delet = function(id, url) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: url + id
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(
            function(data, status, headers, config) {
                if (status === 400) {
                    defered.reject(data);
                } else {
                    throw new Error("Fallo obtener los datos:" + status + "\n" + data);
                }
            });

        return promise;
    };
}

function RemoteResourcesProvider() {
    var _baseUrl;
    this.setBaseUrl = function(baseUrl) {
        baseUrl = baseUrl;
    }
    this.$get = ["$http", "$q", function($http, $q) {
        return new RemoteResources($http, _baseUrl, $q);
    }];
}

angular.module("Service1", []).constant("baseUrl", ".").provider(
    "remoteResources", RemoteResourcesProvider).config(
    ["baseUrl", "remoteResourcesProvider",
        function(baseUrl, remoteResourcesProvider) {
            remoteResourcesProvider.setBaseUrl(baseUrl);
        }
    ]);