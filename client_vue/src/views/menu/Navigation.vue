<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="width: 100%;">
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
                <li class="nav-item">
                    <router-link to="/" class="nav-link">Accueil</router-link>
                </li>
                <li class="nav-item" v-if="userType === 'admin'">
                    <router-link to="/apprenant/getAll" class="nav-link">Apprenants</router-link>
                </li>
                <li class="nav-item dropdown" v-if="userType === 'admin'">
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
                        <li><router-link to="/mission/getAll" class="nav-link">Gérer les missions</router-link></li>

                        <li><a class="dropdown-item" href="/mission/choixApprenant">Affecter une mission</a></li>
                    </ul>
                </li>
                <li class="nav-item" v-if="userType === 'admin'">
                    <!-- Ajoutez ici les éléments de navigation supplémentaires pour l'admin -->
                </li>
                <li class="nav-item" v-if="userType === 'admin'">
                    <router-link to="/action/getAll" class="nav-link">Actions</router-link>
                </li>
                <li class="nav-item dropdown" v-if="userType === 'admin'">
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
                <li class="nav-item dropdown" v-if="userType !== 'admin'">
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
                        <li><a class="dropdown-item" :href="'/jeu/listeJeuxPossiblesApprenant?idApprenant='+id">Jouer à un jeu</a></li>
                        <li><a class="dropdown-item" href="/jeu/choixApprenant?controllerType=voirJeu">Voir jeux réalisés</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" @click="logout">Déconnexion</a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    created() {
        this.id = localStorage.getItem('userId')
    },
    methods: {
        logout() {
            // Supprimez le jeton d'authentification du localStorage
            localStorage.removeItem("authToken");

            // Redirigez l'utilisateur vers la page de connexion ou une autre page appropriée
            window.location.href = "/login";
        }
    },
    computed: {
        userType() {
            // Récupérez le type d'utilisateur à partir du localStorage
            return localStorage.getItem("userType");
        }
    }
};
</script>

<style>
/* Ajoutez ici votre style CSS personnalisé */
</style>
