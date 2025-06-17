import axios from 'axios';

const owenService = {

    getRandomWow() {
      return axios.get('https://owen-wilson-wow-api.onrender.com/wows/random');
    },  

};
  
export default owenService;