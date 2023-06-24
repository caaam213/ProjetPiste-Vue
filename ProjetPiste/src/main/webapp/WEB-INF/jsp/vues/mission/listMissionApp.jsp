<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Liste des missions pour l'apprentie </title>
</head>
<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp" %>
<div class="col-auto row justify-content-center">
    <div class="blanc ">
        <form action="/mission/ajouterApprenant.htm" method="post">
            <input type="hidden" name="idApprenant" value="${idApprenant}" />
                <div class="container">
                    <h2>Missions Apprise</h2>
                    <br><br>

                    <table class="table table-striped mx-auto">
                        <c:forEach var="missionApp" items="${missionsApp}">
                            <tr>
                                <td>${missionApp.id}</td>
                                <td>${missionApp.wording}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="container">
                    <h2>Missions Non Apprise</h2>
                    <br><br>
                    <table class="table table-striped mx-auto">
                        <c:forEach var="missionNonApp" items="${missionsNonApp}">
                            <tr>
                                <td>${missionNonApp.id}</td>
                                <td>${missionNonApp.wording}</td>
                                <input type="hidden" name="idMission" value="${missionNonApp.id}" />
                                <td>
                                    <button type="submit">Affecter l'apprenant à la mission</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
        </form>
    </div>
</div>

</body>
</html>
