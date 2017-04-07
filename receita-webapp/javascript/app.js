(function(){
  var receitaApp = angular.module('receitaApp', ['ui.router','ng-token-auth']);

  receitaApp.constant('REST_END_POINT', 'https://radiant-garden-20769.herokuapp.com');
  receitaApp.config(function($stateProvider,$authProvider) {
    var loginState = {
      name: 'login',
      url: '',
      templateUrl: '/login/login.view.html',
      controller: "IndexCtrl"
    }

    var registerState = {
      name: 'register',
      url: '/register',
      templateUrl: '/register/register.view.html',
      controller: "RegisterCtrl"
    }

    var homeState = {
      name: 'home',
      url: '{id}/items/',
      templateUrl: '/item/home.view.html',
      controller: "homeCtrl",
      resolve:{
        items: function(ItemService,$stateParams){
          return ItemService.getAllItems($stateParams.id);
        } 
      } 
    }

    var itemDetailsState = {
      name: 'itemDetail',
      url: '/items/{itemId}',
      templateUrl: '/item/item.view.html',
      controller: "itemCtrl",
      resolve:{
        item: function(ItemService,$stateParams){
          return ItemService.getItem($stateParams.itemId);
        }
      }
    }

    var itemAddState = {
      name: 'itemAdd',
      url: '{userId}/item/add',
      templateUrl: '/item/item_create_update.view.html',
      controller: "itemAddCtrl"
    }

    $stateProvider.state(loginState);
    $stateProvider.state(registerState);
    $stateProvider.state(homeState);
    $stateProvider.state(itemDetailsState);
    $stateProvider.state(itemAddState);

    $authProvider.configure({
      apiUrl: REST_END_POINT
    });

  });

})();