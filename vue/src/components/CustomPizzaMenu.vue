<template>
  <!-- {{ meatToppings }} -->
  <!-- {{ cheeseToppings }} -->
  <!-- {{ pizzaToppings }} -->
  <section class="container-fluid">

    <!-- Nav tabs -->
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
      <li class="nav-item" role="presentation" v-for="(tab, index) in tabs" :key="tab.id">
        <a class="nav-link" :id="tab.id + '-tab'" data-bs-toggle="pill" :data-bs-target="'#' + tab.id" type="button"
          role="tab" :aria-controls="tab.id" :aria-selected="activeTabIndex === index"
          :class="{ active: activeTabIndex === index }" @click.prevent="setActiveTab(index)">
          {{ tab.label }}
        </a>
      </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content" id="pills-tabContent">
      <div v-for="(tab, index) in tabs" :key="tab.id" :id="tab.id" class="tab-pane fade"
        :class="{ show: activeTabIndex === index, active: activeTabIndex === index }" role="tabpanel"
        :aria-labelledby="tab.id + '-tab'">
        <!-- Crust and Size-->
        <div v-if="tab.id === 'pills-crust'" class="card">
          <ul class="list-group">
            <li class="list-group-item size-crust">Choose Your Crust and Size</li>
            <li class="list-group-item">
              <div class=" card-radio">
                <ul class="list-group list-group">
                  <li v-for="crust in crustTypes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-type" value={{crust.name}}>
                    </label> {{ crust.name }} - {{ crust.description}}
                  </li>
                </ul>
              </div>
              <br>
              <div class=" card-radio">
                <ul class="list-group list-group">
                  <li v-for="crust in crustSizes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-size" value={{crust.name}}>
                    </label> {{ crust.name }}
                  </li>
                </ul>
              </div>
            </li>
          </ul>
          <div class="card-footer d-flex justify-content-end">
            <button class="btn btn-primary" @click="goToNextTab">Sauce & Cheese ></button>
          </div>
        </div>
        <!-- Sauce and Cheese-->
        <div v-else-if="tab.id === 'pills-sauce-cheese'" class="card">
          <div class="tab-pane" id="pills-sauce-cheese" role="tabpanel" aria-labelledby="pills-sauce-cheese-tab">
            <div class="card">
              <ul class="list-group">
                <li class="list-group-item cheese-sauce">Choose Your Sauce and Cheese</li>
                <li class="list-group-item">
                  <!--Sauces-->
                  <div class="card card-radio">
                    <ul class="list-group-item">
                      <li v-for="sauce in sauces" v-bind:key="sauce.name" class="list-group-item">
                        <label>
                          <input type="radio" name="pizza-sauce" value={{sauce.name}}>
                        </label>
                        {{ sauce.name }}
                      </li>
                    </ul>
                  </div>
                  <br>
                  <!--Cheeses-->
                  <div class="card card-radio">
                    <ul class="list-group-item">
                      <li v-for="cheese in cheeseToppings" v-bind:key="cheese.name" class="list-group-item">
                        <label>
                          <input type="radio" name="pizza-cheese" value={{cheese.name}}>
                        </label>
                        {{ cheese.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
            <div class="card-footer d-flex justify-content-between mt-3">
              <button class="btn btn-secondary" @click="goToPreviousTab" v-if="index > 0">Crust & Size</button>
              <button class="btn btn-primary" @click="goToNextTab" v-if="index < tabs.length - 1">Meat Toppings</button>
            </div>
          </div>
        </div>
        <!-- Meats-->
        <div v-else-if="tab.id === 'pills-meat'" class="card">
          <div class="tab-pane" id="pills-meat" role="tabpanel" aria-labelledby="pills-meat-tab">
            <div class="card">
              <ul class="list-group list-group">
                <li class="list-group-item toppings">Choose Your Meat</li>
                <li class="list-group-item">
                  <!--Meats-->
                  <div class="card card-radio my-20">
                    <ul class="list-group list-group">
                      <li v-for="meat in meatToppings" v-bind:key="meat.name" class="list-group-item">
                        <label>
                          <input type="checkbox" name="meat-toppings" value={{meat.name}}>
                        </label>
                        {{ meat.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
            <div class="card-footer d-flex justify-content-between mt-3">
              <button class="btn btn-secondary" @click="goToPreviousTab" v-if="index > 0">Sauce & Cheese</button>
              <button class="btn btn-primary" @click="goToNextTab" v-if="index < tabs.length - 1">Veggie Toppings</button>
            </div>
          </div>
        </div>
        <!-- Veggies-->
        <div v-else="tab.id === 'pills-veggies'" class="card">
          <div class="tab-pane" id="pills-veggies" role="tabpanel" aria-labelledby="pills-veggies-tab">
            <div class="card">
              <ul class="list-group">
                <li class="list-group-item toppings">Choose Your Veggies</li>
                <li class="list-group-item">
                  <!--Non-Meats-->
                  <div class="card card-radio">
                    <ul class="list-group">
                      <li v-for="veggie in veggieToppings" v-bind:key="veggie.name" class="list-group-item">
                        <label>
                          <input type="checkbox" name="non-meat-toppings" value={{veggie.name}}>
                        </label>
                        {{ veggie.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="card-footer d-flex justify-content-between mt-3">
            <button class="btn btn-secondary" @click="goToPreviousTab" v-if="index > 0">Meat Toppings</button>
            <button class="btn btn-danger" @click="goToOrderReview">Review Order</button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>


<script>
import ToppingsService from '../services/ToppingsService.js';


export default {
  data() {
    return {
      activeTabIndex: 0,
      tabs: [
        { id: 'pills-crust', label: 'Crust and Size' },
        { id: 'pills-sauce-cheese', label: 'Sauce and Cheese' },
        { id: 'pills-meat', label: 'Meats' },
        { id: 'pills-veggies', label: 'Veggies' },
      ],
      pizzaToppings: [],
      pizzas: [],
      meatToppings: [],
      veggieToppings: [],
      cheeseToppings: [],
      crustTypes: [],
      sauces: [],
      crustSizes: [],
      // crustDescriptions: {

      //   'Regular': 'Garlic seasoned crust with a rich, buttery taste.',

      //   'Deep Dish': 'Chicago-style deep dish crust with a buttery, flaky exterior.',

      //   'Thin': 'Thin enough for optimum crispy to crunchy ratio.',

      //   'Cauliflower': 'Gluten-free cauliflower crust with a buttery, flaky exterior.',
      // },
    }
  },
  methods: {
    setActiveTab(index) {
      this.activeTabIndex = index;
    },
    goToNextTab() {
      if (this.activeTabIndex < this.tabs.length - 1) {
        this.activeTabIndex++;
      }
    },
    goToPreviousTab() {
      if (this.activeTabIndex > 0) {
        this.activeTabIndex--;
      }
    },
    //need to create an order review page to go to?
    goToOrderReview() {
      this.$router.push({ name: 'OrderReview' });
    },
  },
  created() {
    ToppingsService.getToppings().then(
      (response) => {
        this.pizzaToppings = response.data;
        // this.pizzaToppings.forEach(
        // (topping) =>{
        //   if(topping.topping_type === "Meat" && topping.topping_available){ 
        //     this.meatToppings.push(topping);
        //     console.log(topping.name);
        //   }
        //   if(topping.topping_type === "Veggie" && topping.topping_available){ 
        //     this.veggieToppings.push(topping);
        //   }
        //   if(topping.topping_type === "Cheese" && topping.topping_available){ 
        //     this.cheeseToppings.push(topping);
        //   }
        //   console.log(topping.name);
        // });
      });
    ToppingsService.getCheese().then(
      (response) => {
        let cheeseList;
        cheeseList = response.data;
        //console.log(cheeseList);
        cheeseList.forEach(
          (cheeseLoop) => {
            if (cheeseLoop.available /* && cheeseLoop.toppingTier == 2*/) {
              this.cheeseToppings.push(cheeseLoop);
              //console.log(cheeseLoop);
            }
          });
      });
    ToppingsService.getMeat().then(
      (response) => {
        let meatList;
        meatList = response.data;
        meatList.forEach(
          (toppingLoop) => {
            if (toppingLoop.available) {
              this.meatToppings.push(toppingLoop);
            }
          });
      });
    ToppingsService.getSauce().then(
      (response) => {
        //this.sauces = response.data;
        let sauceList;
        sauceList = response.data;
        sauceList.forEach(
          (toppingLoop) => {
            if (toppingLoop.available) {
              this.sauces.push(toppingLoop);
            }
          });
      });
    ToppingsService.getCrust().then(
      (response) => {
        //this.crustTypes = response.data;
        let crustList;
        crustList = response.data;
        crustList.forEach(
          (typesLoop) => {
            if (typesLoop.available) {
              this.crustTypes.push(typesLoop);
            }
          });
      });
    ToppingsService.getVeggie().then(
      (response) => {
        //this.veggieToppings = response.data;
        let veggieList;
        veggieList = response.data;
        veggieList.forEach(
          (toppingLoop) => {
            if (toppingLoop.available) {
              this.veggieToppings.push(toppingLoop);
            }
          });
      });
    ToppingsService.getSize().then(
      (response) => {
        //this.crustSizes = response.data;
        let sizesList;
        sizesList = response.data;
        sizesList.forEach(
          (sizeLoop) => {
            if (sizeLoop.available) {
              this.crustSizes.push(sizeLoop);
            }
          });
      });
    ToppingsService.getPizzas().then(
      (response) => {
        this.pizzas = response.data;

      });


  },
  methods(){
    
  },
}
</script>


<style>
.container-fluid {
  margin-top: 20px;
  background-color: #A4200B;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;

}

#pills-tab {
  background-color: #F7C516;
  border: 2px solid #2892C4;
  border-radius: 5px;


}

.nav-pills .nav-link {
  color: #FA8A0D;
  background-color: #A4200B;
  border: 2px solid #F7C516;
  border-radius: 5px;
  /* padding: 20px; */
}

.nav-pills .nav-link.active {
  color: #A4200B;
  font-weight: bold;
  font-size: large;
  background-color: #F7C516;
  border: 2px solid #2892C4;
  text-transform: uppercase;
  align-content: center;
}

.card {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
}

.tab-pane {
  /* display: none; */
  background-color: #F2DC9C;

}

.cheese-sauce,
.size-crust,
.toppings {
  font-weight: bold;
  text-transform: uppercase;
  color: #2892C4;
}

input[type="radio"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
}

input[type="checkbox"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
}
</style>