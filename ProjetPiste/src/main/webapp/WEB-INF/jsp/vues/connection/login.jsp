<%--
  Created by IntelliJ IDEA.
  User: sachamontel
  Date: 04/05/2023
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>

<body>
<%@include file="../navigation.jsp" %>
<div class="text-center d-flex justify-content-center">
    <form class="form-signin col-4" action="/login/getLogin" method="post">
        <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72"
             height="72">
        <h1 class="h3 mb-3 font-weight-normal">Me connecter</h1>
        <label for="inputNom" class="sr-only">Email</label>
        <input name="login" type="text" id="inputNom" class="form-control" placeholder="Nom" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Mot de passe</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Mot de passe"
               required="">
        <c:if test="${not empty message}">
            <div class="alert alert-primary" role="alert">
                Identifiant ou mot de passe incorrecte.
            </div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Connection</button>

    </form>
</div>


</div>
</body>
</html>
