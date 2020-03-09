<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: fateme
  Date: 3/5/20
  Time: 12:00 AM
  To change this template use File | Settings | File Templates. --%>

<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Deatil</h1>
            <p class="lead">Hear is details about of product!</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width: 100%"/>
                </div>

                <div class="col-md-5">
                    <h3>"${product.productName}"</h3>
                    <p>
                        <strong>Description</strong> : "${product.productDescription}"
                    </p>
                    <p>
                        <strong>Manufacturer</strong> :${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> :${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> :${product.productCondition}
                    </p>
                    <p>
                        <strong>Price</strong> :${product.productPrice}
                    </p>

                </br>
                    <c:set scope="page" var="role" value="${param.role}"/>
                    <c:set scope="page" var="url" value="/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning"
                           ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"/>Order Now </a>
                        <a href="<spring:url value="/cart"/>" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"/> View Cart</a>
                    </p>
                </div>

            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="template/footer.jsp"%>