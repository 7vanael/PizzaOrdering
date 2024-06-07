<template>
    <div>

    </div>

</template>


<script scoped>
import ToppingsService
 from '../services/ToppingsService';
export default{
    components: {

    },
    data(){
        return {
            specialtyPizzas: [],
        }

    },
    methods: {

    },
    created() {
    ToppingsService.getPizzas().then(
      (response) => {
        this.specialtyPizzas = response.data;
        let pizzaList = this.specialtyPizzas;
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
.cheese-sauce,
.size-crust,
.toppings {
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