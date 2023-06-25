<template>
    <div>
        <h1 class="text-center">Affichage des Actions possibles pour {{ utilisateur.surname }} {{ utilisateur.forename }}</h1>
        <div class="container text-center">
            <div class="col-auto row justify-content-center">
                <div class="blanc">
                    <br /><br />
                    <form @submit.prevent="creerJeu">
                        <input type="hidden" name="idApprenant" :value="idApprenant" />
                        <table class="table table-striped mx-auto">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Intitulé</th>
                                <th scope="col">Score à avoir pour valider l'action</th>
                                <th scope="col">Dernier score</th>
                                <th scope="col">Jouer</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="(item, index) in listeActions" :key="index">
                                <td scope="row">{{ index + 1 }}</td>
                                <td>{{ item.libelleAction }}</td>
                                <td>{{ item.scoreMinimum }}</td>
                                <td v-if="item.score !== -1">{{ item.score }}</td>
                                <td v-else>Score non disponible</td>
                                <td v-if="item.etat">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" :value="item.idAction" name="actionsCheckbox" :id="'checkbox' + item.id" @change="verifierCasesCochees" />
                                        <label class="form-check-label" :for="'checkbox' + item.id">
                                            Je veux m'évaluer sur cette action
                                        </label>
                                    </div>
                                </td>
                                <td v-else>
                                    Vous devez valider cette action : {{ item.precedenteAction }} afin de pouvoir vous évaluer sur cette action
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <label for="nomPartie">Nom de la partie :</label>
                        <input type="text" name="nomPartie" id="nomPartie" required v-model="nomPartie" />

                        <!-- Le reste du formulaire -->
                        <button type="submit" class="btn btn-secondary"  :disabled="!submitButtonEnabled">Jouer !</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-offset-2 col-md-7" id="resultat"></div>
    </div>
</template>

<script>
import axios from 'axios';
import { API_PATH } from "@/config/config";

export default {
    data() {
        return {
            nomPartie: '',
            submitButtonEnabled: false,
            listeActions: [],
            utilisateur: {
                surname: '',
                forename: ''
            },
            idApprenant: 0
        };
    },
    methods: {
        async fetchListeActionsPossibles() {
            try {
                const response = await fetch(`http://${API_PATH}/jeu/listeJeuxPossiblesApprenant?idApprenant=${this.$route.query.idApprenant}`);
                const data = await response.json();
                this.listeActions = data;
                console.log(data);
            } catch (error) {
                console.error(error);
            }
        },
        async getUtilisateurChoisi() {
            try {
                const response = await fetch(`http://${API_PATH}/utilisateur/getUtilisateur?id=${this.$route.query.idApprenant}`);
                const data = await response.json();
                this.utilisateur = data;
            } catch (error) {
                console.error(error);
            }
        },
        verifierCasesCochees() {
            const casesCochees = document.querySelectorAll('input[type="checkbox"]:checked');
            this.submitButtonEnabled = casesCochees.length > 0 && this.nomPartie.trim() !== '';
        },
        creerJeu() {
            try {
                const casesCochees = Array.from(document.querySelectorAll('input[name="actionsCheckbox"]:checked'));
                this.actionsSelectionnees = casesCochees.map(checkbox => checkbox.value);
                this.actionsSelectionnees = this.actionsSelectionnees.map(element => parseInt(element));
                console.log(this.actionsSelectionnees);

                const requestBody = {
                    libelleJeu: this.nomPartie,
                    idApprenant: this.idApprenant,
                    actionsCheckbox: this.actionsSelectionnees,
                };

                axios.post(`http://${API_PATH}/jeu/creerJeu`, requestBody)
                    .then(response => {
                        const jeuId = parseInt(response.data);
                        console.log(response.data)
                        this.$router.push(`/jeu/jouer?idApprenant=${this.idApprenant}&idJeu=${jeuId}`);
                    })
                    .catch(error => {
                        console.error(error);
                        // Gérer les erreurs
                    });
            } catch (error) {
                console.error(error);
                // Gérer les erreurs
            }
        },
    },
    created() {
        this.idApprenant = this.$route.query.idApprenant;
        console.log("idApp " + this.idApprenant);
        this.getUtilisateurChoisi();
        this.fetchListeActionsPossibles();
    },
    mounted() {
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        const inputText = document.querySelector('input[type="text"]');

        for (let i = 0; i < checkboxes.length; i++) {
            checkboxes[i].addEventListener('change', this.verifierCasesCochees);
        }

        inputText.addEventListener('input', this.verifierCasesCochees);
    },
};
</script>
