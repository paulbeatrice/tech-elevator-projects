<template>
  <section class="main">
    <img alt="Vue logo" src="./assets/logo.png" />
    
    <!-- Step 3: Use (in HTML) -->
    <ProductReview />

  </section>
</template>

<script>
import ProductReview from './components/ProductReview.vue';  // Step 1: Import

export default {
  components: {
    ProductReview     // Step 2: Register
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
