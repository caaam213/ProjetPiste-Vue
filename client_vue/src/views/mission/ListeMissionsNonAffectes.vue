<template>
    <div class="col-auto row justify-content-center">
        <div class="blanc">
            <form @submit.prevent="ajouterApprenant">
                <input type="hidden" name="idApprenant" :value="idApprenant" />

                <div class="container">
                    <h2>Missions Non Apprises</h2>
                    <br /><br />
                    <table class="table table-striped mx-auto" v-if="listeMissionNonApp.length > 0">
                        <tr v-for="missionNonApp in listeMissionNonApp" :key="missionNonApp.id">
                            <td>{{ missionNonApp.wording }}</td>
                            <td>
                                <button type="submit" class="btn btn-primary w-25 mt-2" @click="ajouterMissionApprenant(missionNonApp.id)">
                                    Affecter l'apprenant à la mission
                                </button>
                            </td>
                        </tr>
                    </table>
                    <p v-else>Aucune mission disponible.</p>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import { API_PATH } from "@/config/config";
import router from "@/router";

export default {
    data() {
        return {
            idApprenant: null,
            listeMissionNonApp: []
        };
    },
    methods: {
        async fetchMissionsNonApp() {
            try {
                const response = await fetch(
                    `http://${API_PATH}/mission/listeMissionApp?idApprenant=${this.$route.query.idApprenant}`
                );
                const data = await response.json();
                this.listeMissionNonApp = data;
                console.log(data);
            } catch (error) {
                console.error(error);
            }
        },
        async ajouterMissionApprenant(idMission) {
            try {
                const response = await fetch(
                    `http://${API_PATH}/mission/ajouterApprenant?idApprenant=${this.idApprenant}&idMission=${idMission}`,
                    { method: "POST" }
                );
                if (response.ok) {
                    // Opération réussie
                    console.log("Ajout de l'apprenant à la mission effectué avec succès");
                    router.push(`/mission/listeMissionApp?idApprenant=${this.idApprenant}`)
                    window.location.reload();
                } else {
                    // Erreur lors de l'opération
                    console.error("Erreur lors de l'ajout de l'apprenant à la mission");
                }
            } catch (error) {
                console.error(error);
            }
        },
        async ajouterApprenant() {
            // Vous pouvez ajouter d'autres opérations si nécessaire avant d'appeler ajouterMissionApprenant()
            await this.ajouterMissionApprenant(this.listeMissionNonApp.id);
        }
    },
    created() {
        this.idApprenant = this.$route.query.idApprenant;
        this.fetchMissionsNonApp();
    }
};
</script>

<style scoped>
/* Vos styles CSS spécifiques ici */
</style>
