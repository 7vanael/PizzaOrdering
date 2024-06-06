<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <router-link class="navbar-brand" v-bind:to=" { name: 'home'}">Syntax Slices</router-link>
      <button class="navbar-toggler" type="button" @click="toggleNavbar" :aria-expanded="isNavbarExpanded" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div :class="['collapse navbar-collapse', { show: isNavbarExpanded }]" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <router-link class="nav-link" to="/location">Location</router-link>
          <router-link class="nav-link active" to="/checkout">Order</router-link>
          <router-link class="nav-link" to="/register">Sign Up</router-link>
          <router-link class="nav-link" to="/login">Log In</router-link>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      isNavbarExpanded: false,
    };
  },
  methods: {
    toggleNavbar() {
      this.isNavbarExpanded = !this.isNavbarExpanded;
    },
  },
};
</script>

<style scoped>
.navbar {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
}

.navbar-brand {
  color: #F2DC9C;
}
.nav-link {
  color: #FA8A0D;
}

.nav-link.active {
  color: #F2DC9C;
}
</style>