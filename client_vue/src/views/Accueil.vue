<template>
    <div class="bg-light">
        <h1 class="mt-5">Bienvenue dans l'application Permis Piste !</h1>
        <div class="container">
            <div class="row">
                <div class="col-8">
                    <div class="ml-3">
                        <p>Nous sommes le {{ getCurrentDateTime() }}</p>
                        <p>Cette application vous permettra de suivre pas à pas votre apprentissage. En vous souhaitant une agréable visite !</p>
                        <h2>Pour commencer, vous pouvez vous :</h2>
                        <ul>
                            <li>1) <router-link to="/apprenant/add">Enregistrer en tant qu'apprenant</router-link></li>
                            <li>2) <router-link to="/mission/choixApprenant">Affecter une mission depuis la liste</router-link></li>
                            <li>3) <router-link to="/jeu/choixApprenant?controllerType=jeu">Jouer à un jeu</router-link></li>
                        </ul>
                        <h3>D'autres informations comme la liste des apprenants ou des actions sont disponibles en haut à droite.</h3>
                    </div>
                </div>
                <div class="col-4">
                    <img src="/Images/Polytech_Lyon_logo.png" alt="Logo Polytech Lyon">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "index",
    methods: {
        getCurrentDateTime() {
            const currentDate = new Date();
            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric' };
            return currentDate.toLocaleString('fr-FR', options);
        }
    }
}
</script>

<style scoped>
h1 {
    margin-top: 5rem;
}

.container {
    margin-top: 3rem;
}

img {
    max-width: 100%;
    height: auto;
}
</style>