import {HTTP} from "./http-commons";
import {API_PATH} from "../config/config";
import Qs from "qs";

const PaysService = {
    getPaysContinent: async function(c) {
        // eslint-disable-next-line no-useless-catch
        try {
            return await HTTP.getInstance()
                .get(`http://${API_PATH}/pays/getPaysContinent/${c}`)
                .then(response => Qs.parse(response.data))
        } catch (error) {
            throw error
        }
    },
}

export default PaysService
