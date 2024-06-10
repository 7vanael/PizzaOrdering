<template>
  <div class="container">
    <SizeAvailability />
    <CrustAvailability />
    <SauceAvailability />
    <CheeseAvailability />
    <MeatAvailability />
    <VeggieAvailability />

  </div>
</template>


<script scoped>
// import ToppingsService from '../services/ToppingsService';
import CheeseAvailability from './CheeseAvailability.vue';
import CrustAvailability from './CrustAvailability.vue';
import MeatAvailability from './MeatAvailability.vue';
import SauceAvailability from './SauceAvailability.vue';
import SizeAvailability from './SizeAvailability.vue';
import VeggieAvailability from './VeggieAvailability.vue';

export default {
  components: {
    SizeAvailability,
    CrustAvailability,
    CheeseAvailability,
    SauceAvailability,
    MeatAvailability,
    VeggieAvailability
},
  data() {
    return {
      // crustSizes: [],
      // crustTypes: [],
      // sauces: [],
      // cheeseToppings: [],
      // meatToppings: [],
      // veggieToppings: [],
    }
  },
  methods: {

  },
  created() {
    // //   <!-- TODO: revisit retrieving size; possible new end point in the works per Jennifer -->
    // ToppingsService.getSize().then(
    //   (response) => {
    //     let sizesList = response.data;
    //     sizesList.forEach(
    //       (toppingLoop) => {
    //         // if (sizeLoop.available) {
    //         this.crustSizes.push(toppingLoop);
    //         // }
    //       });
    //   });
    // ToppingsService.getCrust().then(
    //   (response) => {
    //     let crustList = response.data;
    //     crustList.forEach(
    //       (toppingLoop) => {
    //         // if (typesLoop.available) {
    //         this.crustTypes.push(toppingLoop);
    //         // }
    //       });
    //   });
    // ToppingsService.getSauce().then(
    //   (response) => {
    //     let sauceList;
    //     sauceList = response.data;
    //     sauceList.forEach(
    //       (toppingLoop) => {
    //         // if (toppingLoop.available) {
    //         this.sauces.push(toppingLoop);
    //         // }
    //       });
    //   });
    // ToppingsService.getCheese().then(
    //   (response) => {
    //     let cheeseList;
    //     cheeseList = response.data;
    //     cheeseList.forEach(
    //       (toppingLoop) => {
    //         // if (cheeseLoop.available /* && cheeseLoop.toppingTier == 2*/) {
    //         this.cheeseToppings.push(toppingLoop);
    //         // }
    //       });
    //   });
    // ToppingsService.getMeat().then(
    //   (response) => {
    //     let meatList;
    //     meatList = response.data;
    //     meatList.forEach(
    //       (toppingLoop) => {
    //         // if (toppingLoop.available) {
    //         this.meatToppings.push(toppingLoop);
    //         // }
    //       });
    //   });
    // ToppingsService.getVeggie().then(
    //   (response) => {
    //     let veggieList;
    //     veggieList = response.data;
    //     veggieList.forEach(
    //       (toppingLoop) => {
    //         // if (toppingLoop.available) {
    //         this.veggieToppings.push(toppingLoop);
    //         // }
    //       });
    //   });

    // ToppingsService.getToppings().then(
    //   (response) => {
    //     this.pizzaToppings.forEach(
    //     (topping) =>{
    //       if(topping.topping_type === "Meat" && topping.topping_available){ 
    //         this.meatToppings.push(topping);
    //       }
    //       if(topping.topping_type === "Veggie" && topping.topping_available){ 
    //         this.veggieToppings.push(topping);
    //       }
    //       if(topping.topping_type === "Cheese" && topping.topping_available){ 
    //         this.cheeseToppings.push(topping);
    //       }

    //     });
    //     this.pizzaToppings.forEach(
    //     (topping) =>{
    //       if(topping.topping_type === "Meat" && !topping.topping_available){ 
    //         this.meatToppings.push(topping);
    //       }
    //       if(topping.topping_type === "Veggie" && !topping.topping_available){ 
    //         this.veggieToppings.push(topping);
    //       }
    //       if(topping.topping_type === "Cheese" && !topping.topping_available){ 
    //         this.cheeseToppings.push(topping);
    //       }

    //     });
    //   });

    // ToppingsService.getPizzas().then(
    //   (response) => {
    //     this.specialtyPizzas = response.data;
    //     let pizzaList = this.specialtyPizzas, veggieList = [], meatList = [], cheese;
    //     pizzaList.forEach(
    //       (pizzaLoop) => {
    //         if (pizzaLoop.name === "The Polymorph") {
    //           this.$store.commit("SET_ACTIVE_PIZZA", pizzaLoop);
    //           pizzaLoop.toppings.forEach(
    //             (topping) => {
    //               if (topping.type === "Cheese") { 
    //                 cheese = topping;
    //               }
    //               if (topping.type === "Meat") { 
    //                 meatList.push(topping.name); 
    //               }
    //               if (topping.type === "Veggie") { 
    //                 veggieList.push(topping.name);
    //               }
    //             });
    //             this.$store.commit("SET_ACTIVE_CHEESE", cheese);
    //             this.$store.commit("SET_ACTIVE_MEATS", meatList);
    //             this.$store.commit("SET_ACTIVE_VEGGIES", veggieList); 
    //         }
    //       });
    //   });
  },

}
</script>

<style>
.container {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
  margin-top: 10px;
}
hr {
  border: 2px solid #A4200B;
}
h3 {
  color: #A4200B;
  font-size: 26pt;
}

/* .size,
.crust,
.sauce,
.cheese,
.meat,
.toppings {
  font-weight: bold;
  font-size: 20pt;
  text-transform: uppercase;
  color: #2892C4;
}

input[type="checkbox"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
} */

</style>