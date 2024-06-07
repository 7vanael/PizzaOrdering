<template>
    <Navbar />
    <div>
        <div class="container">
            <!-- Header -->
            <h1> Welcome, Syntax Slices Employee!</h1>
            <div class="row">
                <div class="col">
                    <PizzaAvailability />
                    <h2 class="toggle" v-on:click="togglePizzaForm"> Add a Specialty Pizza</h2>
                    <form v-on:submit.prevent="addNewPizza" v-show="showPizzaForm">
                        <label for="name">Pizza name: </label>
                        <input type="text" id="name" name="name" v-model="newPizza.pizza_name">
                        <label for="description">Pizza description:</label>
                        <input type="text" id="description" name="description" v-model="newPizza.pizza_description">

                        <!-- TODO: INSERT THE CUSTOM BUILD MENU HERE?? TO SELECT THE REST OF THE OPTIONS?? -->
                        <!-- Do we need to include an image file? Can we accept it to the images folder? -->
                        <!-- submit form to add new specialty pizza to DB -->
                        <button class="submitButton" type="submit">Add this Specialty Pizza to the Menu</button>
                    </form>
                </div>
                <div class="col">
                    <ToppingsAvailability />
                </div>
                <div class="col">
                    <!-- Pending orders  -- Should this be displaying another component?-->
                </div>
            </div>
        </div>

    </div>

</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import Navbar from '../components/Navbar.vue';
import ToppingsService from '../services/ToppingsService';

export default{
    components: {
        Navbar,
    PizzaAvailability,
    ToppingsAvailability
},
    data(){
        return{
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
        togglePizzaForm() {
            this.showPizzaForm = !this.showPizzaForm;
        },  
        addNewPizza (){
            // Fabulously slick code that will send the newPizza on over to the DB
            this.clearForm();
        },
        clearForm(){
                this.newPizza.pizza_name= '';
                this.newPizza.pizza_size= ''; 
                this.newPizza.crust_type= ''; 
                this.newPizza.sauce_type= '';
                this.newPizza.pizza_available= true; 
                this.newPizza.pizza_description= '';
            
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