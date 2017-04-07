(function(){
  angular.module('receitaApp').controller('IndexCtrl',['$scope','$state','$auth','$rootScope',function($scope, $state,$auth,$rootScope) {

    $scope.handleLoginBtnClick = function() {
      $auth.submitLogin($scope.loginForm)
      .then(function(resp) {
          console.log(resp);
      })
      .catch(function(resp) {
        console.log(resp);
      });
    };

    $rootScope.$on('auth:login-success', function(ev, user) {
      $state.go('home', {id: user.id});
    });

    $rootScope.$on('auth:login-error', function(ev, reason) {
      alert('auth failed because', reason.errors[0]);
    });

  }])
})();
