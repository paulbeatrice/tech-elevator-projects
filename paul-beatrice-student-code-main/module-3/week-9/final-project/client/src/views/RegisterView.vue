<template>
  <div class="register-container">
    <form v-on:submit.prevent="register" class="register-form">
      <h2>Create Account</h2>

      <input type="text" placeholder="Username" v-model="user.username" required />
      <input type="text" placeholder="Name" v-model="user.name" required />
      <input type="password" placeholder="Password" v-model="user.password" required />
      <input type="password" placeholder="Confirm Password" v-model="user.confirmPassword" required />

      <button type="submit">Create Account</button>
      <p>Have an account? <router-link v-bind:to="{ name: 'login' }">Sign in!</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        name: "",
        password: "",
        confirmPassword: "",
        role: "user"
      },
    };
  },
  methods: {
    error(msg) {
      alert(msg);
    },
    success(msg) {
      alert(msg);
    },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.error("Password & Confirm Password do not match");
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.success("Thank you for registering, please sign in.");
              this.$router.push({
                path: "/login",
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            if (!response) {
              this.error(error);
            } else if (response.status === 400) {
              if (response.data.errors) {
                // Show the validation errors
                let msg = "Validation error: ";
                for (let err of response.data.errors) {
                  msg += `'${err.field}':${err.defaultMessage}. `;
                }
                this.error(msg);
              } else {
                this.error(response.data.message);
              }
            } else {
              this.error(response.data.message);
            }
          });
      }
    },
  },
};
</script>

<style scoped>

.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 80vh;
  background-color: #f9f9f9;
}

.register-form {
  background: #ffffff;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
  text-align: center;
}

.register-form h2 {
  margin-bottom: 1.5rem;
  color: #2D3142;
}

.register-form input {
  display: block;
  width: 100%;
  margin-bottom: 1rem;
  padding: 0.75rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1rem;
}

.register-form button {
  background-color: #EF8354;
  color: #fff;
  border: none;
  padding: 0.75rem;
  width: 100%;
  border-radius: 5px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.register-form button:hover {
  background-color: #d56b3a;
}

.register-form p {
  margin-top: 1rem;
  font-size: 0.9rem;
}
</style>
