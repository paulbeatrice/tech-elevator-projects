<template>
  <div id="book-app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/myBooks">My Books</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App'  
}
</script>

<style>
#book-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
