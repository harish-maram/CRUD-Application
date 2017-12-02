var app=angular.module('evvemi',['ngResource']);

app.controller('StudentController',['$scope','$resource', function($scope, $resource){
	
	function fetchAllStudents(){
		$scope.students=$resource('http://localhost:8080/student').query(function(data){return data;});	
	};
	fetchAllStudents();
	
	
	$scope.refresh = function() {
	fetchAllStudents();	
	};	
	
	$scope.create = function() {
	User=$resource("http://localhost:8080/create",
					{},
						{save: {method:'PUT', isArray:false}}
		
	);	
	
	var user ={};
	
	user.id=$scope.studentForm.id;
	user.name=$scope.studentForm.name;
	user.age=$scope.studentForm.age;
	user.courseid=$scope.studentForm.courseid;
	
	$scope.Message = User.save(user);
	
	$scope.studentForm.id="";
	$scope.studentForm.name="";
	$scope.studentForm.age="";
	$scope.studentForm.courseid="";
	};
	
	
	$scope.delete = function(){
		User=$resource("http://localhost:8080/delete/:id",
	{},{save:{method:'DELETE',params:{id: '@id'}}}
	);
	
	User.delete({id:$scope.studentForm.id}).then(function successCallback(response){
		$scope.Message=response;
	},function errorCallback(response){
	});
	
	scope.studentForm.id="";
	$scope.studentForm.name="";
	$scope.studentForm.age="";
	$scope.studentForm.courseid="";
	};
	
	
	$scope.update = function(){
		User=$resource("http://localhost:8080/update/:id",
	{},{save:{method:'PUT',params:{id: '@id'}}}
	);
	
	var user={};
	
	user.id=$scope.studentForm.id;
	user.name=$scope.studentForm.name;
	user.age=$scope.studentForm.age;
	user.courseid=$scope.studentForm.courseid;
	
	$scope.Message=User.save({id:$scope.studentForm.id},user);
	
	$scope.studentForm.id="";
	$scope.studentForm.name="";
	$scope.studentForm.age="";
	$scope.studentForm.courseid="";
	};
	
	}]); 