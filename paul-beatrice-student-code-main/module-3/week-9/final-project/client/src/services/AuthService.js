import axios from 'axios';

const API_BASE_URL = import.meta.env.VITE_REMOTE_API;

export default {

  login(user) {
    return axios.post(`${API_BASE_URL}/login`, user);
  },

  register(user) {
    return axios.post(`${API_BASE_URL}/register`, user);
  }

}
