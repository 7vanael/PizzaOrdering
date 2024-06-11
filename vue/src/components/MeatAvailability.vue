<template>
    <div>
      <div class="container">
        <h2>Meat</h2>
        <ul class="meats">
          <li v-for="meat in meats" v-bind:key="meat.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="meat.name" v-bind:value="meat.name" 
                v-bind:checked="meat.available" @click="updateAvailability(meat)">
            </label>
            {{ meat.name }}
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
            meats: [],
            availableMeats: []
        }
    },
    methods: {
      updateAvailability(meat){
        meat.available = !meat.available;
        EmployeeService.updateToppingAvailability(meat);
      }
    },
    created() {
    ToppingsService.getMeat().then(
      (response) => {
        this.meats = response.data;
        this.availableMeats = this.meats.forEach(meat => {
          if(meat.available == true){
            this.availableMeats.push;
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
.meats {
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