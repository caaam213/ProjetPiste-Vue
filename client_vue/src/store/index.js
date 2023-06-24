import { createStore } from 'vuex'
import { action } from './action.module'


export default createStore({
    modules:{
        uneAction : action,
    },
})