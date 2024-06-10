<template>
    <Navbar />

    <div>
        <div class="container">
            <h1> Welcome, Syntax Slices Employee!</h1>
            <h2> Here you can view and update orders.</h2>
            <hr />
            <select v-model="orderStatus">
                <option value="">Pending</option>
                <option value="Received">Received</option>
                <option value="Ready">Ready</option>
                <option value="Out for Delivery">Out for Delivery</option>
                <option value="Completed">Completed</option>
                <option value="Canceled">Canceled</option>
            </select>
            <button @click="showOrders">Show Orders</button>
            <div v-for="order in orders" v-bind:key="order.id">
                <div>Order ID: {{ order.id }}</div>
                <div>Order total: {{ order.total }}</div>
                <div>Order type: {{ order.type }}</div>
                <div>Customer name: {{ order.customer.name }}</div>
                <div>Customer email: {{ order.customer.email }}</div>
                <div>Customer address: {{ order.customer.address }}, {{ order.customer.city }}, {{ order.customer.state }} {{ order.customer.zip }}</div>
                <div v-for="item, index in order.items" v-bind:key = index>
                    <div>Pizza: {{ item.pizza.name }}</div>
                    <div>Default Size: {{ item.pizza.size }}</div>
                    <div>Default Crust: {{ item.pizza.crust }}</div>
                    <div>Default Sauce: {{ item.pizza.sauce }}</div>
                    <div v-for="topping, index in item.pizza.toppings" v-bind:key="index">
                        <div>Customize {{ topping.type }}: {{ topping.name }}</div>
                    </div>

                </div>



                <div>Status: {{ order.status }}</div>
                <select v-model="order.newStatus">
                    <option value="Received">Received</option>
                    <option value="Ready">Ready</option>
                    <option value="Out for Delivery">Out for Delivery</option>
                    <option value="Completed">Completed</option>
                    <option value="Canceled">Canceled</option> 
                </select>
                <button @click="updateOrderStatus(order.id, order.newStatus)">Update status</button>
            </div>


        </div>
    </div>
</template>

<script scoped>
import Navbar from '../components/NavBar.vue';
import OrderService from '../services/OrderService';

export default {
    components: {
        Navbar
    },
    data() {
        return {
            orders: [],
            orderStatus: ""
        }
    },
    computed: {
    },
    methods: {
        showOrders(orderStatus){
            if(orderStatus == ""){
                OrderService.getAllOrders().then((response) => this.orders = response.data)
                console.log(this.orders)
            } else {
                OrderService.getOrdersByStatus(this.orderStatus).then((response) => this.orders = response.data)
                console.log(this.orders)
            } 
        },
        updateOrderStatus(id, newStatus){
            OrderService.updateOrderStatus(id, newStatus).then(() =>{
            this.showOrders(this.orderStatus)
        })
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