<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <nav>
      <router-link v-bind:to="{ name: 'TopicDetailsView', params: { topicId: topicId } }">Back to Topic Details</router-link>
    </nav>
    <message-details v-bind:message="message" />
  </div>
</template>

<script>
import MessageDetails from '../components/MessageDetails.vue';
import MessageService from '../services/MessageService.js';

export default {
  components: {
    MessageDetails,
  },
  data(){
    return {
      topicId: this.$route.params.topicId,
      message: {},
      isLoading: true
    }
  },
  methods: {
    getMessage(id) {
      
      // TODO - Get data from API and set `topics` property

      MessageService.get(id)
      .then(data => {
        this.message = data;
        this.isLoading = false;
      })
      .catch(error => {
        console.error('Failed to load message details', error);
      })

    },
  },
  created() {
    this.getMessage(this.$route.params.messageId);
  }
};
</script>

<style scoped>
</style>
