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
<h1>Affichage des actions</h1>
<div class="d-flex">
    <p>Ajouter une action</p>
    <a class="btn btn-primary" href="/action/addForm" role="button">Ajouter</a>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Libellé</th>
        <th scope="col">Score minimum</th>
        <th scope="col">Modifier</th>
        <th scope="col">Supprimer</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${actions}" var="action">
        <tr>
            <th>${action.id}</th>
            <td>${action.wording}</td>
            <td>${action.scoreMinimum}</td>
            <td><a class="btn btn-secondary" href="/action/editForm/${action.id}" role="button">Modifier</a></td>
            <td><a class="btn btn-danger" href="/action/delete/${action.id}" role="button">Supprimer</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>


</body>
</html>


