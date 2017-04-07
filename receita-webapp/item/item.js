(function(){
  angular.module('receitaApp').controller('itemCtrl',['$scope','item','ItemService',function($scope,item,ItemService) {
    $scope.item = item;
    
    $scope.delete = function(){
    	ItemService.deleteItem($scope.item.id);
    };

  }]);
})();


