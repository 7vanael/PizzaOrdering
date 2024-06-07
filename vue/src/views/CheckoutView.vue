<template>
    <NavBar />
    <div class="review-order row">
        <h1>Review Your Order and Checkout</h1>
        <div class="order col">

            <div class="container">
                <div class="row">
                    <img src="../../public/images/tomato_basil_pizza.jpeg" alt="pizza image" />
                </div>
                <router-link class="changeOrder" to="/">Change Order</router-link>
                <div class="row price">
                    <h3 class="col">Pizza Name</h3>
                    <p class="col">Price</p>
                </div>
                <h5>Description of Customer Pizza Preferences</h5>
                <hr />
                <div class="row price">
                    <h4 class="col">Subtotal</h4>
                    <p class="col">Price</p>
                </div>
                <div class="row price">
                    <h4 class="col">Taxes & Fees</h4>
                    <p class="col">Price</p>
                </div>
                <div class="row price">
                    <h4 class="col">Tip</h4>
                    <p class="col">Price</p>
                </div>
                <hr />
                <div class="row price">
                    <h3 class="col">Total</h3>
                    <p class="col">Price</p>
                </div>
                //
                <button class="submitButton" type="submit">Confirm and Place Order</button>

            </div>
        </div>
        <div class="col">
            <form v-on:submit.prevent="sendOrder">
                <div class="container pickup" v-show="!isDelivery">
                    <div class="row">
                        <h5 class="col">Pick-up In Store</h5>
                        <p class="col toggle" v-on:click="toggleDelivery"> Change to Delivery</p>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="form-element">
                            <label for="streetAddress">Street Address: 1234 Pizza Place, Pizza City, PZ 91224</label>
                        </div>
                    </div>

                </div>
                <div class="container delivery" v-show="isDelivery">
                    <div class="row">
                        <h5 class="col">Delivery Address</h5>
                        <p class="col, toggle" v-on:click="toggleDelivery"> Change to pickup</p>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="form-element">
                            <label for="streetAddress">Street Address: </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-element">
                            <input type="text" id="streetAddress" v-model="customerInfo.streetAddress" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="city">City: </label>
                        </div>
                        <div class="col">
                            <label for="state">State: </label>
                        </div>
                        <div class="col">
                            <label for="zip">Zip Code: </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-element, col">
                            <input type="text" id="city" v-model="customerInfo.city" />
                        </div>
                        <div class="form-element, col">
                            <input type="text" id="streetAddress" v-model="customerInfo.state" />
                        </div>
                        <div class="form-element, col">
                            <input type="text" id="zip" v-model="customerInfo.zip" />
                        </div>
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
                    <div class="row tip">
                        <div class="col-2">
                            <button class="tip" name="tip" id="1">None</button>
                        </div>
                        <div class="col-2">
                            <button class="tip" name="tip" id="1.1">10%</button>
                        </div>
                        <div class="col-2">
                            <button class="tip" name="tip" id="1.15">15%</button>
                        </div>
                        <div class="col-2">
                            <button class="tip" name="tip" id="1.2">20%</button>
                        </div>
                        <div class="col-4">
                            <div class="row">
                                <button class="tip col" name="tip" id="custom">Custom</button>
                                <input class="col" type="number" id="custom_tip">
                            </div>
                        </div>

                    </div>

                </div>
                <div class="container" v-show="isDelivery">
                    <div class="row">
                        <h2> Payment Info: </h2>
                    </div>
                    <hr />
                    <div class="row">
                        <h3 class="col"> Credit Card Info:</h3>
                    </div>
                    <div class="row">

                    </div>
                    <div class="row">
                        <p class="col">
                            <label for="ccNumber">Credit Card Number: </label>
                        </p>
                        <p class="col">
                            <label for="ccExp">Expiration: </label>
                        </p>
                    </div>
                    <div class="row">
                        <div class="form-element, col">
                            <input type="text" id="ccNumber" v-model="customerInfo.ccNumber" />
                        </div>
                        <div class="form-element, col">
                            <input type="text" id="ccExp" v-model="customerInfo.ccExp" />
                        </div>
                    </div>
                    <div class="row">
                        <p class="col"> <label for="ccCode">CCV: </label></p>
                        <p class="col"><label for="zip">Zip Code: </label></p>
                    </div>
                    <div class="row">
                        <div class="form-element, col">
                            <input type="text" id="ccCode" v-model="customerInfo.ccCode" />
                        </div>
                        <div class="form-element, col">
                            <input type="text" id="zip" v-model="customerInfo.zip" />
                        </div>
                    </div>
                </div>
            </form>
        </div>


    </div>
