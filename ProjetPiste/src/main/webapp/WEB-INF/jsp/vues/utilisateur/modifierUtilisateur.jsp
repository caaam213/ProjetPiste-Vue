<%--
  Created by IntelliJ IDEA.
  User: etulyon1
  Date: 13/04/2023
  Time: 08:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Utilisateur</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="container">
    <div class="row mt-4">
        <div class="col">
            <h1>Modifier un utilisateur :</h1>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <form method="post" action="<c:url value="/store_action.htm" />">
                <div class="col-sm-12 col-lg-7">
                    <div class="form-group">
                        <label class="control-label">Nom</label>
                        <input type="text" name="surname" id="surname" value="" class="form-control" placeholder="Exemple : Dupont" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom</label>
                        <input type="text" name="forename" id="forename" value="" class="form-control" placeholder="Exemple : Jean" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Pseudo</label>
                        <input type="text" name="nomUtil" id="nomUtil" value="" class="form-control" placeholder="Exemple : BeauGosseDu69" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Email</label>
                        <input type="text" name="email" id="email" value="" class="form-control" placeholder="Exemple : bgdu69@hotmail.fr" required>
                    </div>
                </div>
                <nav class="d-flex justify-content-end" aria-label="...">
                    <a href="<c:url value="/index_action.htm" />" class="btn btn-secondary mr-2">Annuler</a>
                    <button type="submit" class="btn btn-primary pull-right">
                        Ajouter
                    </button>
                </nav>
            </form>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>
