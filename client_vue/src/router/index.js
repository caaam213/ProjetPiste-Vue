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
import AfficherResultats from "@/views/jeu/afficherResultats.vue";


const routes = [

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
        path:'/jeu/afficherResultats',
        name: 'AfficherResultats',
        component: AfficherResultats
    }

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
