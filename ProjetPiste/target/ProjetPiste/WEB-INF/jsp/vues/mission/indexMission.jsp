<%--
  Created by IntelliJ IDEA.
  User: melin
  Date: 21/06/2023
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des missions existantes</title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="container text-center">
    <H1>Liste des missions existantes</H1>
<div class="col-auto row justify-content-center">
    <div class="blanc ">
        <br><br>
        <table>
            <c:forEach var="mission" items="${missions}">
                <tr>
                    <td>${mission.id}</td>
                    <td>${mission.wording}</td>
                    <td>
                        <a href="  " class="registration-button">Affecter un nouvel élève</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
<div class="container d-flex justify-content-center align-items-center">
    <div class="col-md-8 col-sm-8">
        <div class="blanc">
            <h1 class="text-center">Liste des apprenants</h1>
            <div class="mt-5"></div>
            <c:forEach items="${listeApprenants}" var="apprenant">
                <div class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" onclick="location.href='/mission/listeMissionApp.htm?idApprenant=${apprenant.numUtil}'">
                    <span class="text-secondary">${apprenant.surname} ${apprenant.forename}</span>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

</body>
</html>