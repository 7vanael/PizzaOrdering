<template>
    <Navbar />

    <div class="page-wrapper">
        <div class="container">
            <h1> Welcome, Syntax Slices Employee!</h1>
            <h2> Here you can create a new pizza to add to the menu and adjust toppings availability.</h2>
            <hr />
        </div>
        <ul class="nav nav-tabs">
<!-- Orders Review Page -->
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Orders</a>
                <div class="container">
                    <h3> Review Customer Orders: </h3>
                    <OrdersView />
                </div>
            </li>
<!-- Add New Specialty Pizza to Menu -->
            <li class="nav-item">
                <a class="nav-link" href="#">Add New Pizza</a>
                <div class="container">
                    <h3> Add a New Specialty Pizza to the Menu: </h3>
                    <div class="row">
                        <CustomPizzaMenu />
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <label for="name">Name Your Creation:
                                <input type="text" id="name" name="name" v-model="newPizza.pizza_name" required>
                            </label>
                        </div>
                        <div class="col-4">
                            <label for="description">Pizza description:
                                <input type="text" id="description" name="description" v-model="newPizza.pizza_description"
                                    required>
                            </label>
                        </div>
                        <div class="col-3">
                            <button class="submitButton" type="submit" @click.prevent="addNewPizza">Add New Pizza to
                                Menu</button>
                        </div>
                    </div>
                </div>
            </li>
<!-- Add New Topping -->
            <li class="nav-item">
                <a class="nav-link" href="#">Add New Topppings</a>
                <div class="container">
                    <h3> Add New Toppings to the Menu: </h3>
                </div>
            </li>
<!-- Specialty Pizza Availability -->
            <li class="nav-item">
                <a class="nav-link" href="#">Current Stock</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Specialty Pizzas</a>
                <div class="container">
                    <h3> Review Specialty Pizza Availability: </h3>
                    <div class="row">
                        <PizzaAvailability />
                    </div>
                </div>
            </li>
            <!-- Toppings Availability -->
            <li class="nav-item">
                <a class="nav-link" href="#">Toppings</a>
                <div class="container">
                    <h3> Toppings Availability: </h3>
                    <div class="row">
                        <ToppingsAvailability />
                        <div class="col-3">
                            <button class="submitButton" type="submit">Update Toppings Availability</button>
                        </div>
                        <!-- Pending orders  -- Should this be displaying another component? -->
                    </div>
                </div>
            </li>



        </ul>


    </div>
</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import Navbar from '../components/NavBar.vue';
import ToppingsService from '../services/ToppingsService.js';
import CustomPizzaMenu from '../components/CustomPizzaMenu.vue';
import EmployeeService from '../services/EmployeeService.js';
import OrdersView from './OrdersView.vue';

export default {
    components: {
        Navbar,
        PizzaAvailability,
        ToppingsAvailability,
        CustomPizzaMenu,
        OrdersView
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


<style>
.page-wrapper {
    display: flex;
    min-height: 100dvh;
    flex-direction: column;
    align-items: center;
    background-color: #F7C516;
    padding: 10px;
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
}

button.toggle {
    background-color: #2892C4;
    width: 50%;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 2em;
    ;
}

label,
input {
    font-size: 16pt;
    margin-top: 5px;
    font-weight: bold;
    color: #A4200B;
    letter-spacing: 2px;
}

.submitButton {
    background-color: #A4200B;
    color: #F7C516;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 1.5em;
    font-weight: bold;
    margin-top: 10px;
    height: 100%;
}
</style>