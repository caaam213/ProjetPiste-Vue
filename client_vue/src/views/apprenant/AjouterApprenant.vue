<template>
    <div class="container">
        <h1>Ajouter un apprenant</h1>
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" class="form-control" id="nom" v-model="utilisateurData.surname">
            </div>
            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" class="form-control" id="prenom" v-model="utilisateurData.forename">
            </div>
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="text" class="form-control" id="password" v-model="utilisateurData.motPasse">
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
        <p class="error-message" v-if="errorMessage">{{ errorMessage }}</p>
        <p class="success-message" v-if="successMessage">{{ successMessage }}</p>
    </div>
</template>

<script>
import Navigation from "@/views/menu/Navigation.vue";
import {API_PATH} from "@/config/config";
import axios from "axios";

export default {
    components: {
        Navigation
    },
    data() {
        return {
            utilisateurData: {
                surname: "",
                forename: "",
                motPasse: ""
            },
            errorMessage: '',
            successMessage: ''
        }
    },
    methods: {
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';

            // Effectuer la requête POST pour ajouter l'action
            axios.post(`http://${API_PATH}/utilisateur/addApprenant`, this.utilisateurData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.successMessage = response.data;
                    this.surname
                        =
                        "";
                    this.forename
                        =
                        "";
                    this.motPasse
                        =
                        ""
                })
                .catch(error => {
                    this.errorMessage = error.response.data;
                });
        }
    }
};
</script>

<style scoped>
.error-message {
    color: red;
}

.success-message {
    color: green;
}
</style>
