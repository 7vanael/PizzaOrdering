<template>
    <Navbar />

    <div>
        <div class="container">
            <h1> Welcome, Syntax Slices Employee!</h1>
            <h2> Here you can create a new pizza to add to the menu and adjust toppings availability.</h2>
            <hr />
            <div class="row">
                <button class="toggle" @click="toggleComponent">{{ buttonText }}</button>
            </div>
            <div class="row">
                <CustomPizzaMenu v-if="showCustomPizzaMenu" :showButton="false" />
            </div>
            <div class="row" v-if="showCustomPizzaMenu">
                <div class="col-4">
                    <label for="name">Name Your Creation:
                        <input type="text" id="name" name="name" v-model="newPizza.pizza_name" required>
                    </label>
                </div>
                <div class="col-4">
                    <label for="description">Pizza description:
                        <input type="text" id="description" name="description" v-model="newPizza.pizza_description" required>
                    </label>
                </div>
                <!-- TODO: INSERT THE CUSTOM BUILD MENU HERE?? TO SELECT THE REST OF THE OPTIONS??  -->
                <!-- Do we need to include an image file? Can we accept it to the images folder? -->
                <!-- submit form to add new specialty pizza to DB -->
                <div class="col-3">
                    <button class="submitButton" type="submit">Add New Pizza to Menu</button>
                </div>
                </div>
            <div class="row" v-else>
                <ToppingsAvailability  />
                <div class="col-3">
                <button class="submitButton" type="submit">Update Toppings Availability</button>
            </div>
              
                <!-- Pending orders  -- Should this be displaying another component? -->
            </div>

        </div>
    </div>
</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import Navbar from '../components/NavBar.vue';
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
            showCustomPizzaMenu: true,
            // showPizzaForm: false,
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
    computed: {
        buttonText() {
            return this.showCustomPizzaMenu ? 'Toppings Availability Menu' : 'Add Specialty Pizza';
        }
    },
    methods: {
        toggleComponent() {
            this.showCustomPizzaMenu = !this.showCustomPizzaMenu;
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
label, input {
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