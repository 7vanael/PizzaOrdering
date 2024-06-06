<template>
    <NavBar />
    <div class="review-order">
        <h1>Review Your Order</h1>
        <div class="order">
            <h2>Your Order</h2>
            <Checkout />
        </div>
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