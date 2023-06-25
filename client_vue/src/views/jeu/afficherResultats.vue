<template>
    <div class="container">
        <div class="col-md-8 col-sm-8">
            <div class="blanc">
                <div v-for="entryAction in scores" :key="entryAction.libelle">
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
    data() {
        return {
            scores: [] // Define scores as a data property
        };
    },
    created() {
        const idApprenant = this.$route.query.idApprenant;
        const encodedActionsAAfficherScore = this.$route.params.actionsAAfficherScore;
        const decodedActionsAAfficherScore = decodeURIComponent(encodedActionsAAfficherScore);
        const actionsAAfficherScore = JSON.parse(decodedActionsAAfficherScore);

        for (const item of actionsAAfficherScore) {
            const str = item.action;
            const parts = str.split("///");
            const part1 = parts[0]; // "Analyser panne(s)"
            const part2 = parts[1]; // "2"

            const scoreObj = {
                libelle: part1,
                scoreMinimum: parseInt(part2),
                score: parseInt(item.score)
            };

            this.scores.push(scoreObj); // Add scoreObj to the scores array in data
        }

        console.log(actionsAAfficherScore);
        console.log(idApprenant);
    }
};
</script>

<style scoped>
/* Your CSS styles here */
</style>
