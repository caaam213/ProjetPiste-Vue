<template>
    <div>
        <!-- Contenu de votre composant UtilisateurComponent -->
        <h1>Utilisateur Component</h1>
        <p>ID de l'apprenant : {{ idApprenant }}</p>
        <!-- Autres éléments de votre composant -->
    </div>
</template>

<script>
export default {
    data() {
        return {
            idApprenant: null, // La propriété idApprenant pour stocker l'ID récupéré
        };
    },
    created() {
        this.idApprenant = this.$route.params.id; // Récupération de l'ID de l'apprenant depuis l'URL
        console.log(this.idApprenant);
        // Autres actions nécessaires lors de la création du composant
    },
    // Autres méthodes et options du composant
};
</script>

<style scoped>
/* Styles spécifiques au composant */
</style>
