<template>
    <form class="new-book-form" @submit.prevent="saveBook">
        <input
            class="title-input"
            v-model="title"
            type="text"
            placeholder="Title"
            required
            />
            <input
                class="author-input"
                v-model="author"
                type="text"
                placeholder="Author"
                required
                />
            <input
                class="isbn-input"
                v-model="isbn"
                type="text"
                placeholder="ISBN"
                required
                />
                <button type="submit">Save</button>
    </form>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
    setup() {
        const title = ref('');
        const author = ref('');
        const isbn = ref('');
        const store = useStore();

        const saveBook = () => {
            store.commit('addBook', {
                title: title.value,
                author: author.value,
                isbn: isbn.value,
                read: false
            });

            //Clear inputs
            title.value = '';
            author.value = '';
            isbn.value = '';
        };

        return {
            title,
            author,
            isbn,
            saveBook
        };
    }
};
</script>

<style>
.new-book-form {
    display: flex;
    justify-content: center;
    gap: 10px;
    margin-top: 20px;
}

.title-input,
.author-input,
.isbn-input {
    padding: 8px;
    font-size: 1rem;
}
</style>