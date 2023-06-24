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
<form method="post" action="/action/add">
    <div class="form-group">
        <label for="libelle">Libellé</label>
        <input type="text" class="form-control" id="libelle" name="libelle">
    </div>
    <div class="form-group">
        <label for="scoreMin">Score minimum</label>
        <input type="number" class="form-control" id="scoreMin" name="scoreMin">
    </div>
    <button type="submit" class="btn btn-primary">Enregistrer</button>
</form>


</body>
</html>


