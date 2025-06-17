<template>
  <div>
      <h1>You are now looking at Item #{{ $route.params.id }}</h1>

      <div @click="navigateHome">Click here to go back home!</div>
  </div>
</template>

<script>
export default {

    methods: {
        navigateHome() {
            alert('Leaving: ' + this.$route.href);
            this.$router.push({ path: "/about"});
        }
    }
}
</script>

<style>

</style>