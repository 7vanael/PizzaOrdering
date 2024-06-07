<template>
    <div class="container">
        <!-- TODO: This component needs the wiring reviewed, see specifically the v-model to the $store lines -->
        <!-- Currently modeled to the active toppings, but likely need the store to have new data for ALL toppings/crusts/sizes etc -->
            

        <!-- TODO: Add conditional class to items that have availability == false to visually indicate what is available or not -->
        <div>
            <ul class="cheese">
                <li v-for="cheese in cheeseToppings" v-bind:key="cheese.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="cheese.name" v-bind:value="cheese.name" v-model="$store.state.activeToppingsCheese">
                </label>
                {{ cheese.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="sauce">
                <li v-for="sauce in sauces" v-bind:key="sauce.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="sauce.name" v-bind:value="sauce.name" v-model="$store.state.activeToppingsSauce">
                </label>
                {{ sauce.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="crust">
                <li v-for="crust in crustTypes" v-bind:key="crust.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="crust.name" v-bind:value="crust.name" v-model="$store.state.activeToppingsCrust">
                </label> {{ crust.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="size">
                  <li v-for="crust in crustSizes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                        <input type="checkbox" v-bind:name="size.name" v-bind:value="size.name" v-model="$store.state.activeToppingsSize">
                    </label> {{ crust.name }}
                  </li>
                </ul>
        </div>
        <div>
            <ul class="meat">
                <li v-for="meat in meatToppings" v-bind:key="meat.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="meat.name" v-bind:value="meat.name" v-model="$store.state.activeToppingsMeats">
                </label>
                {{ meat.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="toppings">
                <li v-for="veggie in veggieToppings" v-bind:key="veggie.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="veggie.name" v-bind:value="veggie.name" v-model="$store.state.activeToppingsVeggies">
                </label>
                {{ veggie.name }}
                </li>
            </ul>
        </div>
    </div>

</template>


<script scoped>
import ToppingsService from '../services/ToppingsService';

export default{
    components: {

    },
    data(){
        return {            
            meatToppings: [],
            veggieToppings: [],
            cheeseToppings: [],
            crustTypes: [],
            sauces: [],
            crustSizes: [],
        }
    },
    methods: {

    },
    created() {
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
    
    ToppingsService.getCheese().then(
      (response) => {
        let cheeseList;
        cheeseList = response.data;
        cheeseList.forEach(
          (cheeseLoop) => {
            // if (cheeseLoop.available /* && cheeseLoop.toppingTier == 2*/) {
              this.cheeseToppings.push(cheeseLoop);
            // }
          });
      });
    ToppingsService.getMeat().then(
      (response) => {
        let meatList;
        meatList = response.data;
        meatList.forEach(
          (toppingLoop) => {
            // if (toppingLoop.available) {
              this.meatToppings.push(toppingLoop);
            // }
          });
      });
    ToppingsService.getSauce().then(
      (response) => {
        let sauceList;
        sauceList = response.data;
        sauceList.forEach(
          (toppingLoop) => {
            // if (toppingLoop.available) {
              this.sauces.push(toppingLoop);
            // }
          });
      });
    ToppingsService.getCrust().then(
      (response) => {
        let crustList;
        crustList = response.data;
        crustList.forEach(
          (typesLoop) => {
            // if (typesLoop.available) {
              this.crustTypes.push(typesLoop);
            // }
          });
      });
    ToppingsService.getVeggie().then(
      (response) => {
        let veggieList;
        veggieList = response.data;
        veggieList.forEach(
          (toppingLoop) => {
            // if (toppingLoop.available) {
              this.veggieToppings.push(toppingLoop);
            // }
          });
      });
    //   <!-- TODO: revisit retrieving size; possible new end point in the works per Jennifer -->
    ToppingsService.getSize().then(
      (response) => {
        this.crustSizes = [];
        let sizesList = response.data;
        sizesList.forEach(
          (sizeLoop) => {
            // if (sizeLoop.available) {
              this.crustSizes.push(sizeLoop);
            // }
          });
      });
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
}
.cheese,
.sauce,
.size,
.crust,
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

/* TODO: add styling for how .unavailable items should be styled */

</style>