<template>
    <div class="main">
      <div id="app">
       
        <site-header />
        
        <nav>
           <div>
             <router-link v-bind:to="{ name: 'home'}">Home</router-link>&nbsp;&nbsp;
             <router-link v-bind:to="{ name: 'products'}">View Products</router-link>
          </div>
           <div> 
              <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
              Logout
              </router-link>
              <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
           </div>            
        </nav>
        <main>
          <router-view />
        </main>
       
        <site-footer />  
       
      </div>
    </div>
</template>
<script>
import SiteHeader from './components/SiteHeader.vue';
import SiteFooter from './components/SiteFooter.vue';


export default {
    components:{
      SiteHeader,
      SiteFooter     
    }
  };

</script>
<style scoped>
  
    .main {
      font-family: "Avenir", Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
      max-width: 800px;
      margin: 10px auto 0 auto;
    }

    #app {
      display: grid;
      grid-template-areas:
        "header header"
        "nav nav"
        "main main"
        "footer footer";
      grid-template-columns: 1fr 1fr;
      grid-template-rows: auto auto 1fr auto;
      min-height: 98vh;
      justify-items: center;
      
    
    }

    /* Style the grid areas */
    header {
      grid-area: header;
      background-color: #f8f9fa;
      padding: 1rem;
    }

    nav {
      display: flex;
      align-items: center;
      justify-content: space-between;
      grid-area: nav;
      background-color: #e9ecef;
      /* padding: 1rem; */
      width:100%;
    } 

    main {
      grid-area: main;
      padding: 1rem;
    }

    footer {
      grid-area: footer;
      background-color: #f8f9fa;
      padding: 1rem;
      text-align: center;
    }
</style>