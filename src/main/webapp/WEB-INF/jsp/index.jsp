<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:template title="Page d'accueil">
	<jsp:attribute name="content">
		<h1>Bienvenue sur le site des adhérents de l'association</h1>

        <spring:url value="/articles" var="articles"/>
	    <spring:url value="/commande" var="commande"/>

        <ol>
            <li><a href="${articles}">Consulter les articles disponibles</a></li>
            <li><a href="${commande}">Consulter votre commande</a></li>
        </ol>
	</jsp:attribute>
</t:template>