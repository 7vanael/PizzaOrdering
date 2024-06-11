<template>    
      <div class="container">
        <!-- <h2>Crusts</h2> -->
        <ul class="crusts">
          <li v-for="crust in crusts" v-bind:key="crust.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="crust.name" v-bind:value="crust.name" 
                v-bind:checked="crust.available" @click="updateAvailability(crust)">
            </label>
            {{ crust.name }}
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
            crusts: [],
            availableCrusts: []
        }
    },
    methods: {
      // update call to DB to update the availability status of the clicked pizza
      updateAvailability(crust){
        crust.available = !crust.available;
        EmployeeService.updateToppingAvailability(crust);
      }
    },
    created() {
    ToppingsService.getCrust().then(
      (response) => {
        this.crusts = response.data;
        this.availableCrusts = this.crusts.forEach(crust => {
          if(crust.available == true){
            this.availableCrusts.push;
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
.crusts {
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