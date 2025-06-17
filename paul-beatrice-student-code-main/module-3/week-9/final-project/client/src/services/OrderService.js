import axios from "axios";

const API_URL = '/api/orders';

export default {
    getAllOrders() {
        return axios.get(API_URL);
    },
    updateOrderStatus(orderId, status) {
        return axios.patch(`${API_URL}/${orderId}/status?status=${status}`);
    }
};