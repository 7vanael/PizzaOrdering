<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">Syntax Slices</router-link>
    </div>
  </nav>
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="row">
        <div class="col-4 form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="col-4 form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <div class="col-4 form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
        </div>
      </div>
      <button type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';
// import NavBar from '../components/NavBar.vue';


export default {
  components: {
    // NavBar
  },
  data() {
    return {

      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
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
#register {
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
  font-size: 20pt;
  color: #A4200B;
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
}

p {
  margin-top: 20px;
  font-size: 20pt;
  color: #A4200B;
}</style>
