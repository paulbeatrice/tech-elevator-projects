<template>
  <div class="Home">
    <!-- Spinner ------ AutoTrigger On Page Load -->
     <LoadingSpinner v-if="isLoading" />

    <!-- CALL TO ACTION SECTION -->
     <section class="call-to-action">
      <div class="cta-content">
        <h1>Maximize Your Online Visibility</h1>
        <p>Custom SEO packages tailored to your brand, audience, and market.</p>
        <button class="cta-button">Get Started</button>
      </div>
     </section>

     <!-- Features Section -->
      <section class="features-grid">
        <div class="flip-card" v-for="(service, index) in services" :key="index">
          <div class="flip-card-inner">
            <!-- Front Side -->
             <div class="flip-card-front">
              <img: src="service.icon" alt="Service Icon" />
              <h3>{{service.title }}</h3>
             </div>
             <!-- Back Side -->
              <div class="flip-card-back">
                <p>{{ service.description }}</p>
              </div>
          </div>
        </div>
      </section>

      <!-- Rotating Testimonial Section -->
       <section class="testimonial-highlight">
        <transition name="fade" mode="out-in">
        <blockquote :key="currentTestimonialIndex" class="testimonial">
          <p>{{ currentTestimonial.quote }}</p>
          <footer>- {{ currentTestimonial.author }}</footer>
        </blockquote>
      </transition>
       </section>

       <!-- Tailored Solutions Section -->
        <section class="industry-section">
          <h2 class="industry-title">Tailored Solutions For Your Industry</h2>
          
          <div class="industry-slider-wrapper">
            <button class="scroll-button-left" @click="scrollLeft">&#10094;</button>

            <div class="industry-slider" ref="industrySlider">
              <div class="industry-card" v-for="(industry, index) in industries" :key="index">
                <img :src="industry.icon" :alt="industry.name" />
                <p>{{  industry.name }}</p>
            </div>
            </div>

            <button class="scroll-button-right" @click="scrollRight">&#10095;</button>
          </div>
        </section>

        <!-- Contact Section -->

        <section class="contact-section">
          <div class="contact-container">
            <!-- Left Side - CTA and Info -->
             <div class="contact-info">
              <h2 class="contact-title">Your Next Customer Is Searching. Let's Help Them Find You!</h2>
              <p class="contact subtitle">Connect With Our Team Today.</p>
              <p class="contact-detail"><strong>Phone:</strong> (859) 456-3144</p>
              <p class="contact-detail"><strong>Email:</strong> paul@ascendseo.com</p>

              <!-- Business Meeting Img -->
              <div class="contact-image">
                <img src="/img/businessmeeting.jpg" alt=" Business Meeting" />
             </div>
              </div>

             <!-- Right Side Contact Info Form -->
              <form class="contact-form" @submit.prevent="submitForm">
                <input type="text" v-model="form.name" placeholder="Your Name *" required />
                <input type="email" v-model="form.email" placeholder="Your Email *" required />
                <input type="tel" v-model="form.phone" placeholder="Your Phone Number *" required />
                <input type="text" v-model="form.businessName" placeholder="Your Business Name *" required />
                <input type="text" v-model="form.businessWebsite" placeholder="Your Business Website (optional)" />

                <div class="social-field-group">
                  <select v-model="form.socialPlatform">
                    <option disabled value="">Select Social Media Platform (optional)</option>
                    <option>Facebook</option>
                    <option>Instagram</option>
                    <option>LinkedIn</option>
                    <option>X</option>
                    <option>Youtube</option>
                    <option>Other</option>
                  </select>
                  <input type="text" v-model="form.socialLink" placeholder="Social Media Handle or Link (optional)" />
                </div>

                <textarea v-model="form.message" placeholder="Message"></textarea>
                <button type="submit">Submit</button>

                <p v-if="submitted" style="color: green;">Thank you! We'll be in touch soon.</p>
                <p v-if="error" style="color: red;">Something went wrong. Please try again.</p>
              </form>
          </div>
        </section>

     <!-- Loading Spinner Section -->
      <div class="spinner-toggle">
      </div>
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";

