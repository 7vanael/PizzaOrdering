<template>
    <div>
      <div class="container">
        <h3>Veggies</h3>
        <ul class="veggies">
          <li v-for="veggie in veggies" v-bind:key="veggie.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="veggie.name" v-bind:value="veggie.name" 
                v-bind:checked="veggie.available" @click="updateAvailability(veggie)">
            </label>
            {{ veggie.name }}
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
            veggies: [],
            availableVeggies: []
        }
    },
    methods: {
      updateAvailability(veggie){
        veggie.available = !veggie.available;
        EmployeeService.updatePizzaAvailability(veggie);
      }
    },
    created() {
    ToppingsService.getVeggie().then(
      (response) => {
        this.veggies = response.data;
        this.availableVeggies = this.veggies.forEach(veggie => {
          if(veggie.available == true){
            this.availableVeggies.push;
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
.veggies {
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