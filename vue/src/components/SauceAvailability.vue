<template>
      <div class="container">
        <!-- <h2>Sauce</h2> -->
        <ul class="sauces">
          <li v-for="sauce in sauces" v-bind:key="sauce.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="sauce.name" v-bind:value="sauce.name" 
                v-bind:checked="sauce.available" @click="updateAvailability(sauce)">
            </label>
            {{ sauce.name }}
          </li>
        </ul>
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
            sauces: [],
            availableSauces: []
        }
    },
    methods: {
      updateAvailability(sauce){
        sauce.available = !sauce.available;
        EmployeeService.updateToppingAvailability(sauce);
      }
    },
    created() {
    ToppingsService.getSauce().then(
      (response) => {
        this.sauces = response.data;
        this.availableSauces = this.sauces.forEach(sauce => {
          if(sauce.available == true){
            this.availableSauces.push;
          }
        })
      });    
  },
}
</script>

<style scoped>
.container {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
}
.sauces {
  font-weight: bold;
  text-transform: uppercase;
  color: #2892C4;
}
input[type="checkbox"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
}
li {
  list-style-type: none;
  font-size: 20pt;
}

</style>