<template>
    <div>
        <header>
            <Menu/>
        </header>

        <router-view></router-view>
    </div>
</template>

<script>
import Menu from './views/menu/Navigation.vue'

export default {
    name: 'App',
    components: {
        Menu
    },

}
</script>


