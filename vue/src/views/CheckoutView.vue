<template>
    <NavBar />
    <div class="review-order">
        <h1>Review Your Order and Checkout</h1>
        <div class="order">
            <div class="container">
                <img src="../images/tomato basil pizza.jpeg" alt="pizza image" />
                <p>Change Order</p>
                <div class="row">
                    <h3 class="col">Pizza Name</h3>
                    <p class="col">Price</p>
                </div>
                <h5>Description of Customer Pizza Preferences</h5>
                <hr />
                <div class="row">
                    <h4 class="col">Subtotal</h4>
                    <p class="col">Price</p>
                </div>
                <div class="row">
                    <h4 class="col">Taxes & Fees</h4>
                    <p class="col">Price</p>
                </div>
                <div class="row">
                    <h4 class="col">Tip</h4>
                    <p class="col">Price</p>
                </div>
                <hr />
                <div class="row">
                    <h3 class="col">Total</h3>
                    <p class="col">Price</p>
                </div>
            </div>
            <!-- Most of the contents of these need to actually have data in the fields, will
            likely need to import prop? Not sure how you'd like to handle -->
            <div class="container">
                <div class="row">
                    <h4 class="col">Delivery Address</h4>
                    <p class="col"> Change to pickup</p>
                </div>
                <hr />
                <div class="row">
                    <p class="col"> Street Address</p>
                    <p class="col"> Change Address </p>
                </div>
                <div class="row">
                    <p class="col"> City, State Zip</p>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <h4> Add tip:</h4>
                </div>
                <hr />
                <div class="row">
                    <p class="col"> Tip amount: </p>
                </div>           
            </div>
            <div class="container">
                <div class="row">
                    <h4> Add Tip:</h4>
                </div>
                <hr />
                <div class="row">
                    <p class="col"> Tip amount: </p>
                </div>
                <div class="row">
                    <div class="col">
                        <button class="tip" name="tip" id="1">None</button>
                    </div>
                    <div class="col">
                        <button class="tip" name="tip" id="1.1">10%</button>
                    </div>
                    <div class="col">
                        <button class="tip" name="tip" id="1.15">15%</button>
                    </div>
                    <div class="col">
                        <button class="tip" name="tip" id="1.2">20%</button>
                    </div>
                    <div class="col">
                        <div class="row">
                            <button class="tip, col" name="tip" id="custom">Custom</button>
                            <input class="col" type="number" id="custom_tip">
                        </div>
                    </div>
                
                </div>
               
            </div>
            <div class="container">
                <div class="row">
                    <h4> Payment Info: </h4>
                </div>
                <hr />
                <div class="row">
                    <!-- These radio buttons aren't right.... can you help fix it? -->
                    <input class="col" type="radio" name="payment_type" label="Credit Card"/>
                    <p class="col"> Different card?</p>
                </div>
                <div class="row">
                    <!-- These radio buttons aren't right.... can you help fix it? -->
                    <input class="col" type="radio" name="payment_type" label="Credit Card"/>
                    <p class="col"> Credit Card</p>
                </div>
                <div class="row">
                    <p class="col">Card Number</p>
                    <p class="col">Exp</p>
                </div>
                
                <div class="row">
                    <p class="col"> CCV</p>
                    <p class="col">Zip</p>
                </div>
            </div>
        </div>
        <Checkout />
    </div>
</template>

<script>

import NavBar from '../components/NavBar.vue';
import ToppingsService from '../services/ToppingsService.js';
import Checkout from '../components/Checkout.vue';


export default {
    components: {
        NavBar,
        Checkout
    },
    data() {
        return {
            pizzas: []
        }
    },
    created() {
        ToppingsService.getPizzas().then(
            (response) => {
                this.pizzas = response.data;
            });
    },
}

</script>

<style scoped>
h1 {
    text-align: justify;
    text-decoration: underline;
    color: #2892C4;
}
</style>