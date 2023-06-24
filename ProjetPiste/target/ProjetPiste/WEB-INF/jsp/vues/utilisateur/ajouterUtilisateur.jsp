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
<h1>Ajouter une action</h1>
<form method="post" action="/utilisateur/add">
    <div class="form-group">
        <label for="surname">Nom</label>
        <input type="text" class="form-control" id="surname" name="surname">
    </div>
    <div class="form-group">
        <label for="forename">Prenom</label>
        <input type="text" class="form-control" id="forename" name="forename">
    </div>
    <div class="form-group">
        <label for="nomUtil">Pseudo</label>
        <input type="text" class="form-control" id="nomUtil" name="nomUtil">
    </div>
    <div class="form-group">
        <label for="role">Role</label>
        <input type="text" class="form-control" id="role" name="role">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email">
    </div>
    <div class="form-group">
        <label for="motPasse">Mot de passe</label>
        <input type="password" class="form-control" id="motPasse" name="motPasse">
    </div>
    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>
</body>
</html>


