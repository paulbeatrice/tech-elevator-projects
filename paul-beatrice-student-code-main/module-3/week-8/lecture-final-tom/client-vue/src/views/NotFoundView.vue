<template>
  <div class="not-found">
    <h1>404 - Not Found</h1>
    <p>The page you are looking for doesn't exist.</p>
    <!-- <router-link to="/">Go back home</router-link> -->
    <router-link v-bind:to="{ name: 'products'}">Go back home</router-link>
  </div>
</template>

<script>
export default {
  name: 'NotFoundView'
}
</script>

<style scoped>
.not-found {
  text-align: center;
  padding: 2rem;
}
.not-found h1 {
  font-size: 3rem;
  margin-bottom: 1rem;
}
.not-found p {
  font-size: 1.5rem;
  margin-bottom: 2rem;
}
</style>
