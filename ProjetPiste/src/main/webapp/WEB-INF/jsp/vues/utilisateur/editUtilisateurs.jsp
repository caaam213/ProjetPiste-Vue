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
<h1>Modifier un utilisateur</h1>
<form method="post" action="/utilisateur/edit">
    <div class="form-group">
        <label for="numUtil">Id</label>
        <input type="number" class="form-control" id="numUtil" name="numUtil" readonly="readonly" value="${utilisateur.numUtil}">
    </div>
    <div class="form-group">
        <label for="surname">Nom</label>
        <input type="text" class="form-control" id="surname" name="surname" value="${utilisateur.surname}">
    </div>
    <div class="form-group">
        <label for="forename">Prenom</label>
        <input type="text" class="form-control" id="forename" name="forename" value="${utilisateur.forename}">
    </div>
    <div class="form-group">
        <label for="role">Role</label>
        <input type="text" class="form-control" id="role" name="role" value="${utilisateur.role}">
    </div>
    <div class="form-group">
        <label for="nomUtil">Pseudo</label>
        <input type="text" class="form-control" id="nomUtil" name="nomUtil" value="${utilisateur.nomUtil}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email" value="${utilisateur.email}">
    </div>
    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>


</body>
</html>


