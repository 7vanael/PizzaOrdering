
<template>
  <div id="app">
    <custom-pizza-menu v-for="crust in crusts" :key="crust.name" :crust="crust"></custom-pizza-menu>
  </div>
</template>

<script type="module">
import Vue from 'vue'
import PizzaCrusts from './PizzaCrusts.vue'

Vue.component('pizza-crust', PizzaCrusts);

new Vue({
  el: '#app',
  data: {
    crusts: [
      {
        name: 'Regular',
        description: 'Garlic seasoned crust with a rich, buttery taste.',
        sizes: [
          { label: 'Small (10")', value: 'small-hand' },
          { label: 'Medium (12")', value: 'medium-hand' },
          { label: 'Large (14")', value: 'large-hand' }
        ]
      },
      {
        name: 'Deep Dish',
        description: 'Chicago-style deep dish crust with a buttery, flaky exterior.',
        sizes: [
          { label: 'Small (10")', value: 'small-crispy' },
          { label: 'Medium (12")', value: 'medium-crispy' },
          { label: 'Large (14")', value: 'large-crispy' }
        ]
      },
      {
        name: 'Thin',
        description: 'Thin enough for optimum crispy to crunchy ratio.',
        sizes: [
          { label: 'Small (12")', value: 'small-crispy' },
          { label: 'Medium (14")', value: 'medium-crispy' },
          { label: 'Large (16")', value: 'large-crispy' }
        ]
      },
      {
        name: 'Cauliflower',
        description: 'Gluten-free cauliflower crust with a buttery, flaky exterior.',
        sizes: [
          { label: 'Small (12")', value: 'small-cauliflower' },
          { label: 'Medium (14")', value: 'medium-cauliflower' },
          { label: 'Large (16")', value: 'large-cauliflower' }
        ]
      }
    ]
  }
});
</script>

