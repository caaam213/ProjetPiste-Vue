<template>
    <div>
        <h1>Ajouter une action</h1>
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="wording">Libellé</label>
                <input type="text" class="form-control" id="wording" v-model="actionData.wording" required>
            </div>
            <div class="form-group">
                <label for="scoreMinimum">Score minimum</label>
                <input type="number" class="form-control" id="scoreMinimum" v-model="actionData.scoreMinimum" required>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
        <p class="error-message" v-if="errorMessage">{{ errorMessage }}</p>
        <p class="success-message" v-if="successMessage">{{ successMessage }}</p>
    </div>
</template>

<script>
import axios from 'axios';
import { API_PATH } from "../../config/config";

export default {
    data() {
        return {
            actionData: {
                wording: '',
                scoreMinimum: 0
            },
            errorMessage: '',
            successMessage: ''
        };
    },
    methods: {
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';

            // Effectuer la requête POST pour ajouter l'action
            axios.post(`http://${API_PATH}/action/add/`, this.actionData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.successMessage = response.data;
                    this.actionData.wording = '';
                    this.actionData.scoreMinimum = 0;
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
