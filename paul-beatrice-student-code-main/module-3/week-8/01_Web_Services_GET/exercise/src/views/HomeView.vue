<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <header class="flex">
      <h1>Topics</h1>
    </header>
    <topic-list v-bind:topics="topics"/>
  </div>
</template>

<script>
import TopicList from '../components/TopicList.vue';
import TopicService from '../services/TopicService';

export default {
  components: {
    TopicList
  },
  data() {
    return {
      topics: [],
      isLoading: true
    };
  },
  methods: {
    getTopics() {

      // TODO - Get data from API and set `topics` property

      TopicService.list()
      .then(data => {
        this.topics = data;
        this.isLoading = false;
      })
      .catch(error => {
        console.error('Failed to load topics', error);
      });

    },
  },
  created() {
    this.getTopics();
  }
}
</script>

<style scoped>
</style>