<template>
  <div class = container>
    <h1 class="my-4 text-center">Affichage des missions</h1>
<!--    <div class="d-flex justify-content-between mb-3">-->
<!--      <p class="my-auto">Ajouter une mission</p>-->
<!--      <router-link class="btn btn-primary" to="/mission/addForm">Ajouter</router-link>-->
<!--    </div>-->

    <table class="table table-striped">
      <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Libellé</th>
<!--        <th scope="col">Modifier</th>-->
<!--        <th scope="col">Supprimer</th>-->
      </tr>
      </thead>
      <tbody>
      <tr v-for="mission in missions" :key="mission.id">
        <td>{{ mission.id }}</td>
        <td>{{ mission.wording }}</td>
<!--        <td>-->
<!--          <router-link class="btn btn-secondary" :to="'/mission/editForm/' + mission.id">Modifier</router-link>-->
<!--        </td>-->
<!--        <td>-->
<!--          <button class="btn btn-danger" @click="deleteMission(mission.id)">Supprimer</button>-->
<!--        </td>-->
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import {API_PATH} from "@/config/config";
import axios from "axios";


export default {
  name: 'Mission',
  data() {
    return {
      missions: []
    };
  },
  created() {
    this.fetchMissionData(); // Correction de la méthode appelée ici
  },
  methods: {
    fetchMissionData() { // Correction du nom de la méthode ici
      axios.get('http://localhost:8080/mission/getAll/')
          .then(response => {
            this.missions = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
};
</script>

<style >
@import 'Mission.css';
</style>