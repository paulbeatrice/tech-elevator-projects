<template>
  <div class="card" :class="{ read: book.read }">
    <img
    class="book-image"
    :src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"
    :alt="book.title"
    />
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <button 
      :class="book.read ? 'mark-unread' : 'mark-read'"
      @click="toggleRead"
      >{{ book.read ? 'Mark Unread' : 'Mark Read' }}</button>
  </div>
</template>

<script>

import { useStore } from 'vuex';

export default {
  props: ['book'],
  setup(props) {
    const store = useStore();

    const toggleRead = () => {
      store.commit('toggleReadStatus', props.book.isbn);
    };
    return {
      toggleRead
    };
  }
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read, .mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>