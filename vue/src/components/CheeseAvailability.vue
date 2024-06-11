<template>
      <div class="container">
        <!-- <h2>Cheeses</h2> -->
        <ul class="cheese">
          <li v-for="cheese in cheeses" v-bind:key="cheese.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="cheese.name" v-bind:value="cheese.name" 
                v-bind:checked="cheese.available" @click="updateAvailability(cheese)">
            </label>
            {{ cheese.name }}
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
            cheeses: [],
            availableCheeses: []
        }
    },
    methods: {
      updateAvailability(cheese){
        cheese.available = !cheese.available;
        EmployeeService.updateToppingAvailability(cheese);
      }
    },
    created() {
    ToppingsService.getCheese().then(
      (response) => {
        this.cheeses = response.data;
        this.availableCheeses = this.cheeses.forEach(cheese => {
          if(cheese.available == true){
            this.availableCheeses.push;
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
.cheese {
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