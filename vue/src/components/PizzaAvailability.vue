<template>
    <div>
      <div class="container">
        <ul class="pizzas">
          <li v-for="pizza in pizzas" v-bind:key="pizza.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="pizza.name" v-bind:value="pizza.name" 
                v-bind:checked="pizza.available" @click="updateAvailability(pizza)">
            </label>
            {{ pizza.name }}
          </li>
        </ul>
      </div>
    </div>
</template>


<script scoped>
import ToppingsService from '../services/ToppingsService';
import EmployeeService from '../services/EmployeeService';

export default{
    components: {

    },
    data(){
        return {
            pizzas: [],
            availablePizzas: []
        }
    },
    methods: {
      // update call to DB to update the availability status of the clicked pizza
      updateAvailability(pizza){
        pizza.available = !pizza.available;
        EmployeeService.updatePizzaAvailability(pizza);
      }
    },
    created() {
    ToppingsService.getPizzas().then(
      (response) => {
        this.pizzas = response.data;
        this.availablePizzas = this.pizzas.forEach(pizza => {
          if(pizza.pizza_available == true){
            this.availablePizzas.push;
          }
        })
      });    
  },
}
</script>

<style>
.container {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
}
.pizzas {
  font-weight: bold;
  text-transform: uppercase;
  color: #2892C4;
}
input[type="checkbox"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
}

</style>