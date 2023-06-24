
import { HTTP } from "./http-commons";
import { API_PATH } from "../config/config";
import Qs from "qs";

const ActionService = {
    getAllActions: async function () {
        try {
            const response = await HTTP.getInstance().get(`http://${API_PATH}/action/getAll/`);
            const parsedData = Qs.parse(response.data);
            return parsedData;
        } catch (error) {
            throw error;
        }
    },
    addAction: async function (action) {
        try {
            const response = await HTTP.getInstance().post(`http://${API_PATH}/action/add`, action);
            const parsedData = Qs.parse(response.data);
            return parsedData;
        } catch (error) {
            throw error;
        }
    }
};

export default ActionService;