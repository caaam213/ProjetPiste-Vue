<%--
  Created by IntelliJ IDEA.
  User: camel
  Date: 17/05/2023
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Action Apprenant</title>
</head>
<%@include file="../header.jsp" %>
<body class="text-center">
<%@include file="../navigation.jsp" %>

<H1> Affichage des Actions possibles pour ${utilisateur.surname} ${utilisateur.forename} </H1>
<div class="container text-center">
    <div class="col-auto row justify-content-center">
        <div class="blanc ">
            <br><br>
            <form action="/jeu/creerJeu" method="post">
                <input type="hidden" name="idApprenant" value="${idApprenant}" />
                <table class="table table-striped mx-auto">
                    <thead>
                    <tr>
                        <td scope="col">#</td>
                        <td scope="col">Intitulé</td>
                        <td scope="col">Score à avoir pour valider l'action</td>
                        <td scope="col">Dernier score</td>
                        <td scope="col">Jouer</td>
                    </tr>
                    </thead>
                    <c:forEach items="${listeActions}" var="item">
                        <c:if test="${item.etat}">
                            <tbody>
                                <tr>
                                    <th scope="row"></th>
                                    <td>${item.libelleAction}</td>
                                    <td>${item.scoreMinimum}</td>
                                    <c:if test="${item.score != -1}">
                                        <td>${item.score}</td>
                                    </c:if>
                                    <c:if test="${item.score == -1}">
                                        <td>Score non disponible</td>
                                    </c:if>
                                    <td><div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="${item.idAction}" name="actionsCheckbox" id="checkbox${item.idAction}">
                                        <label class="form-check-label" for="checkbox${item.idAction}">
                                            Je veux m'évaluer sur cette action
                                        </label>
                                    </div>
                                    </td>
                                </tr>
                            </tbody>
                        </c:if>

                        <c:if test="${!item.etat}">
                            <tbody>
                            <tr>
                                <th scope="row"></th>
                                <td>${item.libelleAction}</td>
                                <td>${item.scoreMinimum}</td>
                                <c:if test="${item.score != -1}">
                                    <td>${item.score}</td>
                                </c:if>
                                <c:if test="${item.score == -1}">
                                    <td>Score non disponible</td>
                                </c:if>
                                <td>Vous devez valider cette action : ${item.precedenteAction} afin de pouvoir vous évaluer
                                    sur cette action
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>

                <label for="nomPartie">Nom de la partie : </label>
                <input type="text" name="nomPartie" id="nomPartie" required>

                <button type="submit" disabled>
                    Jouer !
                </button>
            </form>
        </div>
    </div>
</div>
<div class="col-md-offset-2 col-md-7" id="resultat">
</div>
</body>
<script>
    // Vérifier si au moins une checkbox est cochée
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var submitButton = document.querySelector('button[type="submit"]');
    var inputText = document.querySelector('input[type="text"]');

    var checkbox = false;
    var text = false;

    function verifierCasesCochees() {
        var casesCochees = document.querySelectorAll('input[type="checkbox"]:checked');

        if (casesCochees.length > 0) {
            checkbox = true;
        } else {
            checkbox = false;
        }

        if (checkbox && text) {
            submitButton.disabled = false;
        } else {
            submitButton.disabled = true;
        }
    }

    // Ajouter un écouteur d'événement à chaque case à cocher
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].addEventListener('change', verifierCasesCochees);
    }

    function verifierChampVide() {
        if (inputText.value.trim() === '') {
            text = false;
        } else {
            text = true;
        }

        if (checkbox && text) {
            submitButton.disabled = false;
        } else {
            submitButton.disabled = true;
        }
    }

    // Ajouter un écouteur d'événement "input" au champ de saisie de texte
    inputText.addEventListener('input', verifierChampVide);


</script>
</html>
