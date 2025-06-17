import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      filter: 0,
      nextReviewId: 1005,
      products: [
        {
          id: 0,
          name: '',
          description: '',
          reviews: []
        }
      ]        
    },
    mutations: {
      ADD_REVIEW(state, review) {
        const product = state.products.find(p => p.id == review.productId);
        review.id = state.nextReviewId++;
        product.reviews.unshift(review);
      },

      UPDATE_FILTER(state, filter) {
        state.filter = filter;
      },

      FLIP_FAVORITED(state, reviewToChange) {
        reviewToChange.favorited = ! reviewToChange.favorited;
      },

      SET_PRODUCTS(state, products) {
        state.products = products;
      },

      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },

      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },

      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
    

  })
  return store;
}