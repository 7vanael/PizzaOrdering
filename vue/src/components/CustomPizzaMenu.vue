<template>
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
                      <input type="radio" name="pizza-crust-type" v-bind:value="crust.name"
                        v-model="$store.state.activePizza.crust">
                    </label> {{ crust.name }} - {{ crust.description }}
                  </li>
                </ul>
              </div>
              <br>
              <div class=" card-radio">
                <ul class="list-group list-group">
                  <li v-for="crust in crustSizes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-size" v-bind:value="crust.name"
                        v-model="$store.state.activePizza.size">
                    </label> {{ crust.name }} - <!--{{ sizes.price }}-->
                  </li>
                </ul>
              </div>
            </li>
          </ul>


          <!--Button Start-->
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
                          <input type="radio" name="pizza-sauce" v-bind:value="sauce.name"
                            v-model="$store.state.activePizza.sauce">
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
                          <input type="radio" name="pizza-cheese" v-bind:value="cheese.name" v-model="$store.state.activeToppingsCheese.name">
                        </label>
                        {{ cheese.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>

            <!--Button Start-->
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
                          <input type="checkbox" v-bind:name="meat.name" v-bind:value="meat.name" v-model="$store.state.activeToppingsMeats">
                        </label>
                        {{ meat.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>

            <!--Button Start-->
            <div class="card-footer d-flex justify-content-between mt-3">
              <button class="btn btn-secondary" @click="goToPreviousTab" v-if="index > 0">Sauce & Cheese</button>
              <button class="btn btn-primary" @click="goToNextTab" v-if="index < tabs.length - 1">Veggie Toppings</button>
            </div>


          </div>
        </div>
        <!-- Veggies-->
        <!--="tab.id === 'pills-veggies'"-->
        <div v-else class="card">
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
                          <input type="checkbox" name="non-meat-toppings" v-bind:value="veggie.name" v-model="$store.state.activeToppingsVeggies">
                        </label>
                        {{ veggie.name }}
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
          </div>


          <!--Button Start-->
          <div class="card-footer d-flex justify-content-between mt-3">
            <button class="btn btn-secondary" @click="goToPreviousTab" v-if="index > 0">Meat Toppings</button>
            <button class="btn btn-danger" @click="goToCheckout">Review Order</button>
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
      specialtyPizzas: [],
      //activePizza: {},
      meatToppings: [],
      activeMeatToppings: [],
      veggieToppings: [],
      cheeseToppings: [],
      crustTypes: [],
      sauces: [],
      crustSizes: [],
    }
  },
  methods: {
    setActiveTab(index) {
      this.activeTabIndex = index;
    },
    goToNextTab() {
      this.activeTabIndex++;
    },
    goToPreviousTab() {
      this.activeTabIndex--;
    },
    goToCheckout() {
      this.$router.push({ name: 'Checkout' });
    },
    
  },
  created() {
    ToppingsService.getToppings().then(
      (response) => {
        // this.pizzaToppings = response.data;
        this.pizzaToppings.forEach(
        (topping) =>{
          if(topping.topping_type === "Meat" && topping.topping_available){ 
            this.meatToppings.push(topping);
            // console.log(topping.name);
          }
          if(topping.topping_type === "Veggie" && topping.topping_available){ 
            this.veggieToppings.push(topping);
          }
          if(topping.topping_type === "Cheese" && topping.topping_available){ 
            this.cheeseToppings.push(topping);
          }
          // console.log(topping.name);
        });
      });
    ToppingsService.getCheese().then(
      (response) => {
        // this.cheeseToppings = response.data;
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
        // this.meatToppings = response.data;
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
        // this.sauces = response.data;
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
        // this.crustTypes = response.data;
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
        // this.veggieToppings = response.data;
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
        this.crustSizes = [];
        let sizesList = response.data;
        // sizesList = response.data;
        sizesList.forEach(
          (sizeLoop) => {
            if (sizeLoop.available) {
              this.crustSizes.push(sizeLoop);
            }
          });
      });
    ToppingsService.getPizzas().then(
      (response) => {
        this.specialtyPizzas = response.data;
        let pizzaList = this.specialtyPizzas, veggieList = [], meatList = [], cheese;
        pizzaList.forEach(
          (pizzaLoop) => {
            if (pizzaLoop.name === "The Polymorph") {
              this.$store.commit("SET_ACTIVE_PIZZA", pizzaLoop);
              pizzaLoop.toppings.forEach(
                (topping) => {
                  if (topping.type === "Cheese") { 
                    cheese = topping;
                  }
                  if (topping.type === "Meat") { 
                    meatList.push(topping.name); 
                  }
                  if (topping.type === "Veggie") { 
                    veggieList.push(topping.name);
                  }
                });
                this.$store.commit("SET_ACTIVE_CHEESE", cheese);
                this.$store.commit("SET_ACTIVE_MEATS", meatList);
                this.$store.commit("SET_ACTIVE_VEGGIES", veggieList); 
            }
          });
      });


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