<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<t:template title="Commandes">
	<jsp:attribute name="content">

        <h1>Votre commande</h1>

        <c:choose>
		    <c:when test="${empty articles}">
		        Aucun article commandés
		    </c:when>
		    <c:otherwise>
                <table class="article">
                    <thead>
                    <tr>
                        <th>Code</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Stock</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <td>${article.code}</td>
                            <td>${article.nom}</td>
                            <td>${article.prix}</td>
                            <td>${article.stock}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <br>

                <spring:url value="/delete_commande" var="delete"/>
                <form action="${delete}" method="POST">
                    <button class="btn red">Annuler la commande</button>
                </form>
		    </c:otherwise>
		</c:choose>

	</jsp:attribute>
</t:template>