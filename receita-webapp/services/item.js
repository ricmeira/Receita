angular.module('receitaApp').service('ItemService', function($http) {
	var service = {
	    getAllItems: function(id) {
	    	return $http.get('http://localhost:3000/users/'+id+'/items').then(function(resp) {
	    		return resp.data;
	      });
	    },
	    
	    getItem: function(id) {
	    	return $http.get('http://localhost:3000/users/1/items/'+ id).then(function(resp) {
	    		return resp.data;
	      });
	    },

	    deleteItem: function(id){
	    	$http.delete('http://localhost:3000/users/1/items/'+ id)
	    	.then(function successCallback(response) {
	    		console.log("deleted");
			}, 
			function errorCallback(response) {
			    console.log("error");
			});
	    },

	    addItem: function(userId,item){
	    	$http.post('http://localhost:3000/users/'+userId+'/items',item)
	    }
	}
  
	return service;
})