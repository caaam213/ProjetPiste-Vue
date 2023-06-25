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
            <div class="mx-auto text-center"><button type="submit" class="btn btn-primary mt-2 w-25">Enregistrer</button></div>
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
                numUtil :0,
                surname: "",
                forename: "",
            },
            errorMessage: '',
            successMessage: ''
        }
    },
    created() {
        this.fetchInitialData();
    },
    methods: {
        fetchInitialData() {
            const id = this.$route.params.id;
            axios.get(`http://${API_PATH}/utilisateur/getUtilisateur?id=${id}`) // Remplacez l'URL par votre endpoint d'API
                .then(response => {
                    this.utilisateurData.numUtil = id;
                    this.utilisateurData.surname = response.data.surname;
                    this.utilisateurData.forename = response.data.forename;
                })
                .catch(error => {
                    this.errorMessage = 'Erreur lors de la récupération des données initiales';
                });
        },
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';

            // Effectuer la requête POST pour ajouter l'action
            axios.post(`http://${API_PATH}/utilisateur/editApprenant`, this.utilisateurData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.successMessage = response.data;
                    this.numUtil = 0;
                    this.surname
                        =
                        "";
                    this.forename
                        =
                        "";
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
