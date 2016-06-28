<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/login" var="login"/>
<spring:url value="/register" var="register"/>

<t:template title="Login">
	<jsp:attribute name="content">
        <h1>Login</h1>

		<form method="POST" action="${login}">
            Login : <input type="text" name="login"/><br>
            Password : <input type="password" name="password"/><br>
            <button class="btn blue">Se connecter</button>
        </form>

        <br>

        <p>Pas encore enregistré ? <a href="${register}">Créer votre compte ...</a></p>
	</jsp:attribute>
</t:template>