export default {
 name: "HomeView",
 components: {
  LoadingSpinner
 },
 data() {
  return {
    isLoading: true,
    cardView: true,
    form: {
      name: '',
      email: '',
      phone: '',
      businessName: '',
      businessWebsite: '',
      socialPlatform: '',
      socialLink: '',
      message: ''
    },
    submitted: false,
    error: false,
    services: [
      {
        title: "Scale Sustainably",
        icon: "/assets/web-dev-icon.png",
        description: "Our growth strategies are built for the long haul. We will help you scale without sacrificing stability, quality, or customer experience.",
      },
      {
        title: "Outshine Competitors",
        icon: "/assets/competitor-icon.png",
        description: "Gain a competitive edge with data driven insights and standout content that sets you brand apart in search results and online visibility.",
      },
      {
        title: "Drive Traffic",
        icon: "/assets/traffic-icon.png",
        description: "Through targeted SEO, we attract the right visitors to your site and turn them into loyal customers.",
      },
      {
        title: "Maximize SEO ROI",
        icon: "/assets/roi-icon.png",
        description:
        "Get the most out of your SEO investment with transparent performance tracking, continuous optimization, and expert strategy alignment.",
      },
    ],
    industries: [
      {name: "Architects", icon: "/assets/landmark-solid.svg"},
      {name: "Landscaping", icon: "/assets/seedling-solid.svg"},
      {name: "Insurance", icon: "/assets/car-burst-solid.svg"},
      {name: "Law Firms", icon: "/assets/scale-balanced-solid.svg"},
      {name: "Auto Mechanic", icon: "/assets/wrench-solid.svg"},
      {name: "Travel Agency", icon: "/assets/plane-departure-solid.svg"},
      {name: "Social Media", icon: "/assets/hashtag-solid.svg"},
      {name: "Artist", icon: "/assets/palette-solid.svg"},
      {name: "Photographer", icon: "/assets/camera-solid.svg"},
      {name: "Construction", icon: "/assets/helmet-safety-solid.svg"},
      {name: "IT", icon: "/assets/computer-solid.svg"},
    ],
    testimonials: [
      {
        quote:
          "Working with this team was a game changer. Our site traffic has skyrocketed and bounce rates have dropped thanks to the fast load times.",
          author: "Lisa M., Marketing Manager at Beatrice Food Co.",
      },
      {
        quote: "They helped us improve search rankings for high-value keywords in less than 60 days. Impressive results!",
        author: "Ravi S., E-Commerce Director at Nova Solar Installations",
      },
      {
        quote: "Their technical SEO audit uncovered issues we never knew were occurring with our site. Performance and Visibility have improved significantly.",
        author: "David T., CMO at Pixelated Designs",
      },
      {
        quote: "We have seen a 45% increase in organic traffic and even larger numbers in local search after signing up for their social media plan.",
        author: "Andrew S., Co-Founder of After Hours Coffee Co.",
      },
      {
        quote: "Professional, responsive, and quick results. Wish I would have used them sooner.",
        author: "Derek L., VP of Growth at ABC Holdings",
      },
    ],
    currentTestimonialIndex: 0,
  };
  },

  computed: {
    currentTestimonial() {
      return this.testimonials[this.currentTestimonialIndex];
    },
  
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },

  mounted() {
    setTimeout(() => {
      this.isLoading = false;
    }, 3000); //Spinner disappears after 3 seconds
  
    setInterval(() => {
      this.currentTestimonialIndex =
      (this.currentTestimonialIndex + 1) % this.testimonials.length;
    }, 5000);  //Rotate every 5 seconds
  },

  methods: {
      scrollLeft() {
        this.$refs.industrySlider.scrollBy({
          left: -300,
          behavior: 'smooth'
        });
      },
      scrollRight() {
        this.$refs.industrySlider.scrollBy({
          left: 300,
          behavior: 'smooth'
        });
      },
      async submitForm() {
        try {
          const response = await fetch('/api/contact-submissions', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.form)
          });
          if (response.ok) {
            this.submitted = true;
            this.error = false;
            this.resetForm();
          } else {
            this.error = true;
            const errorText = await response.text();
            console.error('Submission failed:', errorText);
          }
        } catch (error) {
          this.error = true;
          console.error('Network error:', error);
        }
      },
        resetForm() {
          this.form = {
            name: '',
            email: '',
            phone: '',
            businessName: '',
            businessWebsite: '',
            socialPlatform: '',
            socialLink: '',
            message: ''
          };
        }
      }
};
 
</script>

<style scoped>
#spinner {
  color: #EF8354;
}

.call-to-action {
  background-color: #FFFFFF;
  text-align: center;
  padding: 4rem 2rem;
  color: #2D3142;
}

.cta-content h1 {
  font-size: 2.5rem;
  color: #2D3142;
}

.cta-content p {
  font-size: 1.2rem;
  color: #4F5D75;
  margin: 1rem 0 2rem 0;
}

.cta-button {
  background-color: #EF8354;
  color: #FFFFFF;
  border: none;
  padding: 1rem 2rem;
  font-size: 1rem;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.cta-button:hover {
  background-color: #d56b3a;
}

.load-spinner {
  transition-property: opacity;
  transition-duration: 400ms;
  font-size: 2rem;
  color: #EF8354;
  display: block;
  margin: 2rem auto;
}

.features-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 2rem;
  padding: 4rem 2rem;
  background-color: #f5f5f5;
}

