<template>
    <section>
        <h2>Product Reviews for {{ productName }} </h2>
        <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>

            <div class="well">
                <span class="amount">{{ oneStarReviews }}</span>
                1 Star Review
            </div>

            <div class="well">
                <span class="amount">{{ twoStarReviews }}</span>
                2 Star Review
            </div>

            <div class="well">
                <span class="amount">{{ threeStarReviews }}</span>
                3 Star Review
            </div>

            <div class="well">
                <span class="amount">{{ fourStarReviews }}</span>
                4 Star Review
            </div>

            <div class="well">
                <span class="amount">{{ fiveStarReviews }}</span>
                5 Star Review
            </div>
        </div>



        <div class="review" v-for="r in reviews" v-bind:key="r.id">
            <h4 @dblclick="clickHandler($event)">{{ r.reviewer }}</h4>
            <div class="rating" v-on:click="r.rating++">
                <img src="../assets/star.png" v-for="i in r.rating" v-bind:key="i" />
            </div>
            <h3>{{ r.title }}</h3>
            <p>{{ r.review }}</p>
        </div>
    </section>
</template>

<script>
export default {
    name: 'Product Review',
    data() {
        return {
            productName: 'Java For Dummies',
            description: 'Learn Java from a Dummy!',
            reviews: [
                {
                    id: 1000,
                    reviewer: 'R Pérez',
                    title: 'Approachable pattern guide',
                    review:
                        'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                    rating: 4,
                    favorited: false
                },
                {
                    id: 1001,
                    reviewer: 'Carmen',
                    title: 'Pattern complexity gone!',
                    review:
                        'I struggled for years to understand patterns and how to implement the design and how them. This is by far the best book to learn design patterns. I would give this 10 stars if I could.',
                    rating: 5,
                    favorited: false
                },
                {
                    id: 1002,
                    reviewer: 'J. King',
                    title: 'Not for me',
                    review:
                        'The content is thorough and well described. However, the format just doesn\'t work for me. I need something more traditional.',
                    rating: 1,
                    favorited: false
                },
                {
                    id: 1003,
                    reviewer: 'Safa H.',
                    title: 'Good for beginners',
                    review:
                        'Good introduction to design patterns especially if you have never used them before or are relatively new to OO principles.',
                    rating: 3,
                    favorited: false
                },
                {
                    id: 1004,
                    reviewer: 'L Wang',
                    title: 'Entertaining',
                    review:
                        'If you are new to design patterns I HIGHLY recommend this book. You might think it\'s not "serious enough" at first. But as you go through it things just stick. It makes learning enjoyable.',
                    rating: 4,
                    favorited: false
                }
            ],
        };
    },
    methods: {
        clickHandler(event) {
            console.log(event);
        }
    },
    computed: {
        averageRating() {
            let sum = 0;
            this.reviews.forEach((review) => {
                sum += review.rating;
            });

            return (sum / this.reviews.length).toFixed(2);
        },
        oneStarReviews() {
            return this.reviews.filter((review) => {
                if (review.rating === 1) {
                    return true;
                } else {
                    return false;
                }
            }).length;
        },
        twoStarReviews() {
            return this.reviews.filter((review) => {
                return review.rating === 2;
            }).length;
        },
        threeStarReviews() {
            return this.reviews.filter(r => r.rating === 3).length;
        },
        fourStarReviews() {
            return this.reviews.filter(r => r.rating === 4).length;
        },
        fiveStarReviews() {
            return this.reviews.filter(r => r.rating === 5).length;
        },

    }

}
</script>



<style scoped>
.main {
  margin: 1rem 0;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

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

.favorited {
  background-color: lightyellow;
}

.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

.rating img {
  height: 100%;
}

.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
.review p {
  margin: 20px;
}

.review h3 {
  display: inline-block;
}

.review h4 {
  font-size: 1rem;
}
</style>
