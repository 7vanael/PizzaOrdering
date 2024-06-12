<template>
    <NavBar />
    <div class="page-wrapper">
        <div class="container">
            <div class="review-order row">
                <h1>Review Your Order and Checkout</h1>

                <div class="order col left">

                    <div class="container">
                        <div class="row">
                            <img :src="getImageSrc(this.$store.state.activePizza.name)" alt="pizza image" />
                        </div>
                        <router-link class="changeOrder" to="/">Change Order</router-link>
                        <div class="row price">
                            <h2 class="col"> {{ this.$store.state.activePizza.name }}</h2>
                            <p class="col">{{ (this.$store.state.currentCrustPrice + this.$store.state.totalToppingPrice) }}
                            </p>
                            <!-- <p class="col"> {{ this.crustCost }}</p> -->
                        </div>
                        <div class="row">
                            <p id="pizzaIngredients">
                                Crust Size: {{ this.$store.state.activePizza.size }},
                                Crust Type: {{ this.$store.state.activePizza.crust }},
                                Sauce: {{ this.$store.state.activePizza.sauce }},
                                {{ this.$store.state.activeToppingsCheese.name }},
                                {{ this.$store.state.activeToppingsMeats.join(', ') }}
                                {{ this.$store.state.activeToppingsVeggies.join(', ') }}
                            </p>
                        </div>
                        <hr />
                        <div class="row price">
                            <h2 class="col">Total</h2>
                            <p class="col">{{ (this.$store.state.currentCrustPrice + this.$store.state.totalToppingPrice) }}
                            </p>
                        </div>
                        <button class="submitButton" type="submit" v-on:click="sendOrder()">Confirm and Place Order</button>
                    </div>
                </div>

                <div class="order col right">
                    <form v-on:submit.prevent="sendOrder">
                        <div class="container pickup" v-show="!isDelivery">
                            <div class="row">
                                <h5 class="col">Pick-up In Store</h5>
                                <p class="col toggle" v-on:click="toggleDelivery"> Change to Delivery</p>
                            </div>
                            <div class="row">
                                <div class="form-element">
                                    <label class="pickup address" for="streetAddress">Street Address: 1234 Pizza Place,
                                        Pizza
                                        City, PZ 91224</label>
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="form-element">
                                    <label class="pickup address" for="customerName">Customer Name:
                                        <input type="text" id="customerName" placeholder="First and Last Name"
                                            v-model="customerInfo.name" />
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-element">
                                    <label class="pickup address" for="customerEmail">Email:
                                        <input type="email" id="email" placeholder="email@gmail.com"
                                            v-model="customerInfo.email" />
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="container delivery" v-show="isDelivery">
                            <div class="row">
                                <h3 class="col">Delivery Address</h3>
                                <p class="col toggle" v-on:click="toggleDelivery"> Change to Pickup</p>
                            </div>
                            <hr />
                            <p class="row">
                                <label class="delivery address" for="customerName">Customer Name:
                                    <input type="text" id="customerName" placeholder="First and Last Name"
                                        v-model="customerInfo.name" />
                                </label>
                            </p>
                            <p class="row">
                                <label class="delivery address" for="customerEmail">Email:
                                    <input type="text" id="email" placeholder="email@email.com"
                                        v-model="customerInfo.email" />
                                </label>
                            </p>
                            <p class="row">
                                <label class="delivery address" for="streetAddress">Street Address:
                                    <input type="text" id="streetAddress" placeholder="123 Pizza Rd"
                                        v-model="customerInfo.streetAddress" />
                                </label>
                            </p>
                            <div class="row">
                                <p class="col">
                                    <label for="city">City:
                                        <input type="text" id="city" placeholder="Pizza City" v-model="customerInfo.city" />
                                    </label>
                                </p>
                                <p class="col">
                                    <label for="state">State:
                                        <input type="text" id="streetAddress" placeholder="PZ"
                                            v-model="customerInfo.state" />
                                    </label>
                                </p>
                                <p class="col">
                                    <label for="zip">Zip Code:
                                        <input type="text" id="zip" placeholder="12345" v-model="customerInfo.zip" />
                                    </label>
                                </p>
                            </div>
                        </div>
                        <div>
                            <div class="container payment" v-show="isDelivery">
                                <div class="row">
                                    <h3> Payment Info </h3>
                                </div>
                                <hr />
                                <div class="row">
                                    <p class="col">
                                        <label for="ccNumber">Credit Card Number:
                                            <input type="text" id="ccNumber" placeholder="1234 1234 1234 1234"
                                                v-model="ccInfo.ccNumber" />
                                        </label>
                                    </p>
                                    <p class="col">
                                        <label for="ccExp">Expiration:
                                            <input type="text" id="ccExp" placeholder="MM/YY" v-model="ccInfo.ccExp" />
                                        </label>
                                    </p>
                                </div>
                                <div class="row">

                                    <p class="col">
                                        <label for="ccCode">CCV:
                                            <input type="text" id="ccCode" placeholder="123" v-model="ccInfo.ccCode" />
                                        </label>
                                    </p>


                                    <p class="col"><label for="zip">Zip Code:
                                            <input type="text" id="zip" placeholder="12345" v-model="customerInfo.zip" />
                                        </label>
                                    </p>

                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</template>

<script>

// import axios from 'axios';
import NavBar from '../components/NavBar.vue';
import ToppingsService from '../services/ToppingsService.js';
import OrderService from '../services/OrderService.js';

