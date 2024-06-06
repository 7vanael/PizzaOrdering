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