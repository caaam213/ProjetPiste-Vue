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
    <title>Modifier Action</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="container">
    <div class="row mt-4">
        <div class="col">
            <h1>Modifier un apprenant :</h1>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <form method="post" action="<c:url value="/store_action.htm" />">
                <div class="col-sm-12 col-lg-7">
                    <div class="form-group">
                        <label class="control-label">Libellé *</label>
                        <input type="text" name="libaction" id="libaction" value="" class="form-control" placeholder="Exemple : Saut 10cm" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Pré-requis</label>
                        <select name="actNumaction" id="list_actions" class="form-control">
                            <option value="">-- Sélectionner le pré-requis --</option>
                            <c:forEach items="${actions}" var="item2">
                                <option value="${item2.numaction}">${item2.libaction}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Score minimum *</label>
                        <input type="number" name="scoremin" id="scoremin" class="form-control" min="0" value="0" required>
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
