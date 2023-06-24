<%--
  Created by IntelliJ IDEA.
  User: etulyon1
  Date: 13/04/2023
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="navigation.jsp"%>
<H1> Affichage des réservations d'un adhérent </H1>
<div class="container">
    <div class="col-md-8 col-sm-8">
        <div class="blanc">
            <br><br>
            <h1>Recherche par adherent </h1>
            </select>
            <input type="button" value="Ajax test" class="btn btn-primary" onclick="ajaxTest();" />
        </div>
    </div>
</div>
<div class="col-md-offset-2 col-md-7" id="resultat">
</div>
</body>
</html>
