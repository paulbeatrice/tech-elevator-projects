<template>
  <form v-on:submit.prevent="addNewReview">
    <h3>{{ product.name }}</h3>
    <div class="form-element">
      <label for="reviewer">Name:</label>
      <input id="reviewer" type="text" v-model="newReview.reviewer" />
    </div>
    <div class="form-element">
      <label for="title">Title:</label>
      <input id="title" type="text" v-model="newReview.title" />
    </div>
    <div class="form-element">
      <label for="rating">Rating:</label>
      <!-- NOTE: Use .number modifier here so newReview.rating is a number, not a string -->
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>
    <div class="form-element">
      <label for="review">Review</label>
      <textarea id="review" v-model="newReview.review"></textarea>
    </div>
    <input type="submit" value="Save" class="btn btn-primary btn-sm" />
    <input type="button" value="Cancel" v-on:click="resetForm" class="btn btn-cancel btn-sm" />
  </form>
</template>

<script>
    import productService from '../services/ProductService';
    import reviewService from '../services/ReviewService';

    export default {
      name: 'AddReview',
      props: ['productId'],
      data() {
        return {      
          newReview: {}
        };
      },
      computed: {
        product() {
          let product = this.$store.state.products.find(p => p.id == this.productId);
          return product;
        },
      },
      methods: {
        addNewReview() {
          this.newReview.productId = this.productId;
          //this.$store.commit('ADD_REVIEW', this.newReview);
          reviewService.createReview(this.newReview)
            .then(response => {
              if (response.status === 200 || response.status === 201) {
                this.getProducts();
                // Send the visitor back to the product page to see the new review
                this.$router.push({ name: 'product-detail', params: { id: this.productId } });
              }
            })
            .catch(error => {
              if (error.response) {
                  console.error(`Error adding review. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error adding review. Server could not be reached.', error);
              } else {
                  console.error('Error adding review. Request could not be created.', error);
              }
              
            });
        },
        resetForm() {
          this.newReview = {};
          // OPTIONAL: send the visitor back to the product page
          this.$router.push({ name: 'product-detail', params: { id: this.productId } });
        },
        getProducts() {
          productService.getAllProducts()
            .then(response => {
              this.products = response.data;
              this.setProducts(this.products);
            })
            .catch(error => {
              console.error('Error fetching products:', error);
            });
        },
        setProducts(products) {      
          this.$store.commit('SET_PRODUCTS', products);
        }
      }
    };
</script>


<style scoped>
    .form-element {
      margin-top: 10px;
    }

    .form-element label {
      display: block;
    }

    .form-element input,
    .form-element select {
      height: 30px;
      width: 300px;
    }

    .form-element textarea {
      height: 60px;
      width: 300px;
    }

    form input[type=button] {
      width: 100px;
    }

    form input[type=submit] {
      width: 100px;
      margin-right: 10px;
    }
</style>
