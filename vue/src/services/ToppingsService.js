import axios from 'axios';

export default {
    getToppings() {
        return axios.get('/toppings');
    },
    getPizzas() {
        return axios.get('/pizzas');
    }
}