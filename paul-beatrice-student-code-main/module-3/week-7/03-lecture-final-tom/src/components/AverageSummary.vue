<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter(0)">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  methods: {
    updateFilter(newFilterLevel) {
      // update Filter in the Vuex Data Store USING A MUTATION!
      this.$store.commit('UPDATE_FILTER', newFilterLevel);
    }
  },
  computed: {
    averageRating() {
      const reviews = this.$store.state.reviews;
      
      if (reviews.length === 0) {
        return 0;
      }

      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>

<style scoped>
.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

.amount:hover {
  cursor: pointer;
}
</style>