</template>

<script>

import axios from 'axios';
import NavBar from '../components/NavBar.vue';
// import ToppingsService from '../services/ToppingsService.js';


export default {
    components: {
        NavBar,
        //import order from prior page
    },
    data() {
        return {
            pizzas: [],
            isDelivery: false,
            customerInfo: {
                name: '',
                email: '',
                phone: '',
                streetAddress: '',
                city: '',
                state: '',
                zip: '',
                paymentType: '',
                ccNumber: '',
                ccExp: '',
                ccCode: '',
            }
        }
    },
    // created() {
    //     ToppingsService.getPizzas().then(
    //         (response) => {
    //             this.pizzas = response.data;
    //         });
    // },
    methods: {
        toggleDelivery() {
            this.isDelivery = !this.isDelivery;
        },
        sendOrder() {

            //  (maybe?) Really great code to actually POST to the DB here
            axios.post('/order', {
                customerInfo: this.customerInfo,
                pizzas: this.pizzas
            }).then((response) => {
                console.log(response);
            });
        },
        goToCustomPizzaMenu() {
            this.$router.push('/');
        }
    },

}

</script>

<style scoped>
h1 {
    text-align: justify;
    text-decoration: underline;
    color: #2892C4;
}
.row > img {
    display: flex;
    /* max-height: 700px; */
    /* width: 100%; */
}
.changeOrder {
    display: flex;
    justify-content: flex-end;
    font-size: 20pt;
    font-weight: bold;
    text-decoration: underline;
    color: #A4200B;
    margin-top: 20px;
    margin-bottom: 20px;
}
form {
    display: flex;
    flex-direction: column;
    height: 100%;
}
.submitButton {
    display: flex;
    background-color: #A4200B;
    color: #F7C516;
    border-radius: 5px;
    padding: 10px;
    margin-top: 2rem;
    font-size: 20pt;
    justify-content: center;
}
button.tip {
    background-color: #A4200B;
    color: #F7C516;
    border-radius: 5px;
    padding: 10px;
    margin-top: 1rem;
    font-size: 24pt;
}
.row.tip {
    display: flex;
    flex-direction: row;
    padding: none;
    margin: none;
}
.toggle {
    text-decoration: underline;
    color: #A4200B;
}
label {
    font-size: 20pt;
    /* color: #A4200B; */
}
input {
    padding: 10px;
    margin-top: 1rem;
    border-radius: 5px;
    border: 1px solid #A4200B;
    width: 100%;
}
.container {
    margin-top: 2rem;
    padding: 1rem;
    border: 2px solid #2892C4;
    background-color: #F2DC9C;
    border-radius: 5px;
}
.container.delivery {
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding: 20px;
}
.container.pickup {
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
    margin: none;
}
p {
    font-size: 24pt;
    color: #A4200B;
}
.row.price>p.col {
    font-size: 26pt;
    color: #A4200B;
    text-align: right;
    padding-right: 1.5em;
}
.row.price>h4 {
    font-weight: bold;
    color: #A4200B;
    text-align: left;
    padding-left: 1.5em;
}
.row.price>h3 {
    font-weight: bold;
    color: #2892C4;
    text-align: left;
    font-size: 28pt;
}
</style>