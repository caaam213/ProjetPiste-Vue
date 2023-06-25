<template>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="width: 100%;">
        <a class="navbar-brand" href="#"> Permis piste</a>
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
                <li class="nav-item">
                    <router-link to="/" class="nav-link">Accueil</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/apprenant/getAll" class="nav-link">Apprenants</router-link>
                </li>
                <li class="nav-item dropdown">
                    <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        role="button"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        Missions
                    </a>
                    <ul class="dropdown-menu">
                        <!-- Je sais pas lequel supprimer -->
                        <li><a class="dropdown-item" href="/mission/AfficherMission">Gérer les missions</a></li>
                        <li><a class="dropdown-item" href="/mission/choixApprenant">Affecter une mission</a></li>
                    </ul>
                </li>
                <!-- Je sais pas lequel supprimer -->
                <li class="nav-item">
                  <router-link to="/mission/getAll" class="nav-link">Missions</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/action/getAll" class="nav-link">Actions</router-link>
                </li>
                <li class="nav-item dropdown">
                    <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        role="button"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        Jeux
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/jeu/choixApprenant?controllerType=jeu">Jouer à un jeu</a></li>
                        <li><a class="dropdown-item" href="/jeu/choixApprenant?controllerType=voirJeu">Voir jeux réalisés</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login/deconnection">Déconnexion</a>
                </li>
            </ul>
        </div>
    </nav>

</template>

<style>

</style>