export default {
    components: {
        NavBar,
        //import order from prior page
    },
    data() {
        return {
            tempCost: {
                "Large": 10.25,
                "Medium": 9.45,
                "Small": 8.65,
            },
            images:
            {
                'The Front-End': '/images/AI_margherita_pizza.webp',
                'The Default': '/images/pepperoni_pizza.jpg',
                'The Back-End': '/images/BBQ_chicken_pizza.jpg',
                'The Constructor': '/images/classic_cheese_pizza.jpg',
                'The Polymorph': '/images/custom_pizza.jpeg',
                'The Framework': '/images/Meat_Lovers.jpg',
                'The Compiler': '/images/supreme_pizza.webp',
                'The API': '/images/tomato_basil_pizza.jpeg',
                'The Debugger': '/images/veggie_pizza.webp',
                'The Full-Stack': '/images/full_stack_pizza.jpg'
            },
            pizzas: [],
            currentPizza: {},
            isDelivery: false,
            totalCost: 0.0,
            crustCost: 0.0,
            crustSize: '',
            customerInfo: {
                name: '',
                email: '',
                phone: '',
                streetAddress: '',
                city: '',
                state: '',
                zip: '',
                //paymentType: '',
            },
            ccInfo: {
                ccNumber: '',
                ccExp: '',
                ccCode: '',
            },
            currentOrder: {
                "total": 0,
                "status": 'Received',
                "type": "",
                "items": [],
                "customer": {},
            },
            ordersList: {},
        }
    },
    created() {
        ToppingsService.getCrustPriceBySize(this.$store.state.activePizza.size).then((response) => {
            this.crustCost = response.data;
            console.log("current crust price: " + this.crustCost);
        });
    },
    setTotalToppingPrice() {
        let totalPrice = 0;
        let toppingsMeatListTemp = this.$store.state.activeToppingsMeats;
        let toppingsVeggieListTemp = this.$store.state.activeToppingsVeggies;
        this.meatToppings.forEach(
            (topping) => {
                toppingsMeatListTemp.forEach(
                    (activeTopping) => {
                        if (topping.name == activeTopping) {
                            //console.log("hello");
                            totalPrice += this.toppingTierPrice[topping.toppingTier];
                        }
                    });
            });
        this.veggieToppings.forEach(
            (topping) => {
                toppingsVeggieListTemp.forEach(
                    (activeTopping) => {
                        if (topping.name == activeTopping) {
                            //console.log("hello");
                            totalPrice += this.toppingTierPrice[topping.toppingTier];
                        }
                    });
            });
        this.$store.commit("SET_CURRENT_TOTAL_TOPPING_PRICE", totalPrice);
        //console.log(totalPrice);
    },
    methods: {
        getImageSrc(pizzaName) {
            //console.log("reached set active pic");
            if (pizzaName in this.images) {
                return this.images[pizzaName];
            } else return '/images/prototype_logo.jpg';
        },
        setCrustSize() {
            this.crustSize = this.$store.state.activePizza.crust.size;
        },
        toggleDelivery() {
            this.isDelivery = !this.isDelivery;
        },
        fetchOrders() {
            /*axios.get('/order').then((response) => {
                console.log('Order fetched successfully!', response.data);
                this.orders = response.data;
            }).catch((error) => {
                console.log('Error fetching orders', error);
            });*/
            OrderService.getAllOrders().then(
                (response) => {
                    this.ordersList = response.data;
                }).catch((error) => {
                    console.log('Error fetching orders', error);
                });
        },
        sendOrder() {

            this.currentOrder.customer = this.customerInfo;
            this.currentOrder.items.push({ pizza: this.$store.state.activePizza });
            this.currentOrder.type = this.isDelivery ? "Delivery" : "Pick-up";

            OrderService.placeOrder(this.currentOrder).then(
                (response) => {
                    console.log('Order placed Successfully, order number: ' + response.data);
                    window.alert('Your order # is: ' + response.data);
                }).catch((error) => {
                    console.log('Error placing order', error);
                });

            this.clearForm();
        },
        goToCustomPizzaMenu() {
            this.$router.push('/');
        },
        clearForm() {
            this.customerInfo.name = '',
                this.customerInfo.email = '',
                this.customerInfo.phone = '',
                this.customerInfo.streetAddress = '',
                this.customerInfo.city = '',
                this.customerInfo.state = '',
                this.customerInfo.zip = '',
                this.ccInfo.ccCode = '',
                this.ccInfo.ccExp = '',
                this.ccInfo.ccNumber = ''
        }
    }

}

</script>

<style scoped>
.page-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-top: 2em;
}
.container {
    margin-top: 2rem;
    padding: 1rem;
    border: 2px solid #2892C4;
    background-color: #F2DC9C;
    border-radius: 5px;
    margin: 1em 2em 0 2em;
}
.review-order.row {
    background-color: none;
}

h1 {
    text-align: justify;
    text-decoration: underline;
    color: #2892C4;
    margin-top: 2em;
    margin-left: 1em;
}

h2 {
    color: #2892C4;
    font-weight: bold;
}

img {
    width: 50%;
}

.row>img {
    display: flex;
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
    margin-right: 2em;
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

.pickup.address {
    font-size: 26pt;
    color: #2892C4;
    font-weight: bold;
}

.toggle {
    text-decoration: underline;
    color: #A4200B;
}

.col.toggle {
    display: flex;
    justify-content: flex-end;
    font-size: 20pt;
    font-weight: bold;
    text-decoration: underline;
    color: #A4200B;
}

input {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #A4200B;
    width: 100%;
}

.container.delivery {
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
}

.container.pickup {
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
}

h5 {
    font-size: 40pt;
    color: #A4200B;
}

p {
    font-size: 24pt;
    color: #A4200B;
    font-weight: bold;
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

.pizzaDescription {
    font-size: 20pt;
    color: #2892C4;
}</style>