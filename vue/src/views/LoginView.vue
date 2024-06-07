<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">Syntax Slices</router-link>
    </div>
  </nav>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="row">
        <button @click="goToEmployeePage" type="submit">Sign in</button>
      </div>
      <p>
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
// import NavBar from '../components/NavBar.vue';

export default {
  components: {
    // NavBar
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    goToEmployeePage() {
      console.log("This is successfully going to the employee page! Yay!")
      this.$router.push("/employee");
    }
  }
};
</script>

<style scoped>
.navbar {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 0;
  margin: 0;
}

.container-fluid {
  margin: 0;
  padding: 20;
}

.navbar-brand {
  color: #F2DC9C;
}
#login {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: #A4200B;
  background-color: #F7c516;
}

h1 {
  margin-bottom: 1rem;
  font-weight: bold;
  font-size: 50pt;
}

.form-input-group {
  display: flex;
  flex-direction: column;
  columns: 2;
  padding: 20px;
  justify-content: space-between;
}

label {
  font-size: 25pt;
  color: #A4200B;
  text-align: center;
}

input {
  padding: 10px;
  margin-top: 1rem;
  border-radius: 5px;
  border: 1px solid #A4200B;
  width: 100%;
}

button {
  background-color: #A4200B;
  color: #F7C516;
  border-radius: 5px;
  padding: 10px;
  margin-top: 2rem;
  font-size: 20pt;
  justify-content: center;
}

p {
  margin-top: 20px;
  font-size: 20pt;
  color: #A4200B;
  text-align: center;
}
</style>