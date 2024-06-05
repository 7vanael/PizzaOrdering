<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#home">Syntax Slices</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
        aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-link" aria-current="page" href="#location">Location</a>
          <a class="nav-link active" href="#">Order</a>
          <a class="nav-link" href="#">Sign Up</a>
        </div>
      </div>
    </div>
  </nav>
</template>

<script></script>

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