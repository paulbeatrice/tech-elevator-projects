import axios from 'axios';

export default {
    getAllUsers() {
        return axios.get('/api/users'); // Hits the spring boot backend controller
    },
    
    deleteUser(userId) {
        return axios.delete(`/api/users/${userId}`);
    },

    updateUser(id, user) {
        return axios.put(`/api/users/${id}`, user);
    }

};