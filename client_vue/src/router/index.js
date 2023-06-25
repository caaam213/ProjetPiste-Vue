import { createWebHistory, createRouter } from "vue-router";
// import Menu from '../views/menu/Menu';
import Action from '../views/action/AfficherActions.vue'
import AjouterActionForm from "@/views/action/AjouterAction.vue";
import AjouterAction from "@/views/action/AjouterAction.vue";
import ChoixApprenant from "@/views/jeu/choixApprenant.vue";
import listeJeuxPossiblesApprenant from "@/views/jeu/listerJeuxPossibles.vue";
import UtilisateurComponent from "@/components/utilisateur/UtilisateurComponent.vue";
import Jouer from "@/views/jeu/Jouer.vue";
import Missions from "@/views/mission/AfficherMissions.vue";
import AfficherApprenants from "@/views/apprenant/AfficherApprenants.vue";
import AjouterApprenant from "@/views/apprenant/AjouterApprenant.vue";
import ModifierApprenant from "@/views/apprenant/ModifierApprenant.vue";
import Accueil from "@/views/Accueil.vue";



const routes = [
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
        props: (route) => ({ idJeu: route.query.idJeu, idApprenant: route.query.idApprenant })
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
    // {
    //     path: '/mission/getAll/',
    //     name: 'Mission',
    //     component: Missions
    // },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
