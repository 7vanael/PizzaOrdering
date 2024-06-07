<template>
  <NavBar />
  <main id="home">
    <Menu />
    <CustomPizzaMenu />
    <!-- <p>You are authenticated if you see this.</p> -->
  </main>
  
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

<style scoped>
#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
  /* min-height: 100dvh; */
}
</style>
