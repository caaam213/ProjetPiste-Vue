<template>
    <div class="container">
        <h1>Ajouter une mission</h1>
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="libelle">Libellé</label>
                <input type="text" class="form-control" id="libelle" v-model="missionData.wording">
            </div>
            <p>Actions :</p>
            <div v-for="action in actions" :key="action.id">
                <input type="checkbox" :id="action.id" :value="action.id" name="actions" @change="updateSelectedActions($event, action.id)">
                <label :for="action.id">{{ action.wording }}</label>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
        <p class="error-message" v-if="errorMessage">{{ errorMessage }}</p>
        <p class="success-message" v-if="successMessage">{{ successMessage }}</p>
    </div>
</template>

<script>
import axios from 'axios';
import { API_PATH } from "@/config/config";

export default {
    data() {
        return {
            missionData: {
                wording: '',
            },
            actions: [], // Ajoutez ici la liste des actions récupérée de l'API
            selectedActions: [], // Actions sélectionnées
            errorMessage: '',
            successMessage: ''
        };
    },
    created() {
        this.fetchActionsData();
    },
    methods: {
        fetchActionsData() {
            axios.get(`http://${API_PATH}/action/getAll/`)
                .then(response => {
                    this.actions = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        updateSelectedActions(event, actionId) {
            if (event.target.checked) {
                this.selectedActions.push(actionId);
            } else {
                const index = this.selectedActions.indexOf(actionId);
                if (index !== -1) {
                    this.selectedActions.splice(index, 1);
                }
            }
        },
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';
            // Effectuer la requête POST pour ajouter la mission avec les actions sélectionnées

            axios.post(`http://${API_PATH}/mission/add`, this.missionData)
                .then(response => {
                    this.successMessage = response.data;
                    console.log(response.data);
                    // Réinitialiser les données du formulaire
                    this.missionData.wording = '';
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