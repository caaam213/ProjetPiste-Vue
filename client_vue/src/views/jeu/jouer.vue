<template>
    <div class="container">
        <div class="col-md-8 col-sm-8">
            <div class="blanc">
                <h2>Jeu lancé</h2>
                <form @submit.prevent="validerJeu">
                    <input type="hidden" name="idApprenant" :value="idApprenant" />
                    <input type="hidden" name="idJeu" :value="idJeu" />
                    <div v-for="actionIndicateurDTO in listeIndicateursActions" :key="actionIndicateurDTO.action.id">
                        <h2>{{ actionIndicateurDTO.action.wording }}</h2>
                        <div v-for="indicateur in actionIndicateurDTO.indicators" :key="indicateur.id" class="checkbox-wrapper">
                            <label :for="'choix' + indicateur.id">{{ indicateur.wording }}</label>
                            <input type="checkbox" :id="'choix' + indicateur.id" name="checkboxesChecked" :value="indicateur.id" class="checkboxJeu" />
                        </div>
                    </div>

                    <h2>A cocher si rien ne devrait être coché</h2>

                    <div class="checkbox-wrapper">
                        <label for="choix-1">Aucun élément sélectionné</label>
                        <input type="checkbox" id="choix-1" name="checkboxesChecked" value="-1" v-model="isAnyChecked" />
                    </div>

                    <button type="submit">Valider le questionnaire</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import {API_PATH} from "@/config/config";

export default {
    data() {
        return {
            isAnyChecked: false,
            idApprenant: '',
            idJeu: '',
            listeIndicateursActions: [],
            selectedIndicators: [],
        };
    },
    methods: {
        async fetchData() {
            try {
                const response = await fetch(`http://${API_PATH}/jeu/jouer?idJeu=${this.$route.query.idJeu}&idApprenant=${this.$route.query.idApprenant}`);
                const data = await response.json();
                this.listeIndicateursActions = data;
            } catch (error) {
                console.error(error);
            }
        },

        // TODO : Modifier ici pour passer une LinkedHashMap
        validerJeu() {

            const casesCochees = Array.from(document.querySelectorAll('input[name="checkboxesChecked"]:checked'));
            this.checkboxesChecked = casesCochees.map(checkbox => checkbox.value);
            console.log(this.checkboxesChecked);
            console.log(this.idJeu);
            console.log(this.idApprenant);

            const requestBody = {
                idJeu: this.idJeu,
                idApprenant: this.idApprenant,
                indicatorsCheckbox: this.checkboxesChecked,
            };

            axios.post(`http://${API_PATH}/jeu/validerJeu`, requestBody)
                .then(response => {
                    const actionsAAfficherScore = Object.entries(response.data).map(([action, score]) => ({ action, score }));

                    // Encodez les données pour les passer en tant que paramètre URL
                    const encodedActionsAAfficherScore = encodeURIComponent(JSON.stringify(actionsAAfficherScore));

                    // Redirigez vers la page 'AfficherResultats' avec les données en tant que paramètre
                    this.$router.push({
                        name: 'AfficherResultats',
                        query: { idApprenant: this.idApprenant },
                        params: { actionsAAfficherScore: encodedActionsAAfficherScore }
                    });
                })
                .catch(error => {
                    console.error(error);
                });
        },

    },

    mounted() {
        this.idApprenant = this.$route.query.idApprenant;
        this.idJeu = this.$route.query.idJeu;
        this.fetchData();

        const checkboxes = document.querySelectorAll("input.checkboxJeu");
        console.log(checkboxes);
        const aucunElementCheckbox = document.getElementById("choix-1");
        let isAnyChecked = false; // Déclaration de la variable ici

        // Fonction pour vérifier l'état des autres checkboxes
        // Fonction pour vérifier l'état des autres checkboxes
        function checkOtherCheckboxes() {
            let isAnyChecked = false; // Déclaration de la variable ici

            for (let i = 0; i < checkboxes.length; i++) {
                console.log(checkboxes[i].checked);
                if (checkboxes[i].checked) {
                    isAnyChecked = true;
                    break;
                }
            }

            // Cocher/décocher la checkbox "Aucun élément sélectionné" en fonction de l'état des autres checkboxes
            aucunElementCheckbox.checked = isAnyChecked;
        }

// Ajouter un écouteur d'événement sur chaque autre checkbox
        checkboxes.forEach(checkbox => {
            checkbox.addEventListener("change", checkOtherCheckboxes);
        });

// Vérifier l'état initial des autres checkboxes lors du chargement de la page
        checkOtherCheckboxes();

    }
};
</script>

<style>
/* Vos styles CSS ici */
</style>
