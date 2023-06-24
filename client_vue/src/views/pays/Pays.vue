<!-- eslint-disable -->
<!--<template>
    <div class="container table-responsive">
        <table class="table table-bordered table-striped  table-primary">
            <thead>
            <tr>
                <th scope="col">Nom Pays</th>
                <th scope="col">Capitale</th>
                <th scope="col">Continent</th>
                <th scope="col">Nombre habitants</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="unPays in mesPays" :key="unPays.NOM_PAYS">
                <td>{{ unPays.NOM_PAYS }}</td>
                <td>{{ unPays.NOM_CAPITALE }}</td>
                <td>{{ unPays.NOM_CONTINENT }}</td>
                <td class="text-right">
                    {{ unPays.NB_HABITANTS }}
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</template>-->

<template>
    <h1 class="text-center">{{titre}}</h1>
    <div class="container table-responsible">
        <table class="table table-bordered table-striped table-primary">
            <thead>
            <tr>
                <th scope="col">Nom Pays</th>
                <th scope="col">Capitale</th>
                <th scope="col">Nombre habitants</th>
            </tr>
            </thead>

            <tbody>
            <tr v-for="unP in mesPaysAsie" :key="unP[0]">
                <td class="text-center">{{unP[0]}}</td>
                <td>{{unP[1]}}</td>
                <td class="text-right">
                    {{unP[2]}}
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {computed, ref} from 'vue'
import tousLesPays from '@/data/pays.js'
import {mapActions, mapGetters} from "vuex";

export default {
    name: "Pays",
    data() {
        return{
            titre:String,
            continent:String,
        }
    },
    created(){
        this.titre = "Affichage des pays";
        this.continent="asie";
        this.appleListePays(this.continent);
    },
    computed: {
        ...mapGetters('unPays', {mesPaysAsie: 'getPaysContinent'}),
    },
    methods: {
        ...mapActions('unPays', {fetchPaysStore: 'fetchPays'}),
        async appleListePays(continent) {
            this.fetchPaysStore(continent)
        },
    },


}

</script>
