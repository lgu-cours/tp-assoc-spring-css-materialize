<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<t:template title="Articles">
	<jsp:attribute name="content">

        <h1>catalogue des articles</h1>

        <c:choose>
		    <c:when test="${empty sessionScope.listeArticles}">
		        Aucun article
		    </c:when>
		    <c:otherwise>

                <spring:url value="/commande" var="commande"/>

                <table class="article">
                    <thead>
                    <tr>
                        <th>Code</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Stock</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.listeArticles}" var="article">
                        <tr>
                            <td>${article.code}</td>
                            <td>${article.nom}</td>
                            <td>${article.prix}</td>
                            <td>${article.stock}</td>
                            <td><a href="${commande}/${article.code}">Commander</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
		    </c:otherwise>
		</c:choose>
	</jsp:attribute>
</t:template>