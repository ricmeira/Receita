(function(){
  angular.module('receitaApp').controller('homeCtrl',['$stateParams','$scope','$http','items','ItemService',function($stateParams,$scope,$http,items,ItemService) {
    $scope.items = items;
    $scope.userId = $stateParams.id;

   }])
})();	