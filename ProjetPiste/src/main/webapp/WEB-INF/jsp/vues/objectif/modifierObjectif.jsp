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
    <title>Modifier Objectif</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="container">
    <div class="row mt-4">
        <div class="col">
            <h1>Editer l'objectif : "${objectif.libobectif}"</h1>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <form method="POST" action="<c:url value="/update_objectif.htm" />">
                <div class="col-sm-12 col-lg-7">
                    <input type="hidden" name="id" value="${objectif.numobjectif}">
                    <div class="form-group">
                        <label class="control-label">Libellé *</label>
                        <input type="text" name="libobectif" id="libobectif" value="${objectif.libobectif}"
                               class="form-control"
                               placeholder="Exemple : Lune" required>
                    </div>

                    <c:if test="${fn:length(fixe) > 0}">
                        <table class="table table-hover">
                            <div class="form-group">
                                <label class="control-label">Liste des missions associées</label>
                                <c:forEach items="${fixe}" var="fixe">
                                    <tr>
                                        <td>${fixe.libmission}</td>
                                        <td>
                                            <a class="btn-sm btn-success"
                                               href="<c:url value="/objectifs_mission.htm/?id=${fixe.nummission}"/>"
                                               role="button">Modifier</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </div>
                        </table>
                    </c:if>

                </div>
                <nav class="d-flex justify-content-end" aria-label="...">
                    <a href="<c:url value="/index_objectif.htm" />" class="btn btn-secondary mr-2">Annuler</a>
                    <button type="submit" class="btn btn-info pull-right">
                        Modifier
                    </button>
                </nav>
            </form>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>
