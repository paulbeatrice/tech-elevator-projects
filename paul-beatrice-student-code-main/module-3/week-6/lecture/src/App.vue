<template>
  <section class="main">
    <img alt="Vue logo" src="./assets/logo.png" />
    <ProductReview></ProductReview>
  </section>
</template>

<script>
 // Step 1: Import 
import ProductReview from './components/ProductReview.vue';

export default {
  components: {       // HERE is the KEY
    ProductReview       // HERE is the value        // Step 2: Register it in components section of export statement
  }
}
</script>

<style>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
