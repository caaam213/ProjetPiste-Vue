<template>
    <div>
        <h1 class="text-center">Liste des apprenants</h1>
        <div class="mt-5"></div>
        <div v-for="apprenant in listeApprenants" :key="apprenant.idUtilisateur">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" @click="redirectToMissionNonApp(apprenant.idUtilisateur)">
                <span class="text-secondary">{{ apprenant.surname }} {{ apprenant.forename }}</span>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { API_PATH } from "../../config/config";
import router from "../../router"

export default {
    data() {
        return {
            listeApprenants: [],
            controllerType: ''
        };
    },
    mounted() {
        this.getControllerType();
        this.getListeApprenants();

    },
    methods: {
        async getListeApprenants() {
            try {
                const response = await fetch(`http://${API_PATH}/jeu/choixApprenant`);
                const data = await response.json();
                this.listeApprenants = data;
                console.log(data);

            } catch (error) {
                console.error(error);
            }
        },

        getControllerType() {
            const params = new URLSearchParams(window.location.search);
            console.log(params.get('controllerType'));
            this.controllerType = params.get('controllerType');

        },
        redirectToMissionNonApp(apprenantId) {
            router.push(`/mission/listeMissionApp?idApprenant=${apprenantId}`)
        }
    }
};
</script>

