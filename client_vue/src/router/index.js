import {createWebHistory, createRouter} from "vue-router";
// import Menu from '../views/menu/Menu';
import Action from '../views/action/AfficherActions.vue'
import AjouterActionForm from "@/views/action/AjouterAction.vue";
import AjouterAction from "@/views/action/AjouterAction.vue";
import ChoixApprenant from "@/views/jeu/choixApprenant.vue";
import listeJeuxPossiblesApprenant from "@/views/jeu/listerJeuxPossibles.vue";
import UtilisateurComponent from "@/components/utilisateur/UtilisateurComponent.vue";
import Jouer from "@/views/jeu/Jouer.vue";
import Missions from "@/views/mission/AfficherMissions.vue";
import AfficherResultats from "@/views/jeu/afficherResultats.vue";

import AfficherApprenants from "@/views/apprenant/AfficherApprenants.vue";
import AjouterApprenant from "@/views/apprenant/AjouterApprenant.vue";
import ModifierApprenant from "@/views/apprenant/ModifierApprenant.vue";
import Accueil from "@/views/Accueil.vue";
import ModifierAction from "@/views/action/ModifierAction.vue";
import AjouterMission from "@/views/mission/AjouterMission.vue";
import ModifierMission from "@/views/mission/ModifierMission.vue";
import {isAuthenticated} from "@/utils/auth";
import Login from "@/views/login/Login.vue";
import AfficherMissionNonApp from "@/views/mission/ListeMissionsNonAffectes.vue"
import ChoixApprenantMissions from "@/views/mission/choixApprenant.vue"


const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/',
        name: 'Accueil',
        component: Accueil
    },
    {
        path: '/action/getAll/',
        name: 'Action',
        component: Action
    },
    {
        path: "/action/addForm/",
        name: "AjouterActionForm",
        component: AjouterActionForm
    },
    {
        path: "/action/add",
        name: "AjouterAction",
        component: AjouterAction
    },
    {
        path: "/action/edit/:id",
        name: "ModifierAction",
        component: ModifierAction
    },
    {
        path: "/jeu/choixApprenant",
        name: "ChoixApprenant",
        component: ChoixApprenant
    },
    {
        path: "/jeu/listeJeuxPossiblesApprenant",
        name: "listeJeuxPossiblesApprenant",
        component: listeJeuxPossiblesApprenant
    },
    {
        path: '/utilisateur/getUtilisateur/:id',
        name: 'Utilisateur',
        component: UtilisateurComponent,
    },
    {
        path: '/jeu/jouer',
        name: 'Jouer',
        component: Jouer,
        props: (route) => ({idJeu: route.query.idJeu, idApprenant: route.query.idApprenant})
    },
    {
        path: '/mission/getAll/',
        name: 'Mission',
        component: Missions
    },
    {
        path: "/mission/add",
        name: "AjouterMission",
        component: AjouterMission
    },
    {
        path: "/mission/edit/:id",
        name: "ModifierMission",
        component: ModifierMission
    },
    {

        path: '/jeu/afficherResultats',
        name: 'AfficherResultats',
        component: AfficherResultats
    },
    {

        path: '/apprenant/getAll/',
        name: 'Apprenant',
        component: AfficherApprenants,
    },
    {
        path: '/apprenant/add/',
        name: 'AjouterApprenant',
        component: AjouterApprenant,
    },
    {
        path: '/apprenant/edit/:id',
        name: 'MoifierApprenant',
        component: ModifierApprenant,
    },
    {
        path: '/mission/listeMissionApp',
        name:"AfficherMissionNonApp",
        component: AfficherMissionNonApp
    },
    {
        path : '/mission/choixApprenant',
        name: 'ChoixApprenantMissions',
        component: ChoixApprenantMissions
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

router.beforeEach((to, from, next) => {
    if (to.name !== "Login" && !isAuthenticated()) {
        next({ name: "Login" });
    } else {
        next();
    }
});

export default router;
