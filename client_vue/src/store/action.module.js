/* no-unused-varso* */
import ActionService from "../service/action.service";

const state = {
        mesActions:[]
    },
    mutations = {
        getActionsSuccess(state, data) {
            state.mesActions = data
        },
        getActionsFailure(state, error) {
            state.mesActions = error
        },
    };


const actions = {
    async fetchActions({commit}, c) {
        try {
            const mesActions = await ActionService.getAllActions()
            commit('getActionsSuccess', mesActions)
        } catch (e) {
            commit('getActionsFailure', {error: e})
            return false
        }
    }

};


const getters =
    {
        getAllActions: (state) => {
            return state.mesActions
        },
    };

export const action = {
    namespaced: true,
    getters,
    state,
    actions,
    mutations
};