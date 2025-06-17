<template>
  <div id="cart-app">
    <Header />
    <nav>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </nav>
    <main>
      <router-view />
    </main>
    <footer></footer>
  </div>
</template>

<script>
import Header from './components/Header.vue';

export default {
  name: 'App',
  components: {
    Header
  }
};
</script>

<style scoped>
#cart-app {
  font-family: 'Segoe UI', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #2D3142;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

main {
  flex: 1;
  padding: 1rem;
}

nav {
  padding: 0.5rem 1rem;
  background-color: #BFC0C0;
  color: #2D3142;
  text-align: right;
}

nav a {
  color: #2D3142;
  margin-left: 1rem;
  text-decoration: none;
  font-weight: bold;
}

nav a:hover {
  color: #EF8354;
}

</style>