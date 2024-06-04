<template>
  <NavBar />
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You are authenticated if you see this.</p> -->
  </div>
  <CustomPizzaMenu />
</template>

<script>

  import NavBar from '../components/NavBar.vue';
  import CustomPizzaMenu from '../components/CustomPizzaMenu.vue';

  

export default {
  components: {
    NavBar,
    CustomPizzaMenu
  }
}

</script>
