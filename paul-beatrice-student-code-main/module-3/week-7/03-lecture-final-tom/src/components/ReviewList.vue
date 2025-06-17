<template>
  <div>
    <review-display
      v-for="r in filteredReviews"
      v-bind:key="r.id"

      v-bind:review="r"
    />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue';

export default {
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      const reviewsFilter = this.$store.state.filter;
      const reviews = this.$store.state.reviews;
      return reviews.filter(review => {
        return reviewsFilter === 0 || reviewsFilter === review.rating;
      });
    }
  }
};
</script>
