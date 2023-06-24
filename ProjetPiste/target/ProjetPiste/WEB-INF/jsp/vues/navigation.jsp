<%--
  Created by IntelliJ IDEA.
  User: sachamontel
  Date: 05/05/2023
  Time: 08:04
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Permis piste</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <form class="d-flex input-group w-auto">
            <input
                    type="search"
                    class="form-control rounded"
                    placeholder="Search"
                    aria-label="Search"
                    aria-describedby="search-addon"
            />
            <span class="input-group-text text-white border-0" id="search-addon">
        <i class="fas fa-search"></i>
      </span>
        </form>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li>
                <a class="nav-item nav-link " href="/">Accueil</a>
            </li>

            <li><a class="nav-item nav-link" href="/utilisateur/indexApprenant">Apprenants</a></li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Missions
                </a>
                <ul class="dropdown-menu">
                    <!-- A modifier selon si admin / apprenant-->
                    <li><a class="nav-item nav-link" href="/mission/index">Gérer les missions</a></li>
                    <li><a class="nav-item nav-link" href="/mission/choixApprenant">Affecter une mission</a></li>

                </ul>
            </li>


            <li><a class="nav-item nav-link " href="/action/getAll">Actions</a></li>


            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Jeux
                </a>
                <ul class="dropdown-menu">
                    <!-- A modifier selon si admin / apprenant-->
                    <li><a class="dropdown-item" href="/jeu/choixApprenant?controllerType=jeu">Jouer à un jeu</a></li>
                    <li><a class="dropdown-item" href="/jeu/choixApprenant?controllerType=voirJeu">Voir jeu réalisés</a></li>

                </ul>
            </li>

            <li><a class="nav-item nav-link " href="/login/deconnection">Deconnection</a></li>
        </ul>
    </div>
</nav>
