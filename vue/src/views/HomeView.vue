<template>
  {{ pizzas }}
  <NavBar />
  <div class="home">
    <h1>Home</h1>
    <Menu />
    <!-- <p>You are authenticated if you see this.</p> -->
  </div>
  <CustomPizzaMenu />
</template>

<script>

import NavBar from '../components/NavBar.vue';
import CustomPizzaMenu from '../components/CustomPizzaMenu.vue';
import Menu from '../components/Menu.vue';
import ToppingsService from '../services/ToppingsService.js';


export default {
  components: {
    NavBar,
    CustomPizzaMenu,
    Menu
  },
  data() {
    return {
      pizzaToppings: [],
      pizzas: [],

    }
  },
  created() {
    ToppingsService.getToppings().then(
      (response) => {
        this.pizzaToppings = response.data;

      });
    ToppingsService.getPizzas().then(
      (response) => {
        this.pizzas = response.data;

      });
  },
}

</script>
