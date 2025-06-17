<template>
  <h1>Products</h1>
  <products-list v-if="!isLoading" />
  <img src="../assets/ping_pong_loader.gif" v-else />
  <p>Owen Wilson says:</p>
  <p>{{ wowQuote }}</p>
</template>

<script>
import ProductsList from "../components/ProductsList.vue";
import productService from '../services/ProductService.js';
import owenService from '../services/OwenWilsonWOWService.js';

export default {
  data(){
    return{
      products: [],
      isLoading: false,
      wowQuote: ''
    }
  },
  components: {
    ProductsList
  },
  
    methods:{
       setProducts(products) {
          this.$store.commit('SET_PRODUCTS', products);
        },
    },

    // Vue Lifecycle Hook
    created() {
      owenService.getRandomWow().then((response) => {
        this.wowQuote = response.data[0].full_line;
      });

        productService.getAllProducts()
          .then((response) => {
            // Add a flag for editing state to each product
            this.products = response.data
            .map(product => ({
              ...product,
              isEditing: false,
            }));

            this.isLoading = false;
                                    
            this.setProducts(this.products);
          })
           .catch(error => {
              if (error.response) {
                  console.error(`Error getting products. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error getting products. Server could not be reached.', error);
              } else {
                  console.error('Error getting products. Request could not be created.', error);
              }
              
            });
      },
};
</script>
