<template>
    <navigation></navigation>
    <div class="container">
        <h1 class="text-center">Affichage des actions</h1>
        <div class="mx-auto text-center mt-2">
            <div>
                <img width="50" height="50" src="https://img.icons8.com/external-others-maxicons/62/external-action-book-genres-others-maxicons-3.png"
                     alt="external-action-book-genres-others-maxicons-3"/>
                <router-link class="btn btn-primary w-25 ml-2 mt-2" to="/action/add">Ajouter</router-link>
            </div>
        </div>

        <table class="table table-striped mt-2">
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
            <tr v-for="action in actions" :key="action.idAction">
                <th>{{ action.idAction }}</th>
                <td>{{ action.wording }}</td>
                <td>{{ action.scoreMin }}</td>
                <td><router-link class="btn btn-secondary" :to="'/action/edit/' + action.idAction">Modifier</router-link></td>
                <td><a v-on:click="deleteAction(action.idAction)"  class="btn btn-danger" role="button" href="/action/getAll">Supprimer</a></td>
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
        },
        deleteAction: async function (id) {
            try {
                const response = await fetch(`http://${API_PATH}/action/delete?id=${id}`);
                const data = await response.json();

            } catch (error) {
                console.error(error);
            }
        }
    }
};
</script>
<style src="./Action.css"></style>