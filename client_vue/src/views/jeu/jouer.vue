<template>
    <div class="container">
        <div class="col-md-8 col-sm-8">
            <div class="blanc">
                <h2>Jeu lancé</h2>
                <div v-for="indicatorsActions in listeIndicateursActions" :key="indicatorsActions.action.id">
                    <h2>{{ indicatorsActions.action.wording }}</h2>
                    <div v-for="indicator in indicatorsActions.indicators" :key="indicator.id">
                        <label :for="'choix' + indicator.id">{{ indicator.wording }}</label><br>
                        <input type="checkbox" :id="'choix' + indicator.id" :value="indicator.id" v-model="selectedIndicators">
                    </div>
                </div>
                <button @click="validerJeu">Valider le questionnaire</button>
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
        validerJeu() {
            const casesCochees = Array.from(document.querySelectorAll('input[name="actionsCheckbox"]:checked'));
            this.selectedIndicators = casesCochees.map(checkbox => checkbox.value);
            this.selectedIndicators = this.selectedIndicators.map(element => parseInt(element));
            console.log(this.selectedIndicators);
        },
    },
    mounted() {
        this.idApprenant = this.$route.query.idApprenant;
        this.idJeu = this.$route.query.idJeu;
        this.fetchData();
    },
};
</script>
