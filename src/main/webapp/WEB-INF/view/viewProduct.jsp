<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="#", alt="image" style="width: 100%;height: 300px">
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
                </div>

            </div>
        </div>


<%@include file="template/footer.jsp"%>