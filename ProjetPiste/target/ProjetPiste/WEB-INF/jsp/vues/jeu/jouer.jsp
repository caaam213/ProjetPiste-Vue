<%--
  Created by IntelliJ IDEA.
  User: camel
  Date: 21/05/2023
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Action Apprenant</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>

<div class="container">
    <div class="col-md-8 col-sm-8">
        <div class="blanc">
            <h2>Jeu lancé</h2>
            <form action="/jeu/validerJeu" method="post">
                <input type="hidden" name="idApprenant" value="${idApprenant}" />
                <input type="hidden" name="idJeu" value="${idJeu}" />
                <c:forEach items="${listeIndicateursActions}" var="actionIndicateurDTO">
                    <h2>${actionIndicateurDTO.action.wording}</h2>

                    <c:forEach items="${actionIndicateurDTO.indicators}" var="indicateur">
                        <label for="choix${indicateur.id}">${indicateur.wording}</label><br>
                        <input type="checkbox" id="choix${indicateur.id}" name="checkboxesChecked"
                               value="${indicateur.id}">
                    </c:forEach>
                </c:forEach>

                <button type="submit">Valider le questionnaire</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>
