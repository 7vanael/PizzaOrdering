<template>
    <NavbarEmployee />

    <div class="page-wrapper">
        <div class="container">
            <h1> Welcome, Syntax Slices Employee!</h1>
            <h2> Here you can create a new pizza to add to the menu and adjust toppings availability.</h2>
            <hr />
            <section>
                

                    <ul class="nav nav-pills" id="pills-tab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="orders-tab" data-bs-toggle="pill" data-bs-target="#orders" type="button"
                                role="tab" aria-controls="orders" aria-selected="true">Orders
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="addPizza-tab" data-bs-toggle="pill" data-bs-target="#addPizza"
                                type="button" role="tab" aria-controls="addPizza" aria-selected="false">Add New
                                Pizza
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="addToppings-tab" data-bs-toggle="pill" data-bs-target="#addToppings"
                                type="button" role="tab" aria-controls="addToppings" aria-selected="false">Add New Toppings
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="updatePizzas-tab" data-bs-toggle="pill" data-bs-target="#updatePizzas"
                                type="button" role="tab" aria-controls="updatePizzas" aria-selected="false">Update Pizzas
                            </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="updateToppings-tab" data-bs-toggle="pill"
                                data-bs-target="#updateToppings" type="button" role="tab" aria-controls="updateToppings"
                                aria-selected="false">Update Toppings
                            </a>
                        </li>
                    </ul>

                    <div class="tab-content" id="pills-tabContent">

                        <div class="tab-pane show active" id="orders" role="tabpanel" aria-labelledby="orders-tab">
                            <!-- <div class="card"> -->
                                <h2> Review Customer Orders: </h2>
                                <hr />
                                <li id="#orders">
                                    <OrdersView />
                                </li>
                            <!-- </div> -->
                        </div>

                        <div class="tab-pane" id="addPizza" role="tabpanel" aria-labelledby="addPizza-tab">
                            <div class="card">
                                <h2> Add a New Specialty Pizza to the Menu: </h2>
                                <li id="#addPizza">
                                    <CustomPizzaMenu />
                                </li>
                                <div class="row">
                                    <div class="col-4">
                                        <label for="name"><h3>Name Your Creation:</h3>
                                            <input type="text" id="name" name="name" v-model="newPizza.pizza_name" required>
                                        </label>
                                    </div>
                                    <div class="col-4">
                                        <label for="description"><h3>Pizza description:</h3>
                                            <input type="text" id="description" name="description"
                                                v-model="newPizza.pizza_description" required>
                                        </label>
                                    </div>
                                    <div class="col-3">
                                        <button class="addPizzaButton" type="submit" @click.prevent="addNewPizza">Add
                                            New Pizza to
                                            Menu</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane" id="addToppings" role="tabpanel" aria-labelledby="addToppings-tab">
                            <div>
                                <h2> Add New Toppings to the Menu: </h2>
                                <div class="row">
                                    <li id="#addToppings">
                                        <OptionsView />
                                    </li>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane" id="updatePizzas" role="tabpanel" aria-labelledby="updatePizzas-tab">
                                <h2> Review Specialty Pizza Availability: </h2>
                                <hr />
                                <li id="#updatePizzas">
                                    <PizzaAvailability />
                                </li>
                        </div>

                        <div class="tab-pane" id="updateToppings" role="tabpanel" aria-labelledby="updateToppings-tab">
                            <li id="#updateToppings">
                                <h2></h2>
                                <ToppingsAvailability />
                                <button class="submitButton" type="submit">Update Toppings Availability
                                </button>
                            </li>
                        </div>


                    </div>

                
            </section>

        </div>
    </div>
</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import NavbarEmployee from '../components/NavBarEmployee.vue';
import CustomPizzaMenu from '../components/CustomPizzaMenu.vue';
import EmployeeService from '../services/EmployeeService.js';
import OrdersView from './OrdersView.vue';
import OptionsView from './OptionsView.vue';

export default {
    components: {
        NavbarEmployee,
        PizzaAvailability,
        ToppingsAvailability,
        CustomPizzaMenu,
        OrdersView,
        OptionsView
    },
    data() {
        return {
            showCustomPizzaMenu: true,
            // showPizzaForm: false,
            newPizza: {
                pizza_name: '',
                pizza_description: ''
            }
        }
    },
    computed: {
        // buttonText() {
        //     return this.showCustomPizzaMenu ? 'Toppings Availability Menu' : 'Add Specialty Pizza';
        // }
    },
    methods: {
        // toggleComponent() {
        //     this.showCustomPizzaMenu = !this.showCustomPizzaMenu;
        // },
        addNewPizza() {

            // Fabulously slick code that will send the newPizza on over to the DB
            const pizza = {
                name: this.newPizza.pizza_name,
                size: this.$store.state.activePizza.size,
                crust: this.$store.state.activePizza.crust,
                sauce: this.$store.state.activePizza.sauce,
                available: true,
                description: this.newPizza.pizza_description,
                toppings: [
                    { name: this.$store.state.activeToppingsCheese.name },
                ]
            }
            for (let i = 0; i < this.$store.state.activeToppingsMeats.length; i++) {
                pizza.toppings.push({ name: this.$store.state.activeToppingsMeats[i] })
            }
            for (let i = 0; i < this.$store.state.activeToppingsVeggies.length; i++) {
                pizza.toppings.push({ name: this.$store.state.activeToppingsVeggies[i] })
            }
            EmployeeService.addPizza(pizza);
            // console.log("active pizza" + pizza)
            this.clearForm();
        },
        clearForm() {
            this.newPizza.pizza_name = '';
            this.newPizza.pizza_description = '';

        }
    }

}


</script>


<style scoped>
.page-wrapper {
    display: flex;
    min-height: 100dvh;
    flex-direction: column;
    align-items: center;
    background-color: #F7C516;
    padding: 10px;
}
a {
    border: none;
}
h1,
h2 {
    text-align: center;
    color: #A4200B;
    margin-top: 10px;
    margin-bottom: 10px;
}

h1 {
    font-weight: bold;
}

.container {
    display: flex;
    flex-direction: column;
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding-bottom: none;
}

.row {
    display: flex;
    justify-content: center;
    padding-top: 20px;
}

/* .submitButton {
    background-color: #A4200B;
    color: #F7C516;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 1.25em;
    font-weight: bold;
    margin-top: 10px;
    height: 100%;
} */
li {
    list-style-type: none;
    font-size: 20pt;
}
.addPizzaButton {
    background-color: #A4200B;
    color: #F7C516;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 1.5em;
    font-weight: bold;
    margin-top: 10px;
}
</style>