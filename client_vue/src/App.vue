<!-- eslint-disable -->
<template>

    <div>
        <header>
            <Menu />
        </header>

        <router-view></router-view>

        <br/>

    </div>

</template>

<script>
import Menu from './views/menu/Navigation.vue'

export default {
    name: 'App',
    components: {
        Menu
    }
}
</script>
