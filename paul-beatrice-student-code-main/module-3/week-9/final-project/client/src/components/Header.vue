
<template>
    <header class="site-header">
        <nav class="navbar">
            <div class="logo">LOGO</div>
            <ul class="nav-links">
                <li><router-link to="/services">Services</router-link></li>
                <li><router-link to="/pricing">Pricing</router-link></li>
                <li><router-link to="/contact">Contact Us</router-link></li>
                <li>
                    <button @click="goHome" class="home-button">Home</button>
                </li>
                <li><font-awesome-icon :icon="['fas', 'user']" title="Account" /></li>      <!-- wanted to use the font-awesome user Icon on Homepage Nav Bar -->
            </ul>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'Header',
    methods: {
        goHome() {
            this.$store.commit('LOGOUT');
            this.$router.push('/');
        }
    }
};
</script>

<style scoped>
.site-header {
    background-color: #2D3142;
    padding: 1rem;
    color: #FFFFFF; 
}

.nav-links button.home-button {
    background: none;
    border: none;
    color: white;
    font-size: 1rem;
    cursor: pointer;
    padding: 0;
    margin-left: 1rem;
}

.nav-links button.home-button:hover {
    text-decoration: underline;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo {
    font-size: 1.5rem;
    font-weight: bold;
    color: EF8354; /* Coral */
}

.nav-links {
    list-style: none;
    display: flex;
    gap: 1.5rem;
    margin: 0;
    padding: 0;
}

.nav-links li {
    color: #FFFFFF;
    text-decoration: none;
}

.nav-links li a {
    color: #FFFFFF;
    text-decoration: none;
}

.nav-links li:hover a {
    color: EF8354;
}

.font-awesome-icon {
    color: #FFFFFF;
    cursor: pointer;
}

</style>
