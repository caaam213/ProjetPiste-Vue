/// ATTENTION VERFIER JE CROIS QUE C'EST APP.VUE QUI FAIT OFFICE DE NAVBAR
/// DONC PEUU ETRE A DEPLACER


<template>
    <footer class="header">
        <div class="menu-first-part">
            <a href="/home"><h1>Permis piste</h1></a>

            <div v-if="isUserLoggedIn()">
                <app-search-bar></app-search-bar>
            </div>

            <div v-if="isUserLoggedIn()">
                <p class="user-infos"><i>User : {{ getIdentity() }}</i></p>
            </div>
        </div>

        <nav>
            <ul>
                <li><a href="/home">Accueil</a></li>
                <div v-if="isUserLoggedIn()">
                    <li><a href="/utilisateur">Apprenants</a></li>
                </div>
                <div v-if="isUserLoggedIn() && !isUserAdmin()">
                    <li><a href="/inscription">Inscription</a></li>
                    <li><a @click="urlService.navigateToMissions(getUserId())">Actions</a></li>
                </div>
                <div v-if="!isUserLoggedIn()">
                    <li><a href="/connection">Connexion</a></li>
                </div>
                <div v-if="isUserLoggedIn()">
                    <li><a href="" @click="logout()">Déconnexion</a></li>
                </div>
            </ul>
        </nav>
    </footer>
</template>

<script setup>
const isUserLoggedIn = () => {
    // Logique pour vérifier si l'utilisateur est connecté
    // Retourne true si l'utilisateur est connecté, sinon false
};

const isUserAdmin = () => {
    // Logique pour vérifier si l'utilisateur est un administrateur
    // Retourne true si l'utilisateur est un administrateur, sinon false
};

const getIdentity = () => {
    // Logique pour obtenir l'identité de l'utilisateur connecté
    // Retourne l'identité de l'utilisateur
};

const getUserId = () => {
    // Logique pour obtenir l'ID de l'utilisateur connecté
    // Retourne l'ID de l'utilisateur
};

const logout = () => {
    // Logique pour déconnecter l'utilisateur
};

const urlService = {
    navigateToMissions(userId) {
        // Logique pour naviguer vers les missions de l'utilisateur spécifié
    }
};
</script>

<style scoped>
.footer {
    background-color: #f5f5f5;
    padding: 20px;
}

.menu-first-part {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.menu-first-part h1 {
    margin: 0;
    font-size: 24px;
}

nav ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

nav ul li {
    display: inline-block;
    margin-right: 10px;
}

nav ul li a {
    text-decoration: none;
    color: #333;
}

.user-infos {
    margin: 0;
    font-size: 14px;
    color: #888;
}
</style>
