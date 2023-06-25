<template>
    <div class="text-center d-flex justify-content-center">
        <form class="form-signin col-4" @submit.prevent="loginApp">
            <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt=""
                 width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Me connecter</h1>
            <label for="inputNom" class="sr-only">Email</label>
            <input v-model="loginData.nomUtil" type="text" id="inputNom" class="form-control" placeholder="Nom"
                   required autoFocus>
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input v-model="loginData.motPasse" type="password" id="inputPassword" class="form-control"
                   placeholder="Mot de passe" required>
            <div v-if="message" class="alert alert-primary" role="alert">
                Identifiant ou mot de passe incorrect.
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
        </form>
    </div>
</template>

<script>
import axios from "axios";
import {API_PATH} from "@/config/config";

export default {
    data() {
        return {
            loginData: {
                nomUtil: "",
                motPasse: ""
            },
            message: ""
        };
    },
    methods: {
        loginApp() {
            // Effectuez ici votre logique de connexion
            // Vous pouvez utiliser la valeur de this.loginData.login et this.loginData.password pour envoyer les informations d'identification au serveur

            // Exemple de requête avec Axios
            axios.post(`http://${API_PATH}/login/authenticate`, this.loginData,{
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    // Connexion réussie, redirigez l'utilisateur vers la page d'accueil ou une autre page appropriée
                    localStorage.setItem("authToken", "connected");
                    localStorage.setItem("userType", response.data.role);
                    localStorage.setItem("userId", response.data.numUtil);
                    window.location.href = "/";
                })
                .catch(error => {
                    // Connexion échouée, affichez un message d'erreur approprié
                    this.message = "Identifiant ou mot de passe incorrect.";
                    console.error(error);
                });
        }
    }
};
</script>

<style>
/* Ajoutez ici votre style CSS personnalisé */
</style>
