//Invoke 'strict' JavaScript mode
'use strict';

//Module
angular.module('index', []);

//Controller
angular.module('index').controller('indexCtrl', ['$scope', '$route', '$routeParams', '$location', '$http', 'Index', 
                                                 function($scope, $route, $routeParams, $location, $http, Index) {
	$scope.setSize = function() {
		 $http.post('/api/stack/setSize.json',$scope.size_value, null).
	     success(function(response, status, headers, config) {
			 $scope.data = response["data"];
	         console.log(response);
	     }).
	     error(function(data, status, headers, config) {
	         console.log("error...");
	     });
	},
	
	$scope.push = function() {
		//var index = new Index({$scope.push_value});
		$http.post('/api/stack/push.json',$scope.push_value, null).
		 success(function(response, status, headers, config) {
			 $scope.data = response["data"];
		     console.log(data);
		 }).
		 error(function(data, status, headers, config) {
		     console.log("error...");
		 });
	},
	
	$scope.pop = function() {
		$http.get('/api/stack/pop.json',{}, null).
		 success(function(response, status, headers, config) {
			 $scope.data = response["data"];
		     console.log(data);
		 }).
		 error(function(data, status, headers, config) {
		     console.log("error...");
		 });
	},
	
	$scope.list = function() {
		$http.get('/api/stack/list.json',{}, null).
		 success(function(response, status, headers, config) {
			 $scope.data = response["data"];
		     console.log(data);
		 }).
		 error(function(data, status, headers, config) {
		     console.log("error...");
		 });
	}
}]);

//Service
angular.module('index').factory('Index', ['$resource', function($resource) {
	// Use the '$resource' service to return an product '$resource' object
    return $resource('/api/stack/:id', {
        id: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);


//Routes
angular.module('index').config(['$routeProvider', function($routeProvider) {
		$routeProvider.
		when('/stack-mvc', {
			templateUrl: '/static/views/stack-mvc.index.view.html',
			controller: 'indexCtrl'
		}).
		when('/stack-mvc/set-size', {
			templateUrl: '/static/views/stack-mvc.set-size.view.html',
			controller: 'indexCtrl'
		}).
		when('/stack-mvc/push', {
			templateUrl: '/static/views/stack-mvc.push.view.html',
			controller: 'indexCtrl'
		}).
		when('/stack-mvc/pop', {
			templateUrl: '/static/views/stack-mvc.pop.view.html',
			controller: 'indexCtrl'
		}).
		when('/stack-mvc/list', {
			templateUrl: '/static/views/stack-mvc.list.view.html',
			controller: 'indexCtrl'
		})
	}

]); 


// Set the main application name
var mainApplicationModuleName = 'myApp';

// Create the main application
var mainApplicationModule = angular.module(mainApplicationModuleName, ['ngResource', 'ngRoute', 'index']);

// Configure the hashbang URLs using the $locationProvider services 
mainApplicationModule.config(['$locationProvider',
	function($locationProvider) {
		$locationProvider.hashPrefix('!');
	}
]);

// Fix Facebook's OAuth bug
if (window.location.hash === '#_=_') window.location.hash = '#!';

// Manually bootstrap the AngularJS application
angular.element(document).ready(function() {
	angular.bootstrap(document, [mainApplicationModuleName]);
});