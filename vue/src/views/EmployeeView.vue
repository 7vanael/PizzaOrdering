<template>
    <Navbar />

    <div class="container">
        <!-- Header -->
        <h1> Welcome, Syntax Slices Employee!</h1>
        <h2> Here you can create a new pizza to add to the menu and adjust toppings availability.</h2>
        <!-- Create New Pizza-->
        <div>
            <button class="toggle" @click="toggleToppingForm">Add Specialty Pizza</button>
            <button class="toggle" @click="toggleToppingForm">Toppings Availability Menu</button>
            <!-- <div class="row">
                <CustomPizzaMenu :showButton="false" />
            </div> -->
            <!-- <div class="row">
                <div class="col-5">
                    <label for="name">Name Your Creation:
                        <input type="text" id="name" name="name" v-model="newPizza.pizza_name">
                    </label>
                </div>
                <div class="col-5">
                    <label for="description">Pizza description:
                        <input type="text" id="description" name="description" v-model="newPizza.pizza_description">
                    </label>
                </div>
                 TODO: INSERT THE CUSTOM BUILD MENU HERE?? TO SELECT THE REST OF THE OPTIONS?? -->
                <!-- Do we need to include an image file? Can we accept it to the images folder? -->
                <!-- submit form to add new specialty pizza to DB -->
                <!-- <div class="col-2">
                    <button class="submitButton" type="submit">Add New Pizza to Menu</button>

                </div> -->
            <!-- </div> --> 
        
        <!-- Toppings Availability Menu  -->
        <div class="row">
            <ToppingsAvailability />

        <!-- <PizzaAvailability /> -->
        <!-- <button class="toggle" v-on:click="togglePizzaForm"> Add a Specialty Pizza</button>
                    <form v-on:submit.prevent="addNewPizza" v-show="showPizzaForm">
                    </form>
        </div> -->
        <!-- <div v-show="!isToppingForm"> -->
        <!-- <div class="col"> -->
                        <!-- <ToppingsAvailability /> -->
                    <!-- </div> -->
        <!-- <div class="col"> -->
                         <!-- Pending orders  -- Should this be displaying another component? -->
        </div>
</div>
    </div>
</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import Navbar from '../components/Navbar.vue';
import ToppingsService from '../services/ToppingsService';
import CustomPizzaMenu from '../components/CustomPizzaMenu.vue';

export default {
    components: {
        Navbar,
        PizzaAvailability,
        ToppingsAvailability,
        CustomPizzaMenu
    },
    data() {
        return {
            showPizzaForm: false,
            newPizza: {
                pizza_name: '',
                pizza_size: '',
                crust_type: '',
                sauce_type: '',
                pizza_available: true,
                pizza_description: ''
            }
        }
    },
    methods: {
        toggleToppingForm() {
            this.isToppingForm = !this.isToppingForm;
        },
        addNewPizza() {
            // Fabulously slick code that will send the newPizza on over to the DB
            this.clearForm();
        },
        clearForm() {
            this.newPizza.pizza_name = '';
            this.newPizza.pizza_size = '';
            this.newPizza.crust_type = '';
            this.newPizza.sauce_type = '';
            this.newPizza.pizza_available = true;
            this.newPizza.pizza_description = '';

        }
    }

}


</script>


<style>
.container {
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding: 20px;
}
</style>