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
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Checkout all awesome products available now!</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td><img src="#" alt="image" ></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td>
                        <a href="<spring:url value="/productList/viewProduct/${product.productId}" />">
                        <span class="glyphicon glyphicon-info-sign"/></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-remove"/></a>
                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-pencil"/></a>

                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct" />" class="btn btn-primary"> Add Product</a>
<%@include file="template/footer.jsp"%>