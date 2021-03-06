var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl",function ($scope,$http) {

    $scope.refreshCart= function () {

        $http.get("/rest/cart/"+$scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete("/rest/cart/"+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCart = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put("/rest/cart/add/"+productId).success(function () {
            alert("product successfully added");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put("/rest/cart/remove/"+productId).success(function (data) {
            $scope.refreshCart();
        });
    };
    $scope.calGrandTotal = function (data) {
        var grandTotal=0;
        for(var i=0;i<$scope.cart.cartItems.length;i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;

    }

});