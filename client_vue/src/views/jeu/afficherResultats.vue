<template>
    <div class="container">
        <div class="col-md-8 col-sm-8">
            <div class="blanc">
                <div v-for="entryAction in actionsAAfficherScore" :key="entryAction.libelle">
                    <h2>Score pour l'action {{ entryAction.libelle }} : {{ entryAction.score }}</h2>

                    <template v-if="entryAction.score < entryAction.scoreMinimum">
                        <p>Le score obtenu est insuffisant pour que l'action soit validée</p>
                        <p>Il vous manque {{ entryAction.scoreMinimum - entryAction.score }} points</p>
                    </template>

                    <template v-else>
                        <p>Action validée, Bravo !!</p>
                    </template>
                </div>
            </div>
            <form action="/">
                <button type="submit">Revenir à la page d'accueil</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    created() {
        // Accéder aux paramètres de la route
        const idApprenant = this.$route.query.idApprenant;
        const actionsAAfficherScore = JSON.parse(this.$route.params.actionsAAfficherScore);

        for (let i = 0; i < actionsAAfficherScore.length; i++) {
            actionsAAfficherScore[i].score = parseInt(actionsAAfficherScore[i].score);
            actionsAAfficherScore[i].scoreMinimum = parseInt(actionsAAfficherScore[i].scoreMinimum);
        }

        // Utiliser les paramètres dans votre logique
        console.log(idApprenant);
        console.log(actionsAAfficherScore);
    }
};
</script>

<style scoped>
/* Vos styles CSS ici */
</style>


