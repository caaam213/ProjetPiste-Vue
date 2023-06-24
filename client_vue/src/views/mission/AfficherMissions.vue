
<template>
<!--  <div>-->
<!--    <h1>Affichage des missions</h1>-->
<!--    <div class="d-flex">-->
<!--      <p>Ajouter une action</p>-->
<!--      <router-link class="btn btn-primary" to="/mission/addForm">Ajouter</router-link>-->
<!--    </div>-->

<!--    <table class="table table-striped">-->
<!--      <thead>-->
<!--      <tr>-->
<!--        <th scope="col">Id</th>-->
<!--        <th scope="col">Libellé</th>-->
<!--        <th scope="col">Modifier</th>-->
<!--        <th scope="col">Supprimer</th>-->
<!--      </tr>-->
<!--      </thead>-->
<!--      <tbody>-->
<!--      <tr v-for="mission in missions" :key="mission.id">-->
<!--        <th>{{ mission.id }}</th>-->
<!--        <td>{{ mission.wording }}</td>-->
<!--        <td>-->
<!--          <router-link class="btn btn-secondary" :to="'/mission/editForm/' + mission.id">Modifier</router-link>-->
<!--        </td>-->
<!--        <td>-->
<!--          <button class="btn btn-danger" @click="deleteMission(mission.id)">Supprimer</button>-->
<!--        </td>-->
<!--      </tr>-->
<!--      </tbody>-->
<!--    </table>-->
<!--  </div>-->
</template>

<script>
// export default {
//   //TODO retravailler le router marche lorsqu'on met exactement le même code dans action
//   name: 'Mission',
//   data() {
//     return {
//       missions: []
//     };
//   },
//   mounted() {
//     this.getAllMissions();
//   },
//   methods: {
//     getAllMissions() {
//       // Appeler votre API pour récupérer toutes les missions
//       axios.get('/mission/getAll/')
//           .then(response => {
//             this.missions = response.data;
//           })
//           .catch(error => {
//             console.error(error);
//           });
//     },
//
//     //TODO : Créer le delete
//     deleteMission(id) {
//       // Appeler votre API pour supprimer une mission par son ID
//       axios.delete(`/mission/delete/${id}`)
//           .then(response => {
//             // Mettre à jour la liste des missions après suppression
//             this.getAllMissions();
//           })
//           .catch(error => {
//             console.error(error);
//           });
//     }
//   }
// };
</script>

<style scoped>
/* Vos styles CSS spécifiques ici */
</style>