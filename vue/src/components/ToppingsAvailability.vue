<template>
    <div class="container">

        <div>
            <ul class="list-group-item">
                <li v-for="cheese in cheeseToppings" v-bind:key="cheese.name" class="list-group-item">
                <label>
                    <input type="radio" name="pizza-cheese" v-bind:value="cheese.name" v-model="$store.state.activeToppingsCheese.name">
                </label>
                {{ cheese.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="sauces">
                <li v-for="sauce in sauces" v-bind:key="sauce.name" class="list-group-item">
                <label>
                    <input type="radio" name="pizza-sauce" v-bind:value="sauce.name"
                    v-model="$store.state.activePizza.sauce">
                </label>
                {{ sauce.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="list-group list-group">
                <li v-for="crust in crustTypes" v-bind:key="crust.name" class="list-group-item">
                <label>
                    <input type="radio" name="pizza-crust-type" v-bind:value="crust.name"
                    v-model="$store.state.activePizza.crust">
                </label> {{ crust.name }} - {{ crust.description }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="list-group list-group">
                  <li v-for="crust in crustSizes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-size" v-bind:value="crust.name"
                        v-model="$store.state.activePizza.size">
                    </label> {{ crust.name }}
                  </li>
                </ul>
        </div>
        <div>
            <ul class="list-group list-group">
                <li v-for="meat in meatToppings" v-bind:key="meat.name" class="list-group-item">
                <label>
                    <input type="checkbox" v-bind:name="meat.name" v-bind:value="meat.name" v-model="$store.state.activeToppingsMeats">
                </label>
                {{ meat.name }}
                </li>
            </ul>
        </div>
        <div>
            <ul class="list-group">
                <li v-for="veggie in veggieToppings" v-bind:key="veggie.name" class="list-group-item">
                <label>
                    <input type="checkbox" name="non-meat-toppings" v-bind:value="veggie.name" v-model="$store.state.activeToppingsVeggies">
                </label>
                {{ veggie.name }}
                </li>
            </ul>
        </div>
    </div>

</template>


<script scoped>
import ToppingsService from '../services/ToppingsService';

export default {
    data() {
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
    ToppingsService.getSize().then(
      (response) => {
        this.crustSizes = [];
        let sizesList = response.data;
        // sizesList = response.data;
        sizesList.forEach(
          (sizeLoop) => {
            // if (sizeLoop.available) {
              this.crustSizes.push(sizeLoop);
            // }
          });
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