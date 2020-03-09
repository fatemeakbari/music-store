<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container-wrapper">
    <div class="login-container">
        <div class="login-box">

            <c:if test="${not empty msg}">
                <div class="msg">${msg} </div>
            </c:if>
            <form method="post"  name="loginForm" action="<c:url value="/j_spring_security_check"/>">

                <c:if test="${not empty error}" >
                    <div class="error" style="color: #c9302c">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User</label>
                    <input id="username" type="text" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>

                <input type="submit" value="submit" class="btn btn-default">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            </form>
        </div>
    </div>

</div>

<%@include file="template/footer.jsp"%>