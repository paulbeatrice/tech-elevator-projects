<template>
    <div v-if="book">
        <h1>{{ book.title }}</h1>
        <h2>{{ book.author }}</h2>
        <img :src="book.coverImageUrl" alt="Book Cover" v-if="book.coverImageUrl" />
        <p>Number of pages: {{ book.numPages }}</p>
        <p>
            <a :href="book.moreInfoLink" target="_blank">More Information</a>
        </p>
        <p v-if="book.read">I have read this book</p>
        <p v-else>I have not read this book yet</p>
    </div>
</template>

<script>
export default {
    props: ['isbn'],
    computed: {
        book() {
            if (!this.$store || !this.$store.state || !this.$store.state.readingList) {
                return null;
            }
            return this.$store.state.readingList.find(book => book.isbn === this.isbn);
        }
    }
}
</script>