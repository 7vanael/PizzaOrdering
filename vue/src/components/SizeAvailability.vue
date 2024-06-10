<template>
    <div>
      <div class="container">
        <h3>Size</h3>
        <ul class="sizes">
          <li v-for="size in sizes" v-bind:key="size.name" class="list-group-item">
            <label>
              <input type="checkbox" v-bind:name="size.name" v-bind:value="size.name" 
                v-bind:checked="size.available" @click="updateAvailability(size)">
            </label>
            {{ size.name }}
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
            sizes: [],
            availableSizes: []
        }
    },
    methods: {
      updateAvailability(size){
        size.available = !size.available;
        EmployeeService.updateToppingAvailability(size);
      }
    },
    created() {
    ToppingsService.getSizes().then(
      (response) => {
        this.sizes = response.data;
        this.availableSizes = this.sizes.forEach(size => {
          if(size.available == true){
            this.availableSizes.push;
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
.sizes {
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