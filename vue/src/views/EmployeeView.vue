<template>
    <div>
        <div class="container">
            <!-- Headder -->
            <h1> Welcome, Syntax Slices Employee!</h1>
                <!-- List specialty pizzas with availability button/checkbox -->
                <PizzaAvailability />
                <!-- button for add a specialty pizza -->
                <!-- Form, vshow on abbove button -->
                    <!-- input fields for new specialty pizza -->
                    <!-- submit form to add new specialty pizza to DB -->
                    <!-- Do we need to include an image file? Can we accept it to the images folder? -->
                <!-- List toppings with availability button/checkbox -->
                <ToppingsAvailability />
                <!-- Pending orders  -- Should this be displaying another component?-->
        </div>

    </div>

</template>

<script scoped>

import PizzaAvailability from '../components/PizzaAvailability.vue';
import ToppingsAvailability from '../components/ToppingsAvailability.vue';
import ToppingsService from '../services/ToppingsService';

export default{
    components: {
    PizzaAvailability,
    ToppingsAvailability
},
    data(){

    },
    methods: {
        
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