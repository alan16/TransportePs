angular.module("movilController",["Service1"])
.controller("movillistController", ["$scope","remoteResources",function($scope,remoteResources) {   
   $scope.moviles = [{
    tuc:"1",
    chasis:"1",
    motor:"1",
    patente:"1",
    marca:{
      id:"1",
      nombre:"hola"
    },
    modelo:{
      id:"1",
      nombre:"hola"
    },
    tipo:{
      id:"1",
      nombre:"chau"
    }

   },
   {
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

   }];
    
    // $scope.guardar=function(){
    // 	remoteResources.insert($scope.correo);  	
    
}])
.controller("movileditController", ["$scope","remoteResources",function($scope,remoteResources) {
   
   $scope.movil={
    tuc:1,
    chasis:2,
    motor:3,
    patente:4,
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

	// remoteResources.get(function(seguro){
 //    	$scope.datos=seguro;
 //    },function(data,status){
 //    	alert("Ha fallado la peticion. Estado HTTP:" + status);
 //    });

}])
.controller("movilnuevoController", ["$scope",function($scope) {
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
   $scope.modelos=[{
      id: 1,
      nombre: "xx5"
      },      
      {id:2,
      nombre:"208"
      }];
   $scope.marcas=[{
      id: 1,
      nombre: "Fiat"
      },      
      {id:2,
      nombre:"Renault"
      }];
   $scope.tipos=[{
      id: 1,
      nombre: "auto"
      },      
      {id:2,
      nombre:"moto"
      }];

}]);