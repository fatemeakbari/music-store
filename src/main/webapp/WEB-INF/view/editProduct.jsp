<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h1>Edit Product</h1>
            <p class="lead">Please update product information!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/product/editProduct"
                   method="post" modelAttribute="product" enctype="multipart/form-data">
        <form:hidden path="productId" value="${product.productId}"/>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control" value="${product.productName}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control" value="${product.productPrice}"/>
        </div>


        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${product.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacture">Manufacture</label>
            <form:input path="productManufacturer" id="manufacture" class="form-Control" value="${product.productManufacturer}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Image File</label>
            <form:input path="productImage" id="productImage"  type="file" class="form:input-large"/>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control" value="${product.productDescription}"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument"/>
                Instrument </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record"/>
                Record </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory"/>
                Accessory </label>
        </div>

        <div class="form-group">
            <label for="condition">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new"/>
                New </label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used"/>
                Used </label>
        </div>

        <div class="form-group">
            <label for="status">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active"/>
                Active </label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="deactive"/>
                Deactive </label>
        </div>
        <input type="submit" value="submit" class="btn btn-default"/>
        <a href="<c:url value="/admin/product/editProduct/"/>" class="btn btn-default">Cancel</a>
        </form:form>


<%@include file="template/footer.jsp"%>