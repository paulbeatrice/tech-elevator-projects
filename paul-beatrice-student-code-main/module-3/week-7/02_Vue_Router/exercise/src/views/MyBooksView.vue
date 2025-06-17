<template>
    <div>
        <ReadingList />
        <router-link to="/addBook">Add Book to ReadingList</router-link>
    </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue';

export default {
    components: {
        ReadingList
    }
}
</script>