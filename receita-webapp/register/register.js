(function(){
  angular.module('receitaApp').controller('RegisterCtrl', function($scope, $auth) {

    $scope.handleRegBtnClick = function() {
      $auth.submitRegistration($scope.registrationForm)
        .then(function(resp) {
          // handle success response
          console.log('funfou');
        })
        .catch(function(resp) {
          // handle error response
          console.log('nao funfou');
        });
    };
  });
})();