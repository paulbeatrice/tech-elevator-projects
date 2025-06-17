<template>
   <header class="app-header">
       <div class="actions">
            <router-link v-bind:to="{ name: 'products' }" class="btn btn-outline-success btn-sm">Back to Products</router-link>&nbsp;
            <router-link v-bind:to="{ name: 'add-review', params: { id: product.id } }" class="btn btn-outline-success btn-sm">Add Review</router-link>
        </div>
    </header>
</template>

<script>
export default {
    name: 'LeftNav'

}
</script>

<style scoped>
    .actions {
        margin: 2rem;
    }
</style>