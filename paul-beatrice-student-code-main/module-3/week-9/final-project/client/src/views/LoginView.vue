<template>
 <div id="login">
  <div class="form-card">
    <h2>Please Sign In</h2>

    <form @submit.prevent="login">
      <input
      type="text"
      id="username"
      placeholder="Username"
      v-model="user.username"
      required
    />

    <input
    type="password"
    id="password"
    placeholder="Password"
    v-model="user.password"
    required
    />

    <button type="submit" class="auth-button">Sign In</button>
  </form>

    <p>Need an account? <router-link :to="{ name: 'register' }">Register</router-link></p>
  </div>
 </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

            const role = response.data.user.role;
            if (role === "ROLE_ADMIN") {
              this.$router.push("/admindashboard");
            } else {
              this.$router.push("/userdashboard");
            } 
          }
        })
        .catch((error) => {
          const response = error.response;
          if (!response) {
            alert(error);
          } else if (response.status === 401) {
            alert("Invalid username and password!");
          } else {
            alert(response.message);
          }
        });
      }
    }
  };
</script>

<style scoped>
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 85vh;
  background-color: #f5f5f5;
}

.form-card {
  background-color: white;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  width: 320px;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  align-items: center;
}

.form-card form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
}

.form-card h2 {
  text-align: center;
  margin-bottom: 1rem;
}

input {
  padding: 0.5rem;
  border-radius: 5px;
  border: 1px solid #ccc;
}

button {
  padding: 0.5rem;
  background-color: #ef8354;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #d66b3c;
}

p {
  text-align: center;
  font-size: 0.9rem;
}

router-link {
  color: #4f5d75;
  font-weight: bold;
}







</style>
