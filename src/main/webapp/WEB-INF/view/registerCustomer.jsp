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
            <h1>Customer Regist</h1>
            <p class="lead">Please fill your info</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" modelAttribute="customer" >

        <div class="form-group">
            <label for="name">Name</label><form:errors path="customerName" cssClass="color:#ff0000"/>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label> <form:errors path="customerEmail" cssClass="color:#ff0000"/>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="phone">Phone</label><form:errors path="customerPhone" cssClass="color:#ff0000"/>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="password" class="form-Control"/>
        </div>

        <h1>Billing Address</h1>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="billingAddress.country" id="country" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="billingAddress.city" id="city" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="billingAddress.state" id="state" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="streetName">Street Name</label>
            <form:input path="billingAddress.streetName" id="streetName" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="apartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">ZipCode</label>
            <form:input path="billingAddress.zipCode" id="zipCode" class="form-Control"/>
        </div>


        <h1>Billing Address</h1>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="shippingAddress.country" id="country" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="shippingAddress.city" id="city" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="shippingAddress.state" id="state" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="streetName">Street Name</label>
            <form:input path="shippingAddress.streetName" id="streetName" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="apartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">ZipCode</label>
            <form:input path="shippingAddress.zipCode" id="zipCode" class="form-Control"/>
        </div>


        <input type="submit" value="submit" class="btn btn-default"/>
        <a href="<c:url value="/register"/>" class="btn btn-default">Cancel</a>

        </form:form>


<%@include file="template/footer.jsp"%>