<template>
  <!-- {{ meatToppings }} -->
  <!-- {{ cheeseToppings }} -->
  <!-- {{ pizzaToppings }} -->
  <section class="container-fluid">
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist" style="height: 20px">
      <li class="nav-item" role="presentation">
        <a class="nav-link" id="pills-crust-tab" data-bs-toggle="pill" data-bs-target="#pills-crust" type="button"
          role="tab" aria-controls="pills-crust" aria-selected="true">Crust and Size
        </a>
      </li>
      <li class="nav-item" role="presentation">
        <a class="nav-link" id="pills-sauce-cheese-tab" data-bs-toggle="pill" data-bs-target="#pills-sauce-cheese"
          type="button" role="tab" aria-controls="pills-sauce-cheese" aria-selected="false">Sauce and Cheese
        </a>
      </li>
      <li class="nav-item" role="presentation">
        <a class="nav-link" id="pills-meat-tab" data-bs-toggle="pill" data-bs-target="#pills-meat" type="button"
          role="tab" aria-controls="pills-meat" aria-selected="false">Meats
        </a>
      </li>
      <li class="nav-item" role="presentation">
        <a class="nav-link" id="pills-veggies-tab" data-bs-toggle="pill" data-bs-target="#pills-veggies" type="button"
          role="tab" aria-controls="pills-veggies" aria-selected="false">Veggies
        </a>
      </li>
    </ul>
    <!-- Crust and Size -->
    <div class="tab-content" id="pills-tabContent">
      <div class="tab-pane show active" id="pills-crust" role="tabpanel" aria-labelledby="pills-crust-tab">
        <div class="card" style="width: 100%;">
          <ul class="list-group">
            <li class="list-group-item size-crust">Choose Your Crust and Size</li>
            <li class="list-group-item">

              <div class=" card-radio" style="width: 100%;">
                <ul class="list-group list-group">

                  <li v-for="crust in crustTypes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-type" value={{crust.name}}>
                    </label> {{ crust.name }} - <!--{{ crustDescriptions[crust.name] }}--> {{ crust.description }}
                  </li>

                </ul>
              </div>
              <br>

              <div class=" card-radio" style="width: 100%;">
                <ul class="list-group list-group">
                  <li v-for="crust in crustSizes" v-bind:key="crust.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-crust-size" value={{crust.name}}>
                    </label> {{ crust.name }}
                  </li>
                </ul>
              </div>

              <!-- </div> -->
            </li>
          </ul>

          <div class="card-footer d-flex justify-content-end">
            <button class="next-step" id="nextButton">Next Step ></button>
            <a href="#pills-profile" data-toggle="tab"></a>
          </div>
        </div>
      </div>
      <!-- Cheese and Sauce -->
      <div class="tab-pane" id="pills-sauce-cheese" role="tabpanel" aria-labelledby="pills-sauce-cheese-tab">
        <div class="card" style="width: 100%;">
          <ul class="list-group list-group">
            <li class="list-group-item cheese-sauce">Choose Your Sauce and Cheese</li>
            <li class="list-group-item">
              <!--Sauce-->
              <div class="card card-radio" style="width: 100%;">
                <ul class="list-group list-group">
                  <li v-for="sauce in sauces" v-bind:key="sauce.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-sauce" value={{sauce.name}}>
                    </label> {{ sauce.name }}
                  </li>
                </ul>
              </div>
              <br />
              <!--Cheese-->
              <div class="card card-radio my-20" style="width: 100%;">
                <ul class="list-group list-group">
                  <li v-for="cheese in cheeseToppings" v-bind:key="cheese.name" class="list-group-item">
                    <label>
                      <input type="radio" name="pizza-cheese" value={{cheese.name}}>
                    </label> {{ cheese.name }}

                  </li>

                </ul>
              </div>
              <br>
            </li>
            <div class="card-footer d-flex justify-content-end my-1">
              <button class="next-step"> Previous</button>
              <button class="next-step">Next ></button>
            </div>
          </ul>
        </div>
      </div>
      <!-- Meats-->
      <div class="tab-pane" id="pills-meat" role="tabpanel" aria-labelledby="pills-meat-tab">
        <div class="card" style="width: 100%;">
          <ul class="list-group list-group">
            <li class="list-group-item toppings">Choose Your Meat</li>
            <li class="list-group-item">
              <!--Meats-->
              <div class="card card-radio my-20" style="width: 100%;">
                <ul class="list-group list-group">

                  <!-- <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="pepperoni">
                  </label>
                  Pepperoni
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="italian-sausage">
                  </label>
                  Italian Sausage
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="bacon">
                  </label>
                  Bacon
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="chicken">
                  </label>
                  BBQ Chicken
                </li> -->

                  <li v-for="meat in meatToppings" v-bind:key="meat.name" class="list-group-item">
                    <label>
                      <input type="checkbox" name="meat-toppings" value={{meat.name}}>
                    </label>
                    {{ meat.name }}
                  </li>

                </ul>
              </div>
              <div class="card-footer d-flex justify-content-end my-1">
                <button class="next-step"> Previous</button>
                <button class="next-step">Next ></button>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="tab-pane" id="pills-veggies" role="tabpanel" aria-labelledby="pills-veggies-tab">
        <div class="card" style="width: 100%;">
          <ul class="list-group">
            <li class="list-group-item toppings">Choose Your Veggies</li>
            <li class="list-group-item">
              <!--Non-Meats-->
              <div class="card card-radio" style="width: 100%;">
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
          <div class="card-footer d-flex justify-content-end">
            <button class="next-step">Checkout
              <svg xmlns="http://www.w3.org/2000/svg" height="1em"
                viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                <path
                  d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z" />
              </svg>
            </button>
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