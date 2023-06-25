<template>
    <div class="container">
        <h1>Affichage des apprenants</h1>
        <div class="">
            <p>Ajouter un apprenant</p>
            <router-link class="btn btn-primary" to="/apprenant/add">Ajouter</router-link>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nom</th>
                <th scope="col">Prenom</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="apprenant in apprenants" :key="apprenant.idUtilisateur">
                <th>{{ apprenant.idUtilisateur }}</th>
                <td>{{ apprenant.forename }}</td>
                <td>{{ apprenant.surname }}</td>
                <td><router-link class="btn btn-secondary" :to="'/apprenant/edit/' + apprenant.idUtilisateur">Modifier</router-link></td>
                <td><a v-on:click="deleteApprenant(apprenant.idUtilisateur)"  class="btn btn-danger" role="button" href="/apprenant/getAll">Supprimer</a></td>
            </tr>

            </tbody>
        </table>
    </div>
</template>

<script>
import Navigation from "@/views/menu/Navigation.vue";
import {API_PATH} from "@/config/config";

export default {
    components: {
        Navigation
    },
    data() {
        return {
            apprenants: []
        };
    },
    created() {
        this.fetchApprenantsData();
    },
    methods: {
        async fetchApprenantsData() {
            try {
                const response = await fetch(`http://${API_PATH}/utilisateur/getAllApprennants`);
                const data = await response.json();
                this.apprenants = data;
            } catch (error) {
                console.error(error);
            }
        }
        ,
        deleteApprenant : async function (id) {
            try {
                const response = await fetch(`http://${API_PATH}/utilisateur/delete?id=${id}`);
                const data = await response.json();

            } catch (error) {
                console.error(error);
            }
        }
    }
};
</script>

<style>
/* Ajoutez votre style CSS personnalisé ici */
</style>
