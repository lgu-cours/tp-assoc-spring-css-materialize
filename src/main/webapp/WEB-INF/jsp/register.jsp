<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/register" var="register"/>
<spring:url value="/" var="home"/>

<t:template title="Création de compte">
	<jsp:attribute name="content">

        <h1>Enregistrez vous</h1>

		<form method="POST" action="${register}">
            <span class="star_red">*</span> Identifiant : <input type="text" name="login"/>
            <br>
            <span class="star_red">*</span> Mot de passe : <input type="password" name="password"/>
            <br>
            <span class="star_red">*</span> Mot de passe (confirm) : <input type="password" name="password_confirm"/>
            <br>
            <span class="star_red">*</span> Nom : <input type="text" name="nom"/>
            <br>
            <span class="star_red">*</span> Prenom : <input type="text" name="prenom"/>
            <br>
            Adresse (rue) : <input type="text" name="adresse"/>
            <br>
            Code Postal : <input type="text" name="codePostal"/>
            <br>
            Ville : <input type="text" name="ville"/>
            <br>
            Pays :
            <select name="pays">
                <option value="" disabled selected>Selectionner un pays</option>
                <c:forEach items="${sessionScope.listePays}" var="pays">
                    <option value="${pays.code}">${pays.nom}</option>
                </c:forEach>
            </select>

            <br><br>

            <a href="${home}" class="btn blue">Retour</a>
            <button class="btn green">Enregister</button>
        </form>

        <br>

        <span class="star_red">*</span> Champ obligatoire

	</jsp:attribute>
</t:template>