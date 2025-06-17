<template>
  <div class="main">
    <nav>
      <router-link to="/">Home</router-link>
      &nbsp;|&nbsp;
      <router-link to="/about">About</router-link>
      &nbsp;|&nbsp;
      <router-link to="/items/1">See Item #1</router-link>

    </nav>

    <router-view />


  </div>
</template>

<script>
export default {};
</script>

<style>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
