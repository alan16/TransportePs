<!DOCTYPE html>
<html ng-app="app">
 
<head>
  <script src="resources/app/js/libs/angular.min.js"></script>
  <script src="resources/app/js/libs/angular-route.min.js"></script>
  <script src="resources/app/js/services/service1.js"></script>
  <script src="resources/app/js/controllers/marcaController.js"></script>
  <script src="resources/app/js/controllers/modeloController.js"></script>
  <script src="resources/app/js/controllers/tipoController.js"></script>
  <script src="resources/app/js/controllers/movilController.js"></script>
  <script src="resources/app/js/app.js"></script>
  <title>Primera aplicacion con Agularjs</title>
</head>
 
<body ng-controller="listController">
  <header>
    <h1>Este es el titulo y no cambia</h1>
  </header>
  
  <ul>
    <li><a href="#marca/list">Ir a al listado de marcas</a>
    </li>
    <li><a href="#marca/edit">Ir editar las marcas</a>
    </li>
    <li><a href="#marca/nuevo">Ir a agregar marcas</a>
    </li>
  </ul>

  <ul>
    <li><a href="#modelo/list">Ir a modelo list</a>
    </li>
    <li><a href="#modelo/edit">Ir a edit modelo</a>
    </li>
    <li><a href="#modelo/nuevo">Ir a agregar modelo</a>
    </li>
  </ul>

  <ul>
    <li><a href="#tipo/list">Ir a tipo list</a>
    </li>
    <li><a href="#tipo/edit">Ir a editar</a>
    </li>
    <li><a href="#tipo/nuevo">Ir agregar nuevo</a>
    </li>
  </ul>
  <ul>
    <li><a href="#movil/list">lista de automoviles</a>
    </li>
    <li><a href="#movil/edit">editar un automovil</a>
    </li>
    <li><a href="#movil/nuevo">Agregar nuevo automovil</a>
    </li>
  </ul>

  <div ng-view></div>  

  <footer>
    <h3>Esto es un pie y no cambia</h3>
  </footer>
  
 
</body>
 
</html>