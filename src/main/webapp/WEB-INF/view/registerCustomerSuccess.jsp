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
                    <h1>Customer registered successfully</h1>
                </div>
            </div>
        </section>
        <section class="container">
                <a href="<c:url value="/product/productList"/>" class="btn btn-default" >Continue Shoping</a>

            </div>
        </section>
    </div>
</div>
<script src="<c:url value="/resources/js/controller.js" />"></script>

<%@include file="template/footer.jsp"%>