.flip-card {
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px;
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

.flip-card:hover .flip-card-inner {
  transform: rotatey(180deg);
}

.flip-card-front,
.flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  border-radius: 12px;
  backface-visibility: hidden;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 1.rem;
  text-align: center;
}

.flip-card-front {
  background-color: #FFFFFF;
}

.flip-card-front img {
  width: 80px;
  height: 80px;
  margin-bottom: 1rem;
}

.flip-card-front h3 {
  color: #2d3142;
  font-size: 1.2rem;
}

.flip-card-back {
  background: linear-gradient(to bottom right, #2d3142, #4f5d75);
  color: white;
  transform: rotatey(180deg);
  font-size: 1rem;
  padding: 2rem;
}

/* Fade Transition */

.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s ease-in-out;
}

.fade-enter-from, .fade-leave-to {
  opacity: 0;
}

/* Testimonial Styles */

.testimonial {
  position: relative;
  height: 150px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transition: opacity 0.5s ease;
  text-align: center;
  padding: 0 1rem;
}

.testimonial p, .testimonial footer {
  margin: 0;
  padding: 0;
}

.testimonial p {
  line-height: 1.4;
  white-space: pre-wrap;
}

.testimonial-highlight {
  background: linear-gradient(to bottom right, #2d3142, #4f5d75);
  color: white;
  padding: 4rem 2rem;
  text-align: center;
  font-size: 1.2rem;
}

.testimonial-highlight blockquote {
  max-width: 800px;
  margin: 0 auto;
}

.testimonial-highlight footer {
  margin-top: 1rem;
  color: #EF8354;
  font-weight: bold;
}

/* Styling For Industry Section */

.industry-section {
  background-color: #f5f5f5;
  padding: 4rem 2rem;
  text-align: center;
}

.industry-title {
  font-size: 2rem;
  margin-bottom: 2rem;
  color: #2D3142;
}

.industry-slider-wrapper {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
}

.scroll-button-left,
.scroll-button-right {
  background: none;
  border: none;
  font-size: 2rem;
  cursor: pointer;
  color: #4F5D75;
  z-index: 2;
}

.industry-slider {
  display: flex;
  overflow-x: auto;
  scroll-behavior: smooth;
  gap: 1.5rem;
  padding: 1rem;
  max-width: 90%;
  overflow-x: auto;
  scrollbar-width: none;
}

.industry-slider::-webkit-scrollbar {
  display: none;
}

.industry-card {
  background-color: #FFFFFF;
  border-radius: 10px;
  min-width: 180px;
  max-width: 180px;
  flex: 0 0 auto;
  padding: 1.5rem;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  text-align: center;
  transition: transform 0.3s ease;
}

.industry-card:hover {
  transform: translateY(-5px);
}

.industry-card img {
  width: 60px;
  height: 60px;
  object-fit: contain;
  margin-bottom: 1rem;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.industry-card p {
  color: #2D3142;
  font-weight: 600;
}

/* Contact Info Submission Styling */

.contact-section {
  background-color: #2d3142;
  color: #FFFFFF;
  padding: 4rem 2rem;
}

.contact-container {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  justify-content: space-between;
  align-items: flex-start;
  max-width: 1200px;
  margin: 0 auto;
}

.contact-info {
  display: flex;
  flex-direction: column;
  justify-content: center;
  flex: 1 1 60%;
}

.contact-info h2 {
  font-size: 2rem;
  margin-bottom: 1.5rem;
}

.contact-detail {
  font-size: 1rem;
  margin-bottom: 1rem;
}

.contact-form {
  flex: 1 1 45%;
  max-width: 600px;
  background: #FFFFFF;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
}

.contact-form input,
.contact-form textarea,
.contact-form select {
  padding: 1rem;
  font-size: 1rem;
  border: 1px solid #BFC0C0;
  border-radius: 6px;
  width: 100%;
  font-family: inherit;
  color: #2D3142;
  margin-bottom: 1rem;
}

.contact-form textarea {
  resize: none;
  height: 100px;
}

.contact-form button {
  background-color: #EF8354;
  color: #FFFFFF;
  padding: 0.75rem 2rem;
  font-size: 1rem;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background 0.3s ease;
}

.contact-form button:hover {
  background-color: #d46c3e;
}

.scroll-field-group {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.social-field-group select,
.social-field-group input {
  flex: 1 1 48%;
}

/* Business Meeting Img Styling */

.contact-image {
  margin-top: 2rem;
  text-align: center;
  max-width: 100%;
}

.contact-image img {
  width: 100%;
  max-width: 500px;
  height: auto;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}


@media (min-width: 768px) {
  .contact-container {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    gap: 2rem;
  }

  .contact-info,
.contact-image {
  flex: 1;
  }
}



</style>