(function(){
  angular.module('receitaApp').controller('itemAddCtrl',['$stateParams','$scope','ItemService',function($stateParams,$scope,ItemService) {


	$scope.submitForm = function(){
		console.log($stateParams);
		ItemService.addItem($stateParams.userId,$scope.form);
	};

  }]);
})();
