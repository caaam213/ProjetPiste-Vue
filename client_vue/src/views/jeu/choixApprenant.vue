<template>
    <div>
        <h1 class="text-center">Liste des apprenants</h1>
        <div class="mt-5"></div>
        <div v-for="apprenant in listeApprenants" :key="apprenant.numUtil">
            <div v-if="controllerType === 'jeu'" class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" @click="redirectToJeu(apprenant.numUtil)">
                <span class="text-secondary">{{ apprenant.surname }} {{ apprenant.forename }}</span>
            </div>
            <div v-if="controllerType === 'voirJeu'" class="shadow p-3 mb-5 bg-body-tertiary rounded text-center hover-effect fs-5 w-75 mx-auto" @click="redirectToJeuxRealise(apprenant.numUtil)">
                <span class="text-secondary">{{ apprenant.surname }} {{ apprenant.forename }}</span>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { API_PATH } from "../../config/config";

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
                const config = {
                    headers: {
                        'Access-Control-Allow-Origin': '*'
                    }
                };

                const response = await axios.get(`http://${API_PATH}/choixApprenant`, config);
                this.listeApprenants = response.data.listeApprenants;
            } catch (error) {
                console.error(error);
            }
        },
        getControllerType() {
            const params = new URLSearchParams(window.location.search);
            return params.get('controllerType');
        },
        redirectToJeu(apprenantId) {
            // Rediriger vers la page correspondante pour le jeu avec l'apprenant sélectionné
            // en utilisant l'apprenantId
        },
        redirectToJeuxRealise(apprenantId) {
            // Rediriger vers la page correspondante pour les jeux réalisés par l'apprenant sélectionné
            // en utilisant l'apprenantId
        }
    }
};
</script>

<style>
@import 'Jeu.css';
</style>
