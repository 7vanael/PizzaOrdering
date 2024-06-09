<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">Syntax Slices</router-link>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <router-link class="nav-link" to="/location">Location</router-link>
          <router-link class="nav-link" to="/checkout">Order</router-link>
          <router-link class="nav-link" to="/menu">Menu</router-link>
          <router-link class="nav-link" to="/register">Sign Up</router-link>
          <router-link class="nav-link" to="/login">Log In</router-link>
          <router-link class="nav-link" to="/employee">Employee</router-link>
          <router-link class="nav-link" to="/logout">Logout</router-link>

        </div>
      </div>
    </div>
  </nav>
</template>

<script>

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
.nav-link {
  color: #FA8A0D;
}

.nav-link.active {
  color: #F2DC9C;
}

.navbar-toggler {
  background-color: #F7C516;
  border: 2px solid #2892C4;
  color: #A4200B;
}
</style>