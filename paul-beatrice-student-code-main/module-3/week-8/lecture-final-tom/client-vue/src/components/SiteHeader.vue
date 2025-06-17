<template>
   <header class="app-header">
        <div class="logo-container">
            <img src="../assets/Logo.png" alt="Product Review Logo" class="logo">
            <h1 class="app-title">Product Reviews App</h1>            
        </div>
    </header>
</template>

<script>
export default {
    name: 'SiteHeader'
}
</script>

<style scoped>
    .app-header {
        background-color: #1f1f1f;
        color: white;
        display: flex;
        align-items: center;
        padding: 10px 20px;
        height: 60px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        width:100%;
    }

    .logo-container {
        display: flex;
        align-items: center;
    }

    .logo {
        height: 40px;
        width: auto;
        margin-right: 10px;
    }
</style>