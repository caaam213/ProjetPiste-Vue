<template>
    <div class="container">
        <h1 class="my-4">Affichage des missions</h1>
        <div class="">
            <p>Ajouter une mission</p>
            <router-link class="btn btn-primary" to="/mission/add">Ajouter</router-link>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Libellé</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="mission in missions" :key="mission.id">
                <td>{{ mission.id }}</td>
                <td>{{ mission.wording }}</td>
                <td>
                    <router-link class="btn btn-secondary" :to="'/mission/edit/' + mission.id">Modifier</router-link>
                </td>
                <td><a v-on:click="deleteMission(mission.id)"  class="btn btn-danger" role="button" href="/mission/getAll">Supprimer</a></td>

            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import { API_PATH } from "@/config/config";
import axios from "axios";

export default {
    name: 'Mission',
    data() {
        return {
            missions: [],

        };

    },
    created() {
        this.fetchMissionData();
    },
    methods: {
        fetchMissionData() {
            axios.get(`http://${API_PATH}/mission/getAll/`)
                .then(response => {
                    this.missions = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },deleteMission : async function (id) {
            try {
                const response = await fetch(`http://${API_PATH}/mission/delete?id=${id}`);
                const data = await response.json();

            } catch (error) {
                console.error(error);
            }
        }
    }
};
</script>

<style scoped>
@import 'Mission.css';
/* Ajoutez votre style CSS personnalisé ici */
</style>
