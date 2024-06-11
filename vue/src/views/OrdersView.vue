<template>
        <div class="container">
            <select v-model="orderStatus" class="form-select form-select-lg mb-3" aria-label="Large select example">
                <option value="">Pending</option>
                <option value="Received">Received</option>
                <option value="Ready">Ready</option>
                <option value="Out for Delivery">Out for Delivery</option>
                <option value="Completed">Completed</option>
                <option value="Canceled">Canceled</option>
            </select>
            <button @click="showOrders">Show Orders</button>
            <div v-for="order in orders" v-bind:key="order.id">
                <p>Order ID: {{ order.id }}</p>
                <p>Order total: {{ order.total }}</p>
                <p>Order type: {{ order.type }}</p>
                <p>Customer name: {{ order.customer.name }}</p>
                <p>Customer email: {{ order.customer.email }}</p>
                <p>Customer address: {{ order.customer.address }}, {{ order.customer.city }}, {{ order.customer.state }} {{ order.customer.zip }}</p>
                <div v-for="item, index in order.items" v-bind:key = index>
                    <p>Pizza: {{ item.pizza.name }}</p>
                    <p>Default Size: {{ item.pizza.size }}</p>
                    <p>Default Crust: {{ item.pizza.crust }}</p>
                    <p>Default Sauce: {{ item.pizza.sauce }}</p>
                    <div v-for="topping, index in item.pizza.toppings" v-bind:key="index">
                        <p>Customize {{ topping.type }}: {{ topping.name }}</p>
                    </div>
                </div>

                <div>Status: {{ order.status }}</div>
                <select v-model="order.newStatus" class="form-select form-select-lg mb-3" aria-label="Large select example">
                    <option value="Received">Received</option>
                    <option value="Ready">Ready</option>
                    <option value="Out for Delivery">Out for Delivery</option>
                    <option value="Completed">Completed</option>
                    <option value="Canceled">Canceled</option> 
                </select>
                <button @click="updateOrderStatus(order.id, order.newStatus)">Update status</button>
            </div>


        </div>
</template>

<script scoped>

import OrderService from '../services/OrderService';

export default {
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


<style scoped>
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
}
option {
    font-size: 30pt;
    margin-top: 5px;
    font-weight: bold;
    color: #A4200B;
    letter-spacing: 2px;
}
button {
    background-color: #A4200B;
    color: #F7C516;
    border: none;
    border-radius: 5px;
    padding: 10px;
    /* font-size: 2em; */
    font-weight: bold;
    margin-top: 10px;
    height: 100%;
}
p {
    font-size: 24pt;
}
</style>