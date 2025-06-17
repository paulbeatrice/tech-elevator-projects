import { createStore as _createStore } from 'vuex';
import bookData from '../assets/data/books';

export function createStore() {
  return _createStore({
    state() {
      return {
        books: bookData
      };
    },
    mutations: {
      toggleReadStatus(state, isbn) {
        const book = state.books.find(b => b.isbn === isbn);
        if (book) book.read = !book.read;
      },
      addBook(state, newBook) {
        state.books.push(newBook);
      }
    },
    strict: true
  });
}

