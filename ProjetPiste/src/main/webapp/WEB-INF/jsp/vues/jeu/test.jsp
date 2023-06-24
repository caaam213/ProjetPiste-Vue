<%--
  Created by IntelliJ IDEA.
  User: camel
  Date: 17/05/2023
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1> Affichage des Actions possibles pour un adhérent </H1>
<div class="container">
    <div class="col-md-8 col-sm-8">
        <div class="blanc">
            <br><br>
            <h1>Recherche par apprenant</h1>
            <form action="/jeu/listeJeuxPossiblesApprenant.htm" method="post">
                <input type="hidden" name="idApprenant" value="17" />
                <button type="submit">Envoyer l'ID</button>
            </form>
        </div>
    </div>
</div>
<div class="col-md-offset-2 col-md-7" id="resultat">

    <H1> Affichage des Actions possibles pour un adhérent </H1>
    <div class="container">
        <div class="col-md-8 col-sm-8">
            <div class="blanc">
                <br><br>
                <h1>Recherche par apprenant</h1>
                <form action="/jeu/listeJeuxRealise.htm" method="post">
                    <input type="hidden" name="idApprenant" value="17" />
                    <button type="submit">Envoyer l'ID</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-offset-2 col-md-7" id="resultat2">
</div>
</div>
</body>
</html>
