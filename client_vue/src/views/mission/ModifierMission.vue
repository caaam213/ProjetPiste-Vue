<template>
    <div class="container">
        <h1>Modifier une mission</h1>
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="libelle">Libellé</label>
                <input type="text" class="form-control" id="libelle" v-model="mission.wording">
            </div>
            <p>Actions :</p>
            <div v-for="action in actions" :key="action.id">
                <input type="checkbox" :id="action.id" :value="action.id" name="actions">
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
            mission: {
                id: 0,
                wording: '',
                actionMission: []
            },
            actions: [],
            errorMessage: '',
            successMessage: ''
        };
    },
    created() {
        const missionId = this.$route.params.id;
        this.fetchMissionData(missionId);
        this.fetchActionsData();
    },
    methods: {
        fetchMissionData(missionId) {
            axios.get(`http://${API_PATH}/mission/getMission?id=${missionId}`)
                .then(response => {
                    this.mission = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        fetchActionsData() {
            axios.get(`http://${API_PATH}/action/getAll/`)
                .then(response => {
                    this.actions = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        submitForm() {
            this.errorMessage = '';
            this.successMessage = '';
            axios.post(`http://${API_PATH}/mission/edit`, this.mission)
                .then(response => {
                    this.successMessage = response.data;

                    console.log(response.data);
                    // Rediriger vers une autre page ou effectuer une action supplémentaire
                })
                .catch(error => {
                    this.errorMessage = error.response.data;

                    console.error(error);
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
