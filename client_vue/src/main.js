import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import store from "@/store";
import router from "@/router";

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'

createApp(App).
use('#app').use(router).
use(store).mount('#app')

