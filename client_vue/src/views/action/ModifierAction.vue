<template>
    <div>
        <h1>Modifier une action</h1>
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
import {API_PATH} from "@/config/config";

export default {
    data() {
        return {
            actionData: {
                id: 0,
                wording: '',
                scoreMinimum: 0,
            },
            errorMessage: '',
            successMessage: ''
        };
    },
    created() {
        this.fetchActionData();
    },
    methods: {
        fetchActionData() {
            const id = this.$route.params.id;
            axios.get(`http://${API_PATH}/action/getAction?id=${id}`)
                .then(response => {
                    this.actionData.id = id;
                    this.actionData.wording = response.data.wording;
                    this.actionData.scoreMinimum = response.data.scoreMin;
                })
                .catch(error => {
                    this.errorMessage = 'Erreur lors de la récupération des données de l\'action';
                });
        },
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';

            // Effectuer la requête POST pour modifier l'action
            axios.post(`http://${API_PATH}/action/edit`, this.actionData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.successMessage = response.data;
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
