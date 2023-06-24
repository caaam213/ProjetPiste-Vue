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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-pzjw8VH0g7f8K3K4nYPbXd3y+GYs0p2j/WWxj0nHNq1z0s7jtYB4eOVNI6vP+Hzf"
        crossorigin="anonymous">
</head>
<%@include file="../header.jsp" %>
<body class="text-center"t>
<%@include file="../navigation.jsp" %>
<div class="d-flex justify-content-center align-items-center">
  <div class="col-md-8 offset-md-2">
    <div class="container">
      <h1 class="mt-4">Affichage des Jeux effectué  par : ${Utilisateur.surname} ${Utilisateur.forename}</h1>
      <div class="row mt-4">
        <div class="col-md-8">
          <c:forEach items="${listeJeux}" var="jeuUtilisateur">
            <div class="card mb-3">
              <div class="card-header">
                Jeu: ${jeuUtilisateur.libellejeu}
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-QIav+iwffNAMHg7Z8kl1BE6zRBl2AFL8qQx0g9yQWQicqd8ETDRiNUfJI4uyIydT"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-pzjw8VH0g7f8K3K4nYPbXd3y+GYs0p2j/WWxj0nHNq1z0s7jtYB4eOVNI6vP+Hzf"
        crossorigin="anonymous"></script>
</body>
</html>
