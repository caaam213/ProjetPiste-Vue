<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 06/04/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%@include file="../header.jsp" %>

<body>
<%@include file="../navigation.jsp" %>
<h1>Affichage des utilisateurs</h1>
<div class="d-flex">
    <p>Ajouter un apprenant</p>
    <a class="btn btn-primary" href="/utilisateur/addForm" role="button">Ajouter</a>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${utilisateurs}" var="utilisateur">
        <tr>
            <th>${utilisateur.nomUtil}</th>
            <td>${utilisateur.surname}</td>
            <td>${utilisateur.forename}</td>
            <th>${utilisateur.role}</th>
            <td>${utilisateur.email}</td>
            <td><a class="btn btn-secondary" href="/utilisateur/editForm/${utilisateur.numUtil}" role="button">Modifier</a></td>
            <td><a class="btn btn-danger" href="/utilisateur/delete/${utilisateur.numUtil}" role="button">Supprimer</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>


</body>
</html>


