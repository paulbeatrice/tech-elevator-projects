<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
      <label for="title">Title</label>
      <input type="text" id="title" name="title" v-model="editTopic.title" />
    </div>
    <div class="actions">
      <button class="btn-submit" type="submit">Submit</button>
      <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
    </div>
  </form>
</template>

<script>

import TopicService from "../services/TopicService";

export default {
  props: {
    topic: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      // Since props are read-only, don't bind to props directly. 
      // Instead, initialize a new object with the same property values.
      editTopic: {
        id: this.topic.id,
        title: this.topic.title,
        date: this.topic.date,
      }
    };
  },
  methods: {
  async submitForm() {
      if (!this.validateForm()) {
        return;
      }

      try {
        let response;

        if (this.editTopic.id === 0) {
          //Add new topic
          response = await TopicService.create(this.editTopic);
          if (response.status === 201) {
            this.$router.push({ name: "HomeView" });
          } else {
            this.handleErrorResponse(response, "adding");
          }
        } else {
          //EDIT existing topic
          response = await TopicService.update(this.editTopic.id, this.editTopic);
          if (response.status === 200) {
            this.$router.push({
              name: "TopicDetailsView",
              params: { id: this.editTopic.id }
            });
          } else {
            this.handleErrorResponse(response, "updating");
          }
        }
      } catch (error) {
        this.handleErrorResponse(error, this.editTopic.id === 0 ? "adding" : "updating");
      }
    },
    cancelForm() {
      // Go back to previous page
      this.$router.back();
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.$store.commit('SET_NOTIFICATION',
          `Error ${verb} topic. Response received was "${error.response.statusText}".`);
        }
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} topic. Server could not be reached.`);
      } else {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} topic. Request could not be created.`);
      }
    },
    validateForm() {
      let msg = '';

      this.editTopic.title = this.editTopic.title.trim();
      if (this.editTopic.title.length === 0) {
        msg += 'The new topic must have a title. ';
      }

      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    },
  }
};
</script>

<style>
form {
  padding: 20px;
  font-size: 16px;
}
form * {
  box-sizing: border-box;
  line-height: 1.5;
}
.field {
  display: flex;
  flex-direction: column;
}
.field label {
  margin: 4px 0;
  font-weight: bold;
}
.field input,
.field textarea {
  padding: 8px;
  font-size: 18px;
}
.field textarea {
  height: 300px;
}
.actions {
  text-align: right;
  padding: 10px 0;
}
</style>
