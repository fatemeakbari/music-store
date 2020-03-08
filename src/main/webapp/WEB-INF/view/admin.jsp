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
            <h1>Administerator Page</h1>
            <p class="lead">This is a administerator page!</p>
        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory/" /> ">Product Inventory</a>
        </h3>
        <p>
            Hear you can view, check and modify product inventory!
        </p>


<%@include file="template/footer.jsp"%>