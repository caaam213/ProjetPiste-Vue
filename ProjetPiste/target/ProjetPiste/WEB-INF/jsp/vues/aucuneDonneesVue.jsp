<%--
  Created by IntelliJ IDEA.
  User: camel
  Date: 23/06/2023
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Utilisateur</title>
</head>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>

<c:if test="${erreurType=='Apprenant'}">
    <p>Aucun apprenant n'est enregistré dans la base de données</p>
    <div class="d-flex">
        <p>Ajouter un apprenant</p>
        <a class="btn btn-primary" href="/apprenant/addForm" role="button">Ajouter</a>
    </div>
</c:if>

<c:if test="${erreurType=='Mission'}">
    <p>Aucune mission n'est enregistrée dans la base de données</p>
    <div class="d-flex">
            <p>Ajouter une mission</p>
            <a class="btn btn-primary" href="/mission/addForm" role="button">Ajouter</a>
    </div>
</c:if>

<c:if test="${erreurType=='Action'}">
    <p>Aucune action n'est enregistrée dans la base de données</p>
    <div class="d-flex">
        <p>Ajouter une action</p>
        <a class="btn btn-primary" href="/action/addForm" role="button">Ajouter</a>
    </div>
</c:if>

<form action="/">
    <button type="submit">Revenir à la page d'accueil</button>
</form>

</body>
</html>
