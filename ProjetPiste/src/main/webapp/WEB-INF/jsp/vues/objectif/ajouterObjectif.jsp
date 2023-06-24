<%--
  Created by IntelliJ IDEA.
  User: etulyon1
  Date: 13/04/2023
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Objectif</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="container">
    <div class="row mt-4">
        <div class="col">
            <h1>Ajouter un objectif :</h1>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <form method="post" action="<c:url value="/store_objectif.htm" />">
                <div class="col-sm-12 col-lg-7">
                    <div class="form-group">
                        <label class="control-label">Libellé *</label>
                        <input type="text" name="libobectif" id="libobectif" value="" class="form-control" placeholder="Exemple : Lune" required>
                    </div>
                </div>
                <nav class="d-flex justify-content-end" aria-label="...">
                    <a href="<c:url value="/index_objectif.htm" />" class="btn btn-secondary mr-2">Annuler</a>
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
