<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: fateme
  Date: 3/5/20
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected product in your shoping cart</p>
                </div>
            </div>
        </section>
    </br>
        <section class="container" ng-app="cartApp">
            <div ng-controller ="cartCtrl" ng-init="initCart('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"/> Clear Cart</a>
            </div>


        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit Price</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems" style="text-align: center">
                <td>{{item.product.productName}}</td>
                <td>{{item.product.productPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                    <span class="glyphicon glyphicon-remove"/>remove</a></td>
            </tr>

            <tr>
                <th></th>
                <th></th>
                <th>Grand Total</th>
                <th>{{calGrandTotal()}}</th>
                <th></th>
            </tr>


            </table>
            <a href="<c:url value="/productList"/>" class="btn btn-default" >Continue Shoping</a>

            </div>
        </section>
    </div>
</div>
<script src="<c:url value="/resources/js/controller.js" />"></script>

    <%@include file="template/footer.jsp"%>

