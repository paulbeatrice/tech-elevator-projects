import axios from 'axios';

const reviewService = {
    getAllReviews() {
      return axios.get('/reviews');
    },
  
    getReviewById(id) {
      return axios.get(`/reviews/${id}`);
    },
  
    createReview(review) {      
      return axios.post('/reviews', review);
    },
  
    updateReview(id, review) {
      return axios.put(`/reviews/${id}`, review);
    },
  
    deleteReview(id) {
      return axios.delete(`/reviews/${id}`);
    },
  
    getReviewsByProductId(productId) {
      return axios.get(`/reviews/product/${productId}`);
    },
  };
  
  export default reviewService;