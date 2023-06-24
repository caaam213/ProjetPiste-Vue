<%--
  Created by IntelliJ IDEA.
  User: camel
  Date: 19/06/2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Action Apprenant</title>
  <%@include file="../header.jsp" %>
  <link href="/css/choixApprenants.css" rel="stylesheet">
</head>

<body>
<%@include file="../navigation.jsp" %>

<div class="container d-flex justify-content-center align-items-center">
  <div class="col-md-8 col-sm-8">
    <div class="blanc">
      <h1 class="text-center">Liste des apprenants</h1>
      <div class="mt-5"></div>
      <c:forEach items="${listeApprenants}" var="apprenant">

        <c:if test="${controllerType=='jeu'}">
          <div class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" onclick="location.href='/jeu/listeJeuxPossiblesApprenant.htm?idApprenant=${apprenant.numUtil}'">
            <span class="text-secondary">${apprenant.surname} ${apprenant.forename}</span>
          </div>
        </c:if>

        <c:if test="${controllerType=='voirJeu'}">
          <div class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" onclick="location.href='/jeu/listeJeuxRealise.htm?idApprenant=${apprenant.numUtil}'">
            <span class="text-secondary">${apprenant.surname} ${apprenant.forename}</span>
          </div>
        </c:if>



      </c:forEach>

    </div>
  </div>
</div>

</body>
</html>
