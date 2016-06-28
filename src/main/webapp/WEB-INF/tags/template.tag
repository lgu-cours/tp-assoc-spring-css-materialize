<%@tag description="template de chaque page" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@attribute name="title" required="false" type="java.lang.String" %>
<%@attribute name="content" required="true" fragment="true" %>

<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<title>
		<c:choose>
		    <c:when test="${empty title}">
		        TP Site Assoc
		    </c:when>
		    <c:otherwise>
		        ${title}
		    </c:otherwise>
		</c:choose>
	</title>

	<spring:url value="/static/css" var="css"/>
	<!-- Google Font -->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
	<link rel="stylesheet" href="${css}/style.css" />

</head>
<body>

	<spring:url value="/" var="home"/>
	<spring:url value="/articles" var="articles"/>
	<spring:url value="/commande" var="commande"/>
	<spring:url value="/logout" var="logout"/>

	<c:if test="${!empty sessionScope.adherent}">
		<table id="menu">
			<tr>
				<td class="clickable"><a href="${home}">Accueil</a></td>
				<td class="clickable"><a href="${articles}">Articles</a></td>
				<td class="clickable"><a href="${commande}">Commande</a></td>
				<td>Adhérent : <b>${sessionScope.adherent.ident}</b> <a href="${logout}" class="btn red">Deconnexion<i class="material-icons right">close</i></a></td>
			</tr>
		</table>
	</c:if>

	<div class="container">
		<c:if test="${!empty error}">
			<div class="chip col s12 z-depth-1 danger">${error}<i class="material-icons">close</i></div>
		</c:if>

		<!-- Main Content -->
		<jsp:invoke fragment="content"/>
	</div>

	<spring:url value="/static/js" var="js"/>
	<!-- Scripts -->
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
	<script src="${js}/app.js"></script>
</body>
</html>