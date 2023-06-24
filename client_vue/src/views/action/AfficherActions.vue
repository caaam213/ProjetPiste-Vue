<template>
    <navigation></navigation>
    <div class="container">
        <h1>Affichage des actions</h1>
        <div class="">
            <p>Ajouter une action</p>
            <router-link class="btn btn-primary" to="/action/addForm">Ajouter</router-link>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Libellé</th>
                <th scope="col">Score minimum</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="action in actions" :key="action.id">
                <th>{{ action.idAction }}</th>
                <td>{{ action.wording }}</td>
                <td>{{ action.scoreMin }}</td>
                <td><router-link class="btn btn-secondary" :to="'/action/editForm/' + action.id">Modifier</router-link></td>
                <td><a class="btn btn-danger" :href="'/action/delete/' + action.id" role="button">Supprimer</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import Navigation from "@/views/menu/Navigation.vue";
import { API_PATH } from "../../config/config";
export default {
    data() {
        return {
            actions: []
        };
    },
    created() {
        this.fetchActionData();
    },
    methods: {
        async fetchActionData() {
            try {
                const response = await fetch(`http://${API_PATH}/action/getAll/`);
                const data = await response.json();
                this.actions = data;
            } catch (error) {
                console.error(error);
            }
        }
    }
};
</script>
<style src="./Action.css"></